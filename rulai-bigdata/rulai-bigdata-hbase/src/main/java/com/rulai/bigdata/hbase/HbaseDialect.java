package com.rulai.bigdata.hbase;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CompareOperator;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/30 11:32
 */
@Slf4j
public class HbaseDialect {

    private Configuration configuration;

    private Connection connection;

    private Admin admin;

    public HbaseDialect(Configuration configuration) throws HbaseException {
        try {
            this.configuration = configuration;
            this.connection = ConnectionFactory.createConnection(this.configuration);
        } catch (IOException e) {
            throw new HbaseException(e);
        }
    }

    public void connect() throws HbaseException {
        try {
            if (null == connection || connection.isClosed()) {
                connection = ConnectionFactory.createConnection(this.configuration);
            }
            if (null == admin || admin.isAborted()) {
                admin = connection.getAdmin();
            }
        } catch (IOException e) {
            throw new HbaseException(e);
        }
    }

    public void close() throws HbaseException {
        try {
            if (null != admin) {
                admin.close();
                admin = null;
            }
            if (null != connection || !connection.isClosed()) {
                connection.close();
                connection = null;
            }
        } catch (IOException e) {
            throw new HbaseException(e);
        }
    }

    /**
     * 创建表
     * @param tableName    表名
     * @param columnFamily 列族名
     * @return
     */
    public boolean creatTable(String tableName, List<String> columnFamily) throws HbaseException {
        try {
            List<ColumnFamilyDescriptor> familyDescriptors = columnFamily.stream()
                    .map(e -> ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes(e)).build())
                    .collect(Collectors.toList());
            TableDescriptor tableDescriptor = TableDescriptorBuilder.newBuilder(TableName.valueOf(tableName))
                    .setColumnFamilies(familyDescriptors)
                    .build();
            if (admin.tableExists(TableName.valueOf(tableName))) {
                log.debug("table Exists!");
            } else {
                admin.createTable(tableDescriptor);
                log.debug("create table Success!");
            }
            return true;
        } catch (IOException e) {
            throw new HbaseException(e);
        }
    }

    /**
     * 预分区创建表
     * @param tableName    表名
     * @param columnFamily 列族名的集合
     * @param splitKeys    预分期region
     * @return 是否创建成功
     */
    public boolean createTableBySplitKeys(String tableName, List<String> columnFamily, byte[][] splitKeys)
            throws HbaseException {
        try {
            if (admin.tableExists(TableName.valueOf(tableName))) {
                return true;
            }
            List<ColumnFamilyDescriptor> familyDescriptors = columnFamily.stream()
                    .map(e -> ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes(e)).build())
                    .collect(Collectors.toList());
            TableDescriptor tableDescriptor = TableDescriptorBuilder.newBuilder(TableName.valueOf(tableName))
                    .setColumnFamilies(familyDescriptors)
                    .build();
            admin.createTable(tableDescriptor, splitKeys);
            return true;
        } catch (IOException e) {
            throw new HbaseException(e);
        }
    }

    /**
     * 自定义获取分区splitKeys
     * @param keys
     * @return
     */
    public byte[][] getSplitKeys(String[] keys) {
        if (keys == null) {
            //默认为10个分区
            keys = new String[]{"1|", "2|", "3|", "4|",
                    "5|", "6|", "7|", "8|", "9|"};
        }
        byte[][] splitKeys = new byte[keys.length][];
        //升序排序
        TreeSet<byte[]> rows = new TreeSet<>(Bytes.BYTES_COMPARATOR);
        for (String key : keys) {
            rows.add(Bytes.toBytes(key));
        }
        Iterator<byte[]> rowKeyIter = rows.iterator();
        int i = 0;
        while (rowKeyIter.hasNext()) {
            byte[] tempRow = rowKeyIter.next();
            rowKeyIter.remove();
            splitKeys[i] = tempRow;
            i++;
        }
        return splitKeys;
    }

    /**
     * 按startKey和endKey，分区数获取分区
     * @param startKey
     * @param endKey
     * @param numRegions
     * @return
     */
    public static byte[][] getHexSplits(String startKey, String endKey, int numRegions) {
        byte[][] splits = new byte[numRegions - 1][];
        BigInteger lowestKey = new BigInteger(startKey, 16);
        BigInteger highestKey = new BigInteger(endKey, 16);
        BigInteger range = highestKey.subtract(lowestKey);
        BigInteger regionIncrement = range.divide(BigInteger.valueOf(numRegions));
        lowestKey = lowestKey.add(regionIncrement);
        for (int i = 0; i < numRegions - 1; i++) {
            BigInteger key = lowestKey.add(regionIncrement.multiply(BigInteger.valueOf(i)));
            byte[] b = String.format("%016x", key).getBytes();
            splits[i] = b;
        }
        return splits;
    }

    /**
     * 查询库中所有表的表名
     * @return
     * @throws HbaseException
     */
    public List<String> getAllTableNames() throws HbaseException {
        try {
            TableName[] tableNames = admin.listTableNames();
            return Arrays.stream(tableNames)
                    .map(TableName::getNameAsString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new HbaseException(e);
        }
    }

    /**
     * 遍历查询指定表中的所有数据
     * @param tableName
     * @return
     */
    public Map<String, Map<String, String>> getResultScanner(String tableName) throws HbaseException {
        return queryData(tableName, new Scan());
    }

    /**
     * 根据startRowKey和stopRowKey遍历查询指定表中的所有数据
     * @param tableName   表名
     * @param startRowKey 起始rowKey
     * @param stopRowKey  结束rowKey
     * @return
     */
    public Map<String, Map<String, String>> getResultScanner(String tableName, String startRowKey, String stopRowKey) throws HbaseException {
        Scan scan = new Scan();
        if (StringUtils.isNotBlank(startRowKey) && StringUtils.isNotBlank(stopRowKey)) {
            scan.withStartRow(Bytes.toBytes(startRowKey));
            scan.withStopRow(Bytes.toBytes(stopRowKey));
        }
        return queryData(tableName, scan);
    }

    /**
     * 通过行前缀过滤器查询数据
     * @param tableName 表名
     * @param prefix    以prefix开始的行键
     * @return
     */
    public Map<String, Map<String, String>> getResultScannerPrefixFilter(String tableName, String prefix) throws HbaseException {
        Scan scan = new Scan();
        if (StringUtils.isNoneBlank(prefix)) {
            Filter filter = new PrefixFilter(Bytes.toBytes(prefix));
            scan.setFilter(filter);
        }
        return queryData(tableName, scan);
    }

    /**
     * 通过列前缀过滤器查询数据
     * @param tableName 表名
     * @param prefix    以prefix开始的列名
     * @return
     */
    public Map<String, Map<String, String>> getResultScannerColumnPrefixFilter(String tableName, String prefix) throws HbaseException {
        Scan scan = new Scan();
        if (StringUtils.isNotBlank(prefix)) {
            Filter filter = new ColumnPrefixFilter(Bytes.toBytes(prefix));
            scan.setFilter(filter);
        }
        return queryData(tableName, scan);
    }

    /**
     * 查询行键中包含特定字符的数据
     * @param tableName 表名
     * @param keyword   包含指定关键词的行键
     * @return
     */
    public Map<String, Map<String, String>> getResultScannerRowFilter(String tableName, String keyword) throws HbaseException {
        Scan scan = new Scan();
        if (StringUtils.isNotBlank(keyword)) {
            Filter filter = new RowFilter(CompareOperator.GREATER_OR_EQUAL, new SubstringComparator(keyword));
            scan.setFilter(filter);
        }
        return queryData(tableName, scan);
    }

    /**
     * 查询列名中包含特定字符的数据
     * @param tableName 表名
     * @param keyword   包含指定关键词的列名
     * @return
     */
    public Map<String, Map<String, String>> getResultScannerQualifierFilter(String tableName, String keyword) throws HbaseException {
        Scan scan = new Scan();
        if (StringUtils.isNotBlank(keyword)) {
            Filter filter = new QualifierFilter(CompareOperator.GREATER_OR_EQUAL, new SubstringComparator(keyword));
            scan.setFilter(filter);
        }
        return queryData(tableName, scan);
    }

    /**
     * 通过表名以及过滤条件查询数据
     * @param tableName 表名
     * @param scan      过滤条件
     * @return
     */
    private Map<String, Map<String, String>> queryData(String tableName, Scan scan) throws HbaseException {
        try {
            Map<String, Map<String, String>> result = Maps.newHashMap();
            Table table = getTable(tableName);
            ResultScanner rs = table.getScanner(scan);
            for (Result r : rs) {
                Map<String, String> columnMap = Maps.newHashMap();
                String rowKey = null;
                for (Cell cell : r.listCells()) {
                    if (null == rowKey) {
                        rowKey = Bytes.toString(cell.getRowArray(), cell.getRowOffset(), cell.getRowLength());
                    }
                    columnMap.put(Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength()),
                            Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
                if (null != rowKey) {
                    result.put(rowKey, columnMap);
                }
            }
            return result;
        } catch (IOException e) {
            throw new HbaseException(e);
        }
    }

    /**
     * 根据tableName和rowKey精确查询一行的数据
     * @param tableName 表名
     * @param rowKey    行键
     * @return 返回一行的数据
     * @throws HbaseException
     */
    public Map<String, String> getRowData(String tableName, String rowKey) throws HbaseException {
        try {
            Map<String, String> result = Maps.newHashMap();
            Get get = new Get(Bytes.toBytes(rowKey));
            Table table = getTable(tableName);
            Result hTableResult = table.get(get);
            if (null != hTableResult && !hTableResult.isEmpty()) {
                for (Cell cell : hTableResult.listCells()) {
                    result.put(Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength()),
                            Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
            }
            return result;
        } catch (IOException e) {
            throw new HbaseException(e);
        }
    }

    /**
     * 根据tableName、rowKey、familyName、column查询指定单元格的数据
     * @param tableName  表名
     * @param rowKey     rowKey
     * @param familyName 列族名
     * @param columnName 列名
     * @return
     * @throws HbaseException
     */
    public String getColumnValue(String tableName, String rowKey, String familyName, String columnName) throws HbaseException {
        try {
            String value = null;
            Get get = new Get(Bytes.toBytes(rowKey));
            Table table = getTable(tableName);
            Result result = table.get(get);
            if (null != result && !result.isEmpty()) {
                Cell cell = result.getColumnLatestCell(Bytes.toBytes(familyName), Bytes.toBytes(columnName));
                if (null != cell) {
                    value = Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
                }
            }
            return value;
        } catch (IOException e) {
            throw new HbaseException(e);
        }
    }

    /**
     * 根据tableName、rowKey、familyName、column查询指定单元格多个版本的数据
     * @param tableName  表名
     * @param rowKey
     * @param familyName 列族名
     * @param columnName 列名
     * @param versions   需要查询的版本数
     * @return
     */
    public List<String> getColumnValuesByVersion(String tableName, String rowKey, String familyName, String columnName, int versions)
            throws HbaseException {
        try {
            List<String> result = Lists.newArrayList();
            Get get = new Get(Bytes.toBytes(rowKey));
            get.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(columnName));
            get.readVersions(versions);
            Table table = getTable(tableName);
            Result hTableResult = table.get(get);
            if (null != hTableResult && !hTableResult.isEmpty()) {
                for (Cell cell : hTableResult.listCells()) {
                    result.add(Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength()));
                }
            }
            return result;
        } catch (IOException e) {
            throw new HbaseException(e);
        }
    }

    /**
     * 为表添加 or 更新数据
     * @param tableName  表名
     * @param rowKey     rowKey
     * @param familyName 列族名
     * @param columns    列名数组
     * @param values     列值得数组
     */
    public void putData(String tableName, String rowKey, String familyName, String[] columns, String[] values) throws HbaseException {
        try {
            Table table = getTable(tableName);
            putData(table, rowKey, familyName, columns, values);
        } catch (IOException e) {
            throw new HbaseException(e);
        }
    }

    /**
     * 为表添加 or 更新数据
     * @param table      表
     * @param rowKey     rowKey
     * @param familyName 列族名
     * @param columns    列名数组
     * @param values     列值得数组
     * @throws IOException
     */
    private void putData(Table table, String rowKey, String familyName, String[] columns, String[] values) throws IOException {
        Put put = new Put(Bytes.toBytes(rowKey));
        if (null != columns && null != values && columns.length == values.length) {
            for (int i = 0, len = columns.length; i < len; i++) {
                String columnName = columns[i];
                String value = values[i];
                if (null != columnName && null != value) {
                    put.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(columnName), Bytes.toBytes(value));
                } else {
                    throw new NullPointerException(MessageFormat.format("列名和列数据都不能为空,column:{0},value:{1}"
                            , columnName, value));
                }
            }
        }
        table.put(put);
        table.close();
    }

    /**
     * 为表的某个单元格赋值
     * @param tableName 表名
     * @param rowKey rowKey
     * @param familyName 列族名
     * @param columnName 列名
     * @param value 列值
     * @throws HbaseException
     */
    public void setColumnValue(String tableName, String rowKey, String familyName, String columnName, String value) throws HbaseException {
        try {
            Table table = getTable(tableName);
            Put put = new Put(Bytes.toBytes(rowKey));
            put.addColumn(Bytes.toBytes(familyName), Bytes.toBytes(columnName), Bytes.toBytes(value));
            table.put(put);
        } catch (IOException e) {
            throw new HbaseException(e);
        }
    }

    /**
     * 删除指定的单元格
     * @param tableName 表名
     * @param rowKey rowKey
     * @param familyName 列族名
     * @param columnName 列名
     * @return
     */
    public boolean deleteColumn(String tableName, String rowKey, String familyName, String columnName) throws HbaseException {
        try {
            boolean result = false;
            if (admin.tableExists(TableName.valueOf(tableName))) {
                Table table = getTable(tableName);
                Delete delete = new Delete(Bytes.toBytes(rowKey));
                delete.addColumns(Bytes.toBytes(familyName), Bytes.toBytes(columnName));
                table.delete(delete);
                result = true;
            }
            return result;
        } catch (IOException e) {
            throw new HbaseException(e);
        }
    }

    /**
     * 根据rowKey删除指定的行
     * @param tableName 表名
     * @param rowKey rowKey
     * @return
     * @throws HbaseException
     */
    public boolean deleteRow(String tableName, String rowKey) throws HbaseException {
        try {
            boolean result = false;
            if (admin.tableExists(TableName.valueOf(tableName))) {
                Table table = getTable(tableName);
                Delete delete = new Delete(Bytes.toBytes(rowKey));
                table.delete(delete);
                result = true;
            }
            return result;
        } catch (IOException e) {
            throw new HbaseException(e);
        }
    }

    /**
     * 根据columnFamily删除指定的列族
     * @param tableName 表名
     * @param columnFamily 列族
     * @return
     * @throws HbaseException
     */
    public boolean deleteColumnFamily(String tableName, String columnFamily) throws HbaseException {
        try {
            boolean result = false;
            if(admin.tableExists(TableName.valueOf(tableName))){
                admin.deleteColumnFamily(TableName.valueOf(tableName), Bytes.toBytes(columnFamily));
                result = true;
            }
            return result;
        } catch (IOException e) {
            throw new HbaseException(e);
        }
    }
    
    public boolean deleteTable(String tableName) throws HbaseException {
        try {
            boolean result = false;
            TableName tableNameObj = TableName.valueOf(tableName);
            if(admin.tableExists(tableNameObj)){
                admin.disableTable(tableNameObj);
                admin.deleteTable(tableNameObj);
                result = true;
            }
            return result;
        } catch (IOException e) {
            throw new HbaseException(e);
        }
    }

    /**
     * 获取表
     * @param tableName
     * @return
     * @throws IOException
     */
    private Table getTable(String tableName) throws IOException {
        return connection.getTable(TableName.valueOf(tableName));
    }

}

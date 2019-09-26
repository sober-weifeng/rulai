package com.rulai.generator;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.regex.Pattern;

public class MyBatisGenCore {

    /**
     * 根据表名获取字段信息
     * @param connection
     * @param table
     * @return
     * @throws Exception
     */
    public static List<Map<String, String>> getColInfoList(Connection connection, String table) throws Exception {
        String sql = "SELECT * FROM " + table + " WHERE 1 > 2";
        ResultSet columnResultSet = null;
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
             ){
            //获取主键串
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            columnResultSet = databaseMetaData.getColumns(null, null, table, "%");
            // 获取结果集元数据信息
            ResultSetMetaData rsmd = rs.getMetaData();
            int num = rsmd.getColumnCount();
            Map<String, String> map;
            Map<String, String> columnRemarkMap = Maps.newHashMap();
            List<Map<String, String>> list = new ArrayList<>();
            String columnName;
            String columnComment;
            while (columnResultSet.next()) {
                columnName = columnResultSet.getString("COLUMN_NAME");
                columnComment = columnResultSet.getString("REMARKS");
                columnRemarkMap.put(columnName, columnComment);
            }
            for (int i = 1; i <= num; i++) {
                map = Maps.newHashMap();
                columnName = rsmd.getColumnName(i);
                map.put(MyBatisGenConst.RSMD_COLUMN_NAME, columnName);
                map.put(MyBatisGenConst.RSMD_COLUMN_CLASS_NAME, rsmd.getColumnClassName(i));
                map.put(MyBatisGenConst.RSMD_COLUMN_TYPE_NAME, rsmd.getColumnTypeName(i));
                map.put(MyBatisGenConst.RSMD_COLUMN_PRECISION, Integer.toString(rsmd.getPrecision(i)));
                map.put(MyBatisGenConst.RSMD_COLUMN_SCALE, Integer.toString(rsmd.getScale(i)));
                map.put(MyBatisGenConst.RSMD_COLUMN_REMARK, columnRemarkMap.get(columnName));
                list.add(map);
            }
            return list;
        } catch (Exception e) {
            throw new Exception(e + ",table=" + table, e);
        } finally {
            columnResultSet.close();
        }
    }

    /**
     * 获取列信息
     * @param table
     * @return
     * @throws Exception
     */
    public static List<Map<String, String>> getColInfoList(String table) throws Exception {
        Connection connection = getConnection();
        try {
            return getColInfoList(connection, table);
        } finally {
            try {
                connection.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * 获取参数列表
     *
     * @param colInfoList
     * @return
     * @throws Exception
     */
    public static List<Map<String, String>> makeParamList(List<Map<String, String>> colInfoList) throws Exception {
        List<Map<String, String>> list = Lists.newArrayList();
        Map<String, String> map;
        int num = colInfoList.size();
        Map<String, String> mapNew;
        for (int i = 0; i < num; i++) {
            map = colInfoList.get(i);
            mapNew = new HashMap<>();
            String columnName = map.get(MyBatisGenConst.RSMD_COLUMN_NAME);
            String columnClassName = map.get(MyBatisGenConst.RSMD_COLUMN_CLASS_NAME);
            String columnTypeName = map.get(MyBatisGenConst.RSMD_COLUMN_TYPE_NAME);
            String columnComment = map.get(MyBatisGenConst.RSMD_COLUMN_REMARK);
            String scaleStr = map.get(MyBatisGenConst.RSMD_COLUMN_SCALE);
            int scale = NumberUtils.toInt(scaleStr);
            String precisionStr = map.get(MyBatisGenConst.RSMD_COLUMN_PRECISION);
            int precision = NumberUtils.toInt(precisionStr);
            String javaType = getJavaType(columnClassName, columnTypeName, scale, precision);
            String jdbcType = getJdbcType(columnClassName, columnTypeName);
            String propName = getPropName(columnName);
            String setMethod = getSetMethod(propName);
            String getMethod = getGetMethod(propName);
            mapNew.put(MyBatisGenConst.VP_COLUMN_NAME, columnName.toLowerCase());
            mapNew.put(MyBatisGenConst.VP_PROP_NAME, propName);
            mapNew.put(MyBatisGenConst.VP_JAVA_TYPE, javaType);
            mapNew.put(MyBatisGenConst.VP_JDBC_TYPE, jdbcType);
            mapNew.put(MyBatisGenConst.VP_GET_METHOD, getMethod);
            mapNew.put(MyBatisGenConst.VP_SET_METHOD, setMethod);
            mapNew.put(MyBatisGenConst.VP_COLUMN_COMMENT, columnComment);
            list.add(mapNew);
        }
        return list;
    }

    /**
     * 获取字段的java类型
     *
     * @param columnClassName 字段类名
     * @param columnTypeName  字段类型名称
     * @param scale           精度 小数位数
     * @return
     */
    public static String getJavaType(String columnClassName, String columnTypeName, int scale, int precision) {
        if (columnClassName.equals("java.sql.Timestamp")) {
            return "Date";
        }
        if (columnClassName.equals("java.lang.String")) {
            return "String";
        }
//        if (columnTypeName.equals("DECIMAL") && scale < 1) {
//            return "Long";
//        }
//        if (columnTypeName.equals("DECIMAL") && scale > 0) {
//            return "java.math.BigDecimal";
//        }
        if (columnTypeName.equals("DECIMAL")) {
            return "java.math.BigDecimal";
        }
        if (columnTypeName.startsWith("BIGINT")) {
            return "Long";
        }
        if (columnTypeName.startsWith("INT")) {
            return "Integer";
        }
        if (columnTypeName.startsWith("TINYINT") && precision == 1) {
            return "Integer";
        }
        if (columnTypeName.startsWith("TINYINT") && precision != 1) {
            return "Integer";
        }
        if (columnTypeName.startsWith("SMALLINT")) {
            return "Integer";
        }
        return columnClassName;
    }

    /**
     * 获取jdbc类型
     *
     * @param columnClassName 字段类名
     * @param columnTypeName  字段类型名称
     * @return
     */
    public static String getJdbcType(String columnClassName, String columnTypeName) {
        if (columnClassName.equals("java.lang.String")) {
            return "VARCHAR";
        }
        if (columnClassName.startsWith("java.sql.")) {
            return "TIMESTAMP";
        }
        if (columnTypeName.startsWith("NUMBER")) {
            return "DECIMAL";
        }
        if (columnTypeName.startsWith("INT")) {
            return "INTEGER";
        }
        if (columnTypeName.startsWith("BIGINT")) {
            return "BIGINT";
        }
        return columnTypeName;
    }

    /**
     * 根据表名获取java类型
     *
     * @param tableName 表名
     * @return
     */
    public static String getClassName(String tableName) {
        String t = tableName.toLowerCase();
        t = t.replace(MyBatisGenConst.TABLE_PREFIX, "");
        String[] arr = t.split("_");
        int num = arr.length;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < num; i++) {
            s.append(StringUtils.capitalize(arr[i]));
        }
        return s.toString();
    }

    /**
     * 根据字段名获取java数据对象属性名
     *
     * @param columnName 字段名
     * @return
     */
    public static String getPropName(String columnName) {
        String t = columnName.toLowerCase();
        String[] arr = t.split("_");
        int num = arr.length;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < num; i++) {
            if (i > 0) {
                s.append(StringUtils.capitalize(arr[i]));
            } else {
                s.append(arr[i]);
            }
        }
        return s.toString();
    }

    public static String getSetMethod(String propName) {
        return "set" + StringUtils.capitalize(propName);
    }

    public static String getGetMethod(String propName) {
        return "get" + StringUtils.capitalize(propName);
    }

    public static String getColsStr(List<Map<String, String>> list) {
        int num = list.size();
        Map<String, String> map;
        String colName;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            map = list.get(i);
            colName = map.get(MyBatisGenConst.VP_COLUMN_NAME);
            if (i > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(colName);
        }
        return stringBuilder.toString();
    }

    /**
     * velocity模板合并
     *
     * @param template 模板字符串 如 hello,${name}
     * @param paramMap 参数
     * @return
     * @throws Exception
     */
    public static String merge(String template, Map<String, Object> paramMap) {
        VelocityContext vc = new VelocityContext(paramMap);
        StringWriter writer = new StringWriter();
        Velocity.evaluate(vc, writer, "mybatis_code_gen", template);
        return writer.getBuffer().toString();
    }

    /**
     * 获取sqlmap 参数列表 去掉 主键 GMT_CREATE GMT_MODIFIED 字段
     *
     * @param paramList
     * @param pks
     * @return
     * @throws Exception
     */
    public static List<Map<String, String>> getSqlmapParamList(List<Map<String, String>> paramList, String pks) {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> tmp;
        Map<String, String> map;
        int num = paramList.size();
        for (int i = 0; i < num; i++) {
            tmp = paramList.get(i);
            String columnName = tmp.get(MyBatisGenConst.VP_COLUMN_NAME);
            if (columnName.equalsIgnoreCase(pks)) {
                continue;
            }
            if (columnName.equalsIgnoreCase(MyBatisGenConst.GMT_CREATE)) {
                continue;
            }
            if (columnName.equalsIgnoreCase(MyBatisGenConst.GMT_UPDATE)) {
                continue;
            }
            map = Maps.newHashMap();
            map.putAll(tmp);
            list.add(map);
        }
        return list;
    }

    /**
     * 根据表名生成java数据对象类文件和sqlmap文件
     *
     * @param table 表名
     * @throws Exception
     */
    public static void gen(String table) throws Exception {
        //拿出pkList
        List<Map<String, String>> colInfoList = getColInfoList(table);
        List<Map<String, String>> paramList = makeParamList(colInfoList);
        boolean isSharding = Pattern.compile(MyBatisGenConst.SHARDING_SUFFIX_REG).matcher(table).find();
        if (isSharding) {
            // 去掉分库分表后面的表后缀，如_0001
            table = table.replaceAll(MyBatisGenConst.SHARDING_SUFFIX_REG, "");
        }

        String className = getClassName(table);
        String encoding = MyBatisGenConst.DEFAULT_ENCODING;

        String doTemplate = FileUtils.readFileToString(new File(MyBatisGenConst.DO_TEMPLATE), encoding);
        String queryTemplate = FileUtils.readFileToString(new File(MyBatisGenConst.QUERY_TEMPLATE), encoding);
        String sqlmapTemplate = FileUtils.readFileToString(new File(MyBatisGenConst.SQLMAP_TEMPLATE), encoding);
        String sqlmapExtTemplate = FileUtils.readFileToString(new File(MyBatisGenConst.SQLMAP_EXT_TEMPLATE), encoding);
        String mapperTemplate = FileUtils.readFileToString(new File(MyBatisGenConst.MAPPER_TEMPLATE), encoding);
        String mapperExtTemplate = FileUtils.readFileToString(new File(MyBatisGenConst.MAPPER_EXT_TEMPLATE), encoding);
        String managerTemplate = FileUtils.readFileToString(new File(MyBatisGenConst.MANAGER_TEMPLATE), encoding);
//        String managerImplTemplate = FileUtils.readFileToString(new File(MyBatisGenConst.MANAGER_IMPL_TEMPLATE), encoding);
//        String serviceTemplate = FileUtils.readFileToString(new File(MyBatisGenConst.SERVICE_TEMPLATE), encoding);
//        String serviceImplTemplate = FileUtils.readFileToString(new File(MyBatisGenConst.SERVICE_IMPL_TEMPLATE), encoding);

        Map<String, Object> param = Maps.newHashMap();

        param.put(MyBatisGenConst.VP_DO_PACKAGE, MyBatisGenConst.DO_PACKAGE);
        param.put(MyBatisGenConst.VP_QUERY_PACKAGE, MyBatisGenConst.QUERY_PACKAGE);
        param.put(MyBatisGenConst.VP_MAPPER_PACKAGE, MyBatisGenConst.MAPPER_PACKAGE);
        param.put(MyBatisGenConst.VP_MAPPER_EXT_PACKAGE, MyBatisGenConst.MAPPER_EXT_PACKAGE);
        param.put(MyBatisGenConst.VP_MANAGER_PACKAGE, MyBatisGenConst.MANAGER_PACKAGE);
//        param.put(MyBatisGenConst.VP_MANAGER_IMPL_PACKAGE, MyBatisGenConst.MANAGER_IMPL_PACKAGE);
//        param.put(MyBatisGenConst.VP_SERVICE_PACKAGE, MyBatisGenConst.SERVICE_PACKAGE);
//        param.put(MyBatisGenConst.VP_SERVICE_IMPL_PACKAGE, MyBatisGenConst.SERVICE_IMPL_PACKAGE);

        param.put(MyBatisGenConst.VP_BASEQUERY_PACKAGE, MyBatisGenConst.BASEQUERY_PACKAGE);
        param.put(MyBatisGenConst.VP_PAGERESULT_PACKAGE, MyBatisGenConst.PAGERESULT_PACKAGE);
        param.put(MyBatisGenConst.VP_BASECRITERIA_PACKAGE, MyBatisGenConst.BASECRITERIA_PACKAGE);
        
        param.put(MyBatisGenConst.VP_CLASS_NAME, className);
        String classNameLower = className.substring(0, 1).toLowerCase() + className.substring(1);
        param.put(MyBatisGenConst.VP_CLASS_NAME_LOWER, classNameLower);

        param.put(MyBatisGenConst.VP_MANAGER_MAPPER_NAME, classNameLower + MyBatisGenConst.MAPPER_SUFFIX);
        param.put("currentTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        param.put(MyBatisGenConst.VP_ALL_LIST, paramList);
        
        param.put(MyBatisGenConst.VP_QUERY_PREFIX, MyBatisGenConst.QUERY_PREFIX);
        param.put(MyBatisGenConst.VP_DO_SUFFIX, MyBatisGenConst.DO_SUFFIX);
        param.put(MyBatisGenConst.VP_MAPPER_SUFFIX, MyBatisGenConst.MAPPER_SUFFIX);
        param.put(MyBatisGenConst.VP_MAPPER_EXT_SUFFIX, MyBatisGenConst.MAPPER_EXT_SUFFIX);
        param.put(MyBatisGenConst.VP_MANAGER_SUFFIX, MyBatisGenConst.MANAGER_SUFFIX);
//        param.put(MyBatisGenConst.VP_MANAGER_IMPL_SUFFIX, MyBatisGenConst.MANAGER_IMPL_SUFFIX);
//        param.put(MyBatisGenConst.VP_SERVICE_SUFFIX, MyBatisGenConst.SERVICE_SUFFIX);
//        param.put(MyBatisGenConst.VP_SERVICE_IMPL_SUFFIX, MyBatisGenConst.SERVICE_IMPL_SUFFIX);

        String vpTableName = table.toLowerCase();
        if (isSharding) {
            vpTableName += "_$tabNum$";
        }

        param.put(MyBatisGenConst.VP_TABLE_NAME, vpTableName);
        
        param.put(MyBatisGenConst.VP_SERIAL_VERSION_UID, Long.toString((long) (Math.random() * 1000000000000000000L)));
        param.put(MyBatisGenConst.VP_SERIAL_VERSION_UID2, Long.toString((long) (Math.random() * 1000000000000000000L)));

        String vpPropPkName = paramList.get(0).get(MyBatisGenConst.VP_PROP_NAME);
        String vpColumnPkName = paramList.get(0).get(MyBatisGenConst.VP_COLUMN_NAME);
        String vpJavaTypePk = paramList.get(0).get(MyBatisGenConst.VP_JAVA_TYPE);
        String vpJdbcTypePk = paramList.get(0).get(MyBatisGenConst.VP_JDBC_TYPE);

        String commonColumns = MyBatisGenConst.COMMON_COLUMN_STR.concat(vpColumnPkName).concat(",");
        // 获取字段名不包含 id gmt_create gmt_modified 去掉主键
        List<Map<String, String>> sqlmapParamList = getSqlmapParamList(paramList, commonColumns);
        param.put(MyBatisGenConst.VP_LIST, sqlmapParamList);

        String cols = getColsStr(paramList);
        param.put(MyBatisGenConst.VP_COLS, cols);
        //这样只支持 单个主键
        param.put(MyBatisGenConst.VP_COLUMN_PK_NAME, vpColumnPkName);
        param.put(MyBatisGenConst.VP_PROP_PK_NAME, vpPropPkName);
        param.put(MyBatisGenConst.VP_JDBC_TYPE_PK, vpJdbcTypePk);
        param.put(MyBatisGenConst.VP_JAVA_TYPE_PK, vpJavaTypePk);
        //param添加主键
        
        String doResult = merge(doTemplate, param);
        String queryResult = merge(queryTemplate, param);
        String sqlmapResult = merge(sqlmapTemplate, param);
        String sqlmapExtResult = merge(sqlmapExtTemplate, param);
        String mapperResult = merge(mapperTemplate, param);
        String mapperExtResult = merge(mapperExtTemplate, param);
        String managerResult = merge(managerTemplate, param);
//        String managerImplResult = merge(managerImplTemplate, param);
//        String serviceResult = merge(serviceTemplate, param);
//        String serviceImplResult = merge(serviceImplTemplate, param);

        String doOutFilePath = MyBatisGenConst.MAPPER_DO_DIR + "/" + className + MyBatisGenConst.DO_SUFFIX + ".java";
        String queryOutFilePath = MyBatisGenConst.MAPPER_QUERY_DIR + "/" + className + MyBatisGenConst.QUERY_PREFIX + ".java";
        String sqlmapOutFilePath = MyBatisGenConst.MAPPER_XML_DIR + "/" + className + MyBatisGenConst.MAPPER_SUFFIX + ".xml";
        String sqlmapExtOutFilePath = MyBatisGenConst.MAPPER_EXT_XML_DIR + "/" + className + MyBatisGenConst.MAPPER_EXT_SUFFIX + ".xml";
        String mapperOutFilePath = MyBatisGenConst.MAPPER_JAVA_DIR + "/" + className + MyBatisGenConst.MAPPER_SUFFIX + ".java";
        String mapperExtOutFilePath = MyBatisGenConst.MAPPER_EXT_JAVA_DIR + "/" + className + MyBatisGenConst.MAPPER_EXT_SUFFIX + ".java";
        String managerOutFilePath = MyBatisGenConst.MANAGER_JAVA_DIR + "/" + className + MyBatisGenConst.MANAGER_SUFFIX + ".java";
//        String managerImplOutFilePath = MyBatisGenConst.MANAGER_IMPL_JAVA_DIR + "/" + className + MyBatisGenConst.MANAGER_IMPL_SUFFIX + ".java";
//        String serviceOutFilePath = MyBatisGenConst.SERVICE_JAVA_DIR + "/" + className + MyBatisGenConst.SERVICE_SUFFIX + ".java";
//        String serviceImplOutFilePath = MyBatisGenConst.SERVICE_IMPL_JAVA_DIR + "/" + className + MyBatisGenConst.SERVICE_IMPL_SUFFIX + ".java";
        
        if (!createFilePath(MyBatisGenConst.MAPPER_DO_DIR)) {
            printMkdirError(MyBatisGenConst.MAPPER_DO_DIR, table);
            return;
        }

        if (!createFilePath(MyBatisGenConst.MAPPER_QUERY_DIR)) {
            printMkdirError(MyBatisGenConst.MAPPER_QUERY_DIR, table);
            return;
        }

        if (!createFilePath(MyBatisGenConst.MAPPER_XML_DIR)) {
            printMkdirError(MyBatisGenConst.MAPPER_XML_DIR, table);
            return;
        }

        if (!createFilePath(MyBatisGenConst.MAPPER_EXT_XML_DIR)) {
            printMkdirError(MyBatisGenConst.MAPPER_EXT_XML_DIR, table);
            return;
        }

        if (!createFilePath(MyBatisGenConst.MAPPER_JAVA_DIR)) {
            printMkdirError(MyBatisGenConst.MAPPER_JAVA_DIR, table);
            return;
        }

        if (!createFilePath(MyBatisGenConst.MAPPER_EXT_JAVA_DIR)) {
            printMkdirError(MyBatisGenConst.MAPPER_EXT_JAVA_DIR, table);
            return;
        }

        if (!createFilePath(MyBatisGenConst.MANAGER_JAVA_DIR)) {
            printMkdirError(MyBatisGenConst.MANAGER_JAVA_DIR, table);
            return;
        }

//        if (!createFilePath(MyBatisGenConst.MANAGER_IMPL_JAVA_DIR)) {
//            printMkdirError(MyBatisGenConst.MANAGER_IMPL_JAVA_DIR, table);
//            return;
//        }
//
//        if (!createFilePath(MyBatisGenConst.SERVICE_JAVA_DIR)) {
//            printMkdirError(MyBatisGenConst.SERVICE_JAVA_DIR, table);
//            return;
//        }
//
//        if (!createFilePath(MyBatisGenConst.SERVICE_IMPL_JAVA_DIR)) {
//            printMkdirError(MyBatisGenConst.SERVICE_IMPL_JAVA_DIR, table);
//            return;
//        }

        if (!createSourceFileForceReplace(doOutFilePath, doResult)) {
            printCreateFileError(doOutFilePath, table);
            return;
        }

        if (!createSourceFileForceReplace(queryOutFilePath, queryResult)) {
            printCreateFileError(mapperOutFilePath, table);
            return;
        }

        if (!createSourceFileForceReplace(sqlmapOutFilePath, sqlmapResult)) {
            printCreateFileError(sqlmapExtOutFilePath, table);
            return;
        }

        if (!createSourceFileForceReplace(mapperOutFilePath, mapperResult)) {
            printCreateFileError(mapperOutFilePath, table);
            return;
        }

        if (!createSourceFileNoForceReplace(mapperExtOutFilePath, mapperExtResult)) {
            printCreateFileError(mapperOutFilePath, table);
            return;
        }

        if (!createSourceFileNoForceReplace(sqlmapExtOutFilePath, sqlmapExtResult)) {
            printCreateFileError(mapperOutFilePath, table);
            return;
        }

        if (!createSourceFileNoForceReplace(managerOutFilePath, managerResult)) {
            printCreateFileError(mapperOutFilePath, table);
            return;
        }

//        if (!createSourceFileNoForceReplace(managerImplOutFilePath, managerImplResult)) {
//            printCreateFileError(mapperOutFilePath, table);
//            return;
//        }
//
//        if (!createSourceFileNoForceReplace(serviceOutFilePath, serviceResult)) {
//            printCreateFileError(mapperOutFilePath, table);
//            return;
//        }
//
//        if (!createSourceFileNoForceReplace(serviceImplOutFilePath, serviceImplResult)) {
//            printCreateFileError(mapperOutFilePath, table);
//            return;
//        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static Connection getConnection() throws ClassNotFoundException, SQLException, FileNotFoundException,
            IOException {
        Properties prop = new Properties();
        prop.load(ClassLoader.getSystemResourceAsStream("db.config"));
        String driver = prop.getProperty("driver");
        Class.forName(driver);
        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String psw = prop.getProperty("pwd");
        return DriverManager.getConnection(url, user, psw);
    }

    /**
     * 批量生成java数据对象类文件和sqlmap文件
     *
     * @param tables 表 多个表用逗号分隔 table1,table2,table3
     * @throws Exception
     */
    public static void batchGen(List<String> tables) throws Exception {
        System.out.println("table num " + tables.size());
        Connection connection = getConnection();
        try {
            for (String table : tables) {
                gen(table.trim());
                System.out.println(table.trim() + " done");
            }
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
    }
    
    private static void printMkdirError(String dir, String table) {
        println(String.format("mkdir %s error, shutdown sync %s", dir, table));
    }

    private static void printCreateFileError(String dir, String table) {
        println(String.format("createNewFile %s error, shutdown sync %s", dir, table));
    }
    
    private static void println(String message) {
        System.out.println(message);
    }
    
    private static boolean createSourceFile(String filePath, String result, boolean isForce) throws IOException {
        File file = new File(filePath);
        boolean isSuccess;
        if (!file.exists()) {
            isSuccess = file.createNewFile();
            if (!isSuccess) {
                return isSuccess;
            }
            FileUtils.writeStringToFile(file, result, MyBatisGenConst.DEFAULT_ENCODING);
        } else {
            if (isForce) {
                FileUtils.writeStringToFile(file, result, MyBatisGenConst.DEFAULT_ENCODING);
            }
            isSuccess = true;
        }
        return isSuccess;
    }

    private static boolean createSourceFileForceReplace(String filePath, String result) throws IOException {
        return createSourceFile(filePath, result, true);
    }

    private static boolean createSourceFileNoForceReplace(String filePath, String result) throws IOException {
        return createSourceFile(filePath, result, false);
    }

    private static boolean createFilePath(String path) {
        File dirFile = new File(path);
        boolean isSuccess;
        if (!dirFile.exists()) {
            isSuccess = dirFile.mkdirs();
        } else {
            isSuccess = true;
        }
        return isSuccess;
    }
}

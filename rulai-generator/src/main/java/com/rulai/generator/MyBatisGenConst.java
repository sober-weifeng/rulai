package com.rulai.generator;

import java.io.File;

/**
 * mybatisgen generate constants.
 *
 * @author xizhe.
 */
public class MyBatisGenConst {

    // 包名
    public static final String DAL_PACKAGE = "com.rulai.spider";
    public static final String BEAN_PACKAGE = "com.rulai.spider.bean";
//    public static final String BIZ_PACKAGE = "com.bmw.biz";
    public static final String DO_PACKAGE = BEAN_PACKAGE + ".model";
    public static final String QUERY_PACKAGE = BEAN_PACKAGE + ".query";
    public static final String MAPPER_PACKAGE = DAL_PACKAGE + ".mapper";
    public static final String MAPPER_EXT_PACKAGE = MAPPER_PACKAGE + ".ext";
    public static final String MANAGER_PACKAGE = DAL_PACKAGE + ".manager";
//    public static final String MANAGER_IMPL_PACKAGE = MANAGER_PACKAGE + ".impl";
//    public static final String SERVICE_PACKAGE = BIZ_PACKAGE + ".service";
//    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";

    public static final String PAGERESULT_PACKAGE = "com.rulai.common.component.PageResult";
    public static final String BASEQUERY_PACKAGE = "com.rulai.common.component.BaseQuery";
    public static final String BASECRITERIA_PACKAGE = "com.rulai.common.component.BaseCriteria";
    
    public static final String TABLE_PREFIX = "";
    public static final String QUERY_PREFIX = "Query";
    public static final String MAPPER_SUFFIX = "Mapper";
    public static final String MAPPER_EXT_SUFFIX = "ExtMapper";
    public static final String MANAGER_SUFFIX = "Manager";
//    public static final String MANAGER_IMPL_SUFFIX = "ManagerImpl";
//    public static final String SERVICE_SUFFIX = "Service";
//    public static final String SERVICE_IMPL_SUFFIX = "ServiceImpl";
    public static final String DO_SUFFIX = "DO";

    // 工作目录
    public static final String WORK_DIR = System.getProperty("user.dir") + File.separator;
    // do/model 输出目录
    public static final String MAPPER_DO_DIR = WORK_DIR + "rulai-spider/src/main/java/com/rulai/spider/bean/model";
    // query 输出目录
    public static final String MAPPER_QUERY_DIR = WORK_DIR + "rulai-spider/src/main/java/com/rulai/spider/bean/query";
    // mapper xml 输出目录
    public static final String MAPPER_XML_DIR = WORK_DIR + "rulai-spider/src/main/resources/mapper/cookbook/";
    // mapper-ext xml 输出目录
    public static final String MAPPER_EXT_XML_DIR = MAPPER_XML_DIR + "ext/";
    // mapper java 输出目录
    public static final String MAPPER_JAVA_DIR = WORK_DIR + "rulai-spider/src/main/java/com/rulai/spider/mapper";
    // mapper-ext java 输出目录
    public static final String MAPPER_EXT_JAVA_DIR = MAPPER_JAVA_DIR + "/ext";
    
    public static final String MANAGER_JAVA_DIR = WORK_DIR + "rulai-spider/src/main/java/com/rulai/spider/manager";
    
//    public static final String MANAGER_IMPL_JAVA_DIR =  MANAGER_JAVA_DIR +"/impl";
//
//    public static final String SERVICE_JAVA_DIR = WORK_DIR + "bmw-web/src/main/java/com/bmw/biz/service";
//
//    public static final String SERVICE_IMPL_JAVA_DIR =  SERVICE_JAVA_DIR +"/impl";

    // java数据对象类模板
    public static final String DO_TEMPLATE = ClassLoader.getSystemResource("template/do.txt").getPath();//  "resources/template/do.txt";
    // query 模板
    public static final String QUERY_TEMPLATE = ClassLoader.getSystemResource("template/query.txt").getPath();
    // sqlmap模板
    public static final String SQLMAP_TEMPLATE = ClassLoader.getSystemResource("template/sqlmap.txt").getPath();
    // sqlmap-ext模板
    public static final String SQLMAP_EXT_TEMPLATE = ClassLoader.getSystemResource("template/sqlmap-ext.txt").getPath();
    // mapper模板
    public static final String MAPPER_TEMPLATE = ClassLoader.getSystemResource("template/mapper.txt").getPath();
    // mapper-ext模板
    public static final String MAPPER_EXT_TEMPLATE = ClassLoader.getSystemResource("template/mapper-ext.txt").getPath();
    // manager模板
    public static final String MANAGER_TEMPLATE = ClassLoader.getSystemResource("template/manager.txt").getPath();
    // manager impl 模板
//    public static final String MANAGER_IMPL_TEMPLATE = ClassLoader.getSystemResource("template/manager.txt").getPath();
//    // service模板
//    public static final String SERVICE_TEMPLATE = ClassLoader.getSystemResource("template/service.txt").getPath();
//    // service impl 模板
//    public static final String SERVICE_IMPL_TEMPLATE = ClassLoader.getSystemResource("template/serviceImpl.txt").getPath();

    public static final String COMMON_COLUMN_STR = "";

    // jdbc result set metadata collumn name
    public static final String RSMD_COLUMN_NAME = "rsmdColumnName";
    public static final String RSMD_COLUMN_CLASS_NAME = "columnClassName";
    public static final String RSMD_COLUMN_TYPE_NAME = "columnTypeName";
    public static final String RSMD_COLUMN_PRECISION = "Precision";
    public static final String RSMD_COLUMN_SCALE = "Scale";
    public static final String RSMD_COLUMN_REMARK = "remark";
    public static final String RSMD_COLUMN_PRIMARY_KEY = "PrimaryKey";

    public static final String COLUMN_NAME = "COLUMN_NAME";

    // velocity param
    public static final String VP_LIST = "list";
    public static final String VP_ALL_LIST = "allList";
    public static final String VP_QUERY_PREFIX = "queryPrefix";
    public static final String VP_DO_SUFFIX = "doSuffix";
    public static final String VP_MAPPER_SUFFIX = "mapperSuffix";
    public static final String VP_MAPPER_EXT_SUFFIX = "extMapperSuffix";
    public static final String VP_MANAGER_SUFFIX = "managerSuffix";
//    public static final String VP_MANAGER_IMPL_SUFFIX = "managerImplSuffix";
//    public static final String VP_SERVICE_SUFFIX = "serviceSuffix";
//    public static final String VP_SERVICE_IMPL_SUFFIX = "serviceImplSuffix";

    public static final String VP_CLASS_NAME = "className";
    public static final String VP_CLASS_NAME_LOWER = "classNameLower";
    public static final String VP_MANAGER_MAPPER_NAME = "managerMapperName";
    public static final String VP_DO_PACKAGE = "doPackage";
    public static final String VP_QUERY_PACKAGE = "queryPackage";
    public static final String VP_MAPPER_PACKAGE = "mapperPackage";
    public static final String VP_MAPPER_EXT_PACKAGE = "mapperExtPackage";
    public static final String VP_MANAGER_PACKAGE = "managerPackage";
//    public static final String VP_MANAGER_IMPL_PACKAGE = "managerImplPackage";
//    public static final String VP_SERVICE_PACKAGE = "servicePackage";
//    public static final String VP_SERVICE_IMPL_PACKAGE = "serviceImplPackage";
    public static final String VP_JAVA_TYPE = "javaType";
    public static final String VP_PROP_NAME = "propName";
    public static final String VP_GET_METHOD = "getMethod";

    public static final String VP_PAGERESULT_PACKAGE = "pageResultPackage";
    public static final String VP_BASEQUERY_PACKAGE = "baseQueryPackage";
    public static final String VP_BASECRITERIA_PACKAGE = "baseCriteriaPackage";

    public static final String VP_SET_METHOD = "setMethod";
    public static final String VP_COLUMN_NAME = "columnName";
    public static final String VP_TABLE_NAME = "tableName";
    public static final String VP_JDBC_TYPE = "jdbcType";
    public static final String VP_COLUMN_COMMENT = "columnComment";
    public static final String VP_COLS = "cols";
    public static final String VP_SERIAL_VERSION_UID = "serialVersionUID";

    public static final String VP_SERIAL_VERSION_UID2 = "serialVersionUID2";
    public static final String VP_COLUMN_PK_NAME = "columnPkName";
    public static final String VP_PROP_PK_NAME = "propPkName";
    public static final String VP_JAVA_TYPE_PK = "javaTypePk";
    public static final String VP_JDBC_TYPE_PK = "jdbcTypePk";

    //分库分表 表后缀regex
    public static final String SHARDING_SUFFIX_REG = "_[\\d]{4}";
    
    public static final String GMT_CREATE = "GMT_CREATE";
    public static final String GMT_UPDATE = "GMT_UPDATE";
    
    public static final String DEFAULT_ENCODING = "UTF-8";

}

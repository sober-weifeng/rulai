package com.rulai.distributed.redis.connection;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/10/8 16:36
 */
public enum DataType {
    
    NONE("none"), 
    STRING("string"), 
    LIST("list"), 
    SET("set"), 
    ZSET("zset"), 
    HASH("hash"),
    ;
    
    private static final Map<String, DataType> codeLookup = new ConcurrentHashMap<>(6);
    
    static {
        for (DataType dataType : EnumSet.allOf(DataType.class)) {
            codeLookup.put(dataType.code, dataType);
        }
    }
    
    private final String code;

    DataType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
    
    public static DataType fromCode(String code) {
        DataType dataType = codeLookup.get(code);
        if (null == dataType) {
            throw new IllegalArgumentException("unknown data type code");
        }
        return dataType;
    }
}

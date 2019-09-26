package com.rulai.mybatis.session.impl;

import com.rulai.mybatis.config.JdbcProperties;
import com.rulai.mybatis.config.MapperStatement;
import com.rulai.mybatis.session.Executor;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/2 14:28
 */
public class SimpleExecutor implements Executor {

    private JdbcProperties jdbcProperties;

    public SimpleExecutor(JdbcProperties jdbcProperties) {
        this.jdbcProperties = jdbcProperties;
    }

    @Override
    public <E> List<E> query(MapperStatement mapperStatement, Object parameter) {
        List<E> ret = new ArrayList<>();
        try {
            Class.forName(jdbcProperties.getDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection = DriverManager.getConnection(jdbcProperties.getUrl(), jdbcProperties.getUsername(), jdbcProperties.getPassword());
                PreparedStatement preparedStatement = connection.prepareStatement(mapperStatement.getSql());
        ) {
            parameterize(preparedStatement, parameter);
            ResultSet resultSet = preparedStatement.executeQuery();
            handlerResultSet(resultSet, ret, mapperStatement.getResultType());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    private void parameterize(PreparedStatement preparedStatement, Object parameter) throws SQLException {
        if (parameter instanceof String) {
            preparedStatement.setString(1, (String) parameter);
        } else if (parameter instanceof Long) {
            preparedStatement.setLong(1, (Long) parameter);
        } else if (parameter instanceof Integer) {
            preparedStatement.setInt(1, (Integer) parameter);
        }
    }

    private <E> void handlerResultSet(ResultSet resultSet, List<E> ret, String className) {
        Class<E> clazz = null;
        try {
            clazz = (Class<E>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while (resultSet.next()) {
                // 通过反射实例化对象
                Object entity = clazz.newInstance();
                // 使用反射工具将resultSet中的数据填充到entity中
                // id,name,sex,age
                // 获取实体类的所有属性，返回Field数组
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    String fname = field.getName();
                    Type type = field.getGenericType();
                    if (type.toString().equals("class java.lang.String")) {
                        String column = resultSet.getString(fname);
                        field.set(entity, column);
                    } else if (type.toString().equals("long")) {
                        Long column = resultSet.getLong(fname);
                        field.set(entity, column);
                    }
                }
                ret.add((E) entity);
            }
        } catch (SQLException 
                | InstantiationException 
                | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}

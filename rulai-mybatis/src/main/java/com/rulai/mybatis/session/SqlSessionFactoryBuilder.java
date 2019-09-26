package com.rulai.mybatis.session;

import com.rulai.mybatis.config.Configuration;
import com.rulai.mybatis.config.JdbcProperties;
import com.rulai.mybatis.config.MapperStatement;
import com.rulai.mybatis.session.impl.DefaultSqlSessionFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * <p></p>
 * @author z```s
 * @version 1.0
 * @date 2019/9/2 14:10
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(InputStream inputStream) {
        SAXReader saxReader = new SAXReader();
        Document document = null;
        Configuration configuration = new Configuration();
        try {
            document = saxReader.read(inputStream);
            Element configElement = document.getRootElement();
            Element propertiesElement = configElement.element("properties");
            String jdbcPropertiesPath = propertiesElement.attributeValue("resource");
            loadProperties(configuration, jdbcPropertiesPath);
            Element mappersElement = configElement.element("mappers");
            List<Element> mapperElements = mappersElement.elements("mapper");
            for (Element mapperElement : mapperElements) {
                String mapperPath = mapperElement.attributeValue("resource");
                loadMapperStatement(configuration, mapperPath);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return new DefaultSqlSessionFactory(configuration);
    }

    /**
     * 加载配置信息
     * @param configuration
     */
    private void loadProperties(Configuration configuration, String jdbcPropertiesPath) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(jdbcPropertiesPath);
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JdbcProperties jdbcProperties = new JdbcProperties();
        jdbcProperties.setUrl(properties.getProperty("url"));
        jdbcProperties.setDriver(properties.getProperty("driver"));
        jdbcProperties.setPassword(properties.getProperty("password"));
        jdbcProperties.setUsername(properties.getProperty("username"));
        configuration.setJdbcProperties(jdbcProperties);
    }

    /**
     * 加载mapper信息
     * @param configuration
     * @param mapperPath
     */
    private void loadMapperStatement(Configuration configuration, String mapperPath) {
        SAXReader reader = new SAXReader();
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(mapperPath);
            Document document = reader.read(inputStream);
            Element rootEle = document.getRootElement();
            //获取命名空间
            String namespace = rootEle.attributeValue("namespace");
            MapperStatement mapperStatement;
            for (Element ele : rootEle.elements()) {
                mapperStatement = new MapperStatement();
                mapperStatement.setQueryType(ele.getName());
                mapperStatement.setId(namespace + "." + ele.attributeValue("id"));
                mapperStatement.setResultType(ele.attributeValue("resultType"));
                mapperStatement.setSql(ele.getText());
                configuration.addMapperStatement(mapperStatement);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}

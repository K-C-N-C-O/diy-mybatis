package cn.kcnco.mybatis.session;

import cn.kcnco.mybatis.builder.xml.XMLConfigBuilder;
import cn.kcnco.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @program: diy-mybatis
 * @description:
 * @author: KCNCO
 **/
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader){
        XMLConfigBuilder xmlConfigBuilder=new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }


    public SqlSessionFactory build(Configuration config){
        return new DefaultSqlSessionFactory(config);
    }
}

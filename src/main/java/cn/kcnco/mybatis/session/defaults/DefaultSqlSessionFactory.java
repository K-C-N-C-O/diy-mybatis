package cn.kcnco.mybatis.session.defaults;

import cn.kcnco.mybatis.binding.MapperRegistry;
import cn.kcnco.mybatis.session.Configuration;
import cn.kcnco.mybatis.session.SqlSession;
import cn.kcnco.mybatis.session.SqlSessionFactory;

/**
 * @program: diy-mybatis
 * @description:默认的 DefaultSqlSessionFactory
 * @author: KCNCO
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}

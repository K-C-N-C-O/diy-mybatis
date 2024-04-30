package cn.kcnco.mybatis.session.defaults;

import cn.kcnco.mybatis.binding.MapperRegistry;
import cn.kcnco.mybatis.session.SqlSession;
import cn.kcnco.mybatis.session.SqlSessionFactory;

/**
 * @program: diy-mybatis
 * @description:默认的 DefaultSqlSessionFactory
 * @author: KCNCO
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}

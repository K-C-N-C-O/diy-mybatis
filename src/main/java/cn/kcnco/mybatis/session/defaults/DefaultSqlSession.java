package cn.kcnco.mybatis.session.defaults;

import cn.kcnco.mybatis.binding.MapperRegistry;
import cn.kcnco.mybatis.executor.Executor;
import cn.kcnco.mybatis.mapping.BoundSql;
import cn.kcnco.mybatis.mapping.Environment;
import cn.kcnco.mybatis.mapping.MappedStatement;
import cn.kcnco.mybatis.session.Configuration;
import cn.kcnco.mybatis.session.SqlSession;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: diy-mybatis
 * @description:
 * @author: KCNCO
 **/
public class DefaultSqlSession implements SqlSession {

    /*
    映射器注册机
     */
    private Configuration configuration;

    private Executor executor;

    public DefaultSqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    @Override
    public <T> T selectOne(String statement) {
        return this.selectOne(statement, null);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement ms = configuration.getMappedStatement(statement);
        List<T> list = executor.query(ms, parameter, Executor.NO_RESULT_HANDLER, ms.getBoundSql());
        return list.get(0);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type,this);
    }

    @Override
    public Configuration getConfiguration() {
        return configuration;
    }


}

package cn.kcnco.mybatis.session;

import cn.kcnco.mybatis.binding.MapperRegistry;
import cn.kcnco.mybatis.datasource.druid.DruidDataSourceFactory;
import cn.kcnco.mybatis.mapping.Environment;
import cn.kcnco.mybatis.mapping.MappedStatement;
import cn.kcnco.mybatis.transaction.jdbc.JdbcTransactionFactory;
import cn.kcnco.mybatis.type.TypeAliasRegistry;


import java.util.HashMap;
import java.util.Map;

/**
 * @program: diy-mybatis
 * @description:配置项
 * @author: KCNCO
 **/
public class Configuration {


    //环境
    protected Environment environment;

    // 映射注册机
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    // 映射的语句，存在Map里
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    // 类型别名注册机
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();

    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
    }

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }

    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }


}

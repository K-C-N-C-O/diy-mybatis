package cn.kcnco.mybatis.session;

import cn.kcnco.mybatis.binding.MapperRegistry;
import cn.kcnco.mybatis.mapping.MappedStatement;


import java.util.HashMap;
import java.util.Map;

/**
 * @program: diy-mybatis
 * @description:配置项
 * @author: KCNCO
 **/
public class Configuration {

    /*
    映射注册机
     */

    protected MapperRegistry mapperRegistry=new MapperRegistry(this);

    /*
    映射的语句存在Map里
     */
    protected final Map<String, MappedStatement> mappedStatements=new HashMap<>();

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


}

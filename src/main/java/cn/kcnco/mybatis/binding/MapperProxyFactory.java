package cn.kcnco.mybatis.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @program: diy-mybatis
 * @description:映射器代理工厂
 * @author: KCNCO
 **/
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;
    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(Map<String, String> sqlSession){
        MapperProxy<T> mapperProxy=new MapperProxy<>(sqlSession,mapperInterface);
        return (T)Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface},mapperProxy);
    }
}

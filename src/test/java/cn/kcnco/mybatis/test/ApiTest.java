package cn.kcnco.mybatis.test;

import cn.kcnco.mybatis.binding.MapperProxyFactory;
import cn.kcnco.mybatis.binding.MapperRegistry;
import cn.kcnco.mybatis.session.SqlSession;
import cn.kcnco.mybatis.session.SqlSessionFactory;
import cn.kcnco.mybatis.session.defaults.DefaultSqlSessionFactory;
import cn.kcnco.mybatis.test.dao.IUserDao;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ApiTest {

    private Logger logger= LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory() {
        // 1. 注册 Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("cn.kcnco.mybatis.test.dao");

        // 2. 从 SqlSession 工厂获取 Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 4. 测试验证
        String res = userDao.queryUserName("10001");
        logger.info("测试结果：{}", res);
    }


}

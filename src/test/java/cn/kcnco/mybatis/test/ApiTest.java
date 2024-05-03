package cn.kcnco.mybatis.test;

import cn.kcnco.mybatis.binding.MapperProxyFactory;
import cn.kcnco.mybatis.binding.MapperRegistry;
import cn.kcnco.mybatis.builder.xml.XMLConfigBuilder;
import cn.kcnco.mybatis.datasource.pooled.PooledDataSource;
import cn.kcnco.mybatis.io.Resources;
import cn.kcnco.mybatis.session.Configuration;
import cn.kcnco.mybatis.session.SqlSession;
import cn.kcnco.mybatis.session.SqlSessionFactory;
import cn.kcnco.mybatis.session.SqlSessionFactoryBuilder;
import cn.kcnco.mybatis.test.dao.IUserDao;
import cn.kcnco.mybatis.test.po.User;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;



public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        User user = userDao.queryUserInfoById(1L);
        logger.info("测试结果：{}", JSON.toJSONString(user));
    }

}

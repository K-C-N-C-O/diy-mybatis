package cn.kcnco.mybatis.session;

public interface SqlSessionFactory {

    //打开一个session
    SqlSession openSession();
}

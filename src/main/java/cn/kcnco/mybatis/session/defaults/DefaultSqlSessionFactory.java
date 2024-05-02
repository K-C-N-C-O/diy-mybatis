package cn.kcnco.mybatis.session.defaults;

import cn.kcnco.mybatis.binding.MapperRegistry;
import cn.kcnco.mybatis.executor.Executor;
import cn.kcnco.mybatis.mapping.Environment;
import cn.kcnco.mybatis.session.Configuration;
import cn.kcnco.mybatis.session.SqlSession;
import cn.kcnco.mybatis.session.SqlSessionFactory;
import cn.kcnco.mybatis.transaction.Transaction;
import cn.kcnco.mybatis.transaction.TransactionFactory;
import cn.kcnco.mybatis.session.TransactionIsolationLevel;

import java.sql.SQLException;

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
        Transaction tx = null;
        try {
            final Environment environment = configuration.getEnvironment();
            TransactionFactory transactionFactory = environment.getTransactionFactory();
            tx = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);
            // 创建执行器
            final Executor executor = configuration.newExecutor(tx);
            // 创建DefaultSqlSession
            return new DefaultSqlSession(configuration, executor);
        } catch (Exception e) {
            try {
                assert tx != null;
                tx.close();
            } catch (SQLException ignore) {
            }
            throw new RuntimeException("Error opening session.  Cause: " + e);
        }
    }
}

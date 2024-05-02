package cn.kcnco.mybatis.transaction;



import cn.kcnco.mybatis.session.TransactionIsolationLevel;

import javax.sql.DataSource;
import java.sql.Connection;

public interface TransactionFactory {

    //根据connection创建Transaction
    Transaction newTransaction(Connection conn);

    //根据数据源和事务隔离级别
    Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit);


}

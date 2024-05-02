package cn.kcnco.mybatis.datasource.druid;

import cn.kcnco.mybatis.datasource.DataSourceFactory;
import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @program: diy-mybatis
 * @description:Druid数据源工厂
 * @author: KCNCO
 **/
public class DruidDataSourceFactory implements DataSourceFactory {

    private Properties props;
    @Override
    public void setProperties(Properties props) {
        this.props=props;
    }

    @Override
    public DataSource getDataSource() {
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName(props.getProperty("driver"));
        dataSource.setUrl(props.getProperty("url"));
        dataSource.setUsername(props.getProperty("username"));
        dataSource.setPassword(props.getProperty("password"));
        return dataSource;
    }
}

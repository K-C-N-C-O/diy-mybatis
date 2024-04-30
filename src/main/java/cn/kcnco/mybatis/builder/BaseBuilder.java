package cn.kcnco.mybatis.builder;

import cn.kcnco.mybatis.session.Configuration;

/**
 * @program: diy-mybatis
 * @description:构建器的基类，建造者模式
 * @author: KCNCO
 **/
public class BaseBuilder {
    protected Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }


}

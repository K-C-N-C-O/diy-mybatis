package cn.kcnco.mybatis.builder;

import cn.kcnco.mybatis.session.Configuration;
import cn.kcnco.mybatis.type.TypeAliasRegistry;

/**
 * @program: diy-mybatis
 * @description:构建器的基类，建造者模式
 * @author: KCNCO
 **/
public abstract class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }


}

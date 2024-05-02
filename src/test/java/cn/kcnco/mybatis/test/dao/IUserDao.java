package cn.kcnco.mybatis.test.dao;

import cn.kcnco.mybatis.test.po.User;

public interface IUserDao {
    User queryUserInfoById(Long uId);
}

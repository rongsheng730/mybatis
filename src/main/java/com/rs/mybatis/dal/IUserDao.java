package com.rs.mybatis.dal;

import com.rs.mybatis.pojo.User;

public interface IUserDao {

    int insert(User user);

    int delete(User user);

    int update(User user);

    User findById(User user);
}
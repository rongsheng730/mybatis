package com.rs.mybatis.service;

import com.rs.mybatis.pojo.User;

public interface IUserService {

    int insert(User user);

    int delete(User user);

    int update(User user);

    User findById(User user);
}
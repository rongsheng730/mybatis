/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.rs.mybatis.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rs.mybatis.dal.IUserDao;
import com.rs.mybatis.pojo.User;
import com.rs.mybatis.routing.annotation.Router;
import com.rs.mybatis.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;

    @Router
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Router
    public int delete(User user) {
        return userDao.delete(user);
    }

    @Router
    public int update(User user) {
        return userDao.update(user);
    }

    @Router
    public User findById(User user) {
        return userDao.findById(user);
    }
}

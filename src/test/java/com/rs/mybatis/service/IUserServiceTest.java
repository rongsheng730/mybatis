/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.rs.mybatis.service;

import static com.rs.mybatis.db.DbContextHolder.getDbKey;
import static com.rs.mybatis.db.DbContextHolder.getTableIndex;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rs.mybatis.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
public class IUserServiceTest {
    @Autowired
    IUserService userService;

    @Test
    public void testInsert() {
        User user = new User();
        user.setUserId(101);
        user.setUserName("admin");
        user.setAge(23);
        user.setPassword("adf23");
        int re = userService.insert(user);
        System.out.printf("%s.t_user%s %s\n", getDbKey(), getTableIndex(), "插入结果: +" + re);

        user = new User();
        user.setUserId(102);
        user.setUserName("admin");
        user.setAge(23);
        user.setPassword("adf23");
        re = userService.insert(user);
        System.out.printf("%s.t_user%s %s\n", getDbKey(), getTableIndex(), "插入结果: +" + re);
    }

    @Test
    public void testDelete() {
        User user = new User();
        user.setUserId(101);
        int re = userService.delete(user);
        System.out.printf("%s.t_user%s %s\n", getDbKey(), getTableIndex(), "删除结果: +" + re);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUserId(101);
        user.setAge(34);
        int re = userService.update(user);
        System.out.printf("%s.t_user%s %s\n", getDbKey(), getTableIndex(), "更新结果: +" + re);
    }

    @Test
    public void testQuery() {
        User user = new User();
        user.setId(1);
        user.setUserId(101);
        User userDb = userService.findById(user);
        System.out.printf("%s.t_user%s %s\n", getDbKey(), getTableIndex(), "查询结果: +" + userDb);
    }
}

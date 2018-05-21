/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.rs.mybatis.pojo;

import java.io.Serializable;

import com.rs.mybatis.db.DbContextHolder;

import lombok.Data;

/**
 * @Description 所有pojo必须继承此bean 才能使用分库分表
 */
@Data
public abstract class BaseDomain implements Serializable {

    private long userId;
    private String tableIndex;

    public String getTableIndex() {
        return DbContextHolder.getTableIndex();
    }
}

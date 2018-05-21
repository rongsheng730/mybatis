/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.rs.mybatis.routing.router;

import java.util.List;

import lombok.Data;

@Data
public class RouterRule {

    /**
     * 数据库表的逻辑KEY,与数据源MAP配置中的key一致
     */
    private List<String> dbKeyArray;

    /**
     * 数据库数量
     */
    private int dbNumber;
    /**
     * 数据表数量
     */
    private int tableNumber;
    /**
     * 数据表index样式
     */
    private String tableIndexStyle;

}

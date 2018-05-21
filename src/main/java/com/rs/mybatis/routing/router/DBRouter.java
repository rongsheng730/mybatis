/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.rs.mybatis.routing.router;

/**
 * @Description DB路由接口，通过调用该接口来自动判断数据位于哪个服务器
 */
public interface DBRouter {

    String doRouteByUserId(long userId);

}

package com.rs.mybatis.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Description SPring 的动态数据源的实现
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
    	return DbContextHolder.getDbKey();//获取当前数据源
    }

}
package com.rs.mybatis.routing.router;

import java.text.DecimalFormat;

import org.apache.commons.lang.StringUtils;

import com.rs.mybatis.db.DbContextHolder;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class DBRouterImpl implements DBRouter {
    private static final String ROUTER_TABLE_SUFFIX_DEFAULT = "_0000";

    /**
     * 配置列表
     */
    private RouterRule routerRule;

    public String doRouteByUserId(long userId) {
        RouterRule routerRule = this.routerRule;

        int dbIndex = (int) (userId % routerRule.getDbNumber());
        String dbKey = routerRule.getDbKeyArray().get(dbIndex);
        DbContextHolder.setDbKey(dbKey);

        long tbIndex = userId % routerRule.getTableNumber();
        String tableIndex = getFormateTableIndex(routerRule.getTableIndexStyle(), tbIndex);
        DbContextHolder.setTableIndex(tableIndex);

        return dbKey;
    }

    /**
     * @Description 此方法是将例如+++0000根式的字符串替换成传参数字例如44 变成+++0044
     */
    private String getFormateTableIndex(String style, long tbIndex) {
        DecimalFormat df = new DecimalFormat();
        if (StringUtils.isEmpty(style)) {
            style = ROUTER_TABLE_SUFFIX_DEFAULT;//在格式后添加诸如单位等字符
        }
        df.applyPattern(style);
        return df.format(tbIndex);
    }
}

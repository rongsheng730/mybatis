package com.rs.mybatis.pojo;

import lombok.Data;

/**
 * @Description 与表中实体映射bean
 */
@Data
public class User extends BaseDomain {
    private long id;
    private String userName;
    private String password;
    private int age;

}
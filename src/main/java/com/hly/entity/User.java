package com.hly.entity;

import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 用户类
 * @author han long yi
 * @create 2021-03-14 15:07
 */


@lombok.Data
@Accessors(chain = true)
public class User {
    /**
     * 用户id
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户真实姓名
     */
    private String realname;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户性别
     */
    private String sex;

    /**
     * 用户状态
     */
    private String status;

    /**
     * 用户注册时间
     */
    private Date registerTime;

}

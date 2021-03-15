package com.hly.service;

import com.hly.entity.User;

/**
 * 用户业务
 * @author han long yi
 * @create 2021-03-14 15:38
 */
public interface UserService {

    /**
     * 用户注册
     * @param user
     */
    void register(User user);

    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);


}

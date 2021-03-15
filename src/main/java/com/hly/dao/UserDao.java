package com.hly.dao;

import com.hly.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户注册接口类
 * @author han long yi
 * @create 2021-03-14 15:12
 */

@Mapper
public interface UserDao {
    /**
     * 用户保存
     * @param user
     */
    void save(User user);


    /**
     * 通过username查询用户
     * @param string
     * @return
     */
    User findByUserName(String string);

}

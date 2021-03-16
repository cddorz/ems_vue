package com.hly.service.Impl;

import com.hly.dao.UserDao;
import com.hly.entity.User;
import com.hly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;

/**
 * @author han long yi
 * @create 2021-03-14 15:39
 */

@Service
public class UserServiceImpl  implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public void register(User user) {
        //0.根据用户输入用户名判断是否存在
        User userName = userDao.findByUserName(user.getUsername());
        if (userName == null) {
            //1.生成用户状态
            user.setStatus("已激活");
            //2.设置用户注册时间
            user.setRegisterTime(new Date());
            //3.调用Dao
            userDao.save(user);
        } else {
            throw new RuntimeException("用户名已存在");
        }
    }

    @Override
    public User login(User user) {
        User byUserName = userDao.findByUserName(user.getUsername());
        if(!ObjectUtils.isEmpty(byUserName)){
            if(byUserName.getPassword().equals(user.getPassword())){
                return byUserName;
            }else{
                throw new RuntimeException("密码输入错误");
            }
        }else{
            throw new RuntimeException("用户名输入错误");
        }
    }
}

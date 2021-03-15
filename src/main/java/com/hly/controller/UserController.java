package com.hly.controller;

import com.hly.entity.User;
import com.hly.service.UserService;
import com.hly.utils.VerifyCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author han long yi
 * @create 2021-03-14 14:18
 */

@Slf4j
@RestController
@CrossOrigin //允许跨域
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用户登录
     * @param user
     * @return
     */
    @PostMapping("login")
    public Map<String, Object> login(@RequestBody User user){
        log.info("当前登录用户的信息:[{}]",user.toString());
        Map<String, Object> map = new HashMap<>();
        try {
            User login = userService.login(user);
            map.put("state",true);
            map.put("msg","登陆成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg",e.getMessage());
        }

        return map;
    }

    /**
     * 生成验证码图片
     * @param request
     * @return
     * @throws IOException
     */
    @GetMapping("getImage")
    public String getImageCode(HttpServletRequest request) throws IOException {
        //1.使用工具类生成验证码
        String code = VerifyCodeUtils.generateVerifyCode(4);
        //2.将验证码放入serveletContext作用域
        request.getServletContext().setAttribute("code",code);
        //3.将图片转为base64
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        VerifyCodeUtils.outputImage(120,30,byteArrayOutputStream,code);
        return "data:image/png;base64," + Base64Utils.encodeToString(byteArrayOutputStream.toByteArray());

    }

    /**
     * 用户注册
     * @param user
     * @param code
     * @param request
     * @return
     */
@PostMapping("register")
    public Map<String, Object> register(@RequestBody User user, String code,HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        log.info("用户信息：[{}]",user.toString());
        log.info("用户输入的验证码信息：[{}]",code);
        try {
            String key = (String) request.getServletContext().getAttribute("code");
            if(key.equalsIgnoreCase(code)){
                //1.调用业务方法
                userService.register(user);
                map.put("state",true);
                map.put("msg","注册成功");
            }else{
                throw new RuntimeException("验证码错误");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("state",false);
            map.put("msg","提示："+e.getMessage());
        }
        return map;
    }

}

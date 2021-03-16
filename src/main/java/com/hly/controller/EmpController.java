package com.hly.controller;

import com.hly.entity.Emp;
import com.hly.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 员工控制层
 * @author han long yi
 * @create 2021-03-16 22:04
 */

@RestController
@RequestMapping("emp")
@CrossOrigin
@Slf4j
public class EmpController {

    @Autowired
    private EmpService empService;

    @Value("${photo.dir}")
    private String realPath;

    /**
     * 获取员工列表
     * @return
     */
    @GetMapping("findAll")
    public List<Emp> findAll(){
        return empService.findAll();
    }

    /**
     * 添加员工
     * @return
     */
    @PostMapping("add")
    public Map<String, Object> addEmp(Emp emp, MultipartFile photo) {
        log.info("员工信息：[{}]",emp.toString());
        log.info("员工头像：[{}]",photo.getOriginalFilename());
        Map<String, Object> map = new HashMap<>();
        try {
            //头像保存
            String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(photo.getOriginalFilename());
            photo.transferTo(new File(realPath,newFileName));
            //设置头像地址
            emp.setPath(newFileName);
            //保存员工信息
            empService.addEmp(emp);
            map.put("state",true);
            map.put("msg","增加员工成功");
        } catch (Exception e) {
            map.put("state",false);
            map.put("msg",e.getMessage());
        }
        return map;
    }
}

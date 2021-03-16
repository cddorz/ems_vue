package com.hly.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 员工实体类
 * @author han long yi
 * @create 2021-03-16 19:15
 */
@Data
@Accessors(chain = true)
public class Emp {
    /**
     * 员工id
     */
    private String id;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 员工头像
     */
    private String path;

    /**
     * 员工工资
     */
    private Double salary;

    /**
     * 员工年龄
     */
    private Integer age;
}

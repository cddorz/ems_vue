package com.hly.service;

import com.hly.entity.Emp;

import java.util.List;

/**
 * 员工业务层
 * @author han long yi
 * @create 2021-03-16 22:00
 */
public interface EmpService {

    /**
     * 查询员工列表
     * @return
     */
    List<Emp> findAll();


    /**
     * 新增员工
     * @param emp
     */
    void addEmp(Emp emp);

    /**
     * 删除员工
     * @param id
     */
    void deleteEmp(String id);

    /**
     * 查询单个员工
     * @param id
     * @return
     */
    Emp findOne(String id);

    /**
     * 更新员工信息
     * @param emp
     */
    void update(Emp emp);

}

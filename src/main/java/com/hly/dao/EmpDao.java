package com.hly.dao;

import com.hly.entity.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 员工Dao
 * @author han long yi
 * @create 2021-03-16 19:20
 */
@Mapper
public interface EmpDao {

    List<Emp> findAll();

    void addEmp(Emp emp);

    void deleteEmp(String id);

    Emp findOne(String id);
}

package com.hly.service.Impl;

import com.hly.dao.EmpDao;
import com.hly.entity.Emp;
import com.hly.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author han long yi
 * @create 2021-03-16 22:00
 */

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Emp> findAll() {
        return empDao.findAll();
    }

    @Override
    public void addEmp(Emp emp) {
        empDao.addEmp(emp);
    }

    @Override
    public void deleteEmp(String id) {
        empDao.deleteEmp(id);
    }

    @Override
    public Emp findOne(String id) {
        return empDao.findOne(id);
    }
}

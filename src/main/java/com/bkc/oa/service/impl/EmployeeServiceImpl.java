package com.bkc.oa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkc.oa.dao.IEmployeeDao;
import com.bkc.oa.entity.Employee;
import com.bkc.oa.service.IEmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService
{
    
    @Autowired
    private IEmployeeDao employeeDao;
    
    public void setEmployeeDao(IEmployeeDao employeeDao)
    {
        this.employeeDao = employeeDao;
    }
    
    /** 使用用户名作为查询条件，查询用户对象 */
    @Override
    public Employee findEmployeeByName(String name)
    {
        Employee employee = employeeDao.findEmployeeByName(name);
        return employee;
    }
    
}

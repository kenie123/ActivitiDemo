package com.bkc.oa.dao;

import com.bkc.oa.entity.Employee;

public interface IEmployeeDao
{
    Employee findEmployeeByName(String name);;
}
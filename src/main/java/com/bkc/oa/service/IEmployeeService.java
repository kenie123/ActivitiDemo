package com.bkc.oa.service;

import com.bkc.oa.entity.Employee;

public interface IEmployeeService
{
    Employee findEmployeeByName(String name);
}

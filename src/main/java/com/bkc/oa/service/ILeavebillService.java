package com.bkc.oa.service;

import java.util.List;

import com.bkc.oa.entity.Employee;
import com.bkc.oa.entity.Leavebill;

public interface ILeavebillService
{
    
    List<Leavebill> selectLeavebillList();
    
    List<Leavebill> findLeavebillListByUserid(Employee employee);
    
    void saveLeavebill(Leavebill leavebill);
    
    Leavebill findLeavebillById(Long id);
    
    void deleteLeavebillById(Long id);
    
    void updateLeavebillState(Leavebill leavebill);
    
}

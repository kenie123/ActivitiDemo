package com.bkc.oa.dao;

import java.util.List;

import com.bkc.oa.entity.Employee;
import com.bkc.oa.entity.Leavebill;

public interface ILeavebillDao
{
    List<Leavebill> findLeavebillListByUserid(Employee employee);
    
    void saveLeavebill(Leavebill leavebill);
    
    Leavebill findLeavebillById(Long id);
    
    void updateLeavebill(Leavebill leavebill);
    
    void deleteLeavebillById(Long id);
    
    List<Leavebill> selectLeavebillList();
    
    void updateLeavebillState(Leavebill leavebill);
    
}
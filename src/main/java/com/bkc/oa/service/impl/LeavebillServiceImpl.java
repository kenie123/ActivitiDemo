package com.bkc.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkc.oa.dao.ILeavebillDao;
import com.bkc.oa.entity.Employee;
import com.bkc.oa.entity.Leavebill;
import com.bkc.oa.service.ILeavebillService;

@Service("leavebillService")
public class LeavebillServiceImpl implements ILeavebillService
{
    
    @Autowired
    private ILeavebillDao leavebillDao;
    
    public void setLeavebillDao(ILeavebillDao leavebillDao)
    {
        this.leavebillDao = leavebillDao;
    }
    
    /** 查询自己的请假单的信息 */
    @Override
    public List<Leavebill> findLeavebillListByUserid(Employee employee)
    {
        List<Leavebill> list = leavebillDao.findLeavebillListByUserid(employee);
        return list;
    }
    
    /** 保存请假单 */
    @Override
    public void saveLeavebill(Leavebill leavebill)
    {
        // 获取请假单ID
        Long id = leavebill.getId();
        /** 新增保存 */
        if (id == null)
        {
            // 2：保存请假单表，添加一条数据
            leavebillDao.saveLeavebill(leavebill);
        }
        /** 更新保存 */
        else
        {
            // 1：执行update的操作，完成更新
            leavebillDao.updateLeavebill(leavebill);
        }
        
    }
    
    /** 使用请假单ID，查询请假单的对象 */
    @Override
    public Leavebill findLeavebillById(Long id)
    {
        Leavebill bill = leavebillDao.findLeavebillById(id);
        return bill;
    }
    
    /** 使用请假单ID，删除请假单 */
    @Override
    public void deleteLeavebillById(Long id)
    {
        leavebillDao.deleteLeavebillById(id);
    }
    
    @Override
    public List<Leavebill> selectLeavebillList()
    {
        List<Leavebill> billList = leavebillDao.selectLeavebillList();
        return billList;
    }
    
    @Override
    public void updateLeavebillState(Leavebill leavebill)
    {
        leavebillDao.updateLeavebillState(leavebill);
    }
}

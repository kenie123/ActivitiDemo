package com.bkc.oa.entity;

import java.util.Date;

public class Leavebill
{
    private Long id;
    
    private Integer days;
    
    private String content;
    
    private String remark;
    
    private Date leavedate = new Date();// 请假时间
    
    private Integer state = 0;
    
    private Employee user;// 请假人
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public Integer getDays()
    {
        return days;
    }
    
    public void setDays(Integer days)
    {
        this.days = days;
    }
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content == null ? null : content.trim();
    }
    
    public String getRemark()
    {
        return remark;
    }
    
    public void setRemark(String remark)
    {
        this.remark = remark == null ? null : remark.trim();
    }
    
    public Date getLeavedate()
    {
        return leavedate;
    }
    
    public void setLeavedate(Date leavedate)
    {
        this.leavedate = leavedate;
    }
    
    public Integer getState()
    {
        return state;
    }
    
    public Employee getUser()
    {
        return user;
    }
    
    public void setUser(Employee user)
    {
        this.user = user;
    }
    
    public void setState(Integer state)
    {
        this.state = state;
    }
    
    @Override
    public String toString()
    {
        return "Leavebill [id=" + id + ", days=" + days + ", content=" + content + ", remark=" + remark + ", leavedate="
            + leavedate + ", state=" + state + ", user=" + user + "]";
    }
}
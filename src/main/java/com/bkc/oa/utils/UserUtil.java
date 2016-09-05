package com.bkc.oa.utils;

import javax.servlet.http.HttpSession;

import com.bkc.oa.entity.Employee;

/**
 * 用户工具类
 *
 * @author
 */
public class UserUtil
{
    
    public static final String USER = "user";
    
    /**
     * 设置用户到session
     *
     * @param session
     * @param user
     */
    public static void saveUserToSession(HttpSession session, Employee user)
    {
        session.setAttribute(USER, user);
    }
    
    /**
     * 从Session获取当前用户信息
     *
     * @param session
     * @return
     */
    public static Employee getUserFromSession(HttpSession session)
    {
        Object attribute = session.getAttribute(USER);
        return attribute == null ? null : (Employee)attribute;
    }
    
}

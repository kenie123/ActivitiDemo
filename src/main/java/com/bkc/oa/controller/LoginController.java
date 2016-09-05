package com.bkc.oa.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bkc.common.utils.StringUtils;
import com.bkc.oa.entity.Employee;
import com.bkc.oa.service.IEmployeeService;
import com.bkc.oa.utils.UserUtil;

@Controller
@RequestMapping(value = "/")
public class LoginController
{
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    
    @Autowired
    private IEmployeeService employeeService;
    
    /**
     * 登录
     * 
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(Employee employee, @RequestParam(value = "prival", required = false) String prival,
        HttpSession session)
    {
        logger.debug("logon request: {username={}, password={}}", employee.toString());
        
        Employee emp = UserUtil.getUserFromSession(session);
        if (emp == null)
        {
            // 1：获取用户名
            String name = employee.getName();
            if (name == null)
            {
                return "redirect:logout";
            }
            // 2：使用用户名作为查询条件，查询员工表，获取当前用户名对应的信息
            emp = employeeService.findEmployeeByName(name);
            if (emp == null)
            {
                return "redirect:logout";
            }
            // 3：将查询的对象（惟一）放置到Session中
            UserUtil.saveUserToSession(session, emp);
        }
        if (StringUtils.isNotEmpty(prival))
        {
            return prival;
        }
        return "success";
    }
    
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session)
    {
        session.removeAttribute(UserUtil.USER);
        return "login";
    }
    
    @RequestMapping(value = "/index")
    public String index()
    {
        return "login";
    }
}

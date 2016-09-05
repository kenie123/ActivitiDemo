package com.bkc.oa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bkc.oa.entity.Employee;
import com.bkc.oa.entity.Leavebill;
import com.bkc.oa.service.ILeavebillService;
import com.bkc.oa.utils.UserUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("leavebill")
public class LeavebillController
{
    @Autowired
    private ILeavebillService leavebillService;
    
    /**
     * 请假管理首页显示
     * 
     * @return
     */
    @RequestMapping("list")
    public String list(HttpSession session, Model model)
    {
        // 1：查询所有的请假信息（对应a_leavebill），返回List<LeaveBill>
        Employee employee = UserUtil.getUserFromSession(session);
        if (employee == null)
        {
            return "redirect:/index";
        }
        List<Leavebill> leavebillList = new ArrayList<Leavebill>();
        if (employee != null)
        {
            leavebillList = leavebillService.findLeavebillListByUserid(employee);
        }
        model.addAttribute("leavebillList", leavebillList);
        return "leavebill/list";
    }
    
    /**
     * 请假管理首页显示
     * 
     * @return
     */
    @RequestMapping("listPage")
    public String listPage(@RequestParam(value = "pageNum") Integer pageNum,
        @RequestParam(value = "pageSize") Integer pageSize, HttpSession session, Model model)
    {
        // 1：查询所有的请假信息（对应a_leavebill），返回List<LeaveBill>
        Employee employee = UserUtil.getUserFromSession(session);
        if (employee == null)
        {
            return "redirect:/index";
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Leavebill> leavebillList = new ArrayList<Leavebill>();
        if (employee != null)
        {
            leavebillList = leavebillService.findLeavebillListByUserid(employee);
        }
        PageInfo<Leavebill> page = new PageInfo<Leavebill>(leavebillList);
        model.addAttribute("leavebillList", leavebillList);
        
        System.out.println(page.toString());
        model.addAttribute("page", page);
        return "leavebill/listPage";
    }
    
    /**
     * 请假管理首页显示
     * 
     * @return
     */
    @RequestMapping("home")
    public ModelAndView home()
    {
        // 1：查询所有的请假信息（对应a_leavebill），返回List<LeaveBill>
        List<Leavebill> leavebillList = leavebillService.selectLeavebillList();
        ModelAndView mav = new ModelAndView("leavebill/list");
        mav.addObject("leavebillList", leavebillList);
        return mav;
    }
    
    /**
     * 请假管理首页显示
     * 
     * @return
     */
    @RequestMapping("homelist")
    public String homelist(Model model)
    {
        // 1：查询所有的请假信息（对应a_leavebill），返回List<LeaveBill>
        List<Leavebill> leavebillList = leavebillService.selectLeavebillList();
        model.addAttribute("leavebillList", leavebillList);
        return "leavebill/list";
    }
    
    /**
     * 添加请假申请
     * 
     * @return
     */
    @RequestMapping("add")
    public String add(Leavebill leavebill, Model model)
    {
        // 1：获取请假单ID
        Long id = leavebill.getId();
        // 修改
        if (id != null)
        {
            // 2：使用请假单ID，查询请假单信息，
            Leavebill bill = leavebillService.findLeavebillById(id);
            model.addAttribute("bill", bill);
        }
        // 新增
        return "leavebill/add";
    }
    
    /**
     * 保存/更新，请假申请
     */
    @RequestMapping("save")
    public String save(Leavebill leavebill, RedirectAttributes redirectAttributes, HttpSession session)
    {
        Employee employee = (Employee)UserUtil.getUserFromSession(session);
        if (employee == null)
        {
            redirectAttributes.addFlashAttribute("prival", "redirect:/leavebill/add");
            return "redirect:/index";
        }
        leavebill.setUser(employee);// 建立管理关系
        // 执行保存
        leavebillService.saveLeavebill(leavebill);
        return "redirect:list";
    }
    
    /**
     * 保存/更新，请假申请
     */
    @RequestMapping("delete")
    public String delete(Leavebill leavebill, RedirectAttributes redirectAttributes, HttpSession session)
    {
        Employee employee = (Employee)UserUtil.getUserFromSession(session);
        if (employee == null)
        {
            redirectAttributes.addFlashAttribute("prival", "redirect:/leavebill/list");
            return "redirect:/index";
        }
        // 执行保存
        leavebillService.deleteLeavebillById(leavebill.getId());
        ;
        return "redirect:list";
    }
    
    /**
     * 添加请假申请
     * 
     * @return
     */
    @RequestMapping("input")
    public ModelAndView input(Leavebill leavebill)
    {
        // 1：获取请假单ID
        Long id = leavebill.getId();
        // 修改
        if (id != null)
        {
            // 2：使用请假单ID，查询请假单信息，
            Leavebill bill = leavebillService.findLeavebillById(id);
            // 3：将请假单信息放置到栈顶，页面使用struts2的标签，支持表单回显
            ModelAndView mav = new ModelAndView("leavebill/add");
            mav.addObject("bill", bill);
            return mav;
        }
        // 新增
        return new ModelAndView("leavebill/add");
    }
}

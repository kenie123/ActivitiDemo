package com.bkc.oa.controller;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bkc.common.utils.StringUtils;
import com.bkc.oa.entity.Leavebill;
import com.bkc.oa.service.ILeavebillService;
import com.bkc.oa.service.IWorkflowService;
import com.bkc.oa.utils.UserUtil;
import com.bkc.oa.web.form.WorkflowBean;

@Controller
@RequestMapping("workflow")
public class WorkflowController
{
    @Autowired
    private IWorkflowService workflowService;
    
    @Autowired
    private ILeavebillService leavebillService;
    
    /**
     * 发布首页
     * 
     * @return
     */
    @RequestMapping("deployHome")
    public String deployHome(Model model)
    {
        // 1 查询部署对象信息，对应表（act_re_deployment)
        List<Deployment> depList = workflowService.findDeploymentList();
        // 2 查询流程定义的信息，对应表(act_re_procdef)
        List<ProcessDefinition> pdList = workflowService.findProcessDefinitionList();
        
        model.addAttribute("depList", depList);
        model.addAttribute("pdList", pdList);
        return "workflow/workflow";
    }
    
    /**
     * 用于跳转到部署页面
     * 
     * @return
     */
    @RequestMapping("addDeploy")
    public String addDeploy()
    {
        return "workflow/add";
    }
    
    /**
     * 发布流程
     * 
     * @return
     */
    @RequestMapping("newdeploy")
    public String newdeploy(MultipartFile file, RedirectAttributes redirectAttributes)
    {
        if (file.isEmpty())
        {
            redirectAttributes.addFlashAttribute("message", "文件未上传");
            return "redirect:addDeploy";
        }
        else
        {
            // 完成部署
            workflowService.saveNewDeploye(file);
            return "redirect:deployHome";
        }
    }
    
    /**
     * 删除部署信息
     */
    @RequestMapping("delDeployment")
    public String delDeployment(WorkflowBean workflowBean)
    {
        // 1：获取部署对象ID
        String deploymentId = workflowBean.getDeploymentId();
        // 2：使用部署对象ID，删除流程定义
        workflowService.deleteProcessDefinitionByDeploymentId(deploymentId);
        return "redirect:deployHome";
    }
    
    /**
     * 查看流程图
     * 
     * @throws Exception
     */
    @RequestMapping("viewImage")
    public void viewImage(WorkflowBean workflowBean, HttpServletResponse response)
        throws Exception
    {
        // 1：获取页面传递的部署对象ID和资源图片名称
        // 部署对象ID
        String deploymentId = workflowBean.getDeploymentId();
        // 资源图片名称
        String imageName = workflowBean.getImageName();
        // 2：获取资源文件表（act_ge_bytearray）中资源图片输入流InputStream
        InputStream in = workflowService.findImageInputStream(deploymentId, imageName);
        
        byte[] b = new byte[1024];
        int len = -1;
        while ((len = in.read(b, 0, 1024)) != -1)
        {
            response.getOutputStream().write(b, 0, len);
        }
    }
    
    /**
     * 启动流程
     * 
     * @param workflowBean
     * @param session
     * @return
     */
    @RequestMapping("startProcess")
    public String startProcess(WorkflowBean workflowBean, HttpSession session)
    {
        // 更新请假状态，启动流程实例，让启动的流程实例关联业务
        workflowService.saveStartProcess(workflowBean, session);
        return "redirect:listTask";
    }
    
    /**
     * 任务管理首页显示
     * 
     * @return
     */
    @RequestMapping("listTask")
    public String listTask(HttpSession session, Model model)
    {
        // 1：从Session中获取当前用户名
        String name = UserUtil.getUserFromSession(session).getName();
        if (StringUtils.isEmpty(name))
        {
            return "redirect:/index";
        }
        // 2：使用当前用户名查询正在执行的任务表，获取当前任务的集合List<Task>
        List<Task> list = workflowService.findTaskListByName(name);
        model.addAttribute("list", list);
        return "workflow/tasklist";
    }
    
    /**
     * 打开任务表单
     */
    @RequestMapping("viewTaskForm")
    public String viewTaskForm(WorkflowBean workflowBean, Model model)
    {
        // 任务ID
        String taskId = workflowBean.getTaskId();
        // 获取任务表单中任务节点的url连接
        String url = workflowService.findTaskFormKeyByTaskId(taskId);
        model.addAttribute("taskId", taskId);
        return "redirect:" + url;
    }
    
    /**
     * 查看历史的批注信息
     * 
     * @param workflowBean
     * @param model
     * @return
     */
    @RequestMapping("viewHisComment")
    public String viewHisComment(WorkflowBean workflowBean, Model model)
    {
        // 获取清单ID
        Long id = workflowBean.getId();
        // 1：使用请假单ID，查询请假单对象，将对象放置到栈顶，支持表单回显
        Leavebill leaveBill = leavebillService.findLeavebillById(id);
        model.addAttribute("bill", leaveBill);
        // 2：使用请假单ID，查询历史的批注信息
        List<Comment> commentList = workflowService.findCommentByLeavebillId(id);
        model.addAttribute("commentList", commentList);
        return "workflow/taskFormHis";
    }
    
    // 准备表单数据
    @RequestMapping("audit")
    public String audit(WorkflowBean workflowBean, Model model)
    {
        // 获取任务ID
        String taskId = workflowBean.getTaskId();
        /** 一：使用任务ID，查找请假单ID，从而获取请假单信息 */
        Leavebill leaveBill = workflowService.findLeavebillByTaskId(taskId);
        model.addAttribute("taskId", taskId);
        model.addAttribute("bill", leaveBill);
        /** 二：已知任务ID，查询ProcessDefinitionEntiy对象，从而获取当前任务完成之后的连线名称，并放置到List<String>集合中 */
        List<String> outcomeList = workflowService.findOutComeListByTaskId(taskId);
        model.addAttribute("outcomeList", outcomeList);
        /** 三：查询所有历史审核人的审核信息，帮助当前人完成审核，返回List<Comment> */
        List<Comment> commentList = workflowService.findCommentByTaskId(taskId);
        model.addAttribute("commentList", commentList);
        return "workflow/taskForm";
    }
    
    /**
     * 提交任务
     */
    @RequestMapping("submitTask")
    public String submitTask(WorkflowBean workflowBean, HttpSession session)
    {
        workflowService.saveSubmitTask(workflowBean, session);
        return "redirect:listTask";
    }
    
    /**
     * 查看当前流程图（查看当前活动节点，并使用红色的框标注）
     */
    @RequestMapping("viewCurrentImage")
    public String viewCurrentImage(WorkflowBean workflowBean, Model model)
    {
        // 任务ID
        String taskId = workflowBean.getTaskId();
        /** 一：查看流程图 */
        // 1：获取任务ID，获取任务对象，使用任务对象获取流程定义ID，查询流程定义对象
        ProcessDefinition pd = workflowService.findProcessDefinitionByTaskId(taskId);
        // workflowAction_viewImage?deploymentId=<s:property value='#deploymentId'/>&imageName=<s:property
        // value='#imageName'/>
        model.addAttribute("deploymentId", pd.getDeploymentId());
        model.addAttribute("imageName", pd.getDiagramResourceName());
        /** 二：查看当前活动，获取当期活动对应的坐标x,y,width,height，将4个值存放到Map<String,Object>中 */
        Map<String, Object> map = workflowService.findCoordingByTask(taskId);
        model.addAttribute("acs", map);
        return "workflow/image";
    }
    
}

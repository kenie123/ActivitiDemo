package com.bkc.oa.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.web.multipart.MultipartFile;

import com.bkc.oa.entity.Leavebill;
import com.bkc.oa.web.form.WorkflowBean;

public interface IWorkflowService
{
    
    List<Deployment> findDeploymentList();
    
    List<ProcessDefinition> findProcessDefinitionList();
    
    InputStream findImageInputStream(String deploymentId, String imageName);
    
    void deleteProcessDefinitionByDeploymentId(String deploymentId);
    
    List<Task> findTaskListByName(String name);
    
    String findTaskFormKeyByTaskId(String taskId);
    
    Leavebill findLeavebillByTaskId(String taskId);
    
    List<String> findOutComeListByTaskId(String taskId);
    
    void saveSubmitTask(WorkflowBean workflowBean, HttpSession session);
    
    List<Comment> findCommentByTaskId(String taskId);
    
    List<Comment> findCommentByLeavebillId(Long id);
    
    ProcessDefinition findProcessDefinitionByTaskId(String taskId);
    
    Map<String, Object> findCoordingByTask(String taskId);
    
    /**
     * 部署流程 - 保存
     * 
     * @param file 上传的流程包
     * @return
     */
    String saveNewDeploye(MultipartFile file);
    
    void saveStartProcess(WorkflowBean workflowBean, HttpSession session);
    
}

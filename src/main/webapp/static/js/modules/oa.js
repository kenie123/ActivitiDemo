$(function () {

});

/**
 * 跳转到登录页
 */
function index()
{
	window.location.href = ctx + "/login";
}

/**
 * 新增请假单
 */
function addLeavebill(id)
{
	if(id)
	{
		window.location.href = ctx + "/leavebill/add?id="+id;
	}
	else
	{
		window.location.href = ctx + "/leavebill/add";
	}
	
}

/**
 * 显示请假单列表
 */
function showLeavebill()
{
	window.location.href = ctx + "/leavebill/list";
}

/**
 * 显示请假单列表
 */
function showLeavebillPage(curPage,pageSize)
{
	if(!curPage)
	{
		curPage = 1;
	}
	if(!pageSize)
	{
		pageSize = 10;
	}
	window.location.href = ctx + "/leavebill/listPage?pageNum="+curPage+"&pageSize="+pageSize;
}



/**
 * 删除请假单
 */
function deleteLeavebill(id)
{
	window.location.href = ctx + "/leavebill/delete?id="+id;
}

/**
 * 显示流程首页
 */
function showWorkflow()
{
	window.location.href = ctx + "/workflow/deployHome";
}

/**
 * 删除流程，根据流程id
 * @param deploymentId
 */
function delDeployment(deploymentId)
{
	window.location.href = ctx + "/workflow/delDeployment?deploymentId="+deploymentId;
}

/**
 * 跳转到部署流程页面
 */
function addDeployment()
{
	window.location.href = ctx + "/workflow/addDeploy";
}

/**
 * 部署新流程
 */
function newdeploy()
{
	window.location.href = ctx + "/workflow/newdeploy";
}

/**
 * 查看流程图
 */
function viewImage(deploymentId,imageName)
{
	window.location.href = ctx + "/workflow/viewImage?deploymentId="+deploymentId+"&imageName="+imageName;
}

/**
 * 查看审批历史
 */
function viewHisComment(id)
{
	window.location.href = ctx + "/workflow/viewHisComment?id="+id;
}

/**
 *办理任务列表
 */
function listTask()
{
	window.location.href = ctx + "/workflow/listTask";
}

/**
 *办理任务
 */
function viewTaskForm(id)
{
	window.location.href = ctx + "/workflow/viewTaskForm?taskId="+id;
}


/**
 * 查看当前流程图
 */
function viewCurrentImage(id)
{
	window.location.href = ctx + "/workflow/viewCurrentImage?taskId="+id;
}


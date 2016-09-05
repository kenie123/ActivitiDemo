<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>
    <title>登录成功</title>
    
  </head>
  <body>

<div class="container">
     <%@ include  file="/WEB-INF/views/include/top.jsp"%>
	<div class="row">
		<div class="col-sm-3">
			<ul class="nav nav-list bs-docs-sidenav">
				<li class="nav-header">
					请假管理
				</li>
				<li class="active">
					<a href="javascript:void(0)" onclick="showLeavebill()"><i class="icon-chevron-right"></i>列表显示</a>
				</li>
				<li class="active">
					<a href="javascript:void(0)" onclick="showLeavebillPage('${pageNum}','${pageSize }')"><i class="icon-chevron-right"></i>分页显示</a>
				</li>
				<li class="nav-header">
					流程管理
				</li>
				<li><a class="active" href="javascript:void(0)"
						onclick="showWorkflow()">部署管理</a></li>
				<li>
					<a href="javascript:void(0)" onclick="listTask()">任务管理</a>
				</li>
			</ul>
		</div>
	
	<div class="col-sm-9">
	登录成功
	</div>
	</div>
</div>
	<script src="${ctx }/static/js/modules/oa.js"></script>
  </body>
</html>
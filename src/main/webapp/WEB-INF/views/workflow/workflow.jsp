<%@page import="com.bkc.oa.entity.Leavebill"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<title>部署管理</title>

</head>
<body>
	<div class="container" id="LG">
		<%@ include  file="/WEB-INF/views/include/top.jsp"%>
		<div class="row">
			<div class="span12">
				<ul class="breadcrumb">
					<li>当前位置：</li>
					<li>
					<a href="javascript:void(0)" onclick="index()">首页</a>
					</li>
					<li><a class="active" href="javascript:void(0)"
						onclick="showWorkflow()">部署管理</a></li>
					<li><a href="javascript:void(0)" onclick="showWorkflow()">部署信息管理列表</a>
					</li>
				</ul>
				<h2 class="breadcrumb">部署信息管理列表</h2>

				<form class="form-inline" action="?" method="post">
					<div class="form-group">
						<input type="text" class="form-control" id="selectKeys"
							name="selectKeys" placeholder="请输入任务名或者执行类信息" value="">
					</div>
					<button class="btn btn-default" type="submit">查询</button>
					<span style="float: right">
						<button type="button" class="btn btn-primary" id="addBtn"
							onclick="addDeployment()" name="addBtn">部署流程定义</button>
					</span>
				</form>
				<br>
				<div class="table-responsive">
					<table class="table table-condensed table-striped table-bordered">
						<thead class="bg-primary">
							<tr>
								<th>#ID</th>
								<th>流程名称</th>
								<th>发布时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${depList}" var="dep">
								<tr>
									<td>
										<div class="checkbox">
											<label> <input type="checkbox" id="ids" name="ids"
												value="${dep.id }">${dep.id }
											</label>
										</div>
									</td>
									<td>${dep.name }</td>
									<td>
									<fmt:formatDate value="${dep.deploymentTime }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>
									</td>
									<td><a href="javascript:void(0)" onclick="delDeployment('${dep.id }')">删除</a>
									</td>
								</tr>
							</c:forEach>
							<tr>
								<td colspan="4" align="right"></td>
							</tr>
						</tbody>
					</table>

				</div>

				<div class="table-responsive">
				<h2 class="breadcrumb">流程定义信息列表</h2>
					<table class="table table-condensed table-striped table-bordered">
						<thead class="bg-primary">
							<tr>
								<th>#ID</th>
								<th>名称</th>
								<th>流程定义的KEY</th>
								<th>流程定义的版本</th>
								<th>流程定义的规则文件名称</th>
								<th>流程定义的规则图片名称</th>
								<th>部署ID</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${pdList}" var="pd">
								<tr>
									<td>
										<div class="checkbox">
											<label> <input type="checkbox" id="ids" name="ids"
												value="${pd.id }">${pd.id }
											</label>
										</div>
									</td>
									<td>${pd.name }</td>
									<td>${pd.key }</td>
									<td>${pd.version }</td>
									<td>${pd.resourceName }</td>
									<td>${pd.diagramResourceName }</td>
									<td>${pd.deploymentId }</td>
									<td><a  target="_blank"  href="javascript:void(0)" onclick="viewImage('${pd.deploymentId }','${pd.diagramResourceName }')">查看流程图</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		</div>
		<script src="${ctx }/static/js/modules/oa.js"></script>
</body>
</html>
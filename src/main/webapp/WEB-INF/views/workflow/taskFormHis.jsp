<%@page import="com.bkc.oa.entity.Leavebill"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<title>请假任务办理</title>

</head>
<body>
	<div class="container" id="LG">
		<%@ include file="/WEB-INF/views/include/top.jsp"%>
		<div class="row">
			<div class="span12">
				<ul class="breadcrumb">
					<li>当前位置：</li>
					<li><a href="javascript:void(0)" onclick="index()">首页</a></li>
					<li><a href="javascript:void(0)" onclick="showLeavebill()">请假管理</a>
					</li>
					<li><a href="javascript:void(0)" onclick="viewHisComment()">请假申请的任务办理</a>
					</li>
				</ul>
			</div>
		</div>

		<div class="row">
			<div class="span12">
				<h2 class="breadcrumb">请假申请的任务办理</h2>
				<div class="table-responsive">
				<form action="${ctx }/workflow/submitTask" method="POST">
						<table class="table table-condensed table-striped table-bordered" >
								<input id="id" name="id" type="hidden" value="${bill.id }">
								<tr>
									<td align="right">请假天数:</td>
									<td><input id="days" name="days" type="text"
										value="${bill.days }" readonly></td>
								</tr>
								<tr>
									<td align="right">请假原因:</td>
									<td><input id="content" name="content" type="text"
										value="${bill.content}" readonly></td>
								</tr>
								<tr>
									<td align="right">备注:</td>
									<td><input id="remark" name="remark" type="text"
										value="${bill.remark }" readonly></td>
								</tr>
								
								<tr>
									<td align="right">批注:</td>
									<td><input id="comment" name="comment" type="text"></td>
								</tr>
								<tr>
								<td colspan="2" align="center">
									<!-- 使用连线的名称作为按钮 --> <c:if
										test="${outcomeList!=null && outcomeList.size()>0}">
										<c:forEach items="${outcomeList}" var="dep">
											<button class="btn btn-primary" type="submit" name="outcome">${dep.outcome }</button>
										</c:forEach>
									</c:if>
								</td>
							</tr>
							</tbody>
						</table>
						</form>
				</div>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="span12">
			<c:choose >
			<c:when test="${commentList!=null && commentList.size()>0 }">
			
		<div class="table-responsive">
			<table class="table table-condensed table-striped table-bordered">
				<thead class="bg-primary">
					<tr>
						<th>时间</th>
						<th>批注人</th>
						<th>批注信息</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${commentList}" var="dep">
						<tr>
							
							<td><fmt:formatDate value="${dep.time }"
									type="both" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td>${dep.userId }</td>
							<td>${dep.fullMessage }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
		
		</c:when>
		<c:otherwise>
		暂时没有批注信息
		</c:otherwise>
			</c:choose>

		</div>
		</div>
	</div>
	<script src="${ctx }/static/js/modules/oa.js"></script>
</body>
</html>
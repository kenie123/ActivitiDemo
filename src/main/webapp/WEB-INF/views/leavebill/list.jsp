<%@page import="com.bkc.oa.entity.Leavebill"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>
    <title>请假管理</title>
    
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
				<li>
					<a class="active" href="javascript:void(0)" onclick="showLeavebill()">请假管理</a>
				</li>
				</ul>
					<h2 class="breadcrumb"> 
						请假申请列表列表
					</h2>
					
					<form class="form-inline" action="?" method="post">										
					<div class="form-group">
					<input type="text" class="form-control" id="selectKeys" name="selectKeys" placeholder="请输入任务名或者执行类信息" value="">
					</div>					
					<button class="btn btn-default" type="submit" >查询</button>
					<span style="float:right">
					<button type="button" class="btn btn-primary" id="addBtn" onclick="addLeavebill()"
						name="addBtn">
						添加请假申请
					</button></span>
					</form>
					<br>
					<div class="table-responsive">
						<table class="table table-condensed table-striped table-bordered">
							<thead class="bg-primary">
								<tr>
									<th>
										#ID
									</th>
									<th>
										请假人
									</th>
									<th>
										请假天数
									</th>
									<th>
										请假事由
									</th>
									<th>
										请假备注
									</th>
									<th>
										请假时间
									</th>
									<th>
										请假状态
									</th>
									<th>
										操作
									</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${leavebillList}" var="leavebill">
								<tr>
									<td>
										<div class="checkbox">
											<label>
												<input type="checkbox" id="ids" name="ids" value="${leavebill.id }">${leavebill.id }
											</label>
										</div>
									</td>
									<td>
										${leavebill.user.name }
									</td>
									<td>
										${leavebill.days }
									</td>
									<td>
										${leavebill.content }
									</td>
									<td>
										${leavebill.remark }
									</td>
									<td>
										<fmt:formatDate value="${leavebill.leavedate }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/>
									</td>
									<td>
									<c:choose>
									<c:when test="${leavebill.state==0 }">  
				        			初始录入
				        		</c:when>
				 				<c:when  test="${leavebill.state==1}">
				 					审核中
				 				</c:when>
				 				<c:otherwise>
				 					审核完成
				 				</c:otherwise>
				 				</c:choose>
									</td>
									<td>
							<c:choose>
							<c:when test="${leavebill.state==0}">
			        			<a href="javascript:void(0)" onclick="addLeavebill('${leavebill.id }')">修改</a>
								<a href="javascript:void(0)" onclick="deleteLeavebill('${leavebill.id }')">删除</a>
								<a href="${ctx}/workflow/startProcess?id=${leavebill.id }" >申请请假</a>
			        		</c:when>
			 				<c:when test="${leavebill.state==1}">
			 					<a href="javascript:void(0)" onclick="viewHisComment('${leavebill.id }')" >查看审核记录</a>
			 				</c:when>
			 				<c:otherwise>
			 					<a href="javascript:void(0)" onclick="deleteLeavebill('${leavebill.id }')">删除</a>
			 					<a href="javascript:void(0)" onclick="viewHisComment('${leavebill.id }')" >查看审核记录</a>
			 				</c:otherwise>
			 				</c:choose>
									</td>
								</tr>
								</c:forEach>
								<tr>
							<td colspan="8"  align="right">
				</td>
						</tr>
							</tbody>
			</table>

				</div>
			</div>
		</div>
		</div>
	<script src="${ctx }/static/js/modules/oa.js"></script>
  </body>
</html>
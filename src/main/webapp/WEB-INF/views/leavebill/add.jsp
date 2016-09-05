<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<title>新增/修改请假申请</title>

</head>
<body>
	<div class="container" id="LG">
	<%@ include  file="/WEB-INF/views/include/top.jsp"%>
		<div class="row">
			<div class="span12">
				<ul class="breadcrumb">
					<li>当前位置：</li>
					<li><a href="javascript:void(0)" onclick="index()">首页</a></li>
					<li><a href="javascript:void(0)" onclick="showLeavebill()">请假管理</a>
					</li>
					<li><a href="javascript:void(0)" onclick="addLeavebill()">新增/修改请假申请</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="span12">

				<div class="table-responsive">
					<form action="${ctx }/leavebill/save" method="post">
						<table class="table table-condensed table-striped table-bordered" >
							<thead class="bg-primary">
								<tr align="center">
									<th colspan="2">新增/修改请假申请</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td align="right">请假天数:</td>
									<td><input id="days" name="days" type="text"
										value="${bill.days }"></td>
								</tr>
								<tr>
									<td align="right">请假原因:</td>
									<td><input id="content" name="content"
										type="text" value="${bill.content}"></td>
								</tr>
								<tr>
									<td align="right">备注:</td>
									<td><input id="remark" name="remark" type="text"
										value="${bill.remark }"></td>
								</tr>

								<tr>
									<td colspan="2" align="center">
										<button type="submit" class="btn btn-info" id="submitBtn"
											name="submitBtn" value="全选">确定</button>
										<button type="reset" class="btn btn-primary">重置</button>
										<button type="reset" class="btn btn-primary" onclick="showLeavebill()">返回</button>

									</td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
		</div>
		</div>
		<script src="${ctx }/static/js/modules/oa.js"></script>
</body>
</html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>
   <title>查看当前流程图</title>
    
  </head>
  <body>

</head>
<body>
<!-- 1.获取到规则流程图 -->
<img style="position: absolute;top: 0px;left: 0px;" src="${ctx }/workflow/viewImage?deploymentId=${deploymentId }&imageName=${imageName}">

<!-- 2.根据当前活动的坐标，动态绘制DIV -->
<div style="position: absolute;border:1px solid red;top:${acs.y}px;left: ${acs.x }px;width: ${acs.width}px;height:${ acs.height}px;   "></div></body>
</html>
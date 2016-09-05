<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>
    <title>登录页面</title>
     <link href="${ctx }/static/css/signin.css" rel="stylesheet">
  </head>
  <body>
  <c:choose>
  <c:when test="${sessionScope.user} != null" >
  	<c:redirect url="${ctx }/login"/>
  </c:when>
  <c:otherwise>
  	${message }
    <div class="container">
       <form class="form-signin" action="${ctx }/login" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputUsername" class="sr-only">用户名</label>
      	<select name="name" class="form-control">
        		<option value="范冰冰">范冰冰</option>
        		<option value="冯小刚">冯小刚</option>
        		<option value="范冰冰经纪人">范冰冰经纪人</option>
        		<option value="冯小刚经纪人">冯小刚经纪人</option>
        		<option value="王中军">王中军</option>
        </select>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>
    </div>
  </c:otherwise>
  </c:choose>
  </body>
</html>

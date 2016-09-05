<%@ page contentType="text/html;charset=UTF-8" %>
<div class="row">
	<div class="span12">

		<div style="float: right">
			
			<c:choose>
			<c:when test="${sessionScope.user !=null}" >
			当前登录用户:${sessionScope.user.name } 
			<a href="${ctx}/logout">注销</a><span
				id="test"></span>
			</c:when>
			<c:otherwise>
			您还没有登录:
			<a href="${ctx}/index">登录</a><span
				id="test"></span>
			</c:otherwise>
			</c:choose>
		</div>

		<script>
			setInterval(
					"document.getElementById('test').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",
					100);
		</script>
	</div>
</div>
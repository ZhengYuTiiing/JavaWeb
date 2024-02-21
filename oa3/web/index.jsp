<%@page contentType="text/html;charset=UTF-8"%>
<%--下面这行代码让访问JSP不创建session对象--%>
<%@page session="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>欢迎使用OA系统</title>
	</head>
	<body>
<%--		<a href="/oa3/list.jsp">查看部门列表</a>
<%--动态获取项目名&ndash;%&gt;--%>
<%--<a href="<%=request.getContextPath()%>/dept/list">查看部门列表</a>--%>
<%--前端路径要带项目名--%>
<h1>LOGIN PAGE</h1>
<hr>
	<form action="<%=request.getContextPath()%>/user/login" method="post">
		username:<input type="text" name="username"><br>
		password:<input type="password" name="password"><br>
		<input type="submit" value="login">
	</form>
	</body>
</html>
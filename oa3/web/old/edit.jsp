<%@ page import="com.cn.edu.szu.zyt.bean.Dept" %>
<%@page contentType="text/html;charset=UTF-8"%>
<%
	Dept dept=(Dept)request.getAttribute("dept");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>修改部门</title>
	</head>
	<body>
		<h1>修改部门</h1>
		<hr />
		<form action="<%=request.getContextPath()%>/dept/modify" method="post">
			部门编号：<input type="text" name="deptno" value="<%=dept.getDeptno()%>" /><br />
			部门名称：<input type="text" name="dname" value="<%=dept.getDname()%>" /><br />
			部门地址：<input type="text" name="loc" value="<%=dept.getLoc()%>" /><br />
			<input type="submit" value="修改" />
		</form>
	</body>
</html>
<%--<%@ page import="java.util.List,com.cn.edu.szu.zyt.bean.Dept" %>--%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="com.cn.edu.szu.zyt.bean.Dept" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset='utf-8'>
	<title>部门列表展示</title>
	<base href="http://localhost:8080/oa3/">
</head>
<body>
<%--显示登录的用户名--%>
<%--JSP有内置对象session，所以下一行可以直接用，但是你的最上面page要记住不能把session="false"了--%>
<h3>欢迎${username}</h3><br>
<a href="${pageContext.request.contextPath}/user/logout">退出系统</a>
<script>
	function del(dno){
		var ok=window.confirm("是否确认删除?");
		if(ok){
			document.location.href="${pageContext.request.contextPath}/dept/delete?deptno="+dno;
		}
	}
</script>

<h1 align='center'>部门列表</h1>
<hr />
<table border='1px' align='center'width='40%'>
	<tr>
		<th>序号</th>
		<th>部门编号</th>
		<th>部门名称</th>
		<th>操作</th>
	</tr>

	<c:forEach items="${deptList}" var="dept" varStatus="deptStatus">
		<tr>
			<td>${deptStatus.count}</td>
			<td>${dept.deptno}</td>
			<td>${dept.dname}</td>
			<td>
				<!--href='javascript:void(0)'表示仍然保留超链接的样子，点击不跳转-->
				<!--希望点击的时候执行一段JS代码，不进行页面的跳转-->
				<a href='javascript:void(0)' onclick='del(${dept.deptno})'>删除</a>
				<a href='${pageContext.request.contextPath}/dept/detail?f=m&dno=${dept.deptno}'>修改</a>
				<a href='${pageContext.request.contextPath}/dept/detail?f=d&dno=${dept.deptno}'>详情</a>
			</td>
		</tr>

	</c:forEach>


</table>
<a href='${pageContext.request.contextPath}/add.jsp'>新增部门</a>
</body>
</html>
<%--<%@ page import="java.util.List,com.cn.edu.szu.zyt.bean.Dept" %>--%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="com.cn.edu.szu.zyt.bean.Dept" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset='utf-8'>
	<title>部门列表展示</title>
</head>
<body>
<script>
	function del(dno){
		var ok=window.confirm("是否确认删除?");
		if(ok){
			document.location.href="<%=request.getContextPath()%>/dept/delete?deptno="+dno;
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
	<%
		List<Dept> deptList = (List<Dept>)request.getAttribute("deptList");
		int i=0;
		//iter快捷打出增强的for
		for (Dept dept:deptList) {
	%>
	<tr>
		<td><%=++i%></td>
		<td><%=dept.getDeptno()%></td>
		<td><%=dept.getDname()%></td>
		<td>
			<!--href='javascript:void(0)'表示仍然保留超链接的样子，点击不跳转-->
			<!--希望点击的时候执行一段JS代码，不进行页面的跳转-->
			<a href='javascript:void(0)' onclick='del(<%=dept.getDeptno()%>)'>删除</a>
			<a href='<%=request.getContextPath()%>/dept/detail?f=m&dno=<%=dept.getDeptno()%>'>修改</a>
			<a href='<%=request.getContextPath()%>/dept/detail?f=d&dno=<%=dept.getDeptno()%>'>详情</a>
		</td>
	</tr>


	<%
		}
	%>

</table>
<a href='<%=request.getContextPath()%>/add.jsp'>新增部门</a>
</body>
</html>
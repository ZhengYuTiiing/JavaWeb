<%@page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>新增部门</title>
	</head>
	<body>
		<h1>新增部门</h1>
		<hr />
		<form action="<%=request.getContextPath()%>/dept/save" method="post">
			部门编号：<input type="text" name="deptno" id="" /><br />
			部门名称：<input type="text" name="dname" id="" /><br />
			部门地址：<input type="text" name="loc" id="" /><br />
			<input type="submit" value="保存" />
		</form>
	</body>
</html>
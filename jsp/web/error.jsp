<%--
  Created by IntelliJ IDEA.
  User: 11323
  Date: 2024/2/22
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--下面这个page指令为true了之后，可以用九大内置对象exception--%>
<%@page isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>出错啦</h1>
<%
    exception.printStackTrace();
%>
</body>
</html>

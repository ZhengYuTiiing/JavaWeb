
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session= "false" %>
<html>
  <head>
    <title>cookie</title>
  </head>
  <body>
  <h1><a href="<%=request.getContextPath()%>/cookie/generate">服务器生成cookie,响应给浏览器，浏览器保存cookie</a></h1>
  <br>
  <a href="<%=request.getContextPath()%>/sendCookie">浏览器发生cookie给服务器</a>
  </body>
</html>

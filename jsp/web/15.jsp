<%@page contentType="text/html; charset=UTF-8" %>
<%--JSP中的EL表达式的隐含对象
1.pageContext
2.param
3.paramValues
4.initParam
--%>
应用根路径：${pageContext.request.contextPath}<br>
<%--http://localhost:8080/jsp/15.jsp?username=zhangsan--%>
用户名：<%=request.getParameter("username")%><br>
用户名：${param.username}<br>
<hr>
<%--http://localhost:8080/jsp/15.jsp?aihao=drink&aihao=smoke
用checkbox提交的--%>
爱好：<%=request.getParameter("aihao")%><br>
爱好：${param.aihao}<br>

爱好一维数组：${paramValues.aihao}<br>
爱好一维数组：<%=request.getParameterValues("aihao")%><br>

爱好：${paramValues.aihao[0]}、${paramValues.aihao[1]}<br>

<hr>

<%
    String pageSize=application.getInitParameter("pageSize");
    String pageNum = application.getInitParameter("pageNum");
%>
每页显示的记录条数：<%=pageSize%><br>
页码：<%=pageNum%><br>

每页显示的记录条数：<%=application.getInitParameter("pageSize")%><br>
页码：<%=application.getInitParameter("pageNum")%><br>

每页显示的记录条数：${initParam.pageSize}<br>
页码：${initParam.pageNum}<br>




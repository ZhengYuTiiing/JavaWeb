<%@ page import="com.cn.edu.szu.zyt.bean.User" %>
<%@page contentType="text/html; charset=UTF-8" %>
<%
    User user=new User();
    user.setUsername("zhangsan");
    request.setAttribute("ddddafa",user);
    request.setAttribute("abc.efg","hello jsp el");

%>

${ddddafa}<br>
${ddddafa.username}<br>
${ddddafa["username"]}<br>

<%--这样取不出来--%>
${requestScope.abc.efg}<br>
<%--这样能取出来，name中有特殊字符时，才使用[]--%>
${requestScope["abc.efg"]}


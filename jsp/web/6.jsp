
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    request.setAttribute("username","zhangsan");
    request.setAttribute("obj",new Object());
%>
<%--将request域中的数据取出来并输出--%>
<%=request.getAttribute("username")%>
<%=request.getAttribute("obj")%>

${username}
${obj}
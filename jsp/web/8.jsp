<%@page contentType="text/html; charset=UTF-8" %>
<%
    pageContext.setAttribute("data","pageContext");
    request.setAttribute("data","request");
    session.setAttribute("data","session");
    application.setAttribute("data","application");
%>
${data}
<br>
<%--以下是指定范围取数据--%>
${pageScope.data}<br>
${requestScope.data}<br>
${sessionScope.data}<br>
${applicationScope.data}


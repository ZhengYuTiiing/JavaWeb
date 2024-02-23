<%@page contentType="text/html; charset=UTF-8" %>
<%--JSP九大内置对象：pageContext,requst,seesion,application,out,response,config,page,exception--%>
<%=pageContext.getRequest()%>
<br>
<%=request%>
<br>
<hr>
<%--在EL表达式中，没有request这个对象，只有requestScope，。requestScope只代表“请求范围”
    在EL表达式中有pageContext，和JSP九大内置对象的pageContext是同一个对象。
    --%>
<%=pageContext.getRequest()%><br>
${pageContext.request}<br>
<hr>
<%=request.getContextPath()%><br>
<%=((HttpServletRequest)pageContext.getRequest()).getContextPath()%><br>
${pageContext.request.contextPath}<br>

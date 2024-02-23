<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--test属性是必须的，是boolean。test支持EL表达式--%>
<c:if test="${empty param.username}">
    <h1>用户名不能为空</h1>
</c:if>

<c:if test="${ not empty param.username}">
    <h1>欢迎您${param.username}</h1>
</c:if>
<%--if标签还有var属性，scope属性，不是必须的,v是test属性的值,不是true就是false
把v存在request域中--%>
<c:if test="${ not empty param.username}" var="v" scope="request">

</c:if>

${v}
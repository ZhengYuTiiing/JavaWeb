<%@ page import="com.cn.edu.szu.zyt.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${param.age<18}">青少年</c:when>
    <c:when test="${param.age<35}">青年</c:when>
    <c:when test="${param.age<55}">中年</c:when>
    <c:otherwise>老年</c:otherwise>
</c:choose>
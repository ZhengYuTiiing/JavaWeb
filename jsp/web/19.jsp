<%@ page import="com.cn.edu.szu.zyt.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--//if标签会把i存入pageContext域中--%>
<c:forEach var="i" begin="1" end="10" step="1">
    ${i}<br>
</c:forEach>

<%
    List<Student> list=new ArrayList<>();
    Student s1=new Student("110","警察");
    Student s2=new Student("120","救护车");
    Student s3=new Student("119","消防车");
    list.add(s1);
    list.add(s2);
    list.add(s3);
    request.setAttribute("stuList",list);
%>

<c:forEach items="${stuList}" var="stu" varStatus="stuStatus">
    ${stuStatus.count}
    id:${stu.id},name:${stu.name}<br>
</c:forEach>

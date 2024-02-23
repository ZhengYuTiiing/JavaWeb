<%@ page import="com.cn.edu.szu.zyt.bean.User" %>
<%@ page import="com.cn.edu.szu.zyt.bean.Address" %>
<%@page contentType="text/html; charset=UTF-8" %>
<%
    User user = new User();
    user.setAge(20);
    user.setPassword("1234");
    user.setUsername("zyt");

    request.setAttribute("userObj",user);

    Address a=new Address();
    a.setCity("beijing");
    a.setStreet("daxingqu");
    a.setZipcode("111111");
    user.setAddr(a);
%>

${userObj}<br>
<%--下面的不是获取了成员变量，时调用了getUsername...这些方法，全部小写--%>
${userObj.username}<br>
${userObj.password}<br>
${userObj.age}<br>
${userObj.email}<br>
<%--直接将"userobj"当做普通字符串输出到浏览器--%>
${"userobj"}<br>
${userObj.addr.city}<br>
${userObj.addr.street}<br>
${userObj.addr.zipcode}<br>

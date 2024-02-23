<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.cn.edu.szu.zyt.bean.User" %>
<%@page contentType="text/html; charset=UTF-8" %>
<%
    Map<String,String> map=new HashMap<>();
    map.put("username","zhangsan");
    map.put("password","1234");

    User user=new User();
    user.setAge(20);
    Map<String,User> userMap2=new HashMap<>();
    userMap2.put("user",user);

    request.setAttribute("userMap",map);
    request.setAttribute("kahiau",userMap2);

%>

${kahiau.user.age}<br>

${userMap.username}<br>
${userMap.password}<br>
${userMap["username"]}<br>
${userMap["password"]}<br>

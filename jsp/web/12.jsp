<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String[] usernames={"zhangsan","lisi","wangwu"};
    request.setAttribute("nameArray",usernames);

    List<String> list=new ArrayList<>();
    list.add("abc");
    list.add("def");
    request.setAttribute("mylist",list);

    Set<String> set=new HashSet<>();
    set.add("a");
    set.add("b");
    request.setAttribute("set",set);
%>
${mylist}<br>
<%--${mylist[0]}<br>无法获取，会有异常，因为set是无序的--%>
<%--${mylist[1]}<br>--%>

${set}<br>
${set[0]}<br>
${set[1]}<br>
${nameArray}<br>
${nameArray[0]}<br>
${nameArray[1]}<br>
${nameArray[2]}<br>
<%--数组下标越界，不会报错，会处理，输出空字符串--%>
${nameArray[1000]}<br>



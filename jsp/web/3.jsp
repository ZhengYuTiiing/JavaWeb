<%@page contentType="text/html; charset=UTF-8" %>
<%--这种脚本块是翻译到service方法中--%>
<%
    System.out.println("hello jsp");
    String name="zyt";
    //使用内置对象out,在这个service里面有一个out对象
    out.write("name="+name);
%>
<%--带！的是翻译到类体中--%>
<%!
    private int num=0;
%>

<%!
    public void printout(){
        System.out.println("输出");
    }
%>
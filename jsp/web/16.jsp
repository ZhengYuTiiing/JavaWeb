<%@ page import="com.cn.edu.szu.zyt.bean.Student" %>
<%@ page contentType="text/html;charset=UTF-8"%>

${10+20}<br>
<%--在EL表达式中+只会求和，不会字符串拼接--%>
${10+"20"}<br>
<%--java.lang.NumberFormatException: For input string: "abd--%>
\${10+"abd"}<br>

${"abc"=="abc"}<br>
${"abc"}==${"abc"}<br>

<%
    Object o = new Object();
    request.setAttribute("k1",o);
    request.setAttribute("k2",o);

%>
${k1==k2}<br><%--true--%>


<%
    String s1 = new String("hehe");
    String s2 = new String("hehe");
    request.setAttribute("s1",s1);
    request.setAttribute("s2",s2);
%>
${s1==s2}<%--true--%><br>

<%
    Object o1 = new Object();
    Object o2 = new Object();
    request.setAttribute("o1",o1);
    request.setAttribute("o2",o2);

%>
${o1==o2}<%--false--%><br>

<%
    Student stu1=new Student("110","police");
    Student stu2=new Student("110","police");
    request.setAttribute("stu1",stu1);
    request.setAttribute("stu2",stu2);
%>

学生==：${stu1==stu2}<br>
学生!=：${stu1!=stu2}<br>
学生eq：${stu1 eq stu2}<br>

!=：${200!=200}<br>
${!(stu1==stu2)}<br>

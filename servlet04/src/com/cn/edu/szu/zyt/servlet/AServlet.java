package com.cn.edu.szu.zyt.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class AServlet extends GenericServlet {
    @Override
    public void service(ServletRequest Request, ServletResponse Response) throws ServletException, IOException {
        Response.setContentType("text/html");
        PrintWriter out = Response.getWriter();

        ServletContext application = this.getServletContext();
        out.print("ServletContext对象是："+application+"<br>");

        Enumeration<String> initParameterNames = application.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            String value = application.getInitParameter(name);
            out.print(name+"="+value+"<br>");
        }
        String contextPath = application.getContextPath();
        out.print("项目路径："+contextPath+"<br>");

        String realPath = application.getRealPath("/WEB-INF/web.xml");
        out.print("真实路径"+realPath+"<br>");

        application.log("i am zyt!");
        User user=new User("zyt","1234");
        application.setAttribute("userObj",user);

        Object userObj = application.getAttribute("userObj");
        out.print(userObj+"<br>");

    }

}

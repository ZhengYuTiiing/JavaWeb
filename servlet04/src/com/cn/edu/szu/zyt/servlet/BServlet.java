package com.cn.edu.szu.zyt.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class BServlet extends GenericServlet
{
    @Override
    public void service(ServletRequest Request, ServletResponse Response) throws ServletException, IOException {
        Response.setContentType("text/html");
        PrintWriter out = Response.getWriter();

        ServletContext application = this.getServletContext();
        out.print("ServletContext对象是："+application+"<br>");
        int age=17;
        if(age<18){
            ServletContext servletContext = this.getServletContext();
            servletContext.log("小屁孩",new Throwable("未满18岁"));
        }

        Object userObj = application.getAttribute("userObj");
        out.print(userObj+"<br>");
    }
}

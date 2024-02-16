package com.cn.szu.zyt.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class ServletConfigTest2 extends GenericServlet {
    @Override
    public void service(ServletRequest Request, ServletResponse Response) throws ServletException, IOException {
        Response.setContentType("text/html;");
        PrintWriter out = Response.getWriter();
        ServletConfig servletConfig = this.getServletConfig();
        out.print("ServletConfig对象是”"+servletConfig+"<br>");
        //这个name就是<servlet-name>
        /**
         *   <servlet>
         *         <servlet-name>Config1</servlet-name>
         *         <servlet-class>com.cn.szu.zyt.javaweb.servlet.ServletConfigTest</servlet-class>
         *     </servlet>
         */
        String name = servletConfig.getServletName();
        out.print("Servlet对象的名字是"+name);
    }
}

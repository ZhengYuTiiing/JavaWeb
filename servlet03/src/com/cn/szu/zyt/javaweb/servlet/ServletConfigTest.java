package com.cn.szu.zyt.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ServletConfigTest extends GenericServlet {
    @Override
    public void service(ServletRequest Request, ServletResponse Response) throws ServletException, IOException {
        Response.setContentType("text/html;");
        PrintWriter out = Response.getWriter();

        //ServletConfig对象是”org.apache.catalina.core.StandardWrapperFacade@429bad4d
        //Tomcat服务器是这个，jetty服务器就是别的包别的地址
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
        out.print("Servlet对象的名字是"+name+"<br>");

        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String ParameterName=initParameterNames.nextElement();
            out.print(ParameterName);
            out.print("=");
            String value=servletConfig.getInitParameter(ParameterName);
            out.print(value+"<br>");
        }
//        String drive=servletConfig.getInitParameter("driver");
//        out.print(drive);
    }
}

package com.cn.szu.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;

public class AServlet implements Servlet {

    public AServlet(){
        System.out.println("A无参数构造方法执行了。。");
    }
    public AServlet(String s){
        System.out.println("A无参数构造方法执行了。。");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("A init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("A service");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("A destory");
    }
}

package com.cn.szu.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class LoginServlet extends GenericServlet{
    @Override
    public void init() {
        System.out.println("login service init");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("log in。。。");
    }
}

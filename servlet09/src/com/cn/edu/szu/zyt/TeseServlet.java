package com.cn.edu.szu.zyt;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class TeseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();
        System.out.println("项目根路径:"+contextPath);

        String method = req.getMethod();
        System.out.println(method);

        String requestURI = req.getRequestURI();
        System.out.println(requestURI);

        String servletPath = req.getServletPath();
        System.out.println(servletPath);

    }
}

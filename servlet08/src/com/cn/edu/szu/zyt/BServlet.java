package com.cn.edu.szu.zyt;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Date nowTime=new Date();
        req.setAttribute("sysTime",nowTime);

        String remoteAddr = req.getRemoteAddr();
        String remoteHost = req.getRemoteHost();
        out.print("远程主机add:"+remoteAddr+"<br>");
        out.print("远程主机host:"+remoteHost+"<br>");
        System.out.println("远程主机:"+remoteAddr+"<br>");
        //转发
        //RequestDispatcher requestDispatcher = req.getRequestDispatcher("/a");
        //不一定非遗转发到servlet,WEB容器中合法的资源就行
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.html");
//        requestDispatcher.forward(req,resp);
        //   req.getRequestDispatcher("/a").forward(req,resp);
//        Object o=req.getAttribute("sysTime");
//
//        out.print("当前系统时间是:"+o);
    }
}

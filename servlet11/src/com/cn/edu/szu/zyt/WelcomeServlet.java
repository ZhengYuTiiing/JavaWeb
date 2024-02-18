package com.cn.edu.szu.zyt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
//当注解的属性是一个数组，并且数组只有一个元素，大括号可以省略
//@WebServlet(value = "/welcome")
//@WebServlet(urlPatterns = "/welcome")
//@WebServlet(value ={ "/welcome","/welcome2","/welcome3"})
@WebServlet( "/wel")
//如果属性名是value，可以省略value
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.print("欢迎欢迎");

    }
}

package com.cn.edu.szu.zyt;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
             throws ServletException, IOException {
        User userobj=new User();
        userobj.setId("1111");
        userobj.setName("zhangsan");

        request.setAttribute("userobj",userobj);

        //request.getRequestDispatcher("/b").forward(request,response);
        response.sendRedirect(request.getContextPath()+"/b" );
    }
}

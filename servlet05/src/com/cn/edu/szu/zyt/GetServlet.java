package com.cn.edu.szu.zyt;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class GetServlet extends GenericServlet {
    @Override
    public void service(ServletRequest Request, ServletResponse Response) throws ServletException, IOException {
        Response.setContentType("text/html");
        PrintWriter out = Response.getWriter();

        out.print("<h1>from get servlet</h1>");
    }
}

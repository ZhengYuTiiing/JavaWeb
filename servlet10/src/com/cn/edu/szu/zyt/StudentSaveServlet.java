package com.cn.edu.szu.zyt;

import com.cn.edu.szu.zyt.util.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("no");
        System.out.println("id="+id);
        String name = request.getParameter("name");

        Connection conn=null;
        PreparedStatement ps=null;
        int count=0;
        try {
            conn= DBUtil.getConnection();
            String  sql="insert into students(id,name) values (?,?)";
            ps = conn.prepareStatement(sql);
           ps.setString(1,id);
            ps.setString(2,name);
            count=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(conn,ps,null);
        }
        if (count==1){
            //request.getRequestDispatcher("/success.html").forward(request,response);
             response.sendRedirect(request.getContextPath()+"/success.html");
        }else {
      //      request.getRequestDispatcher("errorPage.html").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/errorPage.html");
        }

    }
}

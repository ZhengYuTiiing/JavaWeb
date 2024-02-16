package com.cn.edu.szu.zyt.oa.web.action;

import com.cn.edu.szu.zyt.oa.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int count=0;
        try {
           conn=DBUtil.getConnection();
           String sql="insert into dept(deptno,dname,loc) values (?,?,?)";
           ps= conn.prepareStatement(sql);
           //这个？？？从第一个第二个开始，1，2，3
           ps.setString(1,deptno);
           ps.setString(2,dname);
           ps.setString(3,loc);
           count=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(conn,ps,rs);
        }
        if(count==1){
            request.getRequestDispatcher("/dept/list").forward(request,response);
        }else {
            request.getRequestDispatcher("/erroe.html").forward(request,response);
        }
    }
}

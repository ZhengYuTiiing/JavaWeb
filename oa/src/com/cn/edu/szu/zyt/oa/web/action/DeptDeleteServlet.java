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

public class DeptDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptno = request.getParameter("deptno");

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int count=0;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql="delete from dept where deptno=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,deptno);
            count=ps.executeUpdate();
            conn.commit();

        } catch (SQLException e) {
            if(conn!=null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

        }finally {
            DBUtil.close(conn,ps,rs);
        }
        if(count==1){
            //应该用重定向，现在还没学，先转发
            //request.getRequestDispatcher("/dept/list").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }
        else {
          //  request.getRequestDispatcher("/error.html").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/error.html");
        }
    }
}

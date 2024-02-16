package com.cn.edu.szu.zyt.oa.web.action;

import com.cn.edu.szu.zyt.oa.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"utf-8\">\n" +
                "\t\t<title>部门详情</title>\n" +
                "\t</head>\n" +
                "\t<body>\n" +
                "\t\t<h1>部门详情</h1>\n" +
                "\t\t<hr />\n" );


        //获取了“30”这个字符串
        String deptno1 = request.getParameter("deptno");

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            conn = DBUtil.getConnection();
            String sql="select deptno,dname,loc from dept where deptno= ?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,deptno1);
            rs=ps.executeQuery();
      //一定只有一条结果
            if (rs.next()){
                String deptno=rs.getString("deptno");
                String dname=rs.getString("dname");
                String loc=rs.getString("loc");

                out.print("部门编号："+deptno+"<br>\n" +
                        "\t\t部门名称："+dname+"<br>\n" +
                        "\t\t部门位置："+loc+"<br>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(conn,ps,rs);
        }
        out.print( "\t\t\n" +
                "\t\t<input type=\"button\" value=\"后退\" onclick=\"window.history.back()\"/>\n" +
                "\t</body>\n" +
                "</html>");
    }
}

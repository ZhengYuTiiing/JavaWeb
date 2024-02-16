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

public class DeptEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath = request.getContextPath();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<meta charset='utf-8'>\n" +
                "\t\t<title>修改部门</title>\n" +
                "\t</head>\n" +
                "\t<body>\n" +
                "\t\t<h1>修改部门</h1>\n" +
                "\t\t<hr />\n" +
                "\t\t<form action='"+contextPath+"/dept/modify' method='post'>\n");

        String deptno = request.getParameter("deptno");
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            conn= DBUtil.getConnection();
            String sql="select deptno,dname,loc from dept where deptno=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,deptno);
            rs=ps.executeQuery();
            if (rs.next()){
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                out.print("\t部门编号：<input type='text' name='deptno' value='"+deptno+"' readonly /><br />\n" +
                        "\t\t\t部门名称：<input type='text' name='dname' value='"+dname+"' /><br />\n" +
                        "\t\t\t部门地址：<input type='text' name='loc' value='"+loc+"' /><br />");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(conn,ps,rs);
        }
        out.print("\t\t\t<input type='submit' value='修改' />\n" +
                "\t\t</form>\n" +
                "\t</body>\n" +
                "</html>");
    }

}

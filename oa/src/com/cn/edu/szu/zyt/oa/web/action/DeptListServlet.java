package com.cn.edu.szu.zyt.oa.web.action;

import com.cn.edu.szu.zyt.oa.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class DeptListServlet extends HttpServlet {
    //改成重定向了
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req,resp);
//    }

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
                "\t\t<title>部门列表展示</title>\n" +
                "\t</head>\n" +
                "\t<body>\n" +
                "\t\t<script>\n" +
                "\t\t\tfunction del(dno){\n" +
                "\t\t\t\tvar ok=window.confirm(\"是否确认删除?\");\n" +
                "\t\t\t\tif(ok){\n" +
                "\t\t\t\t\tdocument.location.href=\"/oa/dept/delete?deptno=\"+dno;\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t</script>\n" +
                "\t\t<h1 align='center'>部门列表</h1>\n" +
                "\t\t<hr />\n" +
                "\t\t<table border='1px' align='center'width='40%'>\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t\t<th>序号</th>\n" +
                "\t\t\t\t<th>部门编号</th>\n" +
                "\t\t\t\t<th>部门名称</th>\n" +
                "\t\t\t\t<th>操作</th>\n" +
                "\t\t\t</tr>" );

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn = DBUtil.getConnection();
            String sql="select deptno,dname,loc from dept";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            int i=0;
            while (rs.next()){
                String deptno=rs.getString("deptno");
                String dname=rs.getString("dname");
                String loc=rs.getString("loc");

                out.print("\t\t\t<tr>\n" +
                        "\t\t\t\t<td>"+(++i)+"</td>\n" +
                        "\t\t\t\t<td>"+deptno+"</td>\n" +
                        "\t\t\t\t<td>"+dname+"</td>\n" +
                        "\t\t\t\t<td>\n" +
                        "\t\t\t\t\t<a href='javascript:void(0)' onclick='del("+deptno+")'>删除</a>\n" +
                        "\t\t\t\t\t<a href='"+contextPath+"/dept/edit?deptno="+deptno+"'>修改</a>\n" +
                        "\t\t\t\t\t<a href='"+contextPath+"/dept/detail?deptno="+deptno+"'>详情</a>\n" +
                        "\t\t\t\t</td>\n" +
                        "\t\t\t</tr>\n" );

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(conn,ps,rs);
        }
        out.print( "\n" +
                "\t\t</table>\n" +
                "\t\t<a href='"+contextPath+"/add.html'>新增部门</a>\n" +
                "\t</body>\n" +
                "</html>");
    }
}

package com.cn.edu.szu.zyt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(value ={ "/dept/list","/dept/detail","/dept/delete","/dept/save","/dept/edit","/dept/modify"})
public class DeptServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
       if ("/dept/list".equals(servletPath)){
           doList(request,response);
       } else if ("/dept/detail".equals(servletPath)) {
           doDetail(request,response);
       }else if ("/dept/delete".equals(servletPath)) {
           doDel(request,response);
       }else if ("/dept/save".equals(servletPath)) {
           doSave(request,response);
       }else if ("/dept/edit".equals(servletPath)) {
           doEdit(request,response);
       }else if ("/dept/modify".equals(servletPath)) {
           doModify(request,response);
       }
    }
    private void doList(HttpServletRequest request, HttpServletResponse response)
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
                "\t\t\t\t\tdocument.location.href=\"/oa2/dept/delete?deptno=\"+dno;\n" +
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
    private void doDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
    private void doDel(HttpServletRequest request, HttpServletResponse response)
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
    private void doSave(HttpServletRequest request, HttpServletResponse response)
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
            //这个？？？从第一个第二个开始，1，2，3,下标是从1开始
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
            System.out.println(request.getContextPath());
            //request.getRequestDispatcher("/dept/list").forward(request,response);
            //不用转发了，不然ListServlet中还要写doPost,这样改了ListServlet中不用写doPost
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else {
            //request.getRequestDispatcher("/error.html").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/error.html");
        }
    }
    private void doEdit(HttpServletRequest request, HttpServletResponse response)
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
    private void doModify(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        Connection conn=null;
        PreparedStatement ps=null;
        int count =0;
        try {
            conn= DBUtil.getConnection();
            String sql="update dept set dname=?,loc=? where deptno=?";
            ps= conn.prepareStatement(sql);
            ps.setString(1,dname);
            ps.setString(2,loc);
            ps.setString(3,deptno);
            count=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(conn,ps,null);
        }
        if(count==1){
            //request.getRequestDispatcher("/dept/list").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }
        else {
            // request.getRequestDispatcher("/error.html").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/error.html");
        }
    }
}

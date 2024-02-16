package com.suz.javaweb.servlet;


import jakarta.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class StudentServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            String url="jdbc:mysql://localhost:3306/zyt";
            String user="root";
            String password="zyt1566585M";
            conn= DriverManager.getConnection(url,user,password);

            String sql="select id,name from students";
            ps= conn.prepareStatement(sql);
            //执行
            rs=ps.executeQuery();
            servletResponse.setContentType("text/html");
            PrintWriter out=servletResponse.getWriter();
            while (rs.next()){
                String id=rs.getString(1);
                String name=rs.getString(2);
                out.print("id="+id+",name="+name+"<br>") ;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

//    public void init(ServletConfig config) throws ServletException {
//
//    }
//    public void service(ServletRequest request,ServletResponse response)
//            throws ServletException,IOException{
//        Connection conn=null;
//        PreparedStatement ps=null;
//        ResultSet rs=null;
//        try {
//            //注册驱动
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //获取连接
//            String url="jdbc:mysql://localhost:3306/zyt";
//            String user="root";
//            String password="zyt1566585M";
//            conn= DriverManager.getConnection(url,user,password);
//
//            String sql="select id,name from students";
//            ps= conn.prepareStatement(sql);
//            //执行
//            rs=ps.executeQuery();
//            response.setContentType("text/html");
//            PrintWriter out=response.getWriter();
//            while (rs.next()){
//                String id=rs.getString(1);
//                String name=rs.getString(2);
//                out.print("id="+id+",name="+name+"<br>") ;
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        finally {
//            if (rs!=null){
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (ps!=null){
//                try {
//                    ps.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (conn!=null){
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
//
//
//
//    }
//    public void destroy(){
//
//    }
//    public String getServletInfo(){
//        return  "";
//    }
//    public  ServletConfig getServletConfig(){
//        return null;
//    }
}


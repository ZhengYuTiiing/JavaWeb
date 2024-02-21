package com.cn.edu.szu.zyt.webaction;

import com.cn.edu.szu.zyt.DBUtil;
import com.cn.edu.szu.zyt.bean.Dept;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = {"/dept/list","/dept/detail","/dept/delete","/dept/save","/dept/modify"})
public class DeptServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if ("/dept/list".equals(servletPath)){
            doList(request,response);
        }else if("/dept/detail".equals(servletPath)){
            doDetail(request,response);
        }
        else if("/dept/delete".equals(servletPath)){
            doDel(request,response);
        }else if ("/dept/save".equals(servletPath)) {
            doSave(request,response);
        }else if ("/dept/modify".equals(servletPath)) {
            doModify(request,response);
        }
    }

    /**
     *保存部门信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
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
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }
    }

    /**
     * 根据部门编号删除部门
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doDel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deptno = request.getParameter("deptno");

        //连接数据库删除部门
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int count=0;
        try {
            conn=DBUtil.getConnection();
            String sql="delete from dept where deptno=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,deptno);
            count= ps.executeUpdate();
            if(count==1){
               response.sendRedirect(request.getContextPath()+"/dept/list");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(conn,ps,rs);
        }

    }

    /**
     * 根据编号获取相信
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        Dept dept=new Dept();
        String dno = request.getParameter("dno");
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=DBUtil.getConnection();
            String sql="select dname,loc from dept where deptno=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,dno);
            rs=ps.executeQuery();
            if (rs.next()){
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                dept.setDeptno(dno);
                dept.setDname(dname);
                dept.setLoc(loc);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(conn,ps,rs);
        }
        String f = request.getParameter("f");
        request.setAttribute("dept",dept);
        if("m".equals(f)){
            //转发到修改页面
            request.getRequestDispatcher("/edit.jsp").forward(request,response);
        }
        if("d".equals(f)){
            //转发到详情页面
            request.getRequestDispatcher("/detail.jsp").forward(request,response);
        }

    }

    /**
     * 连接数据库，查询所有的部门信息，及那个部门信息收集好，然后跳转到JSP做页面展示
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        List<Dept> depts = new ArrayList<>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=DBUtil.getConnection();
            String sql="select deptno,dname,loc from dept";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                String deptno = rs.getString("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                //将以上零散的数据封装成对象
                Dept dept=new Dept();
                dept.setDeptno(deptno);
                dept.setDname(dname);
                dept.setLoc(loc);

                depts.add(dept);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(conn,ps,rs);
        }
        request.setAttribute("deptList",depts);
        //转发
        request.getRequestDispatcher("/list.jsp").forward(request,response);
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

    }
}

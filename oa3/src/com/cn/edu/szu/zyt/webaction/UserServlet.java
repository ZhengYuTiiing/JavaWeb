package com.cn.edu.szu.zyt.webaction;

import com.cn.edu.szu.zyt.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(value = {"/user/login","/user/logout"})
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if("/user/logout".equals(servletPath)){
            doExit(request,response);
        }else if ("/user/login".equals(servletPath)){
            doLogin(request,response);
        }
    }

    private void doExit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取session对象，销毁session
        HttpSession session = request.getSession(false);
        if (session!=null){
            //手动销毁session对象
            session.invalidate();
//            Cookie[] cookies = request.getCookies();
//            if(cookies!=null){
//                for (Cookie cookie : cookies) {
//                    cookie.setMaxAge(0);
//                        cookie.setPath(request.getContextPath());
//                        response.addCookie(cookie);
//                }
//            }
//           response.sendRedirect(request.getContextPath());
            Cookie cookie1 = new Cookie("username", "");
            cookie1.setMaxAge(0);
            cookie1.setPath(request.getContextPath());

            Cookie cookie2 = new Cookie("password", "");
            cookie2.setMaxAge(0);
            cookie2.setPath(request.getContextPath());

            response.addCookie(cookie1);
            response.addCookie(cookie2);
            response.sendRedirect(request.getContextPath());
        }

    }



    protected void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        boolean success=false;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            String sql="select * from t_user where username=? and password=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs=ps.executeQuery();
            if(rs.next()){
                success=true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(conn,ps,rs);
        }
        if(success){
            HttpSession session = request.getSession();
            session.setAttribute("username",username);

            String flag = request.getParameter("flag");
            if("1".equals(flag)){
                Cookie cookie=new Cookie("username",username);
                Cookie cookie1=new Cookie("password",password);
                cookie.setMaxAge(60*60*24*10);
                cookie1.setMaxAge(60*60*24*10);
                cookie1.setPath(request.getContextPath());
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);
                response.addCookie(cookie1);
            }

            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else {
                response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
}

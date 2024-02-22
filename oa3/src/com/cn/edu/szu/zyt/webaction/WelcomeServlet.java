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

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String username=null;
        String password=null;
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if("username".equals(name)){
                    username=cookie.getValue();
                }
                if("password".equals(name)){
                    password=cookie.getValue();
                }
            }
        }
        if(username!=null&&password!=null){
            //验证有户吗密码是否正确
            Connection conn=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            boolean successs=false;
            try {
                conn= DBUtil.getConnection();
                String  sql="select * from t_user where username= ? and password =?";
                ps=conn.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,password);
                rs= ps.executeQuery();
                if(rs.next()){
                    //登陆成功
                    successs=true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                DBUtil.close(conn,ps,rs);
            }

            if(successs){
                HttpSession session = request.getSession();
                session.setAttribute("username",username);
                response.sendRedirect(request.getContextPath()+"/dept/list");
            }else {
                response.sendRedirect(request.getContextPath()+"/index.jsp");
            }
        }else{
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
    }
}

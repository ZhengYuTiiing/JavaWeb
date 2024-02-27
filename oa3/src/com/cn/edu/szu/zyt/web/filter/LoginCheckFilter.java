package com.cn.edu.szu.zyt.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        /**
         *    “/*”表示所有的都拦截，那index.jsp又要走过滤器，不行
         *    用户要登录也不能拦截。
         *    用户已经登录也不要拦。
         *    WelcomeServlet也不要拦截
         */
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse) resp;
        String servletPath = request.getServletPath();

        //加上false,没有session的的话也不创建，返回null
        HttpSession session = request.getSession(false);
        if("/index.jsp".equals(servletPath)||"/welcome".equals(servletPath)||
                "/user/logout".equals(servletPath)||"/user/login".equals(servletPath)
                || (session!=null&&session.getAttribute("username")!=null)){
            chain.doFilter(request,response);
        }else {
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
    }
}

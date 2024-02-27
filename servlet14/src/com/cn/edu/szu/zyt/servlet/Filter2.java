package com.cn.edu.szu.zyt.servlet;

import jakarta.servlet.*;
import jakarta.servlet.Filter;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
@WebFilter("*.do")
public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter2 do filter begin");
        chain.doFilter(servletRequest,servletResponse);
        System.out.println("Filter2 do filter end");
    }

    @Override
    public void destroy() {
    }
}

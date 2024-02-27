package com.cn.edu.szu.zyt.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
//@WebFilter("/abc")
//@WebFilter({"/a.do","/b.do"})

/**
 * 模糊匹配中的扩展匹配。
 * 以*开头，不以/开头
 */
@WebFilter("*.do")
//匹配所有的路径
//    "/*"
public class Filter1 implements Filter{
    public Filter1(){
        System.out.println("无参构造方法执行");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init方法执行");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("doFilter1方法开始执行");
        //执行下一个过滤器。如果下一个不是过滤器了，则执行目标程序Servlet
        //向下走，没有它是不行的

        chain.doFilter(request,response);
        System.out.println("doFilter2方法执行结束");
    }

    @Override
    public void destroy() {
        System.out.println("destory方法执行");
    }
}

package com.cn.edu.szu.zyt;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    //启动服务器，第一次发送请求，按照生命周期，先无参数构造
//    public HelloServlet() {
//    }
    //创建了HttpServlet的对象，执行对象init()，
    //HttpServlet中没有init，HttpServlet继承GenericServlet，所以调用GenenricServlet的Init()
    /**
     *    public void init(ServletConfig config) throws ServletException {
     *         this.config = config;
     *         this.init();
     *     }
     */
    //然后调void service(ServletRequest req, ServletResponse res),http中有这个方法
    /**
     *  public void service(ServletRequest req, ServletResponse res)
     *         throws ServletException, IOException {
     *
     *         HttpServletRequest  request;
     *         HttpServletResponse response;
     *
     *         try {
     *             // 将ServletRequest和ServletResponse向下转型为带有Http的HttpServletRequest和HttpServletResponse
     *             request = (HttpServletRequest) req;
     *             response = (HttpServletResponse) res;
     *         } catch (ClassCastException e) {
     *             throw new ServletException(lStrings.getString("http.non_http"));
     *         }
     *         // 调用重载的service方法。
     *         service(request, response);
     *     }
     */
    //这样享受不了http 405错误，假设前端发送的请求是get请求，后端程序员重写的方法是doPost
    //假设前端发送的请求是post请求，后端程序员重写的方法是doGet
    //会发生什么呢？
    //发生405这样的一个错误。
//    //405表示前端的错误，发送的请求方式不对。和服务器不一致。不是服务器需要的请求方式。
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        out.print("<h1>hello servlet" + "</h1>");
//    }

    /**
     *     // 这个service方法的两个参数都是带有Http的。
     *     // 这个service是一个模板方法。
     *     // 在该方法中定义核心算法骨架，具体的实现步骤延迟到子类中去完成。
     *     protected void service(HttpServletRequest req, HttpServletResponse resp)
     *         throws ServletException, IOException {
     *         // 获取请求方式
     *         // 这个请求方式最终可能是：""
     *         // 注意：request.getMethod()方法获取的是请求方式，可能是七种之一：
     *         // GET POST PUT DELETE HEAD OPTIONS TRACE
     *         String method = req.getMethod();
     *
     *         // 如果请求方式是GET请求，则执行doGet方法。
     *         if (method.equals(METHOD_GET)) {
     *             long lastModified = getLastModified(req);
     *             if (lastModified == -1) {
     *                 // servlet doesn't support if-modified-since, no reason
     *                 // to go through further expensive logic
     *                 doGet(req, resp);
     *             } else {
     *                 long ifModifiedSince;
     *                 try {
     *                     ifModifiedSince = req.getDateHeader(HEADER_IFMODSINCE);
     *                 } catch (IllegalArgumentException iae) {
     *                     // Invalid date header - proceed as if none was set
     *                     ifModifiedSince = -1;
     *                 }
     *                 if (ifModifiedSince < (lastModified / 1000 * 1000)) {
     *                     // If the servlet mod time is later, call doGet()
     *                     // Round down to the nearest second for a proper compare
     *                     // A ifModifiedSince of -1 will always be less
     *                     maybeSetLastModified(resp, lastModified);
     *                     doGet(req, resp);
     *                 } else {
     *                     resp.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
     *                 }
     *             }
     *
     *         } else if (method.equals(METHOD_HEAD)) {
     *             long lastModified = getLastModified(req);
     *             maybeSetLastModified(resp, lastModified);
     *             doHead(req, resp);
     *
     *         } else if (method.equals(METHOD_POST)) {
     *             // 如果请求方式是POST请求，则执行doPost方法。
     *             doPost(req, resp);
     *
     *         } else if (method.equals(METHOD_PUT)) {
     *             doPut(req, resp);
     *
     *         } else if (method.equals(METHOD_DELETE)) {
     *             doDelete(req, resp);
     *
     *         } else if (method.equals(METHOD_OPTIONS)) {
     *             doOptions(req,resp);
     *
     *         } else if (method.equals(METHOD_TRACE)) {
     *             doTrace(req,resp);
     *
     *         } else {
     *             //
     *             // Note that this means NO servlet supports whatever
     *             // method was requested, anywhere on this server.
     *             //
     *
     *             String errMsg = lStrings.getString("http.method_not_implemented");
     *             Object[] errArgs = new Object[1];
     *             errArgs[0] = method;
     *             errMsg = MessageFormat.format(errMsg, errArgs);
     *
     *             resp.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED, errMsg);
     *         }
     *     }
     */

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        out.print("doGet");
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("doPost");
    }
}

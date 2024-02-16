package com.cn.edu.szu.zyt;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RequsetTestServlet extends HttpServlet {
 //   @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("text/html");
//        PrintWriter out = resp.getWriter();
//        //org.apache.catalina.connector.RequestFacade@1c7159ee
//        //不同的服务器这个包名就不一样,这是Tomcat的
//        out.print(req);
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("req.getParameterMap()");
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keys = parameterMap.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()){
            String key = it.next();
            System.out.print(key+"=");
            String[] values = parameterMap.get(key);
            for (String value: values){
                System.out.print(value+",");
            }
            System.out.println();
        }
        System.out.println("req.getHeaderNames()");
        Enumeration<String> Names = req.getParameterNames();
        while (Names.hasMoreElements()){
            String name = Names.nextElement();
            System.out.println(name);
        }
        System.out.println(" req.getParameterValues(String s)");
        String[] usernames = req.getParameterValues("username");
        for (String username: usernames){
            System.out.println(username);
        }
        String[] userpwds = req.getParameterValues("userpwd");
        for (String userpwd: userpwds){
            System.out.println(userpwd);
        }
        String[] aihaos = req.getParameterValues("aihao");
        for (String aihao: aihaos){
            System.out.println(aihao);
        }
        System.out.println("req.getParameter()");
        String username = req.getParameter("username");
        String userpwd = req.getParameter("userpwd");
        String aihao = req.getParameter("aihao");
        System.out.println(username);
        System.out.println(userpwd);
        System.out.println(aihao);
    }
}

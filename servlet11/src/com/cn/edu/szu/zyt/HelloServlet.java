package com.cn.edu.szu.zyt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import static org.eclipse.jdt.internal.compiler.parser.Parser.name;
//urlPatterns和value一模一样！！！

@WebServlet(
       // urlPatterns = {"/hello1","/hello2","/hello3"},
        value =  {"/hello1","/hello2","/hello3"},
        name = "hello",
        loadOnStartup = 1,
        initParams = {@WebInitParam(name = "user",value = "root"),
                @WebInitParam(name = "password",value = "zyt1566585M")}
)
public class HelloServlet extends HttpServlet {
    public HelloServlet(){
        System.out.println("hello world!!!");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("hello world"+" <br>");

        String name1 = this.getServletName();
        out.print("servlet name="+name1+"<br>");

        String servletPath = request.getServletPath();
        out.print("servlet path="+servletPath+"<br>");

        Enumeration<String> initParameterNames = this.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            String value = this.getInitParameter(name);
            out.print(name+"="+value+"<br>");
        }
    }
}

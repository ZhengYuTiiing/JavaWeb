package xom.xn.edu.szu.zyt.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/cookie/generate")
public class GenerateCookie extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    Cookie cookie=new Cookie("productid","12345678");
    Cookie cookie2=new Cookie("name","zyt");
   //以秒为单位，存在硬盘文件里，一小时后失效
//    cookie.setMaxAge(60*60);
    //删除cookie
    //cookie.setMaxAge(0);
    //有效期小于0表示cookie不会被存储到硬盘文件，保存在运行内存。
     cookie.setMaxAge(-60*60);//负数和不调用setMaxAge一样
   // cookie.setPath("/servlet13");
    cookie2.setPath(request.getContextPath());
    cookie.setPath(request.getContextPath());

    response.addCookie(cookie);
    response.addCookie(cookie2);
}
}

package com.bite.cookie.hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* cookie的基本使用
*/
@WebServlet(name = "HelloCookie")
public class HelloCookie extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.设置编码
        response.setContentType("text/html;charset=utf-8");

        // 2.cookie由服务器创建，并携带给浏览器
        Cookie a = new Cookie("akey","avalue");
        Cookie b = new Cookie("bkey","bvalue");
        Cookie c = new Cookie("ckey","cvalue");

        // 3. 由服务器写回到浏览器
        response.addCookie(a); // 响应头setCookie:akey=avalue;
        response.addCookie(b);
        response.addCookie(c);

        response.getWriter().write("cookie已经写回"); // 请求头：cookie:xxx akey=avalue

        // 4. 获取浏览器中存储的cookie数据
        Cookie[] cookies = request.getCookies();
        // 先判断再使用
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                //System.out.println(cookie);
                System.out.println(cookie.getName()+"="+cookie.getValue());
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}

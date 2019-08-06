package com.sust;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CheckUserServlet")
public class CheckUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        String value1 = "",value2 = "";

        Cookie cookie = null;

        Cookie[] cookies = request.getCookies();

        if(cookie!=null){

        for(int i = 0;i<cookies.length;i++){

        cookie = cookies[i];

        if(cookie.getName().equals("username"))

        value1 = cookie.getValue();

        if(cookie.getName().equals("password"))

        value2 = cookie.getValue();

        }

        if(value1.equals("admin")&&value2.equals("admin")){

        String message = "欢迎您！"+value1+"再次登录该页面！";

        request.getSession().setAttribute("message", message);

        response.sendRedirect("welcome.jsp");

        }else{

        response.sendRedirect("login1.jsp");

        }

        }else{

        response.sendRedirect("login1.jsp");

        }

        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)

        throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("username").trim();

        String password = request.getParameter("password").trim();
        String message;

        if(!username.equals("admin")||!password.equals("admin")){

        message = "用户名或口令不正确，请重试！";

        request.getSession().setAttribute("message", message);

        response.sendRedirect("login1.jsp");

        }

        if(request.getParameter("check")!=null&&

        (request.getParameter("check").equals("check"))){

        Cookie nameCookie = new Cookie("username",username);

        Cookie pswdCookie = new Cookie("password",password);

        nameCookie.setMaxAge(60*60);

        pswdCookie.setMaxAge(60*60);

        response.addCookie(nameCookie);

        response.addCookie(pswdCookie);

        }

        message = "你已经成功登录！";

        request.getSession().setAttribute("message", message);

        response.sendRedirect("welcome.jsp");

        }

        }


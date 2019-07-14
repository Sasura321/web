package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* Refersh:响应头  定时刷新：每隔n秒跳转资源*/
@WebServlet(name = "requestDemo3")
public class requestDemo3 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setHeader("Refreach","");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("注册成功！3秒后跳转页面");
        response.setHeader("refersh","/adv.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}

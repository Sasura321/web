package com.github.response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求重定向
 * location请求头+302状态码
 */
public class ResponseDemo1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 重定向的原理：
        // 设置状态302
        // 1.
//        response.setStatus(302); // 进一步请求服务器
//        // 设置location响应头
//        response.setHeader("location","/adv.html");

        // 2.
        // 简便的方法
        response.sendRedirect("/adv.html");

        // 3.
        // 地址栏不会发生变法，服务器行为
        //request.getRequestDispatcher("/adv.html").forward(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

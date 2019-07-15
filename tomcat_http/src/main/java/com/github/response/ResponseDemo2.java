package com.github.response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * refersh：响应头  定时刷新，每隔n秒跳转资源
 */
public class ResponseDemo2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        // 1.
        // 设置响应头：每经过多少秒实现页面刷新
        //response.setHeader("refersh","2");

        // 2.
        response.getWriter().write("注册成功！3秒后跳转首页");
        response.setHeader("refresh","3;/adv.html");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

package com.github.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取浏览器的类型
 */

public class RequestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 全局解决乱码问题的方式
        response.setContentType("text/html;charset=utf-8");

        // 获取user-agent请求头
        // 获取那类型的浏览器
        String userAgent = request.getHeader("user-agent");
        // 返回值是一堆字符串：拼接
        System.out.println("userAgent:"+userAgent);
        // Chrome:谷歌浏览器类型
        // Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36
        // Firefox:火狐浏览器类型
        // Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0

        // 判断用户使用的是那种浏览器
        if (userAgent.contains("Trident")) {
            response.getWriter().write("当前使用：IE浏览器");
        } else if (userAgent.contains("Chrome")) {
            response.getWriter().write("当前使用：谷歌浏览器");
        } else if (userAgent.contains("Firefox")) {
            response.getWriter().write("当前使用：火狐浏览器");
        } else {
            response.getWriter().write("其他浏览器");
        }
    }
}

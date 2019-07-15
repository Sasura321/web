package com.github.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestDemo5 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        response.setContentType("text/html;charset=utf-8");
        // 获取referer请求头
        String referer = request.getHeader("referer");
        System.out.println("referer:" + referer);
        // 直接访问下载：referer:null

        /*
         * 非法链接：
         * 1）直接访问下载资源地址：referer==null
         * 2）referer请求头中不包含广告页面 (!referer.contains("adv.html"))
         */
        if (referer==null || !referer.contains("adv.html")) {
            response.getWriter().write("您当前属于非法链接，请跳转<a href='/adv.html'>【首页】</a>");
        } else {
            response.getWriter().write("正在下载资源");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

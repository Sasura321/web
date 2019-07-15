package com.github.response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * content-type：响应头：设置当前响应的类型：html/xml/图片资源
 */
public class ResponseDemo3 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码格式
        //response.setHeader("content-type","text/html;charset=utf-8");
        // 简写方式
        //response.setContentType("text/html;charset=utf-8");

        // 当前向浏览器输出的格式支持html格式
        //response.setContentType("text/html,charset=utf-8");
        //response.getWriter().write("<html><body>this is a html页面...</body></html>");

        // 当作自定义标签进行输出
        response.setContentType("text/xml");
        response.getWriter().write("<html><body>this is a xml...</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

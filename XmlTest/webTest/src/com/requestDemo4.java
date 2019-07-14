package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestDemo4")
public class requestDemo4 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        String referer = request.getHeader("referer");
//        System.out.println("referer:"+referer);
//        /*
//        * 非法链接：
//        * 1）直接访问下载资源地址
//        * 2）referer请求头中不包含广告页面
//        */
//        if(referer == null || referer.contains("adv.html")) {
//            response.getWriter().write("你当前属于非法链接，请跳转");
//        }


        /*
        * content-type:响应头
        */
        //设置编码格式
//        response.setContentType("text/html;charset=utf-8");
//
//        //简写方式
        response.setContentType("text/html;charset=utf-8");

        //当前浏览器输出的格式支持html格式
        response.getWriter().write("<html><body>这是一个html页面</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}

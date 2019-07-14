package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestDemo1")
public class requestDemo1 extends HttpServlet {
    //1.tomcat:获取请求参数——>将响应数据封装到了HttpServletResponse对象中
    //2.服务器响应的时候，携带

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置相应参数
        //设置响应头
        response.setHeader("servlet","weblogic");


        //设置相应的状态码
        /*
        * 200 响应成功
        * 500 服务器有问题
        * 404 一般情况：路径有问题
        * 404+406 错误页面
        * 406 业务请求出现问题
        * 302 进一步请求  location响应头
        */
        //response.setStatus(500);

        //使用字符流的方式向浏览器输出内容
        response.getWriter().write("hello,Http" +
                "ServletResponse对象");

        //使用字节流的方式向浏览器输出内容
        response.getOutputStream().write("Hello,response".getBytes());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}

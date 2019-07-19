package com.github.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取请求行参数
 */

public class RequestDemo1 extends HttpServlet {

    /**
     * servlet的服务方法
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("调用了service方法。。。");
    }

    /**
     * 1)  tomcat服务器获取到浏览器的请求数据
     * 2） tomcat服务器将请求数据封装到了HttpServletRequest对象中
     * 3） tomcat服务器调用service方法，业务具体覆盖doGet() / doPost() 方法
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("调用了doGet()方法。。。");
        // 4） 使用请求对象获取数据

        // 获取请求行的信息
        // 1.1 请求方式
        String mothod = request.getMethod();
        System.out.println(mothod);

        // 1.2 请求url
        String uri = request.getRequestURI();
        System.out.println("url = "+uri);
        System.out.println("url = " + request.getRequestURL().toString());

        // 1.3 请求http协议的版本
        System.out.println("protocal = "+request.getProtocol());
        System.out.println("---------------------");

        // 2. 获取指定的请求头信息
        String host = request.getHeader("host");
        System.out.println("host:"+host);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

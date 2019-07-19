package com.bite.servlet.d_config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
* ServletConfig对象：Servlet配置对象
* 一个servlet中可以由多个ServletConfig对象
*
* doGet方法里如何获取
*/
@WebServlet(name = "ConfigDemo")
public class ConfigDemo extends HttpServlet {

//    // 声明一个ServletConfig对象
//    private ServletConfig config;
//
//    String path = null;
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        this.config = config;
//        path = config.getInitParameter("path");
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * 业务中内容----> 频繁更改业务中的方法 ---> 放入到servlet的配置信息中作为初始化梣属
        */

        /*
         * HttpServlet的父类GenericSerlvet源码：
         * private transient ServletConfig config;
         * public ServletConfig getServletConfig() {
         *       return config;
         * }
         */

        // 获取servletConfig对象
        ServletConfig config = this.getServletConfig();
        String path = config.getInitParameter("path");

        // 有一个需求：读取c盘下的test.txt文件的内容，将内容输出
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = null;
        while ((line=br.readLine()) != null) {
            System.out.println(line);
        }

        // 释放资源
        br.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

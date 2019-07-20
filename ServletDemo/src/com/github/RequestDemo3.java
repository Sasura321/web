package com.github;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * request获取参数
 * get方式和post方式提交数据，后台获取参数不一样，想办法将get方式和post方式提交获取参数通用
 * request.getParameter(String name) ————> String value
 * request.getParamerterName() ————> Enurmation ————> Iterator:迭代器
 */
public class RequestDemo3 extends HttpServlet {
    // 默认执行get提交方式
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get方式和post方式获取参数数据是完全不同的
        // get方式获取参数数据：
        // public String getQureyString()
        // http://localhost:8080/testMethod.html?username=xxx&password
        java.lang.String queryString = request.getQueryString();
        System.out.println(queryString);   // username=zhangsan&password=123456
    }

    // 默认执行post提交
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // post方式获取参数数据：专有方式获取参数数据
        InputStream in = request.getInputStream();

        // 定义一个字节数组
        byte[] bys = new byte[1024];
        int len = 0;
        while ((len=in.read(bys)) != -1) {
            System.out.println(new java.lang.String(bys,0,len));
        }
        in.close();
    }

}

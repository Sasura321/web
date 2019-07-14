package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/*
* Content-Disponsition:
*/
@WebServlet(name = "requestDemo5")
public class requestDemo5 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //创建file对象
//        File file = new File("C:/mm.jpg");
//
//        //下载文件
//        //构建一个字节输出流对象
//        response.getHeader("")
//
//        //获取字节输出流对象
//        OutputStream out = response.getOutputStream();
//        //边读边写
//        byte[] buff =
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}

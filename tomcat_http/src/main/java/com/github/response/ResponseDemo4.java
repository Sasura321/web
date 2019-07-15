package com.github.response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Content-Disposition: attachment; filename=aaa.zip
 * ---- 以下载方式打开资源
 */
public class ResponseDemo4 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.
        // 下载文件
        // 创建一个字节输入流对象
//        InputStream in = new FileInputStream("C:\\Users\\28187\\Pictures\\Saved Pictures\\壁纸\\574.jpg");
//        // 获取一个字节输出流对象
//        OutputStream out = response.getOutputStream();
//        // 边读边写
//        byte[] buff = new byte[1024];
//        int len = 0;
//        while ((len=in.read(buff)) != -1) {
//            out.write(buff,0,len);
//        }
//        // 释放资源
//        in.close();
//        out.close();

        // 2.
        // 创建File对象
        File file = new File("C:\\Users\\28187\\Pictures\\Saved Pictures\\壁纸\\574.jpg");

        // Content-Disposition:响应头
        response.setHeader("Content-Disposition","attachment;filename="+file.getName());
        // 下载文件
        // 创建一个字节输入流对象
        InputStream in = new FileInputStream("C:\\Users\\28187\\Pictures\\Saved Pictures\\壁纸\\574.jpg");
        // 获取一个字节输出流对象
        OutputStream out = response.getOutputStream();
        // 边读边写
        byte[] buff = new byte[1024];
        int len = 0;
        while ((len=in.read(buff)) != -1) {
            out.write(buff,0,len);
        }
        // 释放资源
        in.close();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

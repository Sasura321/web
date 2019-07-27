package com.bite.servlet.b_path;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 获取文件真实路径(用类加载器的getpath())
*
* servletContext：主要的作用：域对象
* 作为请求转发使用
*/
@WebServlet(name = "PathDemo")
public class PathDemo extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取全局管理者对象
        ServletContext servletContext = this.getServletContext();
        // public String getRealPath(String path):获取真实路径
        // 如果不使用 servletContext
        String path = PathDemo.class.getClassLoader().getResource("a.txt").getPath();
        // /C:/Data/Code/Web/Bit/servlet_cookie/target/servlet_cookie/WEB-INF/classes/a.txt
        System.out.println(path);

        // 请求转发技术
        // public RequestDispatcher getRequestDispatcher(String path)
        RequestDispatcher rd = servletContext.getRequestDispatcher("/hello.html");
        // forward
        rd.forward(request,response);

        // 特点：整个过程：request请求对象只有一个
        // 简写方式
        request.getRequestDispatcher("/hello.html").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

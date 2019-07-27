package com.bite.servlet.a_scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
* servletContext作用：
* 作为域对象去使用，保存数据，获取数据（共享数据）
*/
@WebServlet(name = "ScopeDemo1")
public class ScopeDemo1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        response.setContentType("text/html;charset=utf-8");

        // 直接可以获取servletContext对象
        // 获取全局管理者对象
        ServletContext servletContext = this.getServletContext();
        // public void setAttribute(String name, Object object)
        // 给与对象中添加数据，同时设置属性名称
/*        // 1
        servletContext.setAttribute("name","eric");
*/

        // 2.
        // 创建一个list集合对象
        List list = new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("javaee");

        // 将list集合存储到域对象中
        servletContext.setAttribute("list",list);


        // 提示
        response.getWriter().write("保存数据成功了...");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

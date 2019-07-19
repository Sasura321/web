package com.bite.servlet.e_context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 一个下项目（web application）有且仅有一个
*       ServletContext的作用
* 作用2：获取全局参数
*/
@WebServlet(name = "ContextDemo2")
public class ContextDemo2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        // 获取上下文参数的初始化参数
        String value1 = context.getInitParameter("AAA");
        System.out.println(value1);
        // getInitParameterNames() ---> 迭代器
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

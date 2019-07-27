package com.bite.servlet.a_scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/*
* 从servletContext域中获取数据
*/
@WebServlet(name = "ScopeDemo2")
public class ScopeDemo2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        // 获取全局管理者对象
        // public Object getAttribe();
        ServletContext context = getServletContext();
        // 从域中获取数据，通过域中存储的属性名称
        /*// 1.
        String name = (String)context.getAttribute("name");
        System.out.println("name:"+name);*/

        // 2.
        List list = (List)context.getAttribute("list");
        System.out.println("list:"+list);

        response.getWriter().write("ScopeDemo2获取到了域中的数据");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

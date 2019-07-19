package com.bite.servlet.e_context;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* ServletContext的作用1：获取上下文路径
*/
@WebServlet(name = "ContextDemo1")
public class ContextDemo1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * GenericServlet的 getServletContext 的源码:
        public ServletContext getServletContext() {
            ServletConfig sc = this.getServletConfig();
            if (sc == null) {
                throw new IllegalStateException(lStrings.getString("err.servlet_config_not_initialized"));
            } else {
                return sc.getServletContext();
            }
        }
        */

        // 方法1：获取ServletConfig对象
//        ServletConfig config = this.getServletConfig();
//        ServletContext servletContext = config.getServletContext();

        // 方法2：直接获取(this可以省略)
        ServletContext servletContext = this.getServletContext();

        // getContextPath():获取上下文路径
        String contextPath = servletContext.getContextPath();
        // 输出：contextPath:/ServletLife
        System.out.println("contextPath:"+contextPath);

        // 重定向：到底服务器行为，还是浏览器行为：location+302
        // web application 的项目名称 / 跳转的页面
        response.sendRedirect(request.getContextPath()+"/hello.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

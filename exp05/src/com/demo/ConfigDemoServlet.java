package com.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConfigDemoServlet")
public class ConfigDemoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        //设置网页响应类型3
        response.setContentType("text/html");
        //实现具体操作
        PrintWriter out = response.getWriter();

        /*
         * 第一题
         */
        ServletConfig config = getServletConfig();
        String name = config.getServletName();
        String email = this.getInitParameter("email");
        String telephone = this.getInitParameter("telephone");

        out.println("<html><body");
        out.println("<br>");
        out.println("select名称："+name+"<br>");
        out.println("Email地址："+email+"<br>");
        out.println("电话："+telephone+"<br>");

        /*
         * 第二题
         */
        //使用ServletContext读取全局初始化参数
        ServletContext context = this.getServletContext();
        String admin_email = context.getInitParameter("admin-email");
        String admin_tel = context.getInitParameter("admin-tel");

        System.out.println("Email地址："+admin_email+"<br>");
        System.out.println("电话："+admin_tel+"<br>");

        //写入日志文件
        context.log(admin_email);
        context.log(admin_tel);

        out.println("</body></html>");
    }
}

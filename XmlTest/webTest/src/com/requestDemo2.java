package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*
*请求重定向
* location请求头：302状态码
*/
@WebServlet(name = "requestDemo2")
public class requestDemo2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置重定向
        response.setStatus(302);

        // 设置location
        response.setHeader("location","adv.html");

        // **简单方式
        //重定向：地址栏——>
        response.sendRedirect("/adv.html");

        //
        //request.getRequestDispatcher("/adv.html").forward();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}

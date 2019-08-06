package com.sust;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "GuessNumberServlet")

public class GuessNumberServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if(request.getSession().getAttribute("name")!=null){
            out.print("你好："+request.getSession().getAttribute("name")+"用户登录成功");
        }else{
            out.print("亲还有登录哦");
        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("SessionId=="+request.getSession().getId());
        String name = request.getParameter("name");
        //将用户的名称保存到session属性中
        request.getSession().setAttribute("name",request.getRemoteAddr()+name);

        //登录成功后，保存名称为JSESSIONID的id的cookie，值为session的id
        Cookie c = new Cookie("JSESSIONID",request.getSession().getId());
        c.setMaxAge(60*100);
        c.setPath("/");
        response.addCookie(c);

        //调用doGet请求
        doGet(request,response);

    }

}
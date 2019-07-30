package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ShowTimeServlet")
public class ShowTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Date nowDate = new Date(System.currentTimeMillis());
        SimpleDateFormat time = new SimpleDateFormat("yyyy年MM月dd日-HH时mm分ss秒");
        out.print("当前系统时间为："+ time.format(nowDate));
    }

    public void destroy() {
        super.destroy();
    }
}

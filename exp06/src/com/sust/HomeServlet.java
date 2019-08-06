package com.sust;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "HomeServlet")
public class HomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //HttpSession session=request.getSession();
        PrintWriter out = response.getWriter();
        String url1 = response.encodeURL("/com/sust/ShowSessionInfo");
        String url2 = response.encodeURL("/com/sust/GuessNumberServlet");

        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print(" A test page showing two URL:<br> ");
        out.println("<a href=\"" + url1 + "\">View GuessNumber Servlet</a><br>");
        out.println("<a href=\""+ url2 + "\">View CheckUser Servlet</a><br>");
        out.println("  </BODY>");
        out.println("</HTML>");
    }
}

package com.bank;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
    ServletContext context;
    HashMap<String,String> users = new HashMap<String,String>();
    String location="";

    public void init(){
        context = getServletContext();
        users.put("ann", "aaa");
        users.put("john", "jjj");
        users.put("mark", "mmm");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,IOException{
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username!= null && password != null && password.equals(users.get(username))){
            request.setAttribute("username", username);
            location="../AccountServlet";
        } else{
            location="../error.html";
        }
        RequestDispatcher view = context.getRequestDispatcher(location);
        view.forward(request, response);
        return;
    }
}

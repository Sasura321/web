package com;

import java.io.IOException;

public class TestServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //post方式手动解码

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //通过获取参数：获取一个参数（对应多个值）
        String[] hobits = request.getParameterValues("hobits");
        if(hobits != null) {
            for(String hobit:hobits) {
                System.out.println("hobit = " + hobit);
            }
        }
    }
}

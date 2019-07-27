package com.bite.cookie.remember;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/*
* 记录访问系统时间
*/
@WebServlet(name = "RememberServlet")
public class RememberServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 设置编码格式，提示内容
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        // 2. 获取指定的cookie（名称为：lastTime）
        // 从知指定的方法中获取指定的cookie
        Cookie c = getCookieByName("lastTime",request.getCookies());

        // 3. 判断为空，直接提示当前是第一次访问
        if (c==null) {
            // 3.1 如果为空，直接提示当前是第一次访问
            writer.write("当前您是第一次访问...");
        } else {
            // 3.2 如果不为空：获取当前指定的cookie的内容——>Dete的日期字符串格式（提示上一次访问时间是：...）
            String value = c.getValue();
            // 将value--->long类型--->Date对象
            long time = Long.parseLong(value);
            // 创建一个日期对象
            Date date = new Date(time); // 使用SimpleDateFormat
            // cookie 存在，提示您上一次访问时间是
            writer.write("您上一次访问时间是："+date.toLocaleString()); // 输出当前的本地时间
        }

        // 4. 记录当前的系统的时间
        // 创建Cookie
        c = new Cookie("latTime",new Date().getTime()+"");
        // 设置一个会话有效期
        c.setMaxAge(3600);
        //c.setPath(request.getContextPath()); // 获取上下文路径：/x项目名

        // 5. 写回浏览器
        response.addCookie(c);
    }

    /**
     * 通过指定名称获取指定的cookie
     * @param name 指定的cookie的名称
     * @param cookies 当前浏览器中的所有的cookie数据
     * @return c
     */
    private static Cookie getCookieByName (String name, Cookie[] cookies) {
        if (cookies != null) {
            // 遍历所有的cookie
            for (Cookie c:cookies) {
                // 判断指定的name名称就是需要的cookie
                if (name.equals(c.getName())) {
                    return c;
                }
            }
        }
        return null;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}

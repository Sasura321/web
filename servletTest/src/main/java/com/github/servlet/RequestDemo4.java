package com.github.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * request获取参数
 * get方式和post方式提交数据，后台获取参数不一样，想办法将get方式和post方式提交获取参数通用
 * request.getParameter(String name) ————> String value
 * request.getParamerterName() ————> Enurmation ————> Iterator:迭代器
 */
public class RequestDemo4 extends HttpServlet {
    // 默认执行get提交方式
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get方式和post方式获取参数数据是完全不同的
        // get方式获取参数数据：
        // public String getQureyString()
        // http://localhost:8080/testMethod.html?username=xxx&password

        // get方式和post方式通用获取参数数据的方法
        // 通过表单的name参数值——>获取表单的内容
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // tomcat以下的版本：遇到参数中文的，获取参数需要手动解码
        System.out.println(username+"&"+password);
        System.out.println("----------------------------------");

        // 方式2
        // 获取的所哟参数名称
        Enumeration<String> enums = request.getParameterNames();
        while(enums.hasMoreElements()) {
            String paramName = enums.nextElement();
            // 通过参数名称获取参数值
            String paramValue = request.getParameter(String.valueOf(paramName));
            System.out.println(paramName+" = "+paramValue);
        }
        System.out.println("----------------------------------");

        // 方式3:获取所有的参数对象
        // key(参数名称)，value：如果只有一个参数：value[0]
        Map<String,String[]> parameterMap = request.getParameterMap();

        // map集合的遍历
        // 1.entrySet()：获取当前map集合中的所有的键值对的对象
        // 2.keySet()：获取所有的键——>遍历

        // 1) entrySet()
        Set<Map.Entry<String,String[]>> entrySet = parameterMap.entrySet();
        for (Map.Entry<String,String[]> entry:entrySet) {
            // 通过键值对对象获取所有的键和值
            String name = entry.getKey();
            String[] value = entry.getValue();
            System.out.println(name+" = "+value[0]);
        }

        System.out.println("----------------------------------");
        // 方式4：通过获取参数：获取一个参数（对应多个值）
        String[] hobits = request.getParameterValues("hobit");
        // 先判断在使用
        if (hobits != null) {
            for (String hobit:hobits) {
                System.out.println("hobit = "+hobit);
            }
        }
    }

    // 默认执行post提交
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*// post方式手动解码
        request.setCharacterEncoding("utf-8");

        Enumeration<String> enums = request.getParameterNames();
        while(enums.hasMoreElements()) {
            String paramName = enums.nextElement();
            // 通过参数名称获取参数值
            java.lang.String paramValue = request.getParameter(java.lang.String.valueOf(paramName));
            // 如果参数对应有多个值，默认获取第一个值
            System.out.println(paramName+" = "+paramValue);
        }
        System.out.println("----------------------------------");*/

        // 一般在doPost方法将doGet方法复用
        doGet(request,response);
    }

}

<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: 28187
  Date: 2019/6/3
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp的认识</title>
</head>
<body>
<%--
    jsp的注释：
    jsp的脚本代码：在html页面中额能写Java代码的
--%>
<%
    int k = 10;
    Date date = new Date();
%>

<%--
    jsp的输出表达式
--%>
<%=date%>

<%!
    // 成员变量
    int i = 4;
%>
</body>
</html>

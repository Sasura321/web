<%--
  Created by IntelliJ IDEA.
  User: 28187
  Date: 2019/5/6
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ServletContext context = getServletConfig().getServletContext();
    Integer count =(Integer)context.getAttribute("onlineCount");
    response.setContentType("text/html;charset=UTF-8");
    out.println("<html><head><title>Session Event Test</title></head>");
    out.println("<h3 align=center><font color=\"#ff0000\">"+
    "当前在线人数："+count+"</h3>");
    out.println("</body></html>");
    out.close();
%>
</body>
</html>

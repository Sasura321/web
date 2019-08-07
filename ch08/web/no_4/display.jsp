<%--
  Created by IntelliJ IDEA.
  User: 28187
  Date: 2019/4/27
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<jsp:useBean id="user" class="mytest.UserBean">
    <jsp:setProperty name="user" property="*"/>
</jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
UserName:<%=user.getUserName() %> <br/>
Password:<%=user.getPassword() %>  <br/>
Email:<%=user.getEmail() %> <br/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<jsp:useBean id="customer" class="edu.no_3.CustomerBean"/>
<jsp:setProperty name="customer" property="*"/>
<html>
<head>
    <title>customer</title>
</head>
<body>
你好！
<%=customer.getCustName() %>
</body>
</html>
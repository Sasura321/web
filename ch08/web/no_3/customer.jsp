<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>顾客</title>
</head>
<body>
<form action="saveBean.jsp" method="post">
    客户名：<input type="text" name="custName"/><br/>
    电子邮箱：<input type="text" name="emial"/><br/>
    联系电话：<input type="text" name="phone"/><br/>
    是否可用：<input type="text" name="valid"/><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
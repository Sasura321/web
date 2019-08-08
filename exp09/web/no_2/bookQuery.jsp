<%--
  Created by IntelliJ IDEA.
  User: 28187
  Date: 2019/5/4
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head> <title>Book Query</title>
</head>
<body>
请输入一个书号:<br>
<form action="BookQueryServlet" method = "post">
    <input type="text" name="bookid"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>

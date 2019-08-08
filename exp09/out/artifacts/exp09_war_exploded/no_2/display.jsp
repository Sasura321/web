<%--
  Created by IntelliJ IDEA.
  User: 28187
  Date: 2019/5/4
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="book" class="edu.exp.no_1.BookBean" scope="session"/>
<html><body>
书号：<jsp:getProperty name="book" property="bookid"/><br><br>
书名：<jsp:getProperty name="book" property="title"/><br><br>
作者：<jsp:getProperty name="book" property="author"/><br><br>
出版社：<jsp:getProperty name="book" property="publisher"/><br><br>
价格：<jsp:getProperty name="book" property="price"/><br><br>
</body></html>

<%--
  Created by IntelliJ IDEA.
  User: 28187
  Date: 2019/4/29
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=gb2312"%>
<jsp:useBean id="book" class="edu.exp.no_1.BookBean" scope="session"/>

<html>
<body>
<table border="1px">
    <tr>
        <td>���</td>
        <td><jsp:getProperty name="book" property="bookid"/></td>
    </tr>
    <tr>
        <td>����</td>
        <td><jsp:getProperty name="book" property="title"/></td>
    </tr>
    <tr>
        <td>����</td>
        <td><jsp:getProperty name="book" property="author"/></td>
    </tr>
    <tr>
        <td>������</td>
        <td><jsp:getProperty name="book" property="publisher"/></td>
    </tr>
    <tr>
        <td>�۸�</td>
        <td><jsp:getProperty name="book" property="price"/></td>
    </tr>
</table>
</body>
</html>
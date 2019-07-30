<%--
  Created by IntelliJ IDEA.
  User: 28187
  Date: 2019/4/1
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>表格</title>
    <script>
        var col = 2;
        var rol = 10;

    </script>
</head>
<body>
    <%
        int col = 10;
    %>
    <!--循环输出表格-->
    <table border="1px" align="center">
        <tr>
            <%
                for(int i=0;i<col;i++){
            %>
            <td><%=i%></td>
            <%
                }
            %>
        </tr>

        <tr>
            <%
                for(int i=0;i<col;i++){
            %>
            <td><%=i*i%></td>
            <%
                }
            %>
        </tr>
    </table>

</body>
</html>

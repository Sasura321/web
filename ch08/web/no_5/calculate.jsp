<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<jsp:useBean id="calculator" class="com.edu.no_5.SimpleCalculator">
    <jsp:setProperty name="calculator" property="*"/>
</jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>计算</title>

</head>
<body>
<%
    try
    {
        float first=calculator.getFirst();
        float second=calculator.getSecond();
        String  op=calculator.getOperator();
        out.print("计算结果为："+calculator.getFirst()+calculator.getOperator()+calculator.getSecond()+"="
                +calculator.calculate(first, second, op));
    }catch(Exception e)
    {
        e.printStackTrace();

    }

%>
<br/>
<form action="calculate.jsp" method="post">
    第一个操作数：<input type="text" name="first">
    第二个操作数：<input type="text" name="second"><br/>
    <select name="operator">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <input type="submit" value="计算" >
</form>
</body>
</html>
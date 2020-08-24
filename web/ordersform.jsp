<%@ page import="javax.sound.sampled.Line" %>
<%@ page import="com.sy.model.Orders" %>
<%@ page import="com.sy.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/3
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form action="/ordersupdate.do" method="post">
        <input type="hidden" name="uid" value="<%=((User)request.getAttribute("loginUser")).getId()%>">
        <input type="hidden" name="id" value="<%=((Orders)request.getAttribute("orders")).getId()%>">
        订单名：<input type="text" name="oname" value="<%=((Orders)request.getAttribute("orders")).getOname()%>">
        <br>
        价格：<input type="text" name="price" value="<%=((Orders)request.getAttribute("orders")).getPrice()%>">
        <br>
        <input type="submit" value="更新">
    </form>

</body>
</html>

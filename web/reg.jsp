<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/3
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span><%=request.getAttribute("mess")%></span>
<form action="/reg.do" method="post" onsubmit="return true">
    用户名：<input type="text" name="username">
    <br>
    密码:<input type="password" name="password">
    <br>
    确认密码：<input type="password" name="rpassword">
    <br>
    <input type="submit" value="注册">
</form>



</body>
</html>

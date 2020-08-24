<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/3
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span><%=request.getAttribute("mess")==null?"":request.getAttribute("mess")%></span>
<form action="/login.do" method="post" onsubmit="return checkUser()" >
    用户名：<input type="text" name="username" >
    <br>
    密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password">
    <br>
    <input type="submit" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;<a href="/reg.jsp">立即注册</a>
</form>

<script src="jq/jquery-3.4.0.min.js"></script>
<script>

    function checkUser() {
        var un = $("input[type='text']").val();
        var pw = $("input[type='password']").val();
        if (un==null||un==''){
            $("span").html("用户名不能为空");
            return false;
        }else if (pw == null || pw ==''){
            $("span").html("密码不能为空");
            return false;
        }else {
            return true;
        }
    }
</script>

</body>
</html>

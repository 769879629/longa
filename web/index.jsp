<%@ page import="com.sy.model.User" %>
<%@ page import="com.sy.model.Orders" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/3
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>欢迎你：<%=((User)request.getAttribute("loginUser")).getUsername()%></h1>

  <table border="1" width="50%" align="center">
  <%
    List<Orders> list  = (List)request.getAttribute("list");
    for(Orders orders:list){
  %>
      <tr>
        <td><%=orders.getId()%></td>
        <td><%=orders.getOname()%></td>
        <td><%=orders.getPrice()%></td>
        <td><a href="/info.do?id=<%=orders.getId()%>&uid=<%=orders.getUid()%>">更新</a>|
            <a href="/ordersdel.do?id=<%=orders.getId()%>&uid=<%=orders.getUid()%>">删除</a>
        </td>
      </tr>
  <%
    }
  %>
  </table>
  </body>
</html>

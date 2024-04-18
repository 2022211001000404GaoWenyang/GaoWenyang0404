<%--
  Created by IntelliJ IDEA.
  User: 和她说散于人海
  Date: 2024/4/6
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<h1>Login</h1>
<%
if(!(request.getAttribute("message")==null)){
    out.print("<h3>"+request.getAttribute("message")+"</h3>");
}
%>
<form action="login" method="post">
    UserName:<input type="text" name="username"><br>
    Password:<input type="password" name="password"><br>
    <input type="submit" value="Submit"/>
</form>


<%@include file="footer.jsp"%>

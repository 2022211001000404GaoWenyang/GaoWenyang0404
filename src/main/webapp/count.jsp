<%--
  Created by IntelliJ IDEA.
  User: 和她说散于人海
  Date: 2024/4/6
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Counter JSP</title>
</head>
<body>
<%--This is Count JSP Page.<br>
<%!int count=0;%>
the page count is now :<%out.println(++count);%>--%>
This is Count JSP Page.<br>
<%!int getCount(){
    return ++count;
}%>
<%!int count=0;%>
The page count is now(using count()):<%out.println(getCount());%>
</body>
</html>

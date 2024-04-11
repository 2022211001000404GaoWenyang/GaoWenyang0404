<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 和她说散于人海
  Date: 2024/4/11
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@ page import="java.sql.ResultSet" %>
<h1>User List</h1>
<table border="1">
    <tr>
        <th>Id</th><th>UserName</th><th>Password</th><th>Email</th><th>Gender</th><th>Birthdate</th>
    </tr>
    <% //get rs from request attribute
    ResultSet rs= (ResultSet) request.getAttribute("rsname");//name of attribute
            if(rs==null){
    %>
    <tr>
        <td>No Data!!!</td>
    </tr>
    <%}else {
        while (rs.next()) {
            out.println("<tr>");
            out.println("<td>" + rs.getInt("id") + "</td>");
            out.println("<td>" + rs.getString("username") + "</td>");
            out.println("<td>" + rs.getString("password") + "</td>");
            out.println("<td>" + rs.getString("email") + "</td>");
            out.println("<td>" + rs.getString("gender") + "</td>");
            out.println("<td>" + rs.getString("birthdate") + "</td>");
            out.println("</tr>");
        }
    }
    %>
</table>
<%@include file="footer.jsp"%>
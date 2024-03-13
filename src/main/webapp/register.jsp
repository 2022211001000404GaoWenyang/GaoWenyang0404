<%--
  Created by IntelliJ IDEA.
  User: 和她说散于人海
  Date: 2024/3/12
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .register {
            width: 500px;
            height: 400px;
            /*background-color: #808080;*/
            margin: 0 auto;
        }
    </style>
</head>
<body>
  <div class="register">
      <form method="post">
          <h1 align="center">New User Registration</h1><br>
          <input type="text" name="Username" placeholder="Username"><br><br>
          <input type="password" name="password" placeholder="password"><br><br>
          <input type="text" name="email" placeholder="Email"><br><br>
          Gender <input type="radio" name="gender">Male <input type="radio" name="gender">Female<br><br>
          <input type="text" name="birth" placeholder="Date of Birth(yyyy-mm-dd)"><br><br>
          <input type="submit" value="Register">

      </form>
  </div>
</body>
</html>

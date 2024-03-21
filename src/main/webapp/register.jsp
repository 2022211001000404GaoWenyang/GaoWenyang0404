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
  <div class="register"  >
      <form method="post" action="register">
          <h1>New User Registration</h1><br>
          username<input type="text" name="username" placeholder="Username"><br><br>
          password<input type="password" name="password" placeholder="password"><br><br>
          Email<input type="text" name="email" placeholder="Email"><br><br>
          Gender <input type="radio" name="gender" value="Male">Male<input type="radio" name="gender" value="Female">Female<br><br>
          Date of birth:<input type="text" name="birth" placeholder="Date of Birth(yyyy-mm-dd)"><br><br>
          <input type="submit" value="Register"/>

      </form>
  </div>
</body>
</html>

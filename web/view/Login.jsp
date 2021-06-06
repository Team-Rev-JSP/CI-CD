<%--
  Created by IntelliJ IDEA.
  User: gooda
  Date: 2021-05-25
  Time: 오후 1:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/Login.css" />
    <title>Login</title>
</head>
<body>
<div class="container">
    <form id="form" class="form" method="post" action="LoginProcess.bo" onsubmit="return false">
        <h2>LOGIN</h2>
        <div class="form-control">
            <input name="id" type="text" id="id" placeholder="Enter id">
        </div>
        <div class="form-control">
            <input name="password" type="password" id="password" placeholder="Enter Password">
        </div>
        <div class="btn">
            <button id="login" type="login" onclick="(e) => login(e)" >로그인</button>
            <button type="join" onclick="location.href='/SignUp.bo'">회원가입</button>
        </div>
    </form>
</div>

<script src="../js/Login.js" defer></script>
</body>
</html>
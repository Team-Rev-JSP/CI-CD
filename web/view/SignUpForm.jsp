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
    <link rel="stylesheet" href="../css/Join.css" />
    <title>Join</title>
</head>
<body>
<div class="container">
    <form id="form" class="form" method="post" action="SignUpProcess.bo" onsubmit="return false">
        <h2>Join With Us</h2>
        <div class="form-control">
            <label for="id">ID</label>
            <input name="id" type="text" id="id" placeholder="Enter id">
            <small>Error message</small>
        </div>
        <div class="form-control">
            <label for="password">Password</label>
            <input name="password" type="password" id="password" placeholder="Enter Password">
            <small>Error message</small>
        </div>
        <div class="form-control">
            <label for="nickname">Nickname</label>
            <input name="nickname" type="text" id="nickname" placeholder="Enter Nickname">
            <small>Error message</small>
        </div>
        <div class="btn">
            <button id="login" type="login" onclick="location.href='/Login.bo'">이전</button>
            <button id="join" type="join" onclick="(e) => join(e)">등록</button>
        </div>
    </form>
</div>

<script src="../js/Join.js" defer>

    /*
    onclick="submit()
    function submit() {
        $('#form').submit();
    }*/
</script>
</body>
</html>
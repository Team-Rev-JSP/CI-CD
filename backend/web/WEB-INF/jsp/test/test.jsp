<%--
  Created by IntelliJ IDEA.
  User: gooda
  Date: 2021-05-18
  Time: 오후 4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<h1>회원 로그인</h1>
<form class="login_form" id="frm" action="test" method="post">
    <div class="id">
        <input type="text" name="u_id" placeholder="아이디를 무조건 입력하시오">
    </div>
    <div class="pw">
        <input type="password" name="u_pw" placeholder="비밀번호를 입력하시오">
    </div>
    <div class="button">
        <input type="submit" value="로그인">
        <input type="button" value="회원가입">
    </div>
</form>
</body>
</html>

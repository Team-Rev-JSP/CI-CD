<%@ page import="vo.CardVO" %><%--
  Created by IntelliJ IDEA.
  User: gooda
  Date: 2021-05-31
  Time: 오후 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% CardVO card = (CardVO)request.getAttribute("card");
    System.out.println(card.toString());
%>
<html>
<head>
    <title>Detail 화면</title>
</head>
<body>
    <div>아이디<%=card.getId()%></div>
<<<<<<< HEAD
    <input type="button" value="삭제" onclick="location.href='/Modify.bo?idx=<%=request.getParameter("idx")%>'">
=======
    <input type="button" value="삭제" onclick="location.href='/DeleteProcess.bo?idx=<%=request.getParameter("idx")%>'">
>>>>>>> 74384717b5086ae429642742dcf37912dae6908c
</body>
</html>

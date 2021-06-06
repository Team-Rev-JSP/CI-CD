
<%@ page import="vo.CardVO" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: gooda
  Date: 2021-05-24
  Time: 오후 10:20
  To change this template use File | Settings | File Templates.
--%>
<%
    ArrayList<CardVO> list = (ArrayList<CardVO>)request.getAttribute("lists");
    String id = (String)session.getAttribute("id");

%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CARDIS</title>
    <link rel="stylesheet" href="../css/Main.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/bab20e0e73.js" crossorigin="anonymous"></script>

</head>
<body>
<div class="body__container">
    <header class="header">
        <div class="inner">
            ${id}님 반갑습니다.
        </div>
    </header>

    <section class="card_list">
        <div class="inner">
            <div class="content">
                <%for(int i = 0; i < list.size() ; i++){
                %>
                <div class="card">
                    <a href="Detail.bo?idx=<%=list.get(i).getId()%>"><%=list.get(i).getId()%></a>
                </div>
                <%}%>
            </div>
        </div>
    </section>
    <input type="button" value="등록" onclick="location.href='Create.bo'">
</div>
</body>
</html>

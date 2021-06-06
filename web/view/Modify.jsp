<%@ page import="java.util.ArrayList" %>
<%@ page import="vo.CardVO" %><%--
  Created by IntelliJ IDEA.
  User: gooda
  Date: 2021-05-27
  Time: 오전 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    CardVO card = (CardVO)request.getAttribute("card");
    System.out.println(card.toString());
%>

<html>
<head>
    <title>Modify</title>
</head>
<body>
<form action="ModifyProcess.bo?idx=<%=request.getParameter("idx")%>" method="post">
    <input type="text" placeholder=<%=card.getName()%> name="name" required style="height:30px; width: 380px" /><br />
    <input type="text" placeholder=<%=card.getPhone()%> name="phone" required style="height:30px; width: 380px" /><br />
    <input type="text" placeholder=<%=card.getEmail()%> name="email" required style="height:30px; width: 380px" /><br />
    <input type="text" placeholder=<%=card.getPosition()%> name="position" required style="height:30px; width: 380px" /><br />
    <input type="text" placeholder=<%=card.getAddress()%> name="address" required style="height:30px; width: 380px" /><br />
    <input type="text" placeholder=<%=card.getFax()%> name="fax" required style="height:30px; width: 380px" /><br />
    <input type="text" placeholder=<%=card.getUrl()%> name="url" required style="height:30px; width: 380px" /><br />
    <input type="text" placeholder=<%=card.getCompany()%> name="company" required style="height:30px; width: 380px" /><br />
    <input type="text" placeholder=<%=card.getPhoto_path()%> name="photo_path" required style="height:30px; width: 380px" /><br />
    <input type="submit" value="저장" class="login" />
</form>
</body>
</html>

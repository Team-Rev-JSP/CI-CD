<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*" %>
<%
    Connection conn=null;

    String driver="com.mysql.jdbc.Driver";
    String url="jdbc:mysql://simon-database.cgfincfn6t0x.ap-northeast-2.rds.amazonaws.com:3306/test";

    Boolean connect=false;

    try{
        Class.forName(driver);
        conn=DriverManager.getConnection(url,"admin","dlsdl123");

        connect=true;

        conn.close();
    }catch(Exception e){
        connect=false;
        e.printStackTrace();
    }
%>
<html>
<head>
    <title>JDBC 연동 테스트 예제</title>
</head>
<body>
<h3>
    <%if(connect==true){ %>
    연결되었습니다.
    <%}else{ %>
    연결에 실패하였습니다.
    <%} %>
</h3>
</body>
</html>

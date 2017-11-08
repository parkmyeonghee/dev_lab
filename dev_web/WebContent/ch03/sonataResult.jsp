<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="com.ch03.Sonata" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>sonataResult.jsp 페이지</title>
</head>
<body>
<%
Sonata himCar= (Sonata)request.getAttribute("himCar");
himCar.speedUp();
out.print("현재 소나타의 속도"+himCar.speed);
//myCar를 사용하고 싶을때
out.print("<hr>");
Sonata myCar = null;
myCar=(Sonata)request.getAttribute("myCar");
out.print("현재 소나타의 속도"+myCar.speed);//
%>
</body>
</html>
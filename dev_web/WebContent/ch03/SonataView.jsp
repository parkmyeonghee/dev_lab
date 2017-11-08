<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@page import="com.ch03.Sonata" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="himCar" class="com.ch03.Sonata" scope="page">
<!-- 액션태그를 이용해서 객체생성
scope라는 속성을 사용할 수 있다.
page:이 안에서만 사용이 가능 result에서 himcar사용ㄴㄴ -->
</jsp:useBean>
<%
Sonata myCar= new Sonata();//직접인스턴스화
out.print(myCar.speed);
out.print("<br>");
himCar.speedUp();
out.print(himCar.speed);
request.setAttribute("himCar",himCar);
request.setAttribute("myCar",myCar);
//response.sendRedirect("./sonataResult.jsp");
RequestDispatcher view=
request.getRequestDispatcher("./sonataResult.jsp");
view.forward(request,response);
%>
</body>
</html>
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
<!-- �׼��±׸� �̿��ؼ� ��ü����
scope��� �Ӽ��� ����� �� �ִ�.
page:�� �ȿ����� ����� ���� result���� himcar��뤤�� -->
</jsp:useBean>
<%
Sonata myCar= new Sonata();//�����ν��Ͻ�ȭ
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
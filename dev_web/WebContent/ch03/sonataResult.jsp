<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="com.ch03.Sonata" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>sonataResult.jsp ������</title>
</head>
<body>
<%
Sonata himCar= (Sonata)request.getAttribute("himCar");
himCar.speedUp();
out.print("���� �ҳ�Ÿ�� �ӵ�"+himCar.speed);
//myCar�� ����ϰ� ������
out.print("<hr>");
Sonata myCar = null;
myCar=(Sonata)request.getAttribute("myCar");
out.print("���� �ҳ�Ÿ�� �ӵ�"+myCar.speed);//
%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>start.jsp</title>
</head>
<body>
<%
	String name="�̼���";
	out.print("�̸�"+name);
	//response.sendRedirect("move.jsp");
	RequestDispatcher view= request.getRequestDispatcher("move.jsp");
	view.include(request,response); //���� ��ü�� req���ָ� ������
	out.print("����");
%>
</body>
</html>
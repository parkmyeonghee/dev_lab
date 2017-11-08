<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>start.jsp</title>
</head>
<body>
<%
	String name="이순신";
	out.print("이름"+name);
	//response.sendRedirect("move.jsp");
	RequestDispatcher view= request.getRequestDispatcher("move.jsp");
	view.include(request,response); //내장 객체라서 req써주면 오류남
	out.print("여기");
%>
</body>
</html>
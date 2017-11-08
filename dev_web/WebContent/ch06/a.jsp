<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page errorPage="/error/aErrorPage.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>a.jsp페이지</title>
</head>
<body>
name 파라미터값:<%="이순신".toString() %>
<br>
<%
try{
%>
name 파라미터값2:<%=request.getParameter("name").toString()%>
<%
}catch(Exception e){
	out.print("name파라미터가 올바르지 않습니다.");
}
int age = Integer.parseInt(request.getParameter("age"));
%>
name 파라미터값3:<%=age %>
</body>
</html>
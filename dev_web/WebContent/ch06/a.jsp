<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page errorPage="/error/aErrorPage.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>a.jsp������</title>
</head>
<body>
name �Ķ���Ͱ�:<%="�̼���".toString() %>
<br>
<%
try{
%>
name �Ķ���Ͱ�2:<%=request.getParameter("name").toString()%>
<%
}catch(Exception e){
	out.print("name�Ķ���Ͱ� �ùٸ��� �ʽ��ϴ�.");
}
int age = Integer.parseInt(request.getParameter("age"));
%>
name �Ķ���Ͱ�3:<%=age %>
</body>
</html>
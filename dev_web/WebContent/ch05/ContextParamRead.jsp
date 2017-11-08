<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.util.Enumeration" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>contextparamread.jsp</title>
</head>
<body>
<%
	Enumeration<String> en =application.getInitParameterNames();
	while(en.hasMoreElements()){
		String name = en.nextElement();
		out.print(name);
		out.print(",");
		out.print(application.getInitParameter(name));
		out.print("<br>");
	}
%>
</body>
</html>
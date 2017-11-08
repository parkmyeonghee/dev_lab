<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.util.List" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>/WEB-INF/jsp/hello/hello</title>
</head>
<body>
<% 
List<String> nameList =(List<String>)request.getAttribute("nameList");
for(String name:nameList){
	out.print(name+"<br>");
}
%>
<br>
hello.jsp
</body>
</html>
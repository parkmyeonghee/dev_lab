<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
       <%@page import="java.util.List,com.vo.DeptVO" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>/WebContent/hello/hello5</title>
</head>
<body>
hello5.jsp
<br>
<%
List<String> nameList =(List<String>)session.getAttribute("nameList2");
if(nameList!=null){
for(String name:nameList){
	out.print(name+"<br>");
}
}
else{
	out.print("값(nameList)을 참조 ㄴㄴ");
}
%>
</body>
</html>
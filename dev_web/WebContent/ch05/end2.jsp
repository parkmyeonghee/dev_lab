<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
String r_memid =(String)request.getAttribute("mem_id");
String r_mempw =(String)request.getAttribute("mem_pw");
out.print("���̵�:"+r_memid+",���:"+r_mempw);
%>
</body>
</html>
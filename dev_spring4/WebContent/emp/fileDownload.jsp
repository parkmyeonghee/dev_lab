<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
	<%
	String fileName=(String)request.getAttribute("rename");
	out.print(fileName);
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>÷������ �ٿ�ε�</title>
<a href="downLoad.jsp?imgFile=<%=fileName%>">�ٿ�ε�</a>
</head>
<body>

</body>
</html>
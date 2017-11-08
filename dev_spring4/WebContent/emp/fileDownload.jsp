<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
	<%
	String fileName=(String)request.getAttribute("rename");
	out.print(fileName);
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>첨부파일 다운로드</title>
<a href="downLoad.jsp?imgFile=<%=fileName%>">다운로드</a>
</head>
<body>

</body>
</html>
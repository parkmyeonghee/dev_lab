<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>test.jsp</title>
</head>
<body>
<%
String path = request.getContextPath();
out.print("Context path:"+path);
%>
<a href="<%=path%>\pds\notouch.exe">다운받기</a>
짝궁자료실<br>
<a href="http://192.168.0.49:9000/dev_web/pds/notouch.exe">notouch</a>
<br>
톰캣서버가 바라보는 물리적인 경로 확인하기<br>
<%=application.getRealPath("/pds/notouch.exe") %>
</body>
</html>
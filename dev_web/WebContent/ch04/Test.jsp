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
<a href="<%=path%>\pds\notouch.exe">�ٿ�ޱ�</a>
¦���ڷ��<br>
<a href="http://192.168.0.49:9000/dev_web/pds/notouch.exe">notouch</a>
<br>
��Ĺ������ �ٶ󺸴� �������� ��� Ȯ���ϱ�<br>
<%=application.getRealPath("/pds/notouch.exe") %>
</body>
</html>
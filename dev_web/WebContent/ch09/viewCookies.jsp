<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.net.URLDecoder" %>
    <%
    Cookie cookies[] = request.getCookies();
    if(cookies != null && cookies.length>0){
    	for(int i =0;i<cookies.length;i++){
    		out.print(cookies[i].getName());
    		out.print("<br>");
    		out.print(URLDecoder.decode(cookies[i].getValue(),"utf-8"));
    	}
    }
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� pc�� ����� ��Ű ���� �б�</title>
</head>
<body>

</body>
</html>
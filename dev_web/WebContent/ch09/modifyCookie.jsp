<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.net.URLEncoder" %>
    <%
    Cookie cookies[] = request.getCookies();
    if(cookies !=null && cookies.length>0){
    	for(int i=0;i<cookies.length;i++){
    		if(cookies[i].getName().equals("mem_name")){
    			Cookie cName = new Cookie("mem_name"
    										,URLEncoder.encode("������","utf-8"));
    			response.addCookie(cName);
    		}
    	}
    }
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�� ����</title>
</head>
<body>

</body>
</html>
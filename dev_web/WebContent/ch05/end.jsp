<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%@page import ="java.util.Enumeration" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>end.jsp페이지</title>
</head>
<body>
<%
Enumeration<String> en=request.getAttributeNames();
while(en.hasMoreElements()){
	String name = en.nextElement();// name,date,goods
	String value =(String)request.getAttribute(name);
	out.print(value+"<br>");
}
out.print("<hr>");
Enumeration<String> en2=session.getAttributeNames();
while(en2.hasMoreElements()){
	String name = en2.nextElement();// name,date,goods
	String value =(String)session.getAttribute(name);
	out.print(value+"<br>");
	out.print("<hr>");
}
	Enumeration<String> en3=application.getAttributeNames();
	while(en3.hasMoreElements()){
		String name = en3.nextElement();// name,date,goods
		Object value =application.getAttribute(name);
		out.print(value+"<br>");
	}


%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	int i;
	String[] col=new String[5];
	col[0]="red";
	col[1]="blue";
	col[2]="green";
	col[3]="purple";
	col[4]="gold";
	for(i=0;i<5;i++){
		out.print("<font size="+(i+1)+"<font color="+col[i]+">"+"hello"+"</font>"+"<br>");
	}
%>
</body>
</html>
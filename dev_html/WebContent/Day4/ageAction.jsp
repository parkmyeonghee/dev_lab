<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ageAction.jsp입니다.</title>
</head>
<body>
<% //스크립틀릿
	int u_age=Integer.parseInt(request.getParameter("age"));
	out.print("사용자가 입력한 나이:"+u_age);
%>
</body>
</html>
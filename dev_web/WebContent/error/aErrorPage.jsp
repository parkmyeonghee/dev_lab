<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page isErrorPage="true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>에러 발생ㅇㅅㅇ</title>
</head>
<body>
	요청 처리 과정에서 에러가 발생하였습니다.<br>
	빠른 시간 내에 문제를 해결하겠습니다.
	에러 타입:<%=exception.getClass().getName() %>
	에러 메시지:<%=exception.getMessage() %>
	<%
	//getclass,toString,equals ===>Object에서 제공하는데 자주쓰이는 친구들 
	if(exception.getClass()==NullPointerException.class){ //getclass 클래스:타입을 비교할때
		out.print("NullPointerException 발생");
	}else
	{
		out.print("그외 발생");
	}
	%>
</body>
</html>
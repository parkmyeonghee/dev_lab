<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% //스크립틀릿
//한글 처리는 POST방식과 GET방식이 있다
//POST방식 :request.setCharacterEncoding("euc-kr")
//get방식일때는 url에 query string으로 넘어 가므로 url을 이용해서 서버로 전송
//server.xml문서에서 URIEncoding =euc-kr설정
	String u_name=request.getParameter("mem_name");
	out.print("사용자가 입력한 이름:"+u_name);
%>
</body>
</html>
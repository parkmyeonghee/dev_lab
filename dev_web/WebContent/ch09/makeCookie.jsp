<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.net.URLEncoder" %>
    <%@page import="java.net.URLDecoder" %>
    <%
    //쿠키에 여러개의 정보를 담을 수도 있다.
    //서로 전혀 관계가 없는 페이지 에서 쿠키값을 사용할 수 있다.
    Cookie cookie = new Cookie("mem_id","test");
    response.addCookie(cookie);
    Cookie cName = new Cookie("mem_name"
    									,URLEncoder.encode("이순신","utf-8"));
    response.addCookie(cName);
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>쿠키생성</title>
</head>
<body>
<%="쿠키이름:"+cookie.getName() %><!--mem_id  -->
<br>
<%="쿠키값:"+cookie.getValue() %><!--test  -->
<hr>
<%="쿠키이름:"+cName.getName() %><!--mem_id  -->
<br>
<%="쿠키값:"+URLDecoder.decode(cName.getValue(),"utf-8")%><!--test  -->
</body>
</html>
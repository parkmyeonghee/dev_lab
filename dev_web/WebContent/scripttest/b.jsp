<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    String nh_age = request.getParameter("nh_age");
    String age = request.getParameter("age");
    Cookie cookie = new Cookie("nh_age",nh_age);
    Cookie cookie2 = new Cookie("age",age);
    
    cookie.setMaxAge(60*60);
    cookie2.setMaxAge(60*60);
    response.addCookie(cookie); //실제로 클라이언트에 쿠키 내려보냄
    response.addCookie(cookie2); //실제로 클라이언트에 쿠키 내려보냄
    //out.print(nh_age); //String 변수 찍는거라서 다른 페이지에서는 접근할 수 없다. 쿠키에 담기지 않았으니
    Cookie cookies[]=request.getCookies();
    for(int i=0;i<cookies.length;i++){
       out.print(cookies[i].getName()+","+cookies[i].getValue());       
    }
    %>
    html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>   
<body>
    
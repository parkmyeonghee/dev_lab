<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="com.vo.MemberVO" %>
    <%
    MemberVO mVO =(MemberVO)session.getAttribute("mVO");
    MemberVO mVO4 =(MemberVO)session.getAttribute("mVO4");
    out.print("아이디:"+mVO.getId());
    if(mVO4!=null){
    	out.print("아이디(mVO4):"+mVO4.getId());
    	out.print("<br>");
    }
    else{
    	out.print("mVO4는 scope가 page이므로 memberFormAction.jsp에서 사용 불가합니다.");
    }
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
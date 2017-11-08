<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//스크립틀릿
	String u_menu = request.getParameter("menu");
	out.print(u_menu);
%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table width="50%" border="0" height="60%"><!-- 960 -->
<!--=========== top.jsp 시작 ===========-->
<tr height="15%">
	<td colspan="2" height="15%">
	<%@ include file="top.jsp" %><!--  디클러레이션 declaration-->
	</td>
</tr>
<!--=========== top.jsp  끝 ===========-->
<!--=========== body.jsp 시작 ===========-->
<tr height="75%">
<!--=========== menu.jsp 시작 ===========-->
<td width="20%" height="75%">
<%@ include file="menu.jsp" %> 
</td>
<!--=========== menu.jsp 끝 ===========-->
<!--=========== main.jsp 시작 ===========-->
<td width="80%" height="75%">
<!--html 땅  -->
<%
//자바땅
	if(u_menu==null){//기본페이지
%>
<%@ include file="main.jsp" %>
<%
	}
	else if("loginForm".equals(u_menu)){//너 로그인 눌렀니?
%>
<%@ include file="loginForm.jsp" %>
<%
	}
	else if("board".equals(u_menu)){//너 게시판 눌렀니?
%>
<%@ include file="boardList.jsp" %>
<%
	}
	else if("guest".equals(u_menu)){//너 방명록 눌렀니?
%>
<%@ include file="guestList.jsp" %>
<%
	}
%>
</td>
<!--=========== main.jsp 끝 ===========-->
</tr>
<!--=========== body.jsp 끝 ===========-->
<!--=========== bottom.jsp 시작 ===========-->
<tr height="10%">
<td colspan="2">
<%@ include file="bottom.jsp" %>
</td>
</tr>
<!--=========== bottom.jsp 끝 ===========-->
</table>
</body>
</html>
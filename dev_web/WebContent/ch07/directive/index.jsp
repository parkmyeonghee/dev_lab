<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    String menu=request.getParameter("menu");
    out.print("menu"+menu);
    request.setAttribute("rmem_name", "시오밍");
    String mem_name="세훙";
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table width="800" height="600" align="center">
<tr>
<td width="800" height="100">
<%-- <jsp:param value="test" name="mem_id"/>
<jsp:param value="123" name="mem_pw"/> --%>
<!-- top.jsp영역 -->
<%@ include file="./top.jsp" %>
</td>
</tr>
<tr>
<td width="800" height="450">
<!--main.jsp영역  -->
<%
//자바영역
if(menu==null){

%>
<!--html 영역 -->
<%@include file="./main.jsp" %>
<%
}
else if("loginForm".equals(menu)){
	%>
	<%@include file="./loginForm.jsp"%>
<% 
}else if("memberForm".equals(menu)){// 회원가입을 선택했을때
%>
<%@include file="./memberForm.jsp" %>
<%
}
else if("boardList".equals(menu)){
 %>
 <%@include file="./boardList.jsp" %>
 <%
}else if("info".equals(menu)){
 %>
 <%@include file="./info.jsp"%>
 <%
}else if("location".equals(menu)){
 %>
  <%@include file="./location.jsp" %>
 <%
}
 %>
</td>
</tr>
<tr>
<td width="800" height="50">
  <%@include file="./bottom.jsp"%>
<!--bottom.jsp영역  -->
</td>
</tr>
</table>
</body>
</html>
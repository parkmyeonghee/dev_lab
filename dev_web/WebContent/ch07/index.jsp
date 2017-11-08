<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    String menu=request.getParameter("menu");
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
<jsp:include page="./top.jsp" flush="false">
<jsp:param value="test" name="mem_id"/>
<jsp:param value="123" name="mem_pw"/>
<jsp:param value="<%=mem_name %>" name="mem_name"/>
</jsp:include>
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
<jsp:include page="./main.jsp" flush="false"/>
<%
}
else if("loginForm".equals(menu)){
	%>
	<jsp:include page="./loginForm.jsp" flush="false"/>
<% 
}else if("memberForm".equals(menu)){// 회원가입을 선택했을때
%>
<jsp:include page="./memberForm.jsp" flush="false"/>
<%
}
else if("boardList".equals(menu)){
 %>
 <jsp:include page="./boardList.jsp" flush="false"/>
 <%
}else if("info".equals(menu)){
 %>
 <jsp:include page="./info.jsp" flush="false"/>
 <%
}else if("location".equals(menu)){
 %>
 <jsp:include page="./location.jsp" flush="false"/>
 <%
}
 %>
</td>
</tr>
<tr>
<td width="800" height="50">
<jsp:include page="./bottom.jsp" flush="false"/>
<!--bottom.jsp영역  -->
</td>
</tr>
</table>
</body>
</html>
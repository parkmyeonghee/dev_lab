<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    String menu=request.getParameter("menu");
    out.print("menu"+menu);
    request.setAttribute("rmem_name", "�ÿ���");
    String mem_name="����";
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
<!-- top.jsp���� -->
<%@ include file="./top.jsp" %>
</td>
</tr>
<tr>
<td width="800" height="450">
<!--main.jsp����  -->
<%
//�ڹٿ���
if(menu==null){

%>
<!--html ���� -->
<%@include file="./main.jsp" %>
<%
}
else if("loginForm".equals(menu)){
	%>
	<%@include file="./loginForm.jsp"%>
<% 
}else if("memberForm".equals(menu)){// ȸ�������� ����������
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
<!--bottom.jsp����  -->
</td>
</tr>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    String menu=request.getParameter("menu");
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
<jsp:include page="./top.jsp" flush="false">
<jsp:param value="test" name="mem_id"/>
<jsp:param value="123" name="mem_pw"/>
<jsp:param value="<%=mem_name %>" name="mem_name"/>
</jsp:include>
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
<jsp:include page="./main.jsp" flush="false"/>
<%
}
else if("loginForm".equals(menu)){
	%>
	<jsp:include page="./loginForm.jsp" flush="false"/>
<% 
}else if("memberForm".equals(menu)){// ȸ�������� ����������
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
<!--bottom.jsp����  -->
</td>
</tr>
</table>
</body>
</html>
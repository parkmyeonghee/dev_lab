<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//��ũ��Ʋ��
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
<!--=========== top.jsp ���� ===========-->
<tr height="15%">
	<td colspan="2" height="15%">
	<%@ include file="top.jsp" %><!--  ��Ŭ�����̼� declaration-->
	</td>
</tr>
<!--=========== top.jsp  �� ===========-->
<!--=========== body.jsp ���� ===========-->
<tr height="75%">
<!--=========== menu.jsp ���� ===========-->
<td width="20%" height="75%">
<%@ include file="menu.jsp" %> 
</td>
<!--=========== menu.jsp �� ===========-->
<!--=========== main.jsp ���� ===========-->
<td width="80%" height="75%">
<!--html ��  -->
<%
//�ڹٶ�
	if(u_menu==null){//�⺻������
%>
<%@ include file="main.jsp" %>
<%
	}
	else if("loginForm".equals(u_menu)){//�� �α��� ������?
%>
<%@ include file="loginForm.jsp" %>
<%
	}
	else if("board".equals(u_menu)){//�� �Խ��� ������?
%>
<%@ include file="boardList.jsp" %>
<%
	}
	else if("guest".equals(u_menu)){//�� ���� ������?
%>
<%@ include file="guestList.jsp" %>
<%
	}
%>
</td>
<!--=========== main.jsp �� ===========-->
</tr>
<!--=========== body.jsp �� ===========-->
<!--=========== bottom.jsp ���� ===========-->
<tr height="10%">
<td colspan="2">
<%@ include file="bottom.jsp" %>
</td>
</tr>
<!--=========== bottom.jsp �� ===========-->
</table>
</body>
</html>
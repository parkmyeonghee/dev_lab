<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import ="com.vo.MemberVO" %>
    <%
 	 request.setCharacterEncoding("euc-kr");
    //�� ������������ �����ϱ� �����̴�.
    MemberVO mVO2 = new MemberVO("test","123","������","test@hotmail.com");  //�Ⱦ�
    MemberVO mVO3 = new MemberVO(request.getParameter("id")
    													,request.getParameter("pw")
    													,request.getParameter("name")
    													,request.getParameter("email")); 
    MemberVO mVO4 = new MemberVO();
    		mVO4.setId(request.getParameter("id"));
    		mVO4.setPw(request.getParameter("pw"));
    		mVO4.setName(request.getParameter("name"));
    		mVO4.setEmail(request.getParameter("email"));
    %>
    <jsp:useBean id="mVO" scope="session" class="com.vo.MemberVO"/>
    <jsp:setProperty property="*" name="mVO"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
	//click �̺�Ʈ ó���ϸ� ������ ���۵Ǳ� ���� ���ͼ�Ʈ �Ͽ�
	//��ȿ�� �˻縦 �����ϰ� ���۵ǵ��� �� �� �ִ�.
	$("#btn_send").click(function(){
		$("#if_login").attr("method","get");
		$("#if_login").attr("action","./memberFormAction.jsp");
		$("#if_login").submit();
	});
});
</script>
<form id="if_login" name="f_login">
<table border="1" cellpadding="0" cellspacing="0">
<tr>
<td>���̵�</td>
<td><jsp:getProperty property="id" name="mVO"/></td>
<td>�н�����</td>
<td><jsp:getProperty property="pw" name="mVO"/></td>
</tr>
<tr>
<td>�̸�</td>
<td><jsp:getProperty property="name" name="mVO"/></td>
<td>�̸���</td>
<td><jsp:getProperty property="email" name="mVO"/></td>
</tr>
<tr>
<td colspan="4" align="center">
<input type="button" value="ȸ������" id="btn_send">
</td>
</tr>
</table>
</form>
</body>
</html>
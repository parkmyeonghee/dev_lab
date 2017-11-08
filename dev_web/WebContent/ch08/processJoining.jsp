<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import ="com.vo.MemberVO" %>
    <%
 	 request.setCharacterEncoding("euc-kr");
    //이 페이지에서만 유지하기 때문이다.
    MemberVO mVO2 = new MemberVO("test","123","나신입","test@hotmail.com");  //싫엉
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
	//click 이벤트 처리하면 서버로 전송되기 전에 인터셉트 하여
	//유효성 검사를 수행하고 전송되도록 할 수 있다.
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
<td>아이디</td>
<td><jsp:getProperty property="id" name="mVO"/></td>
<td>패스워드</td>
<td><jsp:getProperty property="pw" name="mVO"/></td>
</tr>
<tr>
<td>이름</td>
<td><jsp:getProperty property="name" name="mVO"/></td>
<td>이메일</td>
<td><jsp:getProperty property="email" name="mVO"/></td>
</tr>
<tr>
<td colspan="4" align="center">
<input type="button" value="회원가입" id="btn_send">
</td>
</tr>
</table>
</form>
</body>
</html>
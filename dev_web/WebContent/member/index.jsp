<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.net.URLDecoder" %>
    <%
    String cname=null;//서버에서 로컬pc에 저장해둔 쿠키문서에서 읽어온 사용자 이름을 담을 변수
    Cookie[] cookies=request.getCookies();
    if(cookies !=null && cookies.length>0){
    	for(int i=0;i<cookies.length;i++){
    		if("cname".equals(cookies[i].getName())){
    			cname=URLDecoder.decode(cookies[i].getValue(),"utf-8");
    		}
    	}
    }
    out.print("쿠키에 담은 이름:"+cname);
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript"  src="/js/jquery-1.11.1.js"></script>
<title>로그인(쿠키실습)</title>
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
	//아이디 텍스트 클릭했을 때
	$("#imem_id").click(function(){
		$("#imem_id").val("");
	});
	//비번 텍스트 클릭했을 때
	$("#imem_pw").click(function(){
		$("#imem_pw").val("");
		$("#imem_pw").attr("password");
	});
	//로그인 버튼 클릭했을 때
	$("#btn_login").click(function(){
		$("#f_login").attr("method","get");
		$("#f_login").attr("action","./login.mfc");
		$("#f_login").submit();
	});
	//로그아웃 버튼 클릭했을 때
	$("#btn_logout").click(function(){
		$("#f_logout").attr("method","get");
		$("#f_logout").attr("action","./logout.mfc");
		$("#f_logout").submit();//전송 index.jsp-->MemberFrontController(doService:logout.mfc식별)
	});
});
</script>
<!--화면이 두 장 필요함다(로그인화면,인증했을 때 화면) -->
<%
//로그인 하기 전 화면
//쿠키에서 읽어온 이름이 없니?
if(cname==null){
%>
<form id="f_login">
<table width="200" height="80" border="1" bordercolor="orange">
<tr>
<td colspan="2">로그인</td>
</tr>
<tr>
<td>
<input type="text" name="mem_id"  id="imem_id" value="아이디" >
</td>
<td rowspan="2">
<input type="button" id="btn_login" value="로그인">
</td>
</tr>
<tr>
<td>
<input type="password" name="mem_pw"  id="imem_pw" value="비밀번호" >
</td>
</tr>
<tr>
<td colspan="2" align="center">회원가입</td>
</tr>
</table>
</form>
<%
}
//로그인 후 화면
else{
%>
<form id="f_logout">
<table width="250" height="80" border="1" bordercolor="green">
<tr>
<td colspan="2" align="center">로그인</td>
</tr>
<tr>
<td width="170">
<%=cname %>님 환영합니다.
</td>
<td width="80" align="center">
<input type="button" id="btn_logout" value="로그아웃" >
</td>
</tr>
<tr>
<td colspan="2" align="center">정보수정|회원탈퇴</td>
</tr>
</table>
</form>
<%
}
%>
</body>
</html>
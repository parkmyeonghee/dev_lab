<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@page import="java.net.URLDecoder"%>
    	<% String cname= null;
	//로컬 pc에 텍스트 형태로 저장되어 있는 사용자에 대한 정보를 서버가 요청해서 읽은 후에  화면처리하기
	//쿠키 정보 읽어오기
	Cookie cookies[] = request.getCookies(); //메소드 찾을땐 respones4
	for(int i=0; i<cookies.length;i++){
		out.print(cookies[i].getName());
		if("cname".equals(cookies[i].getName())){
			cname=URLDecoder.decode(cookies[i].getValue(),"utf-8");
			out.print("cname : "+cname);
		}else{
			out.print(cookies[i].getValue());
		}
	}
	%>
<table width="250" height="80" border="1" borderColor="green">
	<tr>
		<td colspan="2">로그인</td>
	</tr>
	<tr>
		<td width="170"><%=cname %>님 환영합니다.</td>
		<td width="80" align="center"><input type="button" value="로그아웃"
			onClick="logout()"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">정보수정|회원탈퇴</td>
	</tr>
</table>
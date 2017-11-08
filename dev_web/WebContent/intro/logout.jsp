<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.net.URLDecoder" %>       
<%
	String cname = null;





	String sname = (String) session.getAttribute("sname");
	//쿠키 정보 읽어오기
	Cookie cookies[] = request.getCookies();
		for(int i=0;i<cookies.length;i++){
			//out.print(cookies[i].getName());
			if("cname".equals(cookies[i].getName())){
				cname = URLDecoder.decode(cookies[i].getValue(),"utf-8");
				out.print("cname:"+cname);
			}
		}
%>
<script type="text/javascript" src="/js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	function logout(){
		$.ajax({
			type:"get"
		  , url:"./logout.mem"
		  , success:function(result){
			  $("#d_menu").html("");
		  	  $("#d_login").html(result);
		  }
		  , error:function(e){
			  $("#d_login").text(e.responseText);
		  } 
		});////// end of ajax		
	}////////////end of logout
</script>    
<!--================== 로그아웃 폼 화면 시작 =====================-->
<table width="250" height="80" border="1" borderColor="green">
	<tr>
		<td colspan="2">로그인</td>
	</tr>
	<tr>
		<td width="170">
		<%=sname %>님 환영합니다.
		</td>
		<td width="80" align="center">
			<input type="button" value="로그아웃" onClick="logout()">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<a href="./getMemberList.mem">회원목록 | </a> 정보수정|회원탈퇴</td>
	</tr>
</table>					
<!--================== 로그아웃 폼 화면  끝 =====================-->	
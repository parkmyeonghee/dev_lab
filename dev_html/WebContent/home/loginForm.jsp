<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <html>
    <head>
   
<script type="text/javascript">
function login(){ //로그인버튼을 누르면 secen1이 사라진다.
	document.getElementById("d_secen1").innerText="";
	temp="<div id='d_secen2'><table width='250' height='80' border='1' bordercolor='green'>";
	//secen2에 대한 아이들을 담아준다.(배운방법대로해서 함수를 안쓰고 노가다.)
	temp+="<tr><td colspan='2' align='center'>로그인</td></tr>";
	temp+="<tr><td width='170'>이순신님 환영합니다.</td><td width='80' align='center'><input type='button' value='로그아웃' onClick='logout()'></td></tr>";
	temp+="<tr><td colspan='2' align='center'>정보수정|회원탈퇴</td></tr>";
	temp+="</table></div>";
	document.getElementById("d_secen2").innerHTML=temp; //secen2가 뜬다.
}//text로 찍어주면 태그가 나오기때문에 HTML로 해준다.
function logout(){
	document.getElementById("d_secen2").innerText="";
	temp="<div id='d_secen1'><table width='200' height='80' border='1' bordercolor='orange'>";
	temp+="<tr><td colspan='2' align='center'>로그인</td></tr>";
	temp+="<tr><td><input type='text' name='mem_id'  id='imem_id' value='아이디' ></td>"
	temp+="<td rowspan='2'><input type='button' value='로그인' onClick='login()'></td>";
	temp+="<tr><td><input type='password' name='mem_pw'  id='imem_pw' value='비밀번호' ></td></tr>";
	temp+="<tr><td colspan='2' align='center'>회원가입</td></tr>";
	temp+="</table></div>";
	document.getElementById("d_secen1").innerHTML=temp; 
}
</script>  
   </head>
   <body>
     <script type="text/javascript">
   window.onload=function(){
	 //  alert('11');
	 document.getElementById("d_secen2").innerText=""; 
   };
   </script>
<table border="1"  bordercolor="pink" width="100%" height="100%">
	<tr>
	<td align="center">
<!-- ========================장면1시작================= -->
<div id="d_secen1">
<table width="200" height="80" border="1" bordercolor="orange">
<tr>
<td colspan="2">로그인</td>
</tr>
<tr>
<td>
<input type="text" name="mem_id"  id="imem_id" value="아이디" >
</td>
<td rowspan="2">
<input type="button" value="로그인" onClick="login()">
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
</div>
<!-- ======================장면 1 끝==================== -->
<!-- ========================장면2시작================= -->
<div id="d_secen2">
<table width="250" height="80" border="1" bordercolor="green">
<tr>
<td colspan="2" align="center">로그인</td>
</tr>
<tr>
<td width="170">
이순신님 환영합니다.
</td>
<td width="80" align="center">
<input type="button" value="로그아웃" onClick="logout()">
</td>
</tr>
<tr>
<td colspan="2" align="center">정보수정|회원탈퇴</td>
</tr>
</table>
</div>
<!-- ======================장면 2 끝==================== -->

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/dev_jquery/js/jquery-1.11.1.js"></script>
</head>
<body>
<script>
$(document).ready(function(){
	//document.getElementById("i_pw")
	$("#i_pw").keyup(function(){
		$("#d_msg").text("");
	});
	$("#i_pw2").keyup(function(){
	$("#d_msg").text("입력받은 비번:"+$("#i_pw").val());
	//처음 입력한 비번과 비번확인에서 입력받은 값이 다르니? -다르면 다릅니다
			//(빨강색:태그적용 html)
	if($("#i_pw").val()!=$("#i_pw2").val()){
		$("#d_msg").html("<font color='red'>비밀번호가 일치하지 않습니다.</font>");
	}
			//같니?- 비밀번호가 일치합니다(파랑)
			else{
			$("#d_msg").html("<font color='blue'>비밀번호가 일치 합니다.</font>");	
			}
	});/////end of keyup
	$("#sel_menu").change(function(){
		var selText=$("#sel_menu option:selected").text();//피자,떡볶이,돈까스
		$("#i_choice").val(selText);
	});
	$("#sel_subject").change(function(){
		var str="";
		$("#sel_subject option:selected").each(function(){
			str+=$(this).text()+"|";
		});
		$("#i_subject").val(str.substring(0,str.length-1));
	});
});/////////////end of ready
</script>
<select id="sel_subject" multiple="multiple">
<option>오라클</option>
<option selected="seleted">자바</option>
<option>JSP</option>
<option>Jquery</option>
<option>Ajax</option>
</select>
<br>
<input type="text" id="i_subject">
<hr>
<select id="sel_menu">
<option>피자</option>
<option>떡볶이</option>
<option>돈까스</option>
</select>
<br>
<input type="text" id="i_subject">
<br>
<table style="border:1px solid skyblue">
<tr>
<td>비번</td>
<td><input type="text" id="i_pw" size="10"></td>
</tr>
<tr>
<td>비번확인</td>
<td><input type="text" id="i_pw2" size="10"></td>
</tr>
</table>
<div id="d_msg">비밀번호를 입력하세요</div>
</body>
</html>
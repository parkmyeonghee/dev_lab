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
	$("#d_msg").text("�Է¹��� ���:"+$("#i_pw").val());
	//ó�� �Է��� ����� ���Ȯ�ο��� �Է¹��� ���� �ٸ���? -�ٸ��� �ٸ��ϴ�
			//(������:�±����� html)
	if($("#i_pw").val()!=$("#i_pw2").val()){
		$("#d_msg").html("<font color='red'>��й�ȣ�� ��ġ���� �ʽ��ϴ�.</font>");
	}
			//����?- ��й�ȣ�� ��ġ�մϴ�(�Ķ�)
			else{
			$("#d_msg").html("<font color='blue'>��й�ȣ�� ��ġ �մϴ�.</font>");	
			}
	});/////end of keyup
	$("#sel_menu").change(function(){
		var selText=$("#sel_menu option:selected").text();//����,������,���
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
<option>����Ŭ</option>
<option selected="seleted">�ڹ�</option>
<option>JSP</option>
<option>Jquery</option>
<option>Ajax</option>
</select>
<br>
<input type="text" id="i_subject">
<hr>
<select id="sel_menu">
<option>����</option>
<option>������</option>
<option>���</option>
</select>
<br>
<input type="text" id="i_subject">
<br>
<table style="border:1px solid skyblue">
<tr>
<td>���</td>
<td><input type="text" id="i_pw" size="10"></td>
</tr>
<tr>
<td>���Ȯ��</td>
<td><input type="text" id="i_pw2" size="10"></td>
</tr>
</table>
<div id="d_msg">��й�ȣ�� �Է��ϼ���</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�¶��� ����</title>
<script type="text/javascript" src="/js/jquery-1.11.1.js"></script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function (){
		$("#btn_start").click(function (){
		//	alert("����"); // or console.log()
			location.href="./testLogin.test?test_no="+$("#itest_no").val()
						+"&exam_cd="+$("#iexam_cd").val();
		});
	});
</script>
<center>
	<table>
	<tr>
			<td>�����ڵ�</td>
			<td><input type="text" id="iexam_cd" name="exam_cd" value="t_20170111"></td>
		</tr>
		<tr>
			<td>�����ȣ</td>
			<td><input type="text" id="itest_no" name="test_no" value="2017010001"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<input type="button" id="btn_start" value="����">
			</td>
		</tr>
	</table>
</center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
		$("#if_login").attr("action","./processJoining.jsp");
		$("#if_login").submit();
	});
});
</script>
<form id="if_login" name="f_login">
<table border="1" cellpadding="0" cellspacing="0">
<tr>
<td>���̵�</td>
<td><input type="text" name="id" size="10"></td>
<td>�н�����</td>
<td><input type="text" name="pw" size="10"></td>
</tr>
<tr>
<td>�̸�</td>
<td><input type="text" name="name" size="10"></td>
<td>�̸���</td>
<td><input type="text" name="email" size="10"></td>
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
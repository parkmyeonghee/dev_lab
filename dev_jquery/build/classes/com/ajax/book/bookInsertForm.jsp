<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�������� ���</title>
<script type="text/javascript" src="/dev_ajax/js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	function bookInsert()
	{
		$("#f_book").attr("method","post");
		$("#f_book").attr("action","./bookInsert.bk");
		$("#f_book").submit();
	}
</script>
</head>
<body>
<!-- 
form�±� ���� enctype�߰��Ǿ��� �� �ݵ�� post���۹������ �����Ѵ�.
���� ����
��û��ü�� �̿��ؼ� ����ڰ� �Է��� ������ �޾ƿ� �� ����.
 -->
<form id="f_book" method="post" enctype="multipart/form-data">
<table border="1" width="750" align="center" borderColor="green">
	<tr>
		<td width="120">��������</td>
		<td width="630"><input type="text" id="iab_title" name="ab_title"></td>
	</tr>
	<tr>
		<td>��     ��</td>
		<td><input type="text" id="iab_author" name="ab_author"></td>
	</tr>
	<tr>
		<td>��     ��</td>
		<td><input type="text" id="iab_price" name="ab_price"></td>
	</tr>
	<tr>
		<td>���ǻ�</td>
		<td><input type="text" id="iab_publisher" name="ab_publisher"></td>
	</tr>
	<tr>
		<td>�����̹���</td>
		<td><input type="file" id="iab_img" name="ab_img"></td>
	</tr>			
</table>
<!-- ��ư �߰�  ���� -->
<table border="0" width="750" align="center" borderColor="green">
	<tr>
		<td width="750">
		<input type="button" id="btn_ins" value="���" onClick="bookInsert()">
		<input type="button" id="btn_res" value="���"  onClick="bookReset()">
		</td>
	</tr>
</table>	
<!-- ��ư �߰�   ��   -->
</form>
</body>
</html>
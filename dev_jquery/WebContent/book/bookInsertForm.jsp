<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�������� ���</title>
<script type="text/javascript" src="/dev_jquery/js/jquery-1.11.1.js"></script>
<script type="text/javascript">
function bookInsert(){
	$("#f_book").attr("method","post");
	$("#f_book").attr("action","./bookInsert.bk");
	$("#f_book").submit();
}
</script>
</head>
<body>
<!--
form�±� ���� encType�߰� �Ǿ��� �� �ݵ�� post���� ������� �����Ѵ�
���� ����
��û��ü�� �̿��ؼ� ����ڰ� �Է��� ������ �޾ƿ� �� ����.
  -->
<form id="f_book" method="post" enctype="multipart/form-data">
<table border="1" width="750" aligin="center" borderColor="pink" >
<tr>
<td width="120">���� ����</td>
<td width="630"><input type="text" id="iab_title" name="ab_title"></td>
</tr>
<tr>
<td>���ǻ�</td>
<td><input type="text" id="iab_author" name="ab_author"></td>
</tr>
<tr>
<td>����</td>
<td><input type="text" id="iab_price" name="ab_price"></td>
</tr>
<tr>
<td>����</td>
<td><input type="text" id="iab_publisher" name="ab_publisher"></td>
</tr>
<tr>
<td>�����̹���</td>
<td><input type="file" id="iab_image" name="ab_image"></td>
</tr>
</table>
<!--��ư �߰� ���� -->
<table border="0" width="750" aligin="center">
<tr>
<td width="750">
<input type="button" id="btn_ins" value="���" onClick="bookInsert()">
<input type="button" id="btn_res" value="���" onClick="bookReset()">
</td>
</tr>
<!--��ư �߰� �� -->
</form>
</body>
</html>
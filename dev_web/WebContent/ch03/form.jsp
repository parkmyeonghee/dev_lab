<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <!-- 
   �н���ǥ
   1.����ڰ� �Է��� ���� ������ ���� �� �� �ִ�.
   2.�������� ����ڰ� �Է��� ���� HashMapBinder Ŭ������ �̿��ؼ� ����� �� �ִ�.
   3.�������� ���������� ó�� �� �� �ִ�.
    -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������</title>
<script type="text/javascript">
function send(){
	document.getElementById("f_send").method="get";
	document.getElementById("f_send").action="/dev_web/ch03/FormServlet.do";
	document.getElementById("f_send").submit();
}
</script>
</head>
<body>
<form id="f_send">
�̸�:<input type="text"  name="name" size="10"><br>
�ּ�:<input type="text"  name="address" size="30"><br>
�����ϴ� ����:
<input type="checkbox" name="pet" value="dog">������
<input type="checkbox" name="pet" value="cat">�����
<input type="checkbox" name="pet" value="pig">����
<br>
<input type="button" value="����" onClick="send()">
</form>
</body>
</html>
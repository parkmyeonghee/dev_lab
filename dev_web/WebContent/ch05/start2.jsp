<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>start2.jsp</title>
<script type="text/javascript">
function send(){
	document.f_send.method="get";
	document.f_send.action="/ch05/service.do";
	document.f_send.submit();
}
</script>
</head>
<body>
<form name="f_send">
���̵�:<input type="text" name="mem_id"><br>
���:<input type="text" name="mem_pw"><br>
<input type="button" value="����" onClick="send()">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function send(){
		document.f_get.method = "get";
		document.f_get.action = "/dev_web/ch17/testSend.do";
		document.f_get.submit();
	}
</script>
</head>
<body>
<!-- <form name="f_get" method="get" action="/ch17/testSend.do"></form> -->
<form name="f_get">
	아이디:<input type="text" name="mem_id">
	<input type="button" value="전송" onClick="send()">
</form>
</body>
</html>
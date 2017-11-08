<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/dev_jquery/js/jquery-1.11.1.js"></script>
<style type="text/css">
	.css0{color:orange;}
	.css1{color:red;}
	.css2{color:blue;}
	.css3{color:brown;}
	.css4{color:pink;}
</style>
</head>
<body>
<script type="text/javascript">
	var i=0;
	$(document).ready(function (){//함수 이름 없이 익명함수로 출력
		$("h1").each(forEach);
	});
	function forEach(){
		$(this).attr("class","css"+i);
		i++;
	}
</script>
<h1>Jquery CSS Test</h1>
<h1>Jquery FORM Test</h1>
<h1>Jquery Component Test</h1>
<h1>Jquery EVENT Test</h1>
<h1>Jquery SCRIPT Test</h1>
</body>
</html>
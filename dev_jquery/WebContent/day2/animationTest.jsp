<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/dev_jquery/js/jquery-1.11.1.js"></script>
<style type="text/css">
	.css0{color:orange;}
	h1{position:relative;}
</style>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function (){//함수 이름 없이 익명함수로 출력
		$("h1").click(whenClick);
	});/////end of ready
	function whenClick(){
		$(this).toggleClass("css0");
		if($(this).hasClass("css0")){
		$(this).animate({left:"200"},"slow");
	}
	else{
		$(this).animate({left:"0"},"slow");
	}
	}////////end of whenClick
</script>
<h1>Jquery CSS Test</h1>
<h1>Jquery FORM Test</h1>
<h1>Jquery Component Test</h1>
<h1>Jquery EVENT Test</h1>
<h1>Jquery SCRIPT Test</h1>
</body>
</html>
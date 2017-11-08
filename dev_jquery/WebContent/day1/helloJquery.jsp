<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/dev_jquery/js/jquery-1.11.1.js"></script>
</head>
<body>
<script type="text/javascript">
//document객체의 ready 이벤트 연결
//$기호는 jquery를 대신하는 특수문자
//jquery(document).ready()
//기본 선택자
//선택자($(document))는 jquery에서 가장 중요한 역할
//syntax: $ 선택자 메소드
	$(document).ready(function (){//함수 이름 없이 익명함수로 출력
		//document.write("hello jquery!!!");
		$("h1").click(whenClick);
	});
	function whenClick(){
		$(this).append("+");
		$(this).prepend("#");
	}
</script>
<h1>Jquery CSS Test</h1>
<h1>Jquery FORM Test</h1>
<h1>Jquery Component Test</h1>
<h1>Jquery EVENT Test</h1>
<h1>Jquery SCRIPT Test</h1>
</body>
</html>
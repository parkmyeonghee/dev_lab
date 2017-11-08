<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="/dev_web/js/jquery-1.11.1.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function() {
    $('input[type="checkbox"][name="ckbox"]').click(function(){
        if ($(this).prop('checked')) {
            $('input[type="checkbox"][name="ckbox"]').prop('checked', false);
            $(this).prop('checked', true);
        }
    });
});
$(document).ready(function(){
	$("#")
})
</script>
</head>
<body>
<form id="f_test1">
한릴레이션 기본키를 구성하는 어떠한 속성 값도 널(NULL)값이나 중복 값을 가질 수 없음을 의미하는 것은?
<br>
<input type="checkbox" name="ckbox"  value="1">1.개체 무결성 제약 조건
<br>
<input type="checkbox" name="ckbox"  value="2">2.참조 무결성 제약 조건
<br>
<input type="checkbox" name="ckbox"  value="3">3.도메인 무결성 제약 조건
<br>
<input type="checkbox" name="ckbox"  value="4">4.키 무결성 제약 조건
<br>
정답:1
<br>
<input type="button" id="btn_next" value="다음문제">
</form>
</body>
</html>
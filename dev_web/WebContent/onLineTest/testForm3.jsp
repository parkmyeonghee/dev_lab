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
</script>
</head>
<body>
다음중 멀티미디어의 특징으로 옳지 않은것은?
<br>
<input type="checkbox" name="ckbox"  value="1">
1.디지털 데이터로 변환하여 통합 처리한다
<br>
<input type="checkbox" name="ckbox"  value="1">
2.정보 제공자와 사용자 간의 상호 작용에 의해 데이터가 전달된다.
<br>
<input type="checkbox" name="ckbox"  value="1">
3.데이터가 사용자 선택에 따라 순차적으로 처리되는 선형성의 특징을 가진다.
<br>
<input type="checkbox" name="ckbox"  value="1">
4.문자,그림,사운드 등의 여러 미디어를 통합하여 처리한다.
<br>
정답:3
<br>
<input type="button" id="next" value="다음문제"> &nbsp 
<input type="button" id="return" value="이전문제">

</body>
</html>
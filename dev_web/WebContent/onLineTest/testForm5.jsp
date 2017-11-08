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
인터럽트 요청신호 플래그(Flag)를 차례로 검사하여 인터럽트의 원인을 판별하는 방식은?
<br>
<input type="checkbox" name="ckbox"  value="1">1.스토로브 방식
<br>
<input type="checkbox" name="ckbox"  value="2">2.데이지 체인방식
<br>
<input type="checkbox" name="ckbox"  value="3">3.폴링방식
<br>
<input type="checkbox" name="ckbox"  value="4">4.하드웨어방식
<br>
정답:3
<br>
<input type="button" id="btn_go" value="답안지제출"> &nbsp 
<input type="button" id="btn_return" value="이전문제">
</body>
</html>
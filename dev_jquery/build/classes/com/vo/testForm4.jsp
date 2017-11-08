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
해싱에서 동일한 홈 주소로 인하여 충돌이 일어난 레코드들의 집합을 의미하는 것은?
<br>
<input type="checkbox" name="ckbox"  value="1">
1.overflow
<br>
<input type="checkbox" name="ckbox"  value="1">
2.bucket
<br>
<input type="checkbox" name="ckbox"  value="1">
3.synonym
<br>
<input type="checkbox" name="ckbox"  value="1">
4.collision
<br>
정답:3
<br>
<input type="button" id="next" value="다음문제"> &nbsp 
<input type="button" id="return" value="이전문제">

</body>
</html>
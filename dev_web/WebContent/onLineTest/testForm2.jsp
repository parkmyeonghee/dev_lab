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
<title>Insert title here</title>
</head>
<body>
다음중 네트워크 연결을 위한 동배간 처리(Peer-To-Peer) 방식에 대한 설명으로 옳지 않은것은?
<br>
<input type="checkbox" name="ckbox"  value="1">
1.컴퓨터와 컴퓨터가 동등하게 연결되는 방식이다.
<br>
<input type="checkbox" name="ckbox"  value="2">
2.각각의 컴퓨터는 클라이언트인 동시에 서버가 될 수 있다.
<br>
<input type="checkbox" name="ckbox"  value="3">
3.워크스테이션이나 PC를 단말기로 사용하는 작은 규모의 네트워크에 많이 사용된다.
<br>
<input type="checkbox" name="ckbox"  value="4">
4.유지보수가 쉽고 데이터의 보안이 우수하며 주로 데이터 양이 많을 때 사용한다.
<br>
정답:4번
<br>
<input type="button" id="next" value="다음문제"> &nbsp 
<input type="button" id="return" value="이전문제">
</body>
</html>
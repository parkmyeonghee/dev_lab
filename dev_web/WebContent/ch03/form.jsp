<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <!-- 
   학습목표
   1.사용자가 입력한 값을 서버로 전송 할 수 있다.
   2.서버에서 사용자가 입력한 값을 HashMapBinder 클래스를 이용해서 출력할 수 있다.
   3.서블릿에서 응답페이지 처리 할 수 있다.
    -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>폼생성</title>
<script type="text/javascript">
function send(){
	document.getElementById("f_send").method="get";
	document.getElementById("f_send").action="/dev_web/ch03/FormServlet.do";
	document.getElementById("f_send").submit();
}
</script>
</head>
<body>
<form id="f_send">
이름:<input type="text"  name="name" size="10"><br>
주소:<input type="text"  name="address" size="30"><br>
좋아하는 동물:
<input type="checkbox" name="pet" value="dog">강아지
<input type="checkbox" name="pet" value="cat">고양이
<input type="checkbox" name="pet" value="pig">돼지
<br>
<input type="button" value="전송" onClick="send()">
</form>
</body>
</html>
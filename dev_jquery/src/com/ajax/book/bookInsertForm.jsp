<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>도서정보 등록</title>
<script type="text/javascript" src="/dev_ajax/js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	function bookInsert()
	{
		$("#f_book").attr("method","post");
		$("#f_book").attr("action","./bookInsert.bk");
		$("#f_book").submit();
	}
</script>
</head>
<body>
<!-- 
form태그 내에 enctype추가되었을 때 반드시 post전송방식으로 설정한다.
문제 제기
요청객체를 이용해서 사용자가 입력한 정보를 받아올 수 없다.
 -->
<form id="f_book" method="post" enctype="multipart/form-data">
<table border="1" width="750" align="center" borderColor="green">
	<tr>
		<td width="120">도서제목</td>
		<td width="630"><input type="text" id="iab_title" name="ab_title"></td>
	</tr>
	<tr>
		<td>저     자</td>
		<td><input type="text" id="iab_author" name="ab_author"></td>
	</tr>
	<tr>
		<td>가     격</td>
		<td><input type="text" id="iab_price" name="ab_price"></td>
	</tr>
	<tr>
		<td>출판사</td>
		<td><input type="text" id="iab_publisher" name="ab_publisher"></td>
	</tr>
	<tr>
		<td>도서이미지</td>
		<td><input type="file" id="iab_img" name="ab_img"></td>
	</tr>			
</table>
<!-- 버튼 추가  시작 -->
<table border="0" width="750" align="center" borderColor="green">
	<tr>
		<td width="750">
		<input type="button" id="btn_ins" value="등록" onClick="bookInsert()">
		<input type="button" id="btn_res" value="취소"  onClick="bookReset()">
		</td>
	</tr>
</table>	
<!-- 버튼 추가   끝   -->
</form>
</body>
</html>
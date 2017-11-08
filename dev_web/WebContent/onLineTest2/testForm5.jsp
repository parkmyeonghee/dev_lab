<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String test2 = request.getParameter("hn_test4");
	Cookie cookie = new Cookie("test4",test2);
	cookie.setMaxAge(60*20);//20분
	response.addCookie(cookie);
	//out.print(test1);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="/js/jquery-1.11.1.js"></script>
<title>시험문제5</title>
</head>
<body>
<script type="text/javascript">
	var count = 0;
	$(document).ready(function (){
		$("#btn_send").click(function (){
			//alert("시작");
			//$('input:checkbox[id="checkbox_id"]').is(":checked") == true

			if($("#testForm1").is(":checked")==true){
				$("#h_test5").val(1);
				count++;
				//alert("1번:"+$("#h_test2").val());
			}
			else if($("#testForm2").is(":checked")==true){
				$("#h_test5").val(2);
				count++;
			}
			else if($("#testForm3").is(":checked")==true){
				$("#h_test5").val(3);
				count++;
			}
			else if($("#testForm4").is(":checked")==true){
				$("#h_test5").val(4);
				count++;
			}
			if(count==1){
				$("#if_test5").attr("method","get");
				//location.href="./testFormAccount.jsp";
				$("#if_test5").attr("action","./marking.test"); //쿠키에 담는 코드(jsp처리 화면제공필요없	음)
				//컨트롤러에서 앞에 경로 짜르기때문에 경로 ./로 하면 안됨.
				$("#if_test5").submit();
			}
			else{	
				alert("답을 선택하세요");
				return;
			}			
		});
		$("#btn_pre").click(function (){
			location.href="./testForm4.jsp";
		});
	});
</script>
<form id="if_test5">
<input type="hidden" id="h_test5" name="hn_test5">
5.인터럽트 요청신호 플래그(Flag)를 차례로 검사하여 인터럽트의 원인을 판별하는 방식은?
<br>
<input type="checkbox" id="testForm1">
1.스토로브 방식<br>
<input type="checkbox" id="testForm2">
2.데이지 체인방식<br>
<input type="checkbox" id="testForm3">
3.폴링방식<br>
<input type="checkbox" id="testForm4">
4.하드웨어방식<br>
<input type="button" id="btn_pre" value="이전">
<input type="button" id="btn_send" value="제출">
</form>
</body>
</html>
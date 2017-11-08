<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String test1 = request.getParameter("hn_test1"); //1번문항에 관하여 쿠키 가져옴
	Cookie cookie = new Cookie("test1",test1);
	cookie.setMaxAge(60*20);//20분
	response.addCookie(cookie);
	//out.print(test1);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="/js/jquery-1.11.1.js"></script>
<title>시험문제2</title>
</head>
<body>
<script type="text/javascript">
	var count = 0;
	$(document).ready(function (){		
		$("#btn_next").click(function (){
			//alert("시작");
			//$('input:checkbox[id="checkbox_id"]').is(":checked") == true

			if($("#testForm1").is(":checked")==true){
				$("#h_test2").val(1);
				count++;
				//alert("1번:"+$("#h_test2").val());
			}
			else if($("#testForm2").is(":checked")==true){
				$("#h_test2").val(2);
				count++;
			}
			else if($("#testForm3").is(":checked")==true){
				$("#h_test2").val(3);
				count++;
			}
			else if($("#testForm4").is(":checked")==true){
				$("#h_test2").val(4);
				count++;
			}
			if(count==1){
				$("#if_test2").attr("method","get");
				$("#if_test2").attr("action","./testForm3.jsp");
				$("#if_test2").submit();
			}
			else{
				alert("답을 선택하세요");
				return;
			}	
		});
		$("#btn_pre").click(function (){
			location.href="./testForm1.jsp";
		});		
	});
</script>
<form id="if_test2">
<input type="hidden" id="h_test2" name="hn_test2">
2. 다음중 네트워크 연결을 위한 동배간 처리(Peer-To-Peer) 방식에 대한 설명으로 옳지 않은것은?<br>
<br>
<input type="checkbox" id="testForm1">
1.컴퓨터와 컴퓨터가 동등하게 연결되는 방식이다.<br>
<input type="checkbox" id="testForm2">
2.각각의 컴퓨터는 클라이언트인 동시에 서버가 될 수 있다.<br>
<input type="checkbox" id="testForm3">
3.워크스테이션이나 PC를 단말기로 사용하는 작은 규모의 네트워크에 많이 사용된다.<br>
<input type="checkbox" id="testForm4">
4.유지보수가 쉽고 데이터의 보안이 우수하며 주로 데이터 양이 많을 때 사용한다.<br>
<input type="button" id="btn_pre" value="이전">
<input type="button" id="btn_next" value="다음">
</form>
</body>
</html>
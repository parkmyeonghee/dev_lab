<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String test3 = request.getParameter("hn_test3");
	Cookie cookie = new Cookie("test3",test3);
	cookie.setMaxAge(60*20);//20��
	response.addCookie(cookie);
	//out.print(test1);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="/js/jquery-1.11.1.js"></script>
<title>���蹮��4</title>
</head>
<body>
<script type="text/javascript">
	var count = 0;
	$(document).ready(function (){
		$("#btn_next").click(function (){
			//alert("����");
			//$('input:checkbox[id="checkbox_id"]').is(":checked") == true

			if($("#testForm1").is(":checked")==true){
				$("#h_test4").val(1);
				count++;
				//alert("1��:"+$("#h_test2").val());
			}
			else if($("#testForm2").is(":checked")==true){
				$("#h_test4").val(2);
				count++;
			}
			else if($("#testForm3").is(":checked")==true){
				$("#h_test4").val(3);
				count++;
			}
			else if($("#testForm4").is(":checked")==true){
				$("#h_test4").val(4);
				count++;
			}
			if(count==1){
				$("#if_test4").attr("method","get");
				//location.href="./testFormAccount.jsp";
				$("#if_test4").attr("action","./testForm5.jsp");
				$("#if_test4").submit();
			}
			else{
				alert("���� �����ϼ���");
				return;
			}			
		});
		$("#btn_pre").click(function (){
			location.href="./testForm3.jsp";
		});
	});
</script>
<form id="if_test4">
<input type="hidden" id="h_test4" name="hn_test4">
4. �ؽ̿��� ������ Ȩ �ּҷ� ���Ͽ� �浹�� �Ͼ ���ڵ���� ������ �ǹ��ϴ� ����?<br>

<br>
<input type="checkbox" id="testForm1">
1.overflow<br>
<input type="checkbox" id="testForm2">
2.bucket<br>
<input type="checkbox" id="testForm3">
3.synonym<br>
<input type="checkbox" id="testForm4">
4.collision<br>
<input type="button" id="btn_pre" value="����">
<input type="button" id="btn_next" value="����">
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String test2 = request.getParameter("hn_test2");
	Cookie cookie = new Cookie("test2",test2);
	cookie.setMaxAge(60*20);//20��
	response.addCookie(cookie);
	//out.print(test1);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="/js/jquery-1.11.1.js"></script>
<title>���蹮��3</title>
</head>
<body>
<script type="text/javascript">
	var count = 0;
	$(document).ready(function (){
		$("#btn_next").click(function (){
			//alert("����");
			//$('input:checkbox[id="checkbox_id"]').is(":checked") == true

			if($("#testForm1").is(":checked")==true){
				$("#h_test3").val(1);
				count++;
				//alert("1��:"+$("#h_test2").val());
			}
			else if($("#testForm2").is(":checked")==true){
				$("#h_test3").val(2);
				count++;
			}
			else if($("#testForm3").is(":checked")==true){
				$("#h_test3").val(3);
				count++;
			}
			else if($("#testForm4").is(":checked")==true){
				$("#h_test3").val(4);
				count++;
			}
			if(count==1){
				$("#if_test3").attr("method","get");
				//location.href="./testFormAccount.jsp";
				$("#if_test3").attr("action","./testForm4.jsp");
				$("#if_test3").submit();
			}
			else{
				alert("���� �����ϼ���");
				return;
			}			
		});
		$("#btn_pre").click(function (){
			location.href="./testForm2.jsp";
		});
	});
</script> 
<form id="if_test3">
<input type="hidden" id="h_test3" name="hn_test3">
3. ������ ��Ƽ�̵���� Ư¡���� ���� ��������?<br>
<br>
<input type="checkbox" id="testForm1">
1.������ �����ͷ� ��ȯ�Ͽ� ���� ó���Ѵ�<br>
<input type="checkbox" id="testForm2">
2.���� �����ڿ� ����� ���� ��ȣ �ۿ뿡 ���� �����Ͱ� ���޵ȴ�.<br>
<input type="checkbox" id="testForm3">
3.�����Ͱ� ����� ���ÿ� ���� ���������� ó���Ǵ� �������� Ư¡�� ������.<br>
<input type="checkbox" id="testForm4">
4.����,�׸�,���� ���� ���� �̵� �����Ͽ� ó���Ѵ�.<br>
<input type="button" id="btn_pre" value="����">
<input type="button" id="btn_next" value="����">
</form>
</body>
</html>
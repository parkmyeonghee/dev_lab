<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String test2 = request.getParameter("hn_test4");
	Cookie cookie = new Cookie("test4",test2);
	cookie.setMaxAge(60*20);//20��
	response.addCookie(cookie);
	//out.print(test1);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="/js/jquery-1.11.1.js"></script>
<title>���蹮��5</title>
</head>
<body>
<script type="text/javascript">
	var count = 0;
	$(document).ready(function (){
		$("#btn_send").click(function (){
			//alert("����");
			//$('input:checkbox[id="checkbox_id"]').is(":checked") == true

			if($("#testForm1").is(":checked")==true){
				$("#h_test5").val(1);
				count++;
				//alert("1��:"+$("#h_test2").val());
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
				$("#if_test5").attr("action","./marking.test"); //��Ű�� ��� �ڵ�(jspó�� ȭ�������ʿ��	��)
				//��Ʈ�ѷ����� �տ� ��� ¥���⶧���� ��� ./�� �ϸ� �ȵ�.
				$("#if_test5").submit();
			}
			else{	
				alert("���� �����ϼ���");
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
5.���ͷ�Ʈ ��û��ȣ �÷���(Flag)�� ���ʷ� �˻��Ͽ� ���ͷ�Ʈ�� ������ �Ǻ��ϴ� �����?
<br>
<input type="checkbox" id="testForm1">
1.����κ� ���<br>
<input type="checkbox" id="testForm2">
2.������ ü�ι��<br>
<input type="checkbox" id="testForm3">
3.�������<br>
<input type="checkbox" id="testForm4">
4.�ϵ������<br>
<input type="button" id="btn_pre" value="����">
<input type="button" id="btn_send" value="����">
</form>
</body>
</html>
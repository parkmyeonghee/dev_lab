<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String test1 = request.getParameter("hn_test1"); //1�����׿� ���Ͽ� ��Ű ������
	Cookie cookie = new Cookie("test1",test1);
	cookie.setMaxAge(60*20);//20��
	response.addCookie(cookie);
	//out.print(test1);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="/js/jquery-1.11.1.js"></script>
<title>���蹮��2</title>
</head>
<body>
<script type="text/javascript">
	var count = 0;
	$(document).ready(function (){		
		$("#btn_next").click(function (){
			//alert("����");
			//$('input:checkbox[id="checkbox_id"]').is(":checked") == true

			if($("#testForm1").is(":checked")==true){
				$("#h_test2").val(1);
				count++;
				//alert("1��:"+$("#h_test2").val());
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
				alert("���� �����ϼ���");
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
2. ������ ��Ʈ��ũ ������ ���� ���谣 ó��(Peer-To-Peer) ��Ŀ� ���� �������� ���� ��������?<br>
<br>
<input type="checkbox" id="testForm1">
1.��ǻ�Ϳ� ��ǻ�Ͱ� �����ϰ� ����Ǵ� ����̴�.<br>
<input type="checkbox" id="testForm2">
2.������ ��ǻ�ʹ� Ŭ���̾�Ʈ�� ���ÿ� ������ �� �� �ִ�.<br>
<input type="checkbox" id="testForm3">
3.��ũ�����̼��̳� PC�� �ܸ���� ����ϴ� ���� �Ը��� ��Ʈ��ũ�� ���� ���ȴ�.<br>
<input type="checkbox" id="testForm4">
4.���������� ���� �������� ������ ����ϸ� �ַ� ������ ���� ���� �� ����Ѵ�.<br>
<input type="button" id="btn_pre" value="����">
<input type="button" id="btn_next" value="����">
</form>
</body>
</html>
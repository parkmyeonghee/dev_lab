<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JSON���� ���� �о����</title>
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
	$("#submit").click(function(){
		$.ajax({
			method:"GET"
			,url:"./drink.json"
			,dataType:"json"
			,success:function(data){
				//alert("data"+data);
				var drinks="<ul>";
				//���⼭�� i�� data�� ��ü�� �ε����� ��Ÿ���� n�� optiontext�� optionvalue
				//�Ӽ��� ������ ��ü�� ����Ŵ
				$.each(data,function(i,n){
					alert("optionvalue:"+n["optionvalue"]);
					drinks +="<li>"+n["optiontext"]+"</li>";
				});
				drinks +="<ul>";
				$("#d_msg").html(drinks);
			}
		,error:function(e){
			alert(e.responseText);
		}
		});
	});
});
</script>
<input type="submit" id="submit">
<div id="d_msg"></div>
</body>
</html>
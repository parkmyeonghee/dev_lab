<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�˻��� �ڵ��ϼ� ���</title>
<link rel="stylesheet" type="text/css" href="../css/word.css">
<!-- jquery api import -->
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<script type="text/javascript">
//�ڵ� �ϼ� ������� ��ȸ�� ����� ������ �Ŀ� div�±� ���� ����� �Լ� ����
function clearMethod(){
	$("#d_word").css("backgroundColor","FFFFFF");
	$("#d_word").css("border","none");
	$("#d_word").html("");
}
</script>
</head>
<body>
<script type="text/javascript">
/*Ű���带 �����ٰ� �� ��  */
 //searchWordView.jsp�������� ���� DOM������ �Ϸ�Ǿ��� ��
 $(document).ready(function(){
	 $("#word").keyup(function(){
	 //�̺�Ʈ ó��(Ű���带 �����ٰ� �� ��)
	 var p_word=$("#word").val();
	 var param="w_word="+p_word;
		 $.ajax({
			type:"POST"
			,url:"./getWordList.aja"
			,data:param
			,success:function(result){
				$("#d_word").html(result);
			//	alert(result);
				//$("#d_word").html("<b>�׽�Ʈ</b>");
				//��µǴ� �������� ��ġ Ȥ�� borderȤ�� ������
				$("#d_word").css("border","#000000 1px solid");
				$("#d_word").css("background","#FFFFFF");
				$("#d_word").css("width",150+"px");
				$("#d_word").css("left",$("#word").offset().left+"px");
				$("#d_word").css("left",$("#word").offset().top+$("#word").offset().height+"px");
				$("#d_word").html(result);
				var tds = document.getElementsByTagName("td");//array
				for(var i=0;i<tds.length;i++){
				   tds[i].onmouseover = function(){
				 	this.className = "listIn"
				   };	
				   tds[i].onmouseout = function(){
				 	this.className = "listOut"
				   }; 
				   tds[i].onclick=function(){
					   $("#word").val($(this).text());
					   clearMethod();
				   }
				}
			}///////////////////end of success
		 })////////////////////////end of ajax
	 });///////////////////////////end of keyup EVENT
 });///////////////////////////end of ready
</script>
<!-- ȭ�� ó�� �ϱ� -->
<h3>�˻��� �ڵ��ϼ� ��� ����</h3>
�˻��� �Է�:<input type="text" id="word">
<div id="d_word"></div>
</body>
</html>
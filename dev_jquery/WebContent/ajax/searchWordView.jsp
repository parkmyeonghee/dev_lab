<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>검색어 자동완성 기능</title>
<link rel="stylesheet" type="text/css" href="../css/word.css">
<!-- jquery api import -->
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<script type="text/javascript">
//자동 완성 기능으로 조회한 결과중 선택한 후에 div태그 내용 지우는 함수 구현
function clearMethod(){
	$("#d_word").css("backgroundColor","FFFFFF");
	$("#d_word").css("border","none");
	$("#d_word").html("");
}
</script>
</head>
<body>
<script type="text/javascript">
/*키보드를 눌렀다가 뗄 때  */
 //searchWordView.jsp페이지에 대한 DOM구성이 완료되었을 때
 $(document).ready(function(){
	 $("#word").keyup(function(){
	 //이벤트 처리(키보드를 눌렀다가 뗄 때)
	 var p_word=$("#word").val();
	 var param="w_word="+p_word;
		 $.ajax({
			type:"POST"
			,url:"./getWordList.aja"
			,data:param
			,success:function(result){
				$("#d_word").html(result);
			//	alert(result);
				//$("#d_word").html("<b>테스트</b>");
				//출력되는 페이지의 위치 혹은 border혹은 바탕색
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
<!-- 화면 처리 하기 -->
<h3>검색어 자동완성 기능 구현</h3>
검색어 입력:<input type="text" id="word">
<div id="d_word"></div>
</body>
</html>
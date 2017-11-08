<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>보드판매량 집계(Ajax 적용코드)</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/dev_jquery/js/jquery-1.11.1.js"></script>
<link rel="stylesheet" type="text/css" href="../css/boards.css">
<!-- css파일을 가져오는것 -->
<script type="text/javascript" src="../js/commons.js"></script>
<script type="text/javascript">

function requestProcess(){

	//alert('test');
	if(request.readyState==4){
	

	}
}/////////end of requestprocess
function replaceText(el,text){
	//기존의 노드에 들어 있는 값을 초기화 시킨다.
	clearText(el);
	//지운 자리에 새로운 텍스트 노드추가하기
	var newNode= document.createTextNode(text);
	el.appendChild(newNode);
}
/*******************************************************************************************
 * 
 * @param el(span)
 * @returns 해당없음
******************************************************************************************* */
function clearText(el){//el:span id=borders_sold
	if(el !=null){
		if(el.childNodes){//el.childNodes -span태그에 자식노드
			for(var i=0;el.childNodes.length;i++){
				//childNode변수에 1000
				var childNode=el.childNodes[i];
				el.removeChild(childNode);
			}/////end of for
		}/////end of inner if
	}/////end of outter if
}///////end of clearText
/********************************************************************************************
 * 노드의 값을 읽어오기 구현
 * @param el(span)
 * @returns text
 ********************************************************************************************/
function getText(el)
{
	var text="";
	if(el !=null){
//childNodes는 지정된 객체의 직접적인 자식개체인
//html elements와 TextNode개체들의 컬렉션을 반환한다.
	
		if(el.childNodes){
			for(i=0;i<el.childNodes.length;i++){
				var childNode= el.childNodes[i];
				//너 텍스트 노드니?
				if(childNode.nodeValue !=null){
					text +=childNode.nodeValue;//1000
				}
			}
		}
	}
	return text;
}
</script>
</head>
<!-- <body onLoad="test()"> -->
<body>
<script type="text/javascript">
$(document).ready(function(){
	$("#btn_account").click(function(){
		console.log("마진버튼을 클릭했을때");
		/*
		$.ajax()-->url,data,sucess
		$get()
		$post()-->get or post사용시에는 속성을 사용할 수 없다.
		post(url,type,data)
		*/
		$.ajax({
		  type:"get"
			,url:"./getUpdateBoardSales.jsp"
			,success:function(data){//data:request.responseText;
				console.log("서버페이지로 부터 응답메시지:"+data);
				var newTotal=data;
				//html에서 제공하는 콤퍼넌트에 입력한 값을 가져올 때 -$("#[id일때]선택자").val()
				$("#boards_sold").text(data);//보드 판매량을 수정-text값: 텍스트 노드 접근할때
				var price=$("#price").text();//소비자 금액 담기
				var cost=$("#cost").text();//소비자 금액 담기
				//보드 한 개당 마진 금액 구하기
				var cashPerBoard=price-cost;
				//총 마진 금액 구하기
				var cash=cashPerBoard*newTotal;
				//replaceText(cashEL,cash); 새로 계산된 마진금액을 cash위치에 값을 바꾸기
				$("#cash").text(cash);
			}
		});
	});
});
</script>
<table width="300" height="80">
<tr>
<th>보드 판매량</th><!--textnode 태그이름은 노,값은 존재 -->
<td><span id="boards_sold">1000</span></td>
</tr> 
<tr>
<th>소비자가</th>
<td><span id="price">250000</span></td>
</tr>
<tr>
<th>구매가</th>
<td><span id="cost">170000</span></td>
</tr>
</table>
<h2>마진금액:<span id="cash">80000000원</span></h2>
<input type="button" value="마진은?" id="btn_account">
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�����Ǹŷ� ����(Ajax �����ڵ�)</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/dev_jquery/js/jquery-1.11.1.js"></script>
<link rel="stylesheet" type="text/css" href="../css/boards.css">
<!-- css������ �������°� -->
<script type="text/javascript" src="../js/commons.js"></script>
<script type="text/javascript">

function requestProcess(){

	//alert('test');
	if(request.readyState==4){
	

	}
}/////////end of requestprocess
function replaceText(el,text){
	//������ ��忡 ��� �ִ� ���� �ʱ�ȭ ��Ų��.
	clearText(el);
	//���� �ڸ��� ���ο� �ؽ�Ʈ ����߰��ϱ�
	var newNode= document.createTextNode(text);
	el.appendChild(newNode);
}
/*******************************************************************************************
 * 
 * @param el(span)
 * @returns �ش����
******************************************************************************************* */
function clearText(el){//el:span id=borders_sold
	if(el !=null){
		if(el.childNodes){//el.childNodes -span�±׿� �ڽĳ��
			for(var i=0;el.childNodes.length;i++){
				//childNode������ 1000
				var childNode=el.childNodes[i];
				el.removeChild(childNode);
			}/////end of for
		}/////end of inner if
	}/////end of outter if
}///////end of clearText
/********************************************************************************************
 * ����� ���� �о���� ����
 * @param el(span)
 * @returns text
 ********************************************************************************************/
function getText(el)
{
	var text="";
	if(el !=null){
//childNodes�� ������ ��ü�� �������� �ڽİ�ü��
//html elements�� TextNode��ü���� �÷����� ��ȯ�Ѵ�.
	
		if(el.childNodes){
			for(i=0;i<el.childNodes.length;i++){
				var childNode= el.childNodes[i];
				//�� �ؽ�Ʈ ����?
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
		console.log("������ư�� Ŭ��������");
		/*
		$.ajax()-->url,data,sucess
		$get()
		$post()-->get or post���ÿ��� �Ӽ��� ����� �� ����.
		post(url,type,data)
		*/
		$.ajax({
		  type:"get"
			,url:"./getUpdateBoardSales.jsp"
			,success:function(data){//data:request.responseText;
				console.log("������������ ���� ����޽���:"+data);
				var newTotal=data;
				//html���� �����ϴ� ���۳�Ʈ�� �Է��� ���� ������ �� -$("#[id�϶�]������").val()
				$("#boards_sold").text(data);//���� �Ǹŷ��� ����-text��: �ؽ�Ʈ ��� �����Ҷ�
				var price=$("#price").text();//�Һ��� �ݾ� ���
				var cost=$("#cost").text();//�Һ��� �ݾ� ���
				//���� �� ���� ���� �ݾ� ���ϱ�
				var cashPerBoard=price-cost;
				//�� ���� �ݾ� ���ϱ�
				var cash=cashPerBoard*newTotal;
				//replaceText(cashEL,cash); ���� ���� �����ݾ��� cash��ġ�� ���� �ٲٱ�
				$("#cash").text(cash);
			}
		});
	});
});
</script>
<table width="300" height="80">
<tr>
<th>���� �Ǹŷ�</th><!--textnode �±��̸��� ��,���� ���� -->
<td><span id="boards_sold">1000</span></td>
</tr> 
<tr>
<th>�Һ��ڰ�</th>
<td><span id="price">250000</span></td>
</tr>
<tr>
<th>���Ű�</th>
<td><span id="cost">170000</span></td>
</tr>
</table>
<h2>�����ݾ�:<span id="cash">80000000��</span></h2>
<input type="button" value="������?" id="btn_account">
</body>
</html>
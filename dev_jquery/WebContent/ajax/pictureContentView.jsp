<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.util.List,com.vo.PictureVO" %>
    <%
    List<PictureVO>picList=
    (List<PictureVO>)request.getAttribute("picList");
    int size=0;
    if(request.getAttribute("picList")!=null){
    	size=picList.size();
    }
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>
<link rel="stylesheet" href="../css/word.css"type="text/css"/>
<script type="text/javascript">
//�ݱ� ��ư Ŭ�������� ȣ�� �Լ�
function clearMethod(){
	$("#d_pictureSub").css("backgroundColor","#FFFFFF");
	$("#d_pictureSub").css("border","none");
	$("#d_pictureSub").html("");
}
//pictureContentDetail.jsp���� �ݱ� ��ư�� Ŭ������ ��
function subClose(){
	clearMethod();
}
function pictureDetail(td,pnum){
	//alert(td+","+pnum);
	var param="num="+pnum;
	$.ajax({
		type:"POST"
		,url:"getPictureDetail.aja"
		,data:param
		,success:function(result){
			$("#d_pictureSub").css("border","#000000 1px solid");
			$("#d_pictureSub").css("backgroundColor", "#FFFFFF");
			$("#d_pictureSub").css("top",td.offsetTop+5+"px");
			$("#d_pictureSub").css("left",td.offsetLeft+td.offsetWidth+13+"px");
			$("#d_pictureSub").html(result);
		}
	,error:function(e){
		alert(e.responseText);
	}
	});
	
}
</script>
</head>
<body>
<table width="350px" border=1>
<!-- �˻������ ������ �� -->
<%
if(size>0){
	String imgPath="../images/";
	for(int i=0;i<size;i++){
		PictureVO rpVO =picList.get(i);
%>   
<tr>
<td align="center" width="50">
<img src="<%=imgPath+rpVO.getImgFile()%>" width="50"height="50"/>
</td>
<td width="150" onMouseOver="pictureDetail(this)">
<%=rpVO.getTitle() %>
</td>
</tr>
<!-- �˻������ ���� �� -->
<%
	}///////////////////////////end of for
}///////////////////////////////end of if
else{
%>
<tr>
<td> �˻������ �����ϴ�.</td>
</tr>
<%
}////////////////////////////end of else
%>
</table>
<div id="d_pictureSub">

</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%> 
<%
    //���ǿ� ��� ������ ȭ�鿡�� ����ϱ�
    String sid = (String)session.getAttribute("sid");
	//out.print("���ǿ��� �о�� �̸� : "+sname);
	//��ũ��Ʋ��
	String u_menu = request.getParameter("menu");
   //���� PC�� �ؽ�Ʈ ���·� ����Ǿ� �ִ� ����ڿ� ���� ������ ������ ��û�ؼ� ���� �Ŀ� ȭ�� ó���ϱ�
	//out.print(u_menu);
%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/news.css">
<script type="text/javascript" src="../js/commons.js"></script>
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script> 
<script type="text/javascript">
	var g_id = "haha";//��������(head�±׳� ��ũ��Ʈ �ڵ�ȿ��� ����)
	function idText(){//���̵� textfieldŬ������ ��
		$("#imem_id").val("");
	}
	function pwText(){
		$("#imem_pw").val("");
		$("#imem_pw").attr("type","password");
	}
	function login(){//�α��� ��ư�� Ŭ������ ��
		//insert here - ��ȿ�� üũ�ϱ�
		if($("#imem_id").val()=="���̵��Է��ϼ���"){
			$("#imem_id").val("");
			$("#imem_id").focus();
			return;//login�Լ� Ż��
		}
		if($("#imem_pw").val()=="��й�ȣ���Է��ϼ���"){
			$("#imem_pw").val("");
			$("#imem_pw").focus();
			return;//login�Լ� Ż��
		}	
		console.log("����");
		//����ڰ� �Է��� ���̵��� ���ͼ� vmem_id��� �ڵ�
		var vmem_id = $("#imem_id").val();
		//����ڰ� �Է��� ������� ���ͼ� vmem_pw��� �ڵ�
		var vmem_pw = $("#imem_pw").val();
		//Ajax�� �̿��Ͽ� ������ ��ûó���ϱ�
		$.ajax({
			type:"get"
		  , url:"./login.mem?mem_id="+vmem_id+"&mem_pw="+vmem_pw
		  , success:function(result){//result�������� logout.jsp�������� ��¹��ڿ��� ����.
			var imenu ="<tr><td height='15%'><a href='./index.jsp?menu=board'>��������</a></td></tr>";
			imenu+="<tr><td height='15%'><a href='./index.jsp?menu=board'>�Խ���</a></td></tr>";
			  $("#d_menu").html(imenu);
			  $("#d_login").html(result);//��ư �α����� �α׾ƿ����� ����
		  }
		  , error:function(e){
			  $("#d_login").text(e.responseText);
		  } 
		});////// end of ajax		
	}////////// end of login
	function popupView(){
		console.log("popupView ȣ�� ����");
		url = "./popup.html";//��������
		popupwidth="600";
		popupheight="400";
		popupname="popup";
		//�ڹٽ�ũ��Ʈ������ ���� ǥ���� ���� �ݵ�� ""�� �ٿ��� �Ѵ�.
		//�׷��������� ���� ����Ѵ�.
		cmm_window_popup(url,popupwidth,popupheight,popupname);
	}
</script>  
</head>
<body>
<script type="text/javascript">
	/* $(document).ready(function (){
		//alert("ready~~~~~");
		//$("#d_news").html("<b>����~~~</b>");
		var watch;
		function start(){
			watch = setInterval(autoReload,1000);
		}
		function stop(){
			setTimeout(function (){
				clearInterval(watch);
			},10000);
		}
		//ajax����
		function autoReload(){
			//alert("autoReloadȣ�� ����");
			//$.get({
				//"get", "./getNewsList.do", varName
			//}); 
			//$.post({});
			$.ajax({
				type:"get"
			  , url:"../ajax/getNewsList.do"
			  , success:function(result){
				  //alert("success");
				  $("#d_news").css("border","#000000 1px solid");
				  $("#d_news").css("background","#FFDDAA");
				  $("#d_news").css("left",$("#img_picture1").offset().left+"px");
				  $("#d_news").css("top",$("#img_picture1").offset().top+100 +"px");
			  	  $("#d_news").html(result);
			  }
			  , error:function(e){
				  $("#d_news").text(e.responseText);
			  } 
			});
		}
		start();
		stop();		
	}); */
</script>
<table width="1000" border="0" height="600"><!-- 960 -->
<!--=========== top.jsp ���� ===========-->
<tr height="15%">
	<td colspan="2" height="15%">
	<%@ include file="top.jsp" %><!--  ��Ŭ�����̼� declaration-->
	</td>
</tr>
<!--=========== top.jsp  �� ===========-->
<!--=========== body.jsp ���� ===========-->
<tr height="75%">
<!--=========== menu.jsp ���� ===========-->
<td width="20%" height="75%">
<%@ include file="menu.jsp" %>
</td>
<!--=========== menu.jsp �� ===========-->
<!--=========== main.jsp ���� ===========-->
<td width="80%" height="75%">
<!--html ��  -->
<%
//�ڹٶ�
	if(u_menu==null){//�⺻������
%>
<%@ include file="main.jsp" %>
<%
	}
	else if("loginForm".equals(u_menu)){//�� �α��� ������?
%>
<%@ include file="loginForm.jsp" %>
<%
	}
	else if("board".equals(u_menu)){//�� �Խ��� ������?
%>
<%@ include file="boardList.jsp" %>
<%
	}
	else if("guest".equals(u_menu)){//�� ���� ������?
%>
<%@ include file="guestList.jsp" %>
<%
	}////////////////end of ����
	else if("getMemberList".equals(u_menu)){//�� ȸ����� ������?
%>
<%@ include file="getMemberList.jsp" %> 
<%
	}
	else if("memo".equals(u_menu)){//���������϶�
%>
<%@include file="memoIntro.jsp"%>
<%
	}
	else if("getReceiveMemoList".equals(u_menu)){
%>
<jsp:include page="getReceiveMemoList.jsp">
<jsp:param  name="to_id" value="<%=sid %>"/>
</jsp:include>
<%
//���� ������
	}
	else  id("getSendMemoList".equals(u_memu)){
%>
<jsp:include page="getSendMemoList.jsp">
<jsp:param name="from_id" value="<%=sid %>"/>
</jsp:include>
<%
	}
%>
</td>
<!--=========== main.jsp �� ===========-->
</tr>
<!--=========== body.jsp �� ===========-->
<!--=========== bottom.jsp ���� ===========-->
<tr height="10%">
<td colspan="2">
<%@ include file="bottom.jsp" %>
</td>
</tr>
<!--=========== bottom.jsp �� ===========-->
</table>
</body>
</html>
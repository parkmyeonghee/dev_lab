<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.net.URLDecoder"%>
<%
//���ǿ� ��� ������ ȭ�鿡�� ����ϱ�
//String sname=(String)session.getAttribute("sname");
//out.print("���ǿ��� �о�� �̸�:"+sname);
	//��ũ��Ʋ��
	String u_menu = request.getParameter("menu");

	//��Ű���� �о�� �̸� ���� ���� ����
	String cname= null;
	//���� pc�� �ؽ�Ʈ ���·� ����Ǿ� �ִ� ����ڿ� ���� ������ ������ ��û�ؼ� ���� �Ŀ�  ȭ��ó���ϱ�
	//��Ű ���� �о����
	Cookie cookies[] = request.getCookies(); //�޼ҵ� ã���� respones4
	for(int i=0; i<cookies.length;i++){
		out.print(cookies[i].getName());
		if("cname".equals(cookies[i].getName())){
			cname=URLDecoder.decode(cookies[i].getValue(),"utf-8");
		//	out.print("cname : "+cname);
		}else{
		//	out.print(cookies[i].getValue());
		}
	}
	//out.print(u_menu);
%>   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="../js/commons.js"></script> 
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>  
<script type="text/javascript">
	var g_id = "haha";//��������(head�±׳� ��ũ��Ʈ �ڵ�ȿ��� ����)
	function idText(){//���̵� TextfieldŬ�� ���� ��
		$("#imem_id").val("");
	}
	function pwText(){
		$("#imem_pw").val("");
		$("#imem_pw").attr("type","password");
	}
	function login(){// �α��� ��ư�� Ŭ������ ��
		//��ȿ�� üũ�ϱ�
		if($("#imem_id").val("")=="���̵� �Է��ϼ���"){
			$("#imem_id").val("");
			$("#imem_id").focus();
			return; //login�Լ�Ż��
		}
		if($("#imem_pw").val("")=="��й�ȣ�� �Է��ϼ���"){
			$("#imem_pw").val("");
			return;//login�Լ�Ż��
		}
		console.log("����");
		//����ڰ� �Է��� ���̵��� ���ͼ� vmem_id��� �ڵ�
		//var vmem_id=$("#imem_id").val();
		var vmem_id=document.getElementById("imem_id").value;
	//����ڰ� �Է��� ������� ���ͼ� vmem_pw��� �ڵ�
		var vmem_pw=$("#imem_pw").val();
	alert("id:"+vmem_id+vmem_pw);
		  $.ajax({
		         type:"get"
		         ,url:"./login.mem?mem_id="+vmem_id+"&mem_pw="+vmem_pw 
		         ,success:function(result){//result�������� logout.jsp�������� ��¹��ڿ��� ����.
		        var imenu=" <tr><td height='15%''><a href='./index.jsp?menu=board'>��������</a></td></tr>;"
				imenu+="<tr><td height='15%'><a href='./index.jsp?menu=board'>�Խ���</a></td></tr>;"
		        	$("#d_menu").html(imenu);
		         /*    alert("succes"); */
		            $("#d_login").html(result); //��ư �α����� �α׾ƿ����� ����
		         }
		         ,error:function(e){
		            $("#d_login").text(e.responseText);
		         }	
		      });//end ajax
	}//end of login
	
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

<table width="50%" border="0" height="60%"><!-- 960 -->
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
	}///////////////////////end of ����
	else if("getMemberList".equals(u_menu)){//�� ȸ����� ������?
%>
<%@ include file="getMemberList.jsp" %>
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
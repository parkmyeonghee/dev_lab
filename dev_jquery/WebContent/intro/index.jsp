<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.net.URLDecoder"%>
<%
//세션에 담긴 정보를 화면에서 사용하기
String sname=(String)session.getAttribute("sname");
out.print("세션에서 읽어온 이름:"+sname);
	//스크립틀릿
	String u_menu = request.getParameter("menu");

	//쿠키에서 읽어온 이름 담을 변수 선언
	String cname= null;
	//로컬 pc에 텍스트 형태로 저장되어 있는 사용자에 대한 정보를 서버가 요청해서 읽은 후에  화면처리하기
	//쿠키 정보 읽어오기
	Cookie cookies[] = request.getCookies(); //메소드 찾을땐 respones4
	for(int i=0; i<cookies.length;i++){
		out.print(cookies[i].getName());
		if("cname".equals(cookies[i].getName())){
			cname=URLDecoder.decode(cookies[i].getValue(),"utf-8");
			out.print("cname : "+cname);
		}else{
			out.print(cookies[i].getValue());
		}
	}
	out.print(u_menu);
%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/news/css">
<script type="text/javascript" src="../js/commons.js"></script> 
<script type="text/javascript" src="../js/jquery-1.11.1.js"></script>  
<script type="text/javascript">
	var g_id = "haha";//전역변수(head태그내 스크립트 코드안에서 선언)
	function idText(){//아이디 Textfield클릭 했을 때
		$("#imem_id").val("");
	}
	function pwText(){
		$("#imem_pw").val("");
		$("#imem_pw").attr("type","password");
	}
	function login(){// 로그인 버튼을 클릭했을 때
		//유효성 체크하기
		if($("#imem_id").val("")=="아이디를 입력하세요"){
			$("#imem_id").val("");
			$("#imem_id").focus();
			return; //login함수탈출
		}
		if($("#imem_pw").val("")=="비밀번호를 입력하세요"){
			$("#imem_pw").val("");
			return;//login함수탈출
		}
		console.log("여기");
		//사용자가 입력한 아이디값을 얻어와서 vmem_id담는 코드
		var vmem_id=$("#imem_id").val();
	//사용자가 입력한 비번값을 얻어와서 vmem_pw담는 코드
		var vmem_pw=$("#imem_pw").val();
		  $.ajax({
		         type:"get"
		         ,url:"./login.mem?mem_id="+vmem_id+"&mem_pw="+vmem_pw   
		         ,success:function(result){//result변수에는 logout.jsp페이지의 출력문자열이 담긴다.
		         /*    alert("succes"); */
		            $("#d_login").html(result); //버튼 로그인이 로그아웃으로 변경
		         }
		         ,error:function(e){
		            $("#d_login").text(e.responseText);
		         }	
		      });//end ajax
	}//end of login
	function logout(){
		$.ajax({
			type:"get"
			,url:"./logout.mem"
			,success:function(result){
				$("#d_login").html(result); //div id =d_login 그래서 하나만 하는것
			}
		 ,error:function(e){
	            $("#d_login").text(e.responseText);
	         }	
		}); //////end of ajax
	}/////////end of logout
	function popupView(){
		console.log("popupView 호출 성공");
		url = "./popup.html";//지역변수
		popupwidth="600";
		popupheight="400";
		popupname="popup";
		//자바스크립트에서는 값을 표시할 때는 반드시 ""을 붙여야 한다.
		//그렇지않으면 변수 취급한다.
		cmm_window_popup(url,popupwidth,popupheight,popupname);
	}
</script>  
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
   
   var watch;
   function start(){
      watch = setInterval(autoReload,1000);
   }
	   function stop(){
       setTimeout(function (){
         clearInterval(watch);
      },10000);
   }
   function autoReload(){
   /*    alert("autoReload호출 성공"); */
      $.ajax({
         type:"get"
         ,url:"../ajax/getNewsList.do"   
         ,success:function(result){
         /*    alert("succes"); */
            $("#d_news").html(result);
         }
         ,error:function(e){
            $("#d_news").text(e.responseText);
         }	
      });
   }
   start();
   stop();
});

</script>
<table width="50%" border="0" height="60%"><!-- 960 -->
<!--=========== top.jsp 시작 ===========-->
<tr height="15%">
	<td colspan="2" height="15%">
	<%@ include file="top.jsp" %><!--  디클러레이션 declaration-->
	</td>
</tr>
<!--=========== top.jsp  끝 ===========-->
<!--=========== body.jsp 시작 ===========-->
<tr height="75%">
<!--=========== menu.jsp 시작 ===========-->
<td width="20%" height="75%">
<%@ include file="menu.jsp" %> 
</td>
<!--=========== menu.jsp 끝 ===========-->
<!--=========== main.jsp 시작 ===========-->
<td width="80%" height="75%">
<!--html 땅  -->

<%
//자바땅
	if(u_menu==null){//기본페이지
%>
<%@ include file="main.jsp" %>
<%
	}
	else if("loginForm".equals(u_menu)){//너 로그인 눌렀니?
%>
<%@ include file="loginForm.jsp" %>
<%
	}
	else if("board".equals(u_menu)){//너 게시판 눌렀니?
%>
<%@ include file="boardList.jsp" %>
<%
	}
	else if("guest".equals(u_menu)){//너 방명록 눌렀니?
%>
<%@ include file="guestList.jsp" %>
<%
	}
%>
</td>
<!--=========== main.jsp 끝 ===========-->
</tr>
<!--=========== body.jsp 끝 ===========-->
<!--=========== bottom.jsp 시작 ===========-->
<tr height="10%">
<td colspan="2">
<%@ include file="bottom.jsp" %>
</td>
</tr>
<!--=========== bottom.jsp 끝 ===========-->
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    String u_menu=request.getParameter("menu");
    %>
<html>
<head>
<script type="text/javascript" src="../js/commons.js"></script>
  <script type="text/javascript">
  var g_id="haha";//전역변수(head태그내 스크립트 코드안에서 선언)
function popupView(){
	console.log("popup호출 성공");//디버깅할때 쓰는아이(크롬에서)값이런거 찍어볼때
	url="./login.html"; //js파일에 넣어준 변수를 호출해준다.
	popupwidth="600";//지역변수
	popupheight="400";
	popupname="login";
	//자바스크립트에서는 값을 표시할때는 반드시 ""을 붙여야 한다.
	//그렇지 않으면 변수취급한다.
	cmm_window_popup(url,popupwidth,popupheight,popupname);
}
</script>
<title>index.jsp</title>
</head>
<body > 
<table width="50%" border="0" height="60%"><!-- 픽셀로 줄 수 있고 %로가능 960  -->
<!-- ====================menutop.jsp 시작================== -->
<tr height="10%">
<td colspan="2" >
<%@ include file="menutop.jsp" %><!-- 디클러레이션 -->
</td>
</tr>
<!-- ===============menutop.jsp끝====================== -->
<!-- =================top.jsp시작====================== -->
<tr height="15%">
<td colspan="2" height="15%">
<%@ include file="top.jsp" %>
</td>
</tr>
<!-- ==================body.jsp시작========================= -->
<tr height="75%">
<!-- =================menu.jsp시작====================== -->
<td width="20%" height="75%">
<%@ include file="menu.jsp" %>
</td>
<!-- =================menu.jsp끝====================== -->
<!-- =================main.jsp시작====================== -->
<td width="80%">
<%@ include file="main.jsp" %>
</td>
</tr>
<!-- =================main.jsp끝====================== -->
</table>
</body>
</html>
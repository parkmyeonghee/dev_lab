<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    String u_menu=request.getParameter("menu");
    %>
<html>
<head>
<script type="text/javascript" src="../js/commons.js"></script>
  <script type="text/javascript">
  var g_id="haha";//��������(head�±׳� ��ũ��Ʈ �ڵ�ȿ��� ����)
function popupView(){
	console.log("popupȣ�� ����");//������Ҷ� ���¾���(ũ�ҿ���)���̷��� ����
	url="./login.html"; //js���Ͽ� �־��� ������ ȣ�����ش�.
	popupwidth="600";//��������
	popupheight="400";
	popupname="login";
	//�ڹٽ�ũ��Ʈ������ ���� ǥ���Ҷ��� �ݵ�� ""�� �ٿ��� �Ѵ�.
	//�׷��� ������ ��������Ѵ�.
	cmm_window_popup(url,popupwidth,popupheight,popupname);
}
</script>
<title>index.jsp</title>
</head>
<body > 
<table width="50%" border="0" height="60%"><!-- �ȼ��� �� �� �ְ� %�ΰ��� 960  -->
<!-- ====================menutop.jsp ����================== -->
<tr height="10%">
<td colspan="2" >
<%@ include file="menutop.jsp" %><!-- ��Ŭ�����̼� -->
</td>
</tr>
<!-- ===============menutop.jsp��====================== -->
<!-- =================top.jsp����====================== -->
<tr height="15%">
<td colspan="2" height="15%">
<%@ include file="top.jsp" %>
</td>
</tr>
<!-- ==================body.jsp����========================= -->
<tr height="75%">
<!-- =================menu.jsp����====================== -->
<td width="20%" height="75%">
<%@ include file="menu.jsp" %>
</td>
<!-- =================menu.jsp��====================== -->
<!-- =================main.jsp����====================== -->
<td width="80%">
<%@ include file="main.jsp" %>
</td>
</tr>
<!-- =================main.jsp��====================== -->
</table>
</body>
</html>
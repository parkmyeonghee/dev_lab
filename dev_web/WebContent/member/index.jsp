<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.net.URLDecoder" %>
    <%
    String cname=null;//�������� ����pc�� �����ص� ��Ű�������� �о�� ����� �̸��� ���� ����
    Cookie[] cookies=request.getCookies();
    if(cookies !=null && cookies.length>0){
    	for(int i=0;i<cookies.length;i++){
    		if("cname".equals(cookies[i].getName())){
    			cname=URLDecoder.decode(cookies[i].getValue(),"utf-8");
    		}
    	}
    }
    out.print("��Ű�� ���� �̸�:"+cname);
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript"  src="/js/jquery-1.11.1.js"></script>
<title>�α���(��Ű�ǽ�)</title>
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
	//���̵� �ؽ�Ʈ Ŭ������ ��
	$("#imem_id").click(function(){
		$("#imem_id").val("");
	});
	//��� �ؽ�Ʈ Ŭ������ ��
	$("#imem_pw").click(function(){
		$("#imem_pw").val("");
		$("#imem_pw").attr("password");
	});
	//�α��� ��ư Ŭ������ ��
	$("#btn_login").click(function(){
		$("#f_login").attr("method","get");
		$("#f_login").attr("action","./login.mfc");
		$("#f_login").submit();
	});
	//�α׾ƿ� ��ư Ŭ������ ��
	$("#btn_logout").click(function(){
		$("#f_logout").attr("method","get");
		$("#f_logout").attr("action","./logout.mfc");
		$("#f_logout").submit();//���� index.jsp-->MemberFrontController(doService:logout.mfc�ĺ�)
	});
});
</script>
<!--ȭ���� �� �� �ʿ��Դ�(�α���ȭ��,�������� �� ȭ��) -->
<%
//�α��� �ϱ� �� ȭ��
//��Ű���� �о�� �̸��� ����?
if(cname==null){
%>
<form id="f_login">
<table width="200" height="80" border="1" bordercolor="orange">
<tr>
<td colspan="2">�α���</td>
</tr>
<tr>
<td>
<input type="text" name="mem_id"  id="imem_id" value="���̵�" >
</td>
<td rowspan="2">
<input type="button" id="btn_login" value="�α���">
</td>
</tr>
<tr>
<td>
<input type="password" name="mem_pw"  id="imem_pw" value="��й�ȣ" >
</td>
</tr>
<tr>
<td colspan="2" align="center">ȸ������</td>
</tr>
</table>
</form>
<%
}
//�α��� �� ȭ��
else{
%>
<form id="f_logout">
<table width="250" height="80" border="1" bordercolor="green">
<tr>
<td colspan="2" align="center">�α���</td>
</tr>
<tr>
<td width="170">
<%=cname %>�� ȯ���մϴ�.
</td>
<td width="80" align="center">
<input type="button" id="btn_logout" value="�α׾ƿ�" >
</td>
</tr>
<tr>
<td colspan="2" align="center">��������|ȸ��Ż��</td>
</tr>
</table>
</form>
<%
}
%>
</body>
</html>
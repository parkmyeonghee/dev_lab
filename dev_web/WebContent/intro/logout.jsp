<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.net.URLDecoder" %>       
<%
	String cname = null;





	String sname = (String) session.getAttribute("sname");
	//��Ű ���� �о����
	Cookie cookies[] = request.getCookies();
		for(int i=0;i<cookies.length;i++){
			//out.print(cookies[i].getName());
			if("cname".equals(cookies[i].getName())){
				cname = URLDecoder.decode(cookies[i].getValue(),"utf-8");
				out.print("cname:"+cname);
			}
		}
%>
<script type="text/javascript" src="/js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	function logout(){
		$.ajax({
			type:"get"
		  , url:"./logout.mem"
		  , success:function(result){
			  $("#d_menu").html("");
		  	  $("#d_login").html(result);
		  }
		  , error:function(e){
			  $("#d_login").text(e.responseText);
		  } 
		});////// end of ajax		
	}////////////end of logout
</script>    
<!--================== �α׾ƿ� �� ȭ�� ���� =====================-->
<table width="250" height="80" border="1" borderColor="green">
	<tr>
		<td colspan="2">�α���</td>
	</tr>
	<tr>
		<td width="170">
		<%=sname %>�� ȯ���մϴ�.
		</td>
		<td width="80" align="center">
			<input type="button" value="�α׾ƿ�" onClick="logout()">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<a href="./getMemberList.mem">ȸ����� | </a> ��������|ȸ��Ż��</td>
	</tr>
</table>					
<!--================== �α׾ƿ� �� ȭ��  �� =====================-->	
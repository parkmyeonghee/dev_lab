<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@page import="java.net.URLDecoder"%>
    	<% String cname= null;
	//���� pc�� �ؽ�Ʈ ���·� ����Ǿ� �ִ� ����ڿ� ���� ������ ������ ��û�ؼ� ���� �Ŀ�  ȭ��ó���ϱ�
	//��Ű ���� �о����
	Cookie cookies[] = request.getCookies(); //�޼ҵ� ã���� respones4
	for(int i=0; i<cookies.length;i++){
		out.print(cookies[i].getName());
		if("cname".equals(cookies[i].getName())){
			cname=URLDecoder.decode(cookies[i].getValue(),"utf-8");
			out.print("cname : "+cname);
		}else{
			out.print(cookies[i].getValue());
		}
	}
	%>
<table width="250" height="80" border="1" borderColor="green">
	<tr>
		<td colspan="2">�α���</td>
	</tr>
	<tr>
		<td width="170"><%=cname %>�� ȯ���մϴ�.</td>
		<td width="80" align="center"><input type="button" value="�α׾ƿ�"
			onClick="logout()"></td>
	</tr>
	<tr>
		<td colspan="2" align="center">��������|ȸ��Ż��</td>
	</tr>
</table>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import ="com.pizza.CustomerInfo" %>
    <%
    String u_tel=request.getParameter("h_tel");
    String u_order=request.getParameter("order");
	CustomerInfo cInfo = new CustomerInfo();
	cInfo.init();
	String getAddr="";
	String getName="";
	for(int i=0;i<cInfo.cVOs.length;i++){
		if(cInfo.cVOs[i].getTel().equals(u_tel)){//��ȭ��ȣ�� ����?
			getAddr=cInfo.cVOs[i].getAddress();
			getName=cInfo.cVOs[i].getName();
		}
	}
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="../../css/boards.css">
<title><%=getName %>���� �ֹ�����</title>
</head>
<body>
<table border="1" width="500" height="200">
	<thead><%=getName %>�� �ֹ���</thead>
	<tr>
		<th width="120">����</th>
		<td>&nbsp; <%=getName%></td>
	</tr>
	<tr>
		<th width="120">����ó</th>
		<td>&nbsp;<%=u_tel%></td>
	</tr>	
	<tr>
		<th width="120">�ֹ�����</th>
		<td>&nbsp;<%=u_order%></td>
	</tr>	
	<tr>
		<th width="120">�����</th>
		<td>&nbsp; <%=getAddr%></td>
	</tr>			
</table>
</body>
</html>
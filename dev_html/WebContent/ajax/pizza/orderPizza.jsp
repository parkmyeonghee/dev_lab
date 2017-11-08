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
		if(cInfo.cVOs[i].getTel().equals(u_tel)){//전화번호가 같니?
			getAddr=cInfo.cVOs[i].getAddress();
			getName=cInfo.cVOs[i].getName();
		}
	}
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="../../css/boards.css">
<title><%=getName %>님의 주문내역</title>
</head>
<body>
<table border="1" width="500" height="200">
	<thead><%=getName %>님 주문서</thead>
	<tr>
		<th width="120">고객명</th>
		<td>&nbsp; <%=getName%></td>
	</tr>
	<tr>
		<th width="120">연락처</th>
		<td>&nbsp;<%=u_tel%></td>
	</tr>	
	<tr>
		<th width="120">주문내용</th>
		<td>&nbsp;<%=u_order%></td>
	</tr>	
	<tr>
		<th width="120">배송지</th>
		<td>&nbsp; <%=getAddr%></td>
	</tr>			
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.util.List,java.util.HashMap" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���������</title>
</head>
<body>
<%
//�������� ������ ��ü�� ȭ��ܿ��� ����ϰ� ���� ��
	List<HashMap<String,Object>> list= 
	(List<HashMap<String,Object>>)request.getAttribute("list");
	out.print(list.getClass().getName());
	if(list!=null){
		HashMap<String,Object>pMap=list.get(0);
		Object obj[]=pMap.keySet().toArray();//mem_id,mem_pw,mem_name
		for(Object key:obj){
			out.print(pMap.get(key));
			}
	}
%>
</body>
</html>
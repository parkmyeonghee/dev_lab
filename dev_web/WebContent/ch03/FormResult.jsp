<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.util.Map" %>
    <%
    Map<String,Object>pMap=(Map)request.getAttribute("pMap");
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>form.jsp���� �Է¹��� ���� ����ϱ�</title>
</head>
<body>
����ڰ� ȭ�鿡�� �Է��� �� ����ϱ�<br>
<%
Object keys[]=pMap.keySet().toArray();
for(int i=0;i<keys.length;i++){
	String key = (String)keys[i];
	if("name".equals(key)){
		out.print("�̸�:"+pMap.get(key));
		out.print("<br>");
	}
	else if("address".equals(key)){
		out.print("�ּ�:"+pMap.get(key));
		out.print("<br>");
	}
	else if("dog".equals(key)){
		out.print("�����ϴ� ����:"+pMap.get(key));
		out.print("<br>");
	}
	else if("cat".equals(key)){
		out.print("�����ϴ� ����:"+pMap.get(key));
		out.print("<br>");
	}
	else if("pig".equals(key)){
		out.print("�����ϴ� ����:"+pMap.get(key));
		out.print("<br>");
	}
}

%>
</body>
</html>
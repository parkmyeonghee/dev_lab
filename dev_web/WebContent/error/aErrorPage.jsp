<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page isErrorPage="true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� �߻�������</title>
</head>
<body>
	��û ó�� �������� ������ �߻��Ͽ����ϴ�.<br>
	���� �ð� ���� ������ �ذ��ϰڽ��ϴ�.
	���� Ÿ��:<%=exception.getClass().getName() %>
	���� �޽���:<%=exception.getMessage() %>
	<%
	//getclass,toString,equals ===>Object���� �����ϴµ� ���־��̴� ģ���� 
	if(exception.getClass()==NullPointerException.class){ //getclass Ŭ����:Ÿ���� ���Ҷ�
		out.print("NullPointerException �߻�");
	}else
	{
		out.print("�׿� �߻�");
	}
	%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<% //��ũ��Ʋ��
//�ѱ� ó���� POST��İ� GET����� �ִ�
//POST��� :request.setCharacterEncoding("euc-kr")
//get����϶��� url�� query string���� �Ѿ� ���Ƿ� url�� �̿��ؼ� ������ ����
//server.xml�������� URIEncoding =euc-kr����
	String u_name=request.getParameter("mem_name");
	out.print("����ڰ� �Է��� �̸�:"+u_name);
%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>start.jsp������</title>
</head>
<body>
<%
String  name = "�̼���";
String date ="2016-12-26";
String goods="�źϼ�";
request.setAttribute("name", name);
request.setAttribute("date", date);
request.setAttribute("goods", goods);
//���ǿ� ������ ��� ���ô�. - ����� �ð���������
session.setAttribute("name2", "������");
session.setAttribute("date2", "2016-12-25��");
session.setAttribute("goods2", "�尩");
//application
application.setAttribute("name3", "������");
application.setAttribute("date3", "2016-12-24");
application.setAttribute("goods3", "�񵵸�");
//url�� ������ �ʽ��ϴ�.
/* RequestDispatcher view = request.getRequestDispatcher("end.jsp");
view.forward(request,response); */
//url�� �ٲ�ϴ�. - ��û�̲������� ���ο� ��û�� �����ϴ�.
response.sendRedirect("end.jsp");
%>
</body>
</html>
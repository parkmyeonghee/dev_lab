<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.net.URLEncoder" %>
    <%@page import="java.net.URLDecoder" %>
    <%
    //��Ű�� �������� ������ ���� ���� �ִ�.
    //���� ���� ���谡 ���� ������ ���� ��Ű���� ����� �� �ִ�.
    Cookie cookie = new Cookie("mem_id","test");
    response.addCookie(cookie);
    Cookie cName = new Cookie("mem_name"
    									,URLEncoder.encode("�̼���","utf-8"));
    response.addCookie(cName);
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��Ű����</title>
</head>
<body>
<%="��Ű�̸�:"+cookie.getName() %><!--mem_id  -->
<br>
<%="��Ű��:"+cookie.getValue() %><!--test  -->
<hr>
<%="��Ű�̸�:"+cName.getName() %><!--mem_id  -->
<br>
<%="��Ű��:"+URLDecoder.decode(cName.getValue(),"utf-8")%><!--test  -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
//���̹�Ƽ������ ȣ���� ���ν��� ��� �޽��� ����ϱ�
String msg =(String)request.getAttribute("msg");
out.print("�޿� �λ� ��� ó�� �޼���"+msg);
%>
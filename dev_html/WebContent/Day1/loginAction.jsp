<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="com.util.HangulConversion" %>
   <%
   //post������� ���۽� �ѱ� ó���� �� ������������ �Ʒ��ڵ� �߰�
   request.setCharacterEncoding("euc-kr");
   String mem_id=
	HangulConversion.toKor(request.getParameter("mem_id"));
   String mem_pw=request.getParameter("mem_pw");
   String mem_name=request.getParameter("name");
   out.print("���̵�:"+"<b>"+mem_id+"</b>");
   out.print("<br>");
   out.print("��й�ȣ:"+"<h2>"+mem_pw+"</h2>");
   out.print("<br>");
   out.print("�̸�:"+mem_name);
   %>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="com.google.gson.Gson" %>
    <%@page import="java.util.List,com.vo.BookVO" %>
<%
//�������� ��ȸ�� ����� ��������
List<BookVO> bookList = (List<BookVO>)request.getAttribute("bookList");
//List ->json���˺�ȯ(���)
	Gson g = new Gson();
	String jsonBook =g.toJson(bookList);
	out.print(jsonBook); //Ŭ���̾�Ʈ �� �ٿ�ε�(���������� ���� �� �ִ�.-easyUI/datagrid)
	
%>
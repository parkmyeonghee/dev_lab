<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String u_msg=request.getParameter("msg");
	out.print(u_msg); //내가 적은 메세지가 이 페이지에서 출력이 된다.
%>
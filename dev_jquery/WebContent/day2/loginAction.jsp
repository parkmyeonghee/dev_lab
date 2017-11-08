<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String db_id="test";
	String db_pw="123";
	String mem_id=request.getParameter("mem_id");
	String mem_pw=request.getParameter("mem_pw");
	if(db_id.equals(mem_id)&&db_pw.equals(mem_pw)){
		session.setAttribute("mem_name", "½Ã¿À¹Ö");
		response.sendRedirect("./index.jsp");
	}
%>
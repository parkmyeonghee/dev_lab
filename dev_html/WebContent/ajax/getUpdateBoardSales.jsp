<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");//pot방식 한글처리
	//<input type="text" name="mem_id" id=imem_id size="10">
	//var url="./getUpdateBoardSales.jsp?mem_id"+u_memid+"&time="+new Date().getTime();
	String u_memid=request.getParameter("mem_id");//ajax
	String u_memname=request.getParameter("mem_name");//form
	out.print("1200"+u_memid+",name"+u_memname);
%>
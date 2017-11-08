<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="com.util.HangulConversion" %>
   <%
   //post방식으로 전송시 한글 처리할 때 서버페이지에 아래코드 추가
   request.setCharacterEncoding("euc-kr");
   String mem_id=
	HangulConversion.toKor(request.getParameter("mem_id"));
   String mem_pw=request.getParameter("mem_pw");
   String mem_name=request.getParameter("name");
   out.print("아이디:"+"<b>"+mem_id+"</b>");
   out.print("<br>");
   out.print("비밀번호:"+"<h2>"+mem_pw+"</h2>");
   out.print("<br>");
   out.print("이름:"+mem_name);
   %>

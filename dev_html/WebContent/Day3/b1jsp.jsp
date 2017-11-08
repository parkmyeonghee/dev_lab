<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% //½ºÅ©¸³Æ²¸´
//http://192.168.0.46:9000/day3/b1jsp.jsp?mem_pw=123
String u_pw=request.getParameter("mem_pw");
out.print("<font size='20' color='red'>"+u_pw+"</font>");
%>
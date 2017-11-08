<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
//마이바티스에서 호출한 프로시저 결과 메시지 출력하기
String msg =(String)request.getAttribute("msg");
out.print("급여 인상 결과 처리 메세지"+msg);
%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.util.List" %>
<%
List<String> insaBean =(List<String>)request.getAttribute("insaBean");
for(String insa:insaBean){
	out.print(insa+"<br>");
}
%>
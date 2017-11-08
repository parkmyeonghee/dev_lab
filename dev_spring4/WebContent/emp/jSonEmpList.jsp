<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.List,com.vo.EmpVO"%>
<%@page import="com.google.gson.Gson"%>
<%
	List<EmpVO> empList=(List<EmpVO>)request.getAttribute("empList");
	Gson g = new Gson();
	String jsonEmp = g.toJson(empList);
	out.print(jsonEmp);
	%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.List,com.vo.DeptVO,java.util.HashMap"%>
<%@page import="com.google.gson.Gson"%>
<%
List<HashMap<String,Object>>deptList=
(List<HashMap<String,Object>>)request.getAttribute("deptList");
Gson g=  new Gson();
String jsonDept=g.toJson(deptList);
out.print(jsonDept);
%>
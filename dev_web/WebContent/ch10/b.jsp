<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.util.Map,java.util.HashMap" %>
    <%
    //Map<String,Object>pMap = new HashMap<String,Object>();
   Map<String,Object>pMap =(Map<String,Object>)session.getAttribute("pMap");
   out.print(pMap.get("name"));
   if(pMap.containsKey("name")){
	   out.print("�ִ�");
	   out.print("�̸�:"+pMap.get("name")+"�ڵ�����ȣ:"+pMap.get("hp"));
   }
   else{
	   out.print("����");
   }
   Map<String,Object>rpMap=(Map<String,Object>)request.getAttribute("rpMap");
   if(rpMap!=null){
	   out.print("�ִ�");
	   out.print("�̸�:"+pMap.get("name")+"�ڵ�����ȣ:"+pMap.get("hp"));
   }
   else{
	   out.print("����");
   }
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>b.jsp(����������)</title>
</head>
<body>
�̸�:
�ڵ���:
</body>
</html>
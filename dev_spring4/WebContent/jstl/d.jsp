<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.Map,java.util.HashMap" %>
    <%@page import="com.vo.DeptVO" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@page import="java.util.List,java.util.ArrayList" %>
     <%
     List<Map<String,Object>>jstl_map=new ArrayList<Map<String,Object>>();
     Map<String,Object>dMap= new HashMap<String,Object>();
     dMap.put("deptno",10);
     dMap.put("dename","�λ��");
     dMap.put("loc","��õ");
     jstl_map.add(dMap);
     %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:if test="true">
</c:if>
<c:if test="${Map.dMap==deptno}"/>

</body>
</html>
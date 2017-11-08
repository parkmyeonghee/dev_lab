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
     dMap.put("dename","인사부");
     dMap.put("loc","인천");
     jstl_map.add(dMap);
     %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%=dMap.get("deptno") %>
<c:if test="true">
<c:set var="dmap" value="<%=dMap %>"/>
</c:if>
<table border="1" borderColor="pink">
<tr>
<th>부서번호</th>
<th>부서명</th>
<th>지역</th>
</tr>
<tr>
<c:forEach var="map" items="${dmap}">
<td>${map.key}-${map.value}</td>
</c:forEach>
</tr>
<tr>
<td><c:if test="${map.=='deptno'}"></c:if></td>
</tr>
</table>
</body>
</html>
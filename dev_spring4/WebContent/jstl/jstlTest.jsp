<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.util.List,java.util.ArrayList" %>
    <%@page import="com.vo.DeptVO" %>
    <!--
    jstl과 UI솔루션 차이점
    jstl이 화면에 대한 콤퍼넌트를 지원하지 않는다.
    jstl은 자바의 컬렉션 프레임워크를 직접 받을 수 있다.
    jstl은 자바코드도 직접 활용할 수 있다.
    UI솔루션은 화면에 대한 다양한 콤포넌트를 별도로 지원한다.
    (html보다 훨씬 더 많이,,,)
    UI솔루션은 자바의 컬렉션 프레임워크를 받아 줄 별도의 포멧이 필요하다.
    (dataset지원,json)
      -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>사용자 정의 태그라이브러리 실습</title>
</head>
<body>
<jsp:useBean id="a" scope="page" class="com.mvc.BoardController"/>
<c:set var="jstl_name" scope="request" value="이순신"/>
이름:${jstl_name}
<%
String str_name=new String("이순신");
request.setAttribute("str_name",str_name);
out.print(str_name);
List<String> nameList=new ArrayList<String>();
nameList.add("이홍빈");
nameList.add("차학연");
nameList.add("정택운");
List<DeptVO>deptList=new ArrayList<DeptVO>();
DeptVO dVO = new DeptVO();
dVO.setDeptno(10);
dVO.setDname("인사부");
dVO.setLoc("인천");
deptList.add(dVO);
dVO= new DeptVO();
dVO.setDeptno(20);
dVO.setDname("총무부");
dVO.setLoc("부산");
deptList.add(dVO);
dVO= new DeptVO();
dVO.setDeptno(30);
dVO.setDname("공사부");
dVO.setLoc("포항");
deptList.add(dVO);

%>
<c:set var="jstl_nameList" scope="request" value="<%=nameList %>"/>
<table>
<tr>
<th>이름</th>
</tr>
<c:forEach var="names" items="${jstl_nameList}">
<tr>
<td>${names}</td>
</tr>
</c:forEach>
</table>
<c:set var="jstl_deptList" scope="request" value="<%=deptList%>"/>
<table border="1" borderColor="pink">
<tr>
<th>부서번호</th>
<th>부서명</th>
<th>지역</th>
</tr>
<c:forEach var="dVO" items="${jstl_deptList}" varStatus="status">
<tr>
<td>${dVO.deptno}</td>
<td>${dVO.dname}</td>
<td>${dVO.loc}</td>
</tr>
</c:forEach>
</table>
<table border="1" borderColor="blue">
<tr>
<th>부서번호</th>
<th>부서명</th>
<th>지역</th>
</tr>
<c:forEach var="dVO" items="${jstl_deptList}">
<tr>
<td><%=dVO.getDeptno()%></td>
<td><%=dVO.getDname() %></td>
<td><%=dVO.getLoc() %></td>
</tr>
</c:forEach>
</table>
<!--인덱스로는 접근불가  -->
<table border="1" borderColor="green">
<tr>
<th>부서번호</th>
<th>부서명</th>
<th>지역</th>
</tr>
<c:forEach var="dVO" items="${jstl_deptList}">
<tr>
<td>${dVO[0]}</td>
<td>${dVO[1]}</td>
<td>${dVO[2]}</td>
</tr>
</c:forEach>
</table>
</body>
</html>
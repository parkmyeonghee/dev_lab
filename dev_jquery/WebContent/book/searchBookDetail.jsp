<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="com.vo.BookVO,java.util.List" %>
    <%
    List<BookVO> bookList =(List<BookVO>)request.getAttribute("bookList");
    //조회결과는 무조건 한 건이어야 합니다.
    BookVO bVO =bookList.get(0);
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="300">
<tr>
<!--선택한 도서의 이미지 정보  -->
<td width="100">
<img src="../images/a.png" width="80" height="130">
</td>
<!--선택한 도서의 가격,저자,출판사 정보 등등  -->
<td width="200" valign="top">
<table width="100%" border="1">
<tr>
<td>저자:<%=bVO.getAb_author() %></td>
</tr>
<tr>
<td>출판사:<%=bVO.getAb_publisher() %></td>
</tr>
<tr>
<td>가격:<%=bVO.getAb_publisher() %></td>
</tr>
</table>
</td>
</tr>
</table>
</body>
</html>
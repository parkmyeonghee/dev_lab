<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="com.vo.BookVO,java.util.List" %>
    <%
    List<BookVO> bookList =(List<BookVO>)request.getAttribute("bookList");
    //��ȸ����� ������ �� ���̾�� �մϴ�.
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
<!--������ ������ �̹��� ����  -->
<td width="100">
<img src="../images/a.png" width="80" height="130">
</td>
<!--������ ������ ����,����,���ǻ� ���� ���  -->
<td width="200" valign="top">
<table width="100%" border="1">
<tr>
<td>����:<%=bVO.getAb_author() %></td>
</tr>
<tr>
<td>���ǻ�:<%=bVO.getAb_publisher() %></td>
</tr>
<tr>
<td>����:<%=bVO.getAb_publisher() %></td>
</tr>
</table>
</td>
</tr>
</table>
</body>
</html>
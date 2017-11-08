<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.vo.BookVO,java.util.List" %>
<%
List<BookVO>bookList =(List<BookVO>)request.getAttribute("bookList");
int size =0;
if(bookList!=null){
	size =bookList.size();
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="500">
<tr>
<!--검색한 도서 제목 시작(db에서)  -->
<td width="200">
<table border="1" width="100%">
<%
for(int i=0;i<3;i++){
	BookVO bVO = bookList.get(i); //bookList안에 BookVO:Controller있음
%>
<tr>
<td onClick="setTitle('<%=bVO.getAb_title() %>')" 
onmouseover="titleChoice(this,'<%=bVO.getAb_no()%>','<%=bVO.getAb_title() %>')"
onmouseout="titleCancel()">도서제목</td>
</tr>
<%
}
%>
</table>
</td>
<!--검색한 도서 제목 끝  -->
<!--도서 상세 정보 시작  -->
<td width="300"><div id="d_bookDetail"></div></td>
<!--도서 상세 정보 끝  -->
</tr>
<tr>
<td colspan="2" align="right">
<a href="javascriptvoid(0)">닫기</a>
</td>
</tr>

</table>
</body>
</html>
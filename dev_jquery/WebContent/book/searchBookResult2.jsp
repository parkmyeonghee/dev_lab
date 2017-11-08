<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.List,com.vo.BookVO" %>
<table border="1">
<%List<BookVO> bookList = (List<BookVO>)request.getAttribute("bookList"); 
BookVO bVO = null;
if(bookList!=null){
for(int i =0;i<bookList.size();i++){
 BookVO rbVO = bookList.get(i);
%>
<tr>
<td><%=rbVO.getAb_title()%></td>
</tr>
<%
}
}
else{

%>

<tr>
<td>검색 결과가 없습니다.</td>
</tr>

<%
}
%>

</table>
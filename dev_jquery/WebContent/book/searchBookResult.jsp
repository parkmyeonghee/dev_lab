<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, com.vo.BookVO, java.util.ArrayList" %>    
<table> 
<%
	List<BookVO> bookList = (List<BookVO>)request.getAttribute("bookList");
	//검색결과가 있니?
	if(bookList !=null){
		for(int i=0;i<bookList.size();i++){//null체크를 안했을 경우 여기서 NullPointerException
			BookVO rbVO = bookList.get(i);
%>
	<tr>
		<td width="200"><%=rbVO.getAb_title() %></td>
	</tr>
<%
		}//////////end of for
	}/////////////end of if
	else{
%>	
	<tr>
		<td>검색결과가 없습니다.</td>
	</tr>
<%
	}////////////end of else
%>
</table>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, com.vo.BookVO, java.util.ArrayList" %>    
<table> 
<%
	List<BookVO> bookList = (List<BookVO>)request.getAttribute("bookList");
	//�˻������ �ִ�?
	if(bookList !=null){
		for(int i=0;i<bookList.size();i++){//nullüũ�� ������ ��� ���⼭ NullPointerException
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
		<td>�˻������ �����ϴ�.</td>
	</tr>
<%
	}////////////end of else
%>
</table>
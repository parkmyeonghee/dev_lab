<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.List,com.vo.WordVO" %>
<table border="1">
<%List<WordVO> wordList = (List<WordVO>)request.getAttribute("wordList"); 
WordVO wVO = null;
if(wordList!=null){
for(int i =0;i<wordList.size();i++){
 WordVO rwVO = wordList.get(i);
%>
<tr>
<td><%=rwVO.getW_word() %></td>
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
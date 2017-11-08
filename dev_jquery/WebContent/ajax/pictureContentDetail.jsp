<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@page import="java.util.List,com.vo.PictureVO" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1" borderColor="pink" width="400px">
<%
List<PictureVO>picDetail=
(List<PictureVO>)request.getAttribute("picDetail");
int size=0;
PictureVO pVO=null;
if(request.getAttribute("picDetail")!=null){
	size=picDetail.size();
	pVO =picDetail.get(0);
}
%>
<tr>
<td width="200px"><%=pVO.getContent() %></td>
<td width="200px"><img src="../images/<%=pVO.getImgFile()%>" width="200"
height="120"/></td>
</tr>
<tr>
<td colspan="2" align="right">
<input type="button" value="닫기" onClick="subClose()">
</td>
</tr>
</table>
</body>
</html>
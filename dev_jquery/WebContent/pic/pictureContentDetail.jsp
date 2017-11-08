<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, com.vo.PictureVO" %>    
<%
	List<PictureVO> picList = 
		(List<PictureVO>)request.getAttribute("picList");
	int size = 0;
	PictureVO rVO = null;
	if(request.getAttribute("picList")!=null){
		size = picList.size();
		rVO = picList.get(0);
	}
%>   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border="1" borderColor="orange" width="400px">
	<tr>
		<td  width="200px"><%=rVO.getContent()%></td>
		<td width="200px"><img src="../images/<%=rVO.getImgFile() %>" width="200" height="120"/></td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<input type="button" value="닫기" onClick="subClose()">
		</td>
	</tr>
</table>
</body>
</html>
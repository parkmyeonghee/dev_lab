<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    //�ÿ��� -request ,����-parameter
    //null
    String mem_name=null;
    if(request.getParameter("mem_name")!=null){
    	mem_name=request.getParameter("mem_name");
    }
    else if(request.getAttribute("rmem_name") !=null){
    	mem_name=(String)request.getAttribute("rmem_name");
    }
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table width="100%" height="100%" border="1" bordercolor="green">
<tr>
<td align="center"> ����������(<%=mem_name %>)</td>
</tr>

</table>
</body>
</html>
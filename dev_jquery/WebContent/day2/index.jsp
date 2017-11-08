<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
  	String s_mem_name=(String)session.getAttribute("mem_name");
    out.print("세션정보:"+s_mem_name);
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/dev_jquery/js/jquery-1.11.1.js"></script>
</head>
<body>
<table width="800" height="600" align="center">
<tr>
<td width="800" height="100">
<jsp:include page="./top.jsp" flush="false"/>
<%-- <jsp:param value="test" name="mem_id"/>
<jsp:param value="123" name="mem_pw"/> --%>
<!-- top.jsp영역 -->
</td>
</tr>
<tr>
<td width="800" height="450">
<jsp:include page="./main.jsp" flush="false"/>
<!--main.jsp영역  -->
</td>
</tr>
<tr>
<td width="800" height="50">
<jsp:include page="./bottom.jsp" flush="false"/>
<!--bottom.jsp영역  -->
</td>
</tr>
</table>
</body>
</html>
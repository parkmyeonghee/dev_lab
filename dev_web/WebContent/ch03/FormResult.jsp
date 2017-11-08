<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.util.Map" %>
    <%
    Map<String,Object>pMap=(Map)request.getAttribute("pMap");
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<title>form.jsp에서 입력받은 정보 출력하기</title>
</head>
<body>
사용자가 화면에서 입력한 값 출력하기<br>
<%
Object keys[]=pMap.keySet().toArray();
for(int i=0;i<keys.length;i++){
	String key = (String)keys[i];
	if("name".equals(key)){
		out.print("이름:"+pMap.get(key));
		out.print("<br>");
	}
	else if("address".equals(key)){
		out.print("주소:"+pMap.get(key));
		out.print("<br>");
	}
	else if("dog".equals(key)){
		out.print("좋아하는 동물:"+pMap.get(key));
		out.print("<br>");
	}
	else if("cat".equals(key)){
		out.print("좋아하는 동물:"+pMap.get(key));
		out.print("<br>");
	}
	else if("pig".equals(key)){
		out.print("좋아하는 동물:"+pMap.get(key));
		out.print("<br>");
	}
}

%>
</body>
</html>
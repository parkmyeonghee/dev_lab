<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%
   int first=Integer.parseInt(request.getParameter("first"));
   int second=Integer.parseInt(request.getParameter("second"));
   out.print(first+","+second);
   //out.print(${param.first});
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
두 수의 곱은:${param.first*param.second}
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import ="com.vo.DeptVO" %>
    <%
    //request.getParameter(String):String-HttpServletRequest 타입이 더 크니까 형전환
   // DeptVo dvo = request.getParameter("dvo");
   // getAttribute(String):Object-HttpServletRequest
    DeptVO dvo =(DeptVO)request.getAttribute("dvo");
    DeptVO dvo2 =(DeptVO)request.getAttribute("dvo2");
   
    %>
    <%=dvo.getDeptno() %> <!--  과연 10이 출력? 0? nullpoint? -->
    <%
    out.print("<br>");
    %>
    <%=dvo2.getDeptno() %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>b.jsp페이지 입니다.</title>
</head>
<body>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import ="com.vo.DeptVO" %>
    <%
    //request.getParameter(String):String-HttpServletRequest Ÿ���� �� ũ�ϱ� ����ȯ
   // DeptVo dvo = request.getParameter("dvo");
   // getAttribute(String):Object-HttpServletRequest
    DeptVO dvo =(DeptVO)request.getAttribute("dvo");
    DeptVO dvo2 =(DeptVO)request.getAttribute("dvo2");
   
    %>
    <%=dvo.getDeptno() %> <!--  ���� 10�� ���? 0? nullpoint? -->
    <%
    out.print("<br>");
    %>
    <%=dvo2.getDeptno() %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>b.jsp������ �Դϴ�.</title>
</head>
<body>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="com.vo.DeptVO" %>
   <jsp:useBean id="dvo2" scope="request" class="com.vo.DeptVO"/>
   <%
 	DeptVO dvo = new DeptVO();
   dvo2.setDeptno(20);
   dvo2.setDname("총무");
   dvo2.setLoc("총무");
 	dvo.setDeptno(10);
 	dvo.setDname("영업");
 	dvo.setLoc("서울");
 	request.setAttribute("dvo",dvo);
 	//get방식으로는 주소번지를 넘길 수 있다 없다?
 	//response.sendRedirect("b.jsp?dvo="+dvo);//페이지 이동
 	//response.sendRedirect("b.jsp);
 	//직접인스턴스화 했을 떄 혹은 액션태그를 사용했을 때
 	//sendRedirect로 페이지 이동처리 하면 값을 유지 할 수 없다.
 	//페이지를 forward처리 했을 때는 값을 유지할 수 있다.
 	//차이점
 	//직접인스턴스화 했을 때는 요청객체에 주소번지를 따로 담아 주어야 해당객체를 사용할 수 있다.
 	//액션태그를 사용했을 때는 따로 담아주지 않아도
 	//포워드된 페이지에서 해당 객체를 사용할 수 있다.
 	//scope속성을 session이나 application으로 지정했을 경우에는 
 	//sendRedirect나 forward나 상관없이 유지할 수 있다.
 	RequestDispatcher view =
 			request.getRequestDispatcher("b.jsp");
 	view.forward(request,response);
 	String name ="이순신";
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>a.jsp페이지 입니다.</title>
</head>
<body>

</body>
</html>
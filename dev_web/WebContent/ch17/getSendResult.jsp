<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.ch7.Sonata"%>
<%@page import="com.mvc.address.AddressBook" %>
<%@page import="com.ch7.Duck" %>
<%@page import="java.util.List,java.util.ArrayList,com.vo.DeptVo" %>
<html>
<head>
<title>나는 TestSendServlet</title>
</head>
<body>
<%
	String mem_id=request.getParameter("mem_id");
	out.print(mem_id);
	//만일 유지되지 않고 있다면 Sonata myCar=null;
	Sonata myCar= (Sonata)request.getAttribute("myCar");//타입을 맞춰주어야 한다.
	String r_name=(String)request.getAttribute("r_name");
	out.print("소나타 속도:"+myCar.speed);
	out.print("<br>");
	out.print("이름"+r_name);
	AddressBook abook =(AddressBook)request.getAttribute("abook");
	abook.initDisplay();
	out.print("<br>");
	Duck myDuck = (Duck)request.getAttribute("myDuck");
	
	List<DeptVo>deptList=(List<DeptVo>)request.getAttribute("deptList");
%>
<table border="1"  width="300">
<!--header시작-->
<tr>
<th>부서번호</th>
<th>부서명</th>
<th>지역</th>
<!--header끝-->
<!--목록 시작-->
<%
//자바코드를 작성하는곳
//스클립틀릿 - 변수선언,메소드 호출, 인스턴스화,제어문
for(int i=0;i<deptList.size();i++){
	DeptVo dvo = deptList.get(i);
%>
<tr>
<td><%out.print(dvo.getDeptno()); %></td>
<td><%out.print(dvo.getDname()); %></td>
<td><%out.print(dvo.getLoc()); %></td>
</tr>
<%
}/////////end of for
%>
<!--목록 끝-->
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.ch7.Sonata"%>
<%@page import="com.mvc.address.AddressBook" %>
<%@page import="com.ch7.Duck" %>
<%@page import="java.util.List,java.util.ArrayList,com.vo.DeptVo" %>
<html>
<head>
<title>���� TestSendServlet</title>
</head>
<body>
<%
	String mem_id=request.getParameter("mem_id");
	out.print(mem_id);
	//���� �������� �ʰ� �ִٸ� Sonata myCar=null;
	Sonata myCar= (Sonata)request.getAttribute("myCar");//Ÿ���� �����־�� �Ѵ�.
	String r_name=(String)request.getAttribute("r_name");
	out.print("�ҳ�Ÿ �ӵ�:"+myCar.speed);
	out.print("<br>");
	out.print("�̸�"+r_name);
	AddressBook abook =(AddressBook)request.getAttribute("abook");
	abook.initDisplay();
	out.print("<br>");
	Duck myDuck = (Duck)request.getAttribute("myDuck");
	
	List<DeptVo>deptList=(List<DeptVo>)request.getAttribute("deptList");
%>
<table border="1"  width="300">
<!--header����-->
<tr>
<th>�μ���ȣ</th>
<th>�μ���</th>
<th>����</th>
<!--header��-->
<!--��� ����-->
<%
//�ڹ��ڵ带 �ۼ��ϴ°�
//��Ŭ��Ʋ�� - ��������,�޼ҵ� ȣ��, �ν��Ͻ�ȭ,���
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
<!--��� ��-->
</table>
</body>
</html>
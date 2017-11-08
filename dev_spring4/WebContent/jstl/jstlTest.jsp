<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.util.List,java.util.ArrayList" %>
    <%@page import="com.vo.DeptVO" %>
    <!--
    jstl�� UI�ַ�� ������
    jstl�� ȭ�鿡 ���� ���۳�Ʈ�� �������� �ʴ´�.
    jstl�� �ڹ��� �÷��� �����ӿ�ũ�� ���� ���� �� �ִ�.
    jstl�� �ڹ��ڵ嵵 ���� Ȱ���� �� �ִ�.
    UI�ַ���� ȭ�鿡 ���� �پ��� ������Ʈ�� ������ �����Ѵ�.
    (html���� �ξ� �� ����,,,)
    UI�ַ���� �ڹ��� �÷��� �����ӿ�ũ�� �޾� �� ������ ������ �ʿ��ϴ�.
    (dataset����,json)
      -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����� ���� �±׶��̺귯�� �ǽ�</title>
</head>
<body>
<jsp:useBean id="a" scope="page" class="com.mvc.BoardController"/>
<c:set var="jstl_name" scope="request" value="�̼���"/>
�̸�:${jstl_name}
<%
String str_name=new String("�̼���");
request.setAttribute("str_name",str_name);
out.print(str_name);
List<String> nameList=new ArrayList<String>();
nameList.add("��ȫ��");
nameList.add("���п�");
nameList.add("���ÿ�");
List<DeptVO>deptList=new ArrayList<DeptVO>();
DeptVO dVO = new DeptVO();
dVO.setDeptno(10);
dVO.setDname("�λ��");
dVO.setLoc("��õ");
deptList.add(dVO);
dVO= new DeptVO();
dVO.setDeptno(20);
dVO.setDname("�ѹ���");
dVO.setLoc("�λ�");
deptList.add(dVO);
dVO= new DeptVO();
dVO.setDeptno(30);
dVO.setDname("�����");
dVO.setLoc("����");
deptList.add(dVO);

%>
<c:set var="jstl_nameList" scope="request" value="<%=nameList %>"/>
<table>
<tr>
<th>�̸�</th>
</tr>
<c:forEach var="names" items="${jstl_nameList}">
<tr>
<td>${names}</td>
</tr>
</c:forEach>
</table>
<c:set var="jstl_deptList" scope="request" value="<%=deptList%>"/>
<table border="1" borderColor="pink">
<tr>
<th>�μ���ȣ</th>
<th>�μ���</th>
<th>����</th>
</tr>
<c:forEach var="dVO" items="${jstl_deptList}" varStatus="status">
<tr>
<td>${dVO.deptno}</td>
<td>${dVO.dname}</td>
<td>${dVO.loc}</td>
</tr>
</c:forEach>
</table>
<table border="1" borderColor="blue">
<tr>
<th>�μ���ȣ</th>
<th>�μ���</th>
<th>����</th>
</tr>
<c:forEach var="dVO" items="${jstl_deptList}">
<tr>
<td><%=dVO.getDeptno()%></td>
<td><%=dVO.getDname() %></td>
<td><%=dVO.getLoc() %></td>
</tr>
</c:forEach>
</table>
<!--�ε����δ� ���ٺҰ�  -->
<table border="1" borderColor="green">
<tr>
<th>�μ���ȣ</th>
<th>�μ���</th>
<th>����</th>
</tr>
<c:forEach var="dVO" items="${jstl_deptList}">
<tr>
<td>${dVO[0]}</td>
<td>${dVO[1]}</td>
<td>${dVO[2]}</td>
</tr>
</c:forEach>
</table>
</body>
</html>
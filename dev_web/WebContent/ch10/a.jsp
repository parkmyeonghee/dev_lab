<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.util.Map,java.util.HashMap" %>
    <%
    response.sendRedirect("b.jsp");//url�� �ٲ��-������ �������� ���ο� ��û�� �Ͼ��.
    String name ="�̼���";
    String hp="010-1234-5678";
    Map<String ,Object>pMap = new HashMap<String,Object>();
    pMap.put("name",name);
    pMap.put("hp",hp);
    //request�� ����� ���� ��� �ɱ�?
    		request.setAttribute("rpMap", pMap);
    //���ǿ� ������ ���� ��
    //���ǿ��� ObjectŸ�Ե� ���� �� �ִ�.
    
    session.setAttribute("pMap",pMap);//30�а� �����ȴ�. web.xml����Ÿ�� ����
    session.setMaxInactiveInterval(60*10);//�ʴ����� ������ �� �ִ�.
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>a.jsp(��û������)</title>
</head>
<body>

</body>
</html>
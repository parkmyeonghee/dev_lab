<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    String nh_age = request.getParameter("nh_age");
    String age = request.getParameter("age");
    Cookie cookie = new Cookie("nh_age",nh_age);
    Cookie cookie2 = new Cookie("age",age);
    
    cookie.setMaxAge(60*60);
    cookie2.setMaxAge(60*60);
    response.addCookie(cookie); //������ Ŭ���̾�Ʈ�� ��Ű ��������
    response.addCookie(cookie2); //������ Ŭ���̾�Ʈ�� ��Ű ��������
    //out.print(nh_age); //String ���� ��°Ŷ� �ٸ� ������������ ������ �� ����. ��Ű�� ����� �ʾ�����
    Cookie cookies[]=request.getCookies();
    for(int i=0;i<cookies.length;i++){
       out.print(cookies[i].getName()+","+cookies[i].getValue());       
    }
    %>
    html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>   
<body>
    
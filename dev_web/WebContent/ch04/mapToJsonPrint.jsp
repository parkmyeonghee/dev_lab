<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@page import="org.json.simple.JSONValue"%>
   <%@page import="java.util.Map,java.util.LinkedHashMap" %>
   <%@page import="java.util.List,java.util.ArrayList" %>
   <!--
   �н� ��ǥ
   1.�ܺ� ���̺귯���� ����� �� ������ ������ġ�� ������ �� �ִ�.
   2.XXX.jsp�������� �̿��ؼ� �پ��� ���·� Ŭ���̾�Ʈ���� 
   ��� ����� ������ �� �ִ�.
   :html����
   :xml���� -UI�ַ���� ����ؼ� ȭ���� ������ ��
   :json����-easyui���� �ڹٽ�ũ��Ʈ ����� UI�ַ���� ����ؼ� ȭ���� ������ ��
   				xml���� ������ ������ parser�� �ʿ� ����.
    -->
    <%
    List<Map<String,String>> bookList = new ArrayList<Map<String,String>>();
    Map<String,String> map = new LinkedHashMap<String,String>();
    //������� ó�� �ϰ� ���� �� LinkedHashMap�� ���
    map.put("b_title","JAVA�� ����");
    map.put("b_author","���ü�");
    map.put("b_img","pic.png");
    bookList.add(map);
    
	map = new LinkedHashMap<String,String>();
    map.put("b_title","Oracle11g���α׷���");
    map.put("b_author","������");
    map.put("b_img","pic2.png");
    bookList.add(map);
    
    map = new LinkedHashMap<String,String>();
    map.put("b_title","Jsp2.3�����α׷���");
    map.put("b_author","�ֹ���");
    map.put("b_img","pic3.png");
    bookList.add(map);
    String jsonText =JSONValue.toJSONString(bookList);
    out.print(jsonText);
    %>
    
    
    
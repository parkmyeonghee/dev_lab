<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.util.List,com.vo.MemoVO" %>
    <jsp:useBean id="moLogic" scope="page"class="com.ajax.memo.MemoLogic"/>
    <%
    /* List <MemoVO>memoList =
   (List<MemoVO>)request.getAttribute("memoList"); */
   MemoVO pmoVO=new MemoVO();
   pmoVO.setTo_id(request.getParameter("to_id"));
   List<MemoVO> memoList = moLogic.getReceiveMemoList(pmoVO);
    int size =0;
    if(memoList !=null){
    	size=memoList.size();
    }
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<!--���� ��ư �߰� ����  -->
<div id="tbar_rmemoList">
<!--�˻� ���� �߰� ȭ��  -->
<form id="r_search">
<table>
<tr>
<a href="#" class="easyui-linkbutton"  iconCls="icon-remove" plain="true" onClick="b_write()">����</a>
</td>
</tr>
</table>
</form>
</div>
<!--���� ��ư �߰� �� -->
<table border="1" borderColor="orange" width="100%" height="100%">
	<tr>
	<td align ="center">
	<table align="center">
	<tr>
	<td align="center"></td>
	</tr>
	<tr>
	<td align="center">
	<!-- �������� ��� ���� -->
<table id="tb_rmemoList" toolbar="#tbar_rmemoList" title="����������" class="easyui-datagrid" style="width:800px;height:400px"rownumbers="true">
<!--���̺� ��� �����ϱ�  -->
<thead>
<tr>
<th field="ab_no" align="center" width="80">��ȣ</th>
<th  field="mem_name" align="center" width="150">������</th>
<th  field="from_id" align="center" width="150">������ ���̵�</th>
<th  field="create_date" align="center" width="120">��������</th>
<th  field="read_yn" align="center" width="100">��������</th>
</tr>
</thead>
<!--��ȸ��� ����ϱ�  -->
</table>
</body>
</html>
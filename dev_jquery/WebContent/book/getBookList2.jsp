<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="java.util.List,com.vo.BookVO" %>
    <%
    String stotal="0";
    if(session.getAttribute("total")!=null){
    stotal=session.getAttribute("total").toString();
    } 
    %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ���</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">

function choCheck(str){
	
	var cho=["��","��","��","��","��","��","��","��","��"
		,"��","��","��","��","��","��","��","��","��","��"];
	var result="";i<str.length;i++){
		code=str.charCodeAy(i)-44032;
		//21*28=588
		//19*21*28=11172
		if(code>-1&&code<11172)result +=cho[Math.floor(code/588)];
		}
	return result;

}
function addRow(){
	$("#tb_bookList").datagrid('appendRow',{
		ab_no:0
		,ab_title:''
		,ab_author:''
		,ab_publisher:''
		,ab_img:''
	});
}
function removeRow(){
	var vindex; //����ڰ� ������ �ο찪�� ���� ����
	var row=$("#tb_bookList").datagrid('getSelected');
	if(row){ //�ڹٽ�ũ��Ʈ������ 0�̾ƴϸ� ��δ� true
		vindex=$("#tb_bookList").datagrid('getRowIndex',row);
	}
	$("#tb_bookList").datagrid('deleteRow',vindex);
}
function b_write(){
	$("#dlg_bookIns").dialog('open').dialog('setTitle','�������� ���')
}
//���̾�α� â���� ���� ��ư�� Ŭ������ �� ȣ��
function b_insert(){
	//alert($("ab_pubdate").val());
	var temp=$("#ab_pubdate").val;
	var v_pubdate;
	var v_year=temp.substring(6);//2017
	var v_mm=temp.substring(0,2);//01
	var v_day=temp.substring(3,2);//26
	v_pubdate=v_year+"-"+v_mm+"-"+v_day;
	$("#f_bookIns").attr("method","POST");
	$("#f_bookIns").attr("action","./bookInsert.bk?ab_pubdate="+v_pubdate);
	$("#f_bookIns").submit();
}
//�����˻�
function b_search(){
	var vad_title=$("#tbox_word").val();
	var choKeyword=choCheck(vab_title);
	alert("choKeyword:"+choKeyword+","+var_title);
	//�ʼ� �˻� ����
	if(vab_title!=""&&choKeyword!=""){//�ʼ��˻�
		choMode="Y";
	}else{//�Ϲݰ˻�
		choMode="N";
	}
	var param="ab_title="+var_title+"&choMode="+choMode;
	$.ajax({
		type:"POST"
		,url:"./getBookList.bk"
		,data:param
		,success:function(result){
			
		}
	});///////////////end of ajax
}//////////////////////////////////end of b_searchs
//���� ����
function b_remove(){
	
}
//������ �̵�ó��
function pageMove(pageNumber,pageSize){
	alert("pageMoveȣ��:"+pabeNumber+","+pageSize)
	/*
	������� ��ȸ ����� datagri���۳�Ʈ�� ����� �� �� ���� ����� �����ϴ�.
	��ȸ����� List�� ���� �ڷᱸ���� ��� �� �ּҹ����� request�� ����� ��
	��ȭ �κп����� ��û�� �����Ǵ� ������ �Ǵ�(WAS)�ϹǷ� ��ȭ�� �κ��� �����
	�ݿ����� �ʰ� �ִ�.
	1�� ������δ� datagrid�� ��ȭ�� ������ �ݿ����� ���Ѵ�.
	�ذ���
	JSON�� ����ϴ� jsp�������� ����Ѵ�.
	1)�ڹ� �ڵ带 �̿��ϴ� ���-request�Ӽ��� �̿��Ѵ�
	
	2)JSON�ڵ带 �̿��ϴ� ���
	*/
	//location.href="./getBookList.bk?page="+pageNumber+"&pageSize="+pageSize
 	$("#tb_bookList").datagrid({
		idField:'itemid',
		url:"./getBookList.bk?page="+pageNumber
				+"&pageSize="+pageSize
	});
}
function bookSearch(){
	
}
</script>
<style type="text/css">
div #d_book{
	position:absolute;
	top:30px;
	left:150px;
}
</style>
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){//html������ DOM������ �غ�Ǿ��� ��
	$("#tbox_word").keyup(function(){
		b_search();
	});
/* ����¡ ó�� ���� */
	$("#pg_book").pagination({
	total:<%=stotal%>,
	pageSize:10,
	onSelecttPage:function(pageNumber,pageSize){
		pageMove(pageNumber,pageSize);
	}
	});
	/* ����¡ ó�� �� */
	/* ����Ÿ �׸��� ó�� ���� */
	$("#tb_bookList").datagrid({
		url:'./getBookList.bk' //jSonbookList.jsp->jSon��¹�
		,onDblClickCell:function(index,field,value){
		//	alert("11");//�̺�Ʈ ���� �׽�Ʈ
		var row=$("#tb_bookList").datagrid("getSelected");
		$("#bab_title").textbox('setValue',row.ab_title);
		$("#bab_author").textbox('setValue',row.ab_author);
		$("#bab_publisher").textbox('setValue',row.ab_publisher);
		}
	});
	/* ����Ÿ �׸��� ó�� �� */
});
</script>
<!--ȭ�� ��ü�� ������ DIV�±� �߰� ����  -->
<div id="cc" class="easyui-layout" style="width:1000px;height:500px;">
<!--North���� ����  -->
<!-- �����˻��� ���� -->
 <div data-options="region:'north',title:'�����˻�',split:false" style="width:1000px;height:60px;">
 <div id="d_book">
 <input id="tbox_word" type="text" style="width:700px;"/>
 </div>
 </div>
<!-- �����˻��� ��-->
<!--North���� ��  -->
<!--Center���� ����  -->
<!-- ������Ϲ� ���� -->
 <div data-options="region:'center',title:'�������',split:false" style="width:1000px;height:440px;">
 <table id="tb_bookList" singleSelect="true"toolbar="#tbar_bookList" class="easyui-datagrid" style="width:950px;height:400px"rownumbers="true">
<!--���̺� ��� �����ϱ�  -->
<thead>
<tr>
<th field="ab_no" width="150" align="center">��ȣ</th>
<th  field="ab_title"width="250" align="center">��������</th>
<th  field="ab_author" width="150"align="center">����</th>
<th  field="ab_publisher"width="150" align="center">���ǻ�</th>
<th  field="ab_img" width="200" align="center">÷������</th>
</tr>
</thead>
</table>
 
 </div>
<!-- ������Ϲ� ��-->
<!--Center���� �� -->
</div>
<!--���̺� ���� ���� �߰��� ���� ���� ��Ϲ�ư  -->
<div id="tbar_bookList">
<!--�˻� ���� �߰� ȭ��  -->
<form id="r_search">
<table>
<tr>
<td width="240px">
<label width="120px">��������</label>
<input name="ab_title" class="easyui-textbox"style="width:200px"></td>
<td width="180px">
<label width="60px">����</label>
<input name="ab_author" class="easyui-textbox"style="width:120px"></td>
<td width="210px">
<label width="90px">���ǻ�</label>
<input name="ab_publisher" class="easyui-textbox"style="width:120px"></td>
<td>&nbsp</td>
</tr>
<tr>
<td colspan="3">

<a href="#" class="easyui-linkbutton"  iconCls="icon-search" plain="true" onClick="b_write()">������ȸ</a>
<a href="#" class="easyui-linkbutton"  iconCls="icon-add" plain="true" onClick="b_write()">�������</a>
<a href="#" class="easyui-linkbutton"  iconCls="icon-remove" plain="true" onClick="b_write()">��������</a>
<a href="#" class="easyui-linkbutton"  iconCls="icon-add" plain="true" onClick="addRow()">���߰�</a>
<a href="#" class="easyui-linkbutton"  iconCls="icon-add" plain="true" onClick="removeRow()">�����</a>
</td>
</tr>
</table>
</form>
<!-- �˻� ���� �߰� ȭ�� -->
</div>

<!--������ �׸���� �ؽ�Ʈ�ڽ� ���ε� ó���غ��� ����  -->
<div id="d_bookBind">
<table>
<tr>
<td width="240px">
<label width="120px">��������</label>
<input id="bab_title" name="ab_title" class="easyui-textbox"style="width:200px"></td>
<td width="180px">
<label width="60px">����</label>
<input id="bab_author"name="ab_author" class="easyui-textbox"style="width:120px"></td>
<td width="210px">
<label width="90px">���ǻ�</label>
<input id="bab_publisher"name="ab_publisher" class="easyui-textbox"style="width:120px"></td>
<td>&nbsp</td>
</tr>
</table>
</div>
<!--������ �׸���� �ؽ�Ʈ�ڽ� ���ε� ó���غ��� �� -->
<!-- ������ �׺���̼� ����  -->
<div id="pg_book" class="easyui-pagination" style="border:1px solid #ccc;width:1000px;">
</div>
<!-- ������ �׺���̼� ��  -->
<!--�� �κ��� ���� ��Ϲ�ư�� Ŭ������ �� �˾�â���� ó���� ȭ���Դϴ�.
ó�� �������� �ε� �Ǿ��� ���� ���ξ��ٰ� ����� Ŭ������ �� ��� ȭ���Դϴ�.  -->
<div id="dlg_bookIns"buttons="#dlg_buttons" class="easyui-dialog"closed="true" style="width:600px">
<div style="margin-bottom:20px;font-size:16px;border-bottom:1px solid #CCCCCC">�����������</div>
<!-- ������ ����ڰ� �Է��� ������ �����մϴ�.(form�������� ó���ϱ�) -->
<form id="f_bookIns" enctype="multipart/form-data" style="margin:0;padding:20px 50px">
<div style="margin-bottom:10px">
<input name="ab_title" class="easyui-textbox" label="��������:" style="width:100%">
</div>
<div style="margin-bottom:10px">
<input name="ab_author" class="easyui-textbox" label="����:" style="width:100%">
</div>
<div style="margin-bottom:10px">
<input name="ab_publisher" class="easyui-textbox" label="���ǻ�:" style="width:100%">
</div>
<div style="margin-bottom:10px">
<input name="ab_price" class="easyui-textbox" label="����" style="width:100%">
</div>
<div style="margin-bottom:10px">
<input id="ab_pubdate" name="ab_pubdate" label="������"type="text" class="easyui-datebox" required="required"style="width:200px">
</div>
<div style="margin-bottom:10px">
<input name="ab_img" class="easyui-filebox" label="�̹���" style="width:100%">
</div>
</form>
</div>
<div id="dlg_buttons">
<a href="#" class="easyui-linkbutton c6" iconCls="icon-ok" plain="true" onClick="b_insert()" style="width:90px">����</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_bookIns').dialog('close')"style="width:90px">���</a>
</div>
</body>
</html>
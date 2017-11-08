<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, com.vo.BookVO" %>   
<%
	String stotal = "0";
	if(session.getAttribute("total")!=null){
		stotal = session.getAttribute("total").toString();
	}
%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�������</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<style type="text/css">
	div#d_book{
	    position : absolute;
		top: 50px;
		left: 400px;
	}
	div#d_bookTitle{
		position : absolute;
	}
	.listIn{
		background : #CCFFFF;
	}
	.listOut{
		background : #FFFFFF;
	}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	var g_title;//��������-�ݱ��ư Ŭ�������� onmouseover���������� ���� ����
	function choCheck(str)
	{
		var cho = ["��","��","��","��","��","��","��","��","��","��","��","��"
			           ,"��","��","��","��","��","��","��"];
		var result ="";
		for(i=0;i<str.length;i++){
			code = str.charCodeAt(i)-44032;
			//21*28=588
			//19*21*28=11172
			if(code > -1 && code < 11172) result += cho[Math.floor(code/588)];
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
		var vindex;//����ڰ� ������ �ο찪�� ���� ����
		var row = $("#tb_bookList").datagrid('getSelected');
		if(row){//�ڹٽ�ũ��Ʈ������ 0�� �ƴϸ� ��� �� true
			vindex = $("#tb_bookList").datagrid('getRowIndex',row);
		}
		$("#tb_bookList").datagrid('deleteRow',vindex);
	}
	function b_write(){
		$("#dlg_bookIns").dialog('open').dialog('setTitle','�������� ���');
	}
	//���̾�α�â���� �����ư�� Ŭ������ �� ȣ��
	function b_insert(){
		//alert($("#ab_pubdate").val());// 01/26/2017
		var temp = $("#ab_pubdate").val();
		var v_pubdate;
		var v_year = temp.substring(6);//2017
		var v_mm = temp.substring(0,2);//01
		var v_day = temp.substring(3,5);//26
		v_pubdate = v_year+"-"+v_mm+"-"+v_day;//2017-01-26
		$("#f_bookIns").attr("method","POST");
		$("#f_bookIns").attr("action","./bookInsert.bk");
		$("#f_bookIns").submit();
	}
	//�����˻�
	function b_search(){
		var vab_title = $("#tbox_word").val();//�ڹ��� ����
		var choKeyword = choCheck(vab_title);
		//alert("choKeyword:"+choKeyword+", "+vab_title);
		//�ʼ� �˻� ����
		if(vab_title!="" && choKeyword==""){//�ʼ��˻�
			choMode = "Y";
		}
		else{//�Ϲݰ˻�
			choMode = "N";
		}
		var param = "ab_title="+vab_title+"&choMode="+choMode;
		// ./getBookList.bk?ab_title=��&choMode=N
		$.ajax({
			type:"POST"
		  , url:"./getBookList.bk"
		  , data:param
		  ,success:function(result){
			  //alert("result:"+result);
			  $("#d_bookTitle").css("border","#000000 1px solid");
			  $("#d_bookTitle").css("background","#FFFFFF");
			  $("#d_bookTitle").css("left",400+"px");
			  $("#d_bookTitle").css("top",72+"px");
			  $("#d_bookTitle").html(result)
		  }
		  ,error:function(e){
			  alert(e.responseText);//������ �߻����� �� Ŭ���̾�Ʈ���� �������� �ҽ�
		  }
		});	//////////end of ajax
	}///////////////end of b_search
	//��������
	function b_remove(){
		
	}
	//������ �̵� ó��
	function pageMove(pageNumber,pageSize){
		//alert("pageMoveȣ��:"+pageNumber+" , "+pageSize);
/*
������� ��ȸ ����� datagrid���۳�Ʈ�� ����� �� �� ���� ����� �����ϴ�.
��ȸ����� List�� ���� �ڷᱸ���� ��� �� �ּҹ����� request�� ����� ��
��ȭ �κп� ���ؼ��� ��û�� �����Ǵ� ������ �Ǵ�(WAS)�ϹǷ� ��ȭ�� �κ��� ����� �ݿ����� �ʰ� �ִ�.
1�� ������δ� datagrid�� ��ȭ�� ������ �ݿ����� ���Ѵ�.
�ذ���
JSON�� ����ϴ� jsp�������� ����Ѵ�.
1)�ڹ��ڵ带 �̿��ϴ� ��� - request�Ӽ��� �̿��Ѵ�.

2)JSON�ڵ带 �̿��ϴ� ���
*/
//		location.href="./getBookList.bk?page="+pageNumber+"&pageSize="+pageSize;
		$("#tb_bookList").datagrid({
			idField:'itemid',
			url:"./getBookList.bk?page="+pageNumber
            +"&pageSize="+pageSize
		});
	}
	function bookSearch(){
		
	}
	function setTitle(pab_title){
		$("#tbox_word").val(pab_title);//������ �����������ͼ� �ؽ�Ʈ�ڽ��� ���
	}
	function titleChoice(ctd,psb_no,psb_titles){
		ctd.className="listIn";
		//������ ������ �������� ����ȸ ó��-�κ������� ����(ajax)
		bookDetail(pab_no);
	}
	function titleCancel(ctd){
		ctd.className="listOut";
	}
	function bookDetail(pab_no){
		console.log("bookDetail ȣ�� ����");
		var param="ab_title"+pab_no;
		$.ajax({
			type:"POST"
			,url:"./getBookList.bk" //pun_no-ab_title
			,data:param
			,success:function(result){
				$("#d_bookDetail").html(result);
			}
		});
	}
	function subClose(){
		$("#tbox_word").val(g_title);
		location.reload();
		$("#d_bookTitle").hide();
	}
</script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function (){//html������ DOM������ �غ�Ǿ��� ��
		//alert("ready");		
		$("#tbox_word").keyup(function(){
			//alert("keyup");
			b_search();
		});	
/* ����¡ ó��  ����  */		
			$("#pg_book").pagination({
				total: <%=stotal%>,
				pageSize: 10,
				onSelectPage: function(pageNumber, pageSize){
					pageMove(pageNumber, pageSize);
				}
			});
/* ����¡ ó��  ��  */
/* ����Ÿ�׸��� ó��  ����  */
			$("#tb_bookList").datagrid({
				url:'./getBookList.bk'//jSonBookList.jsp-> json��¹�
			   ,onDblClickCell:function (index,field,value){
					//alert("11");//�̺�Ʈ���� �׽�Ʈ
					var row = $("#tb_bookList").datagrid("getSelected");
					$("#bab_title").textbox('setValue',row.ab_title);
					$("#bab_author").textbox('setValue',row.ab_author);
					$("#bab_publisher").textbox('setValue',row.ab_publisher);
				}
			});
/* ����Ÿ�׸��� ó��  ��     */
});
</script>
<!-- ȭ�� ��ü�� ������ DIV�±� �߰� ���� -->
<div id="cc" class="easyui-layout" style="width:1000px;height:500px;">
<!-- North���� ���� -->
<!-- �����˻� �� ���� -->
<div data-options="region:'north',title:'�����˻�',split:true" style="width:1000px;height:200px;">
	<div id="d_book">
		<input id="tbox_word" type="text" style="width:200px"/>
    </div>
    <div id="d_bookTitle"></div>
</div>
<!-- �����˻� ��  ��   -->
<!-- North����  ��   -->
<!-- Center���� ���� -->
<div data-options="region:'center',title:'�������',split:true" style="width:1000px;height:440px;">
	<table id="tb_bookList" toolbar="#tbar_bookList" singleSelect="true" class="easyui-datagrid" style="width:950px;height:400px" rownumbers="true">
	<!-- ���̺� ��� �����ϱ� -->
		<thead>
		<tr>
			<th field="ab_no" align="center" width="80">��ȣ</th>
			<th field="ab_title" align="center" width="250">��������</th>
		    <th field="ab_author" align="center" width="120">����</th>
		    <th field="ab_publisher" align="center" width="150">���ǻ�</th>
		    <th field="ab_img" align="center" width="150">÷������</th>
		</tr>
		</thead>
	</table>
</div>
<!-- Center����  �� -->
</div>
<!-- ȭ�� ��ü�� ������ DIV�±� �߰�   �� -->

<!-- ���̺��� ���� �߰��� ���� ������Ϲ�ư -->
<div id="tbar_bookList">
<!-- �˻� ���� �߰� ȭ�� �Դϴ�.  -->
<form id="f_search">
	<table>
		<tr>
			<td width="240px">
			<label width="120px">��������</label>
			<input name="ab_title" class="easyui-textbox" style="width:120px">
			</td>
			<td width="180px">
			<label width="60px">����</label>
			<input name="ab_author" class="easyui-textbox" style="width:120px">
			</td>
			<td width="210px">
			<label width="90px">���ǻ�</label>
			<input name="ab_publisher" class="easyui-textbox" style="width:120px">
			</td>
			<td width="370px">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="4">
		    <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="b_search()">������ȸ</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="b_write()">�������</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="b_remove()">��������</a>			
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="addRow()">���߰�</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeRow()">�����</a>
			</td>
		</tr>		
	</table>
</form>	
<!-- �˻� ���� �߰� ȭ�� �Դϴ�.  -->	
</div>
<!-- �����ͱ׸���� �ؽ�Ʈ�ڽ� ���ε� ó�� �غ��� ����  -->
	<div id="d_bookBind">
	<table>
		<tr>
			<td width="240px">
			<label width="120px">��������</label>
			<input id="bab_title" name="ab_title" class="easyui-textbox" style="width:120px">
			</td>
			<td width="180px">
			<label width="60px">����</label>
			<input id="bab_author" name="ab_author" class="easyui-textbox" style="width:120px">
			</td>
			<td width="210px">
			<label width="90px">���ǻ�</label>
			<input id="bab_publisher" name="ab_publisher" class="easyui-textbox" style="width:120px">
			</td>
			<td width="370px">&nbsp;</td>
		</tr>
</table>	
</div>	
<!-- �����ͱ׸���� �ؽ�Ʈ�ڽ� ���ε� ó�� �غ���  ��  -->
<!-- ������ �׺���̼� ���� -->
<div id="pg_book" class="easyui-pagination" style="border:1px solid #ccc;width:1000px"></div>
<!-- ������ �׺���̼�  ��   -->
<!-- �̺κ��� ���� ��� ��ư�� Ŭ������ �� �˾�â���� ó���� ȭ�� �Դϴ�.
     ó�� �������� �ε� �Ǿ��� ���� ���ξ��ٰ� ����� Ŭ������ �� ��� ȭ�� �Դϴ�.
 -->
 <div id="dlg_bookIns" buttons="#dlg_buttons" class="easyui-dialog" closed="true" style="width:600px">
 	<div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #CCCCCC">�������� ���</div>
<!-- ������ ����ڰ� �Է��� ������ �����մϴ�.(form�������� ó���ϱ�) -->
	<form id="f_bookIns" enctype="multipart/form-data" style="margin:0;padding:20px 50px"> 	
 	<div style="margin-bottom:10px">
 	<input name="ab_title" class="easyui-textbox" label="�������� : " style="width:100%">
 	</div>
 	<div style="margin-bottom:10px">
 	<input name="ab_author" class="easyui-textbox" label="���� : " style="width:100%">
 	</div>
 	<div style="margin-bottom:10px">
 	<input name="ab_publisher" class="easyui-textbox" label="���ǻ� : " style="width:100%">
 	</div>
 	<div style="margin-bottom:10px">
 	<input name="ab_price" class="easyui-textbox" label="���� : " style="width:100%">
 	</div>
  	<div style="margin-bottom:10px">
 	<input id="ab_pubdate" name="ab_pubdate"  label="������" type="text" class="easyui-datebox" required="required" style="width:200px">
 	</div>	
  	<div style="margin-bottom:10px">
 	<input name="ab_img" class="easyui-filebox" label="�̹��� : " style="width:100%">
 	</div>
 	</form>	
 </div>
 <div id="dlg_buttons">
	<a href="#" class="easyui-linkbutton c1" iconCls="icon-ok" plain="true" onClick="b_insert()" style="width:90px">����</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_bookIns').dialog('close')" style="width:90px">���</a>
</div>
</body>
</html>







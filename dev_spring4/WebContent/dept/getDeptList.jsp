<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	int result = -1;
	if(request.getParameter("result")!=null){
		result = Integer.parseInt(request.getParameter("result"));
	}
	int total=0;
	if(session.getAttribute("total")!=null){
			total=Integer.parseInt(session.getAttribute("total").toString());
		
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�μ����</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/dev_spring4/js/commons.js"></script>
<script type="text/javascript">
	var vresult = <%=result%>
	//������ �̵�ó��
	function pageMove(pageNumber,pageSize){
		$("#tb_deptList").datagrid({
			idField:'itemid',
			url:"./getDeptList.kosmo?page="+pageNumber
					+"&pageSize="+pageSize
		});
	}
	//�μ���ȣ ���� �˻�
	function deptnoSearch(){
		//����ڰ� �Է��� �μ���ȣ ��������
		var vdeptno = $("#deptno").val();
		console.log("����ڰ� �Է��� �μ���ȣ : "+vdeptno);
		$('#tb_deptList').datagrid({
			url: "./getDeptList.kosmo?deptno="+vdeptno
		});
	}
	//�μ��� ���� �˻�
	function dnameSearch(){
		var vdname = $("#dname").val();
		console.log("����ڰ� �Է��� �μ��� : "+vdname);
		$('#tb_deptList').datagrid({
			url: "./getDeptList.kosmo?dname="+vdname
		});		
	}
	//���� ���� �˻�
	function locSearch(){
		var vloc = $("#loc").val();
		console.log("����ڰ� �Է��� ���� : "+vloc);
		$('#tb_deptList').datagrid({
			url: "./getDeptList.kosmo?loc="+vloc
		});		
	}	
	//��ü ���� �˻�
	function searchALL(){
		$('#tb_deptList').datagrid({
			url: "./getDeptList.kosmo"
		});		
	}
	//�μ����
	function deptInsert(){
		$("#dlg_deptIns").dialog('open').dialog('setTitle','�μ����');
	}
	//�μ����� ���̺� �����ϱ�
	function insertAction()
	{
		$("#f_deptIns").attr("method","get");
		$("#f_deptIns").attr("action","./deptInsert.kosmo");
		$("#f_deptIns").submit();
	}
	//�μ����� - ȭ�鿡�� ���� ���� ����(ajax, form, ������Ʈ��)
	function deptDelete(){
		var row = $("#tb_deptList").datagrid('getSelected');//Object
		//alert("row:"+row);
 		if(row==null){
			alert("������ �ο츦 �����ϼ���.");
			return;
		} 
/* 		alert(row.DEPTNO);
		if(row){
			alert($("#tb_deptList").datagrid('getRowIndex',row));
		} */
/* 		$("#f_deptDel").attr("method","get");
		$("#f_deptDel").attr("action","./deptDelete.kosmo?deptno="+row.DEPTNO);
		$("#f_deptDel").submit();	 */
		location.href="./deptDelete.kosmo?deptno="+row.DEPTNO;
	}
	//�μ� ���� ����
	function deptUpdForm(){
		var row = $("#tb_deptList").datagrid('getSelected');//Object
 		if(row==null){
			alert("������ �ο츦 �����ϼ���.");
			return;
 		}
		var url="./getDeptRead.kosmo?deptno="+row.DEPTNO;
 		 cmm_window_popup(url,'650','320','deptUpdForm');
	}
</script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function (){
		if(vresult==1)
		$("#dlg_deptInsSuccess").dialog('open');
		else if(vresult==0)
		$("#dlg_deptInsFail").dialog('open');	
		/* ������ �׺���̼� �ʱ�ȭ ���� */
		$("#pg_dept").pageination({
			total:<%=total%>
		,pageSize:10
		,onSelectPage:function(pageNumber,pageSize){
			pageMove(pageNumber,pageSize);
		}
		})
		/* ������ �׺���̼� �ʱ�ȭ �� */
	});////////////////////////////end of ready
</script>
<!-- ���� ó���� ���� �� �߰��ϱ�  ��    -->
<!-- ���� �߰��ϱ� ���� -->
<!-- ���̺��� ���� �߰��� ���� ������Ϲ�ư -->
<div id="tbar_deptList">
<!-- �˻� ���� �߰� ȭ�� �Դϴ�.  -->
<form id="f_search">
	<table>
		<tr>
			<td width="140px">
			<label width="80px">�μ���ȣ</label>
			<!-- 
<input class="easyui-searchbox" data-options="prompt:'Please Input Value',searcher:doSearch" style="width:100%">			
			 -->
			<input id="deptno" name="deptno" class="easyui-searchbox" data-options="prompt:'�μ���ȣ', searcher:deptnoSearch" style="width:60px">
			</td>
			<td width="180px">
			<label width="70px">�μ���</label>
			<input id="dname" name="dname" class="easyui-searchbox" data-options="prompt:'�μ���', searcher:dnameSearch" style="width:110px">
			</td>
			<td width="180px">
			<label width="70px">����</label>
			<input id="loc" name="loc" class="easyui-searchbox" data-options="prompt:'����', searcher:locSearch" style="width:110px">
			</td>
		</tr>
		<tr>
			<td colspan="4">
		    <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="searchALL()">�μ���ȸ</a>
		    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="deptUpdForm()">�μ�����</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="deptInsert()">�μ����</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="deptDelete()">�μ�����</a>			
			</td>
		</tr>		
	</table>
</form>	
<!-- �˻� ���� �߰� ȭ�� �Դϴ�.  -->	
</div>
<!-- ���� �߰��ϱ�  ��   -->
<table id="tb_deptList" toolbar="#tbar_deptList" fitColumns="true" data-options="url:'./getDeptList.kosmo'" title="�μ����" singleSelect="true" rownumbers="true" class="easyui-datagrid" style="width:500px;height:400px">
	<thead>
		<tr>
			<th data-options="field:'DEPTNO', width:100, align:'center'">�μ���ȣ</th>
			<th data-options="field:'DNAME', width:150, align:'center'">�μ���</th>
			<th data-options="field:'LOC', width:150, align:'center'">�μ�����</th>
		</tr>
	</thead>
</table>	
<!-- ������ �׺���̼� ����  -->
<div id="pg_dept" class="easyui-pagination" style="border:1px solid #ccc;width:500px;">
</div>
<!-- ������ �׺���̼� ��  -->
<!-- �˾�â���� ������ ȭ�� �Դϴ�. ���� -->
<div id="dlg_deptIns" buttons="#dlg_buttons" class="easyui-dialog" closed="true" style="width:600px">
<!-- ������ ����ڰ� �Է��� ������ �����մϴ�.(form�������� ó���ϱ�) -->
	<form id="f_deptIns" style="margin:0;padding:20px 50px"> 	
 	<div style="margin-bottom:10px">
 	<input id="cb_deptno" name="deptno" label="�μ���ȣ" style="width:100%" class="easyui-combobox" data-options="
        valueField: 'DEPTNO',
        textField: 'DNAME',
        url: 'getDeptnoList.kosmo',
        onSelect: function(rec){
       <!--  alert(rec.DEPTNO); -->
        }">
 	</div>
 	<div style="margin-bottom:10px">
 	<input name="dname" class="easyui-textbox" label="�μ��� : " style="width:100%">
 	</div>
 	<div style="margin-bottom:10px">
 	<input name="loc" class="easyui-textbox" label="���� : " style="width:100%">
 	</div>
 	</form>	
 </div>
 <div id="dlg_buttons">
	<a href="#" class="easyui-linkbutton c1" iconCls="icon-ok" plain="true" onClick="insertAction()" style="width:90px">����</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_deptIns').dialog('close')" style="width:90px">���</a>
</div>

<!-- ��� ������ ������ ȭ�� �Դϴ�.  ����  -->
<div id="dlg_deptInsSuccess" buttons="#dlg_buttons2" class="easyui-dialog" closed="true" style="width:300px">
	<label>��ϼ����Ͽ����ϴ�.</label>
</div>
 <div id="dlg_buttons2">
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_deptInsSuccess').dialog('close')" style="width:90px">�ݱ�</a>
</div>
<!-- ��� ���н� ������ ȭ�� �Դϴ�.  ����  -->
<div id="dlg_deptInsFail" buttons="#dlg_buttons3" class="easyui-dialog" closed="true" style="width:300px">
	<label>��Ͻ����Ͽ����ϴ�.</label>
</div>
 <div id="dlg_buttons3">
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_deptInsFail').dialog('close')" style="width:90px">�ݱ�</a>
</div>
</body>
</html>













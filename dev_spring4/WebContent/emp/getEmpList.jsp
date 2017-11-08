<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
//�⺻ ��¥������ ������
	$.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'/'+(m<10? "0"+m:""+m)+'/'+(d<10? "0"+d:""+d);
	}
//��¥ ������ ����	
	$.fn.datebox.defaults.parser = function(s){
		var t = Date.parse(s);
		if (!isNaN(t)){
			return new Date(t);
		} else {
			return new Date();
		}
	}	
	//������� ���� ��ư Ŭ������ �� ����
	function empUpdate(){
		var row = $("#grid_emp").datagrid('getSelected');
		if(row == null)
		{
			alert("������ �ο츦 �����ϼ���");
			return;//�ش� �Լ� Ż���� �� -empUpdate�Լ�
		}
		$("#uempno").textbox('readonly',true);//true:�б����� false:��������
		$("#uempno").textbox('setValue',row.empno);
		$("#uename").textbox('setValue',row.ename);
		$("#umgr").textbox('setValue',row.mgr);
		$("#uhiredate").textbox('setValue',row.hiredate);
		$("#usal").textbox('setValue',row.sal);
		$("#ucomm").textbox('setValue',row.comm);
		$("#ujob").textbox('setValue',row.job);
		//$("#udeptno").combobox('setValue',row.deptno);
 		$('#udeptno').combobox({
		    url:'../dept/getDeptnoList.kosmo'
		   ,valueField:'DEPTNO'
	 	   ,textField:'DEPTNO'
	 	   ,	onLoadSuccess: function(param){
	 		  $('#udeptno').combobox('select',row.deptno);
	 		}
		});
		$('#dlog_empUpd').dialog('open');		
	}
	//������ ������ ���� ��ư�� Ŭ������ ��
	//���̾�α�â���� �Է¹��� �� ������ �����Ѵ�.
	function empUpdateAction()
	{
		$("#f_empUpd").attr("method","get");
		$("#f_empUpd").attr("action","./empUpdate.kosmo");
		$("#f_empUpd").submit();
	}	
	//������� ���� ��ư Ŭ������ �� ��
	//������ ��ư Ŭ������ ��
	function empInsert(){
 		$('#deptno').combobox({
		    url:'../dept/getDeptnoList.kosmo'
		   ,valueField:'DEPTNO'
	 	   ,textField:'DEPTNO'
		});
		$('#dlog_empIns').dialog('open');		
	}
	//������ ������ ���� ��ư�� Ŭ������ ��
	//���̾�α�â���� �Է¹��� �� ������ �����Ѵ�.
	function empInsertAction()
	{
		$("#f_empIns").attr("method","get");
		$("#f_empIns").attr("action","./empInsert.kosmo");
		$("#f_empIns").submit();
	}
//���������� ��ȸ�ϱ� - IN���� �ǽ�
	function searchALL(){
		//����ڰ� ������ �μ���ȣ�� ���� ���� ����
		var vdeptno="";
		var vdeptnos = [];
		var rows = $("#grid_emp").datagrid('getSelections');
		alert(rows);//Object, Object, Object
		//����ڰ� ������ �μ���ȣ�� �迭 ���
 		for(var i=0;i<rows.length;i++){
			vdeptnos.push(rows[i].deptno);
		}
		//�迭�� ��� ���� ����غ���
 		for(var i=0;i<rows.length;i++){
			//alert(vdeptnos[i]);
			//10,30...�� �ڿ� �޸��� ���̴ٰ� �� ���������� ������ �ʽ��ϴ�.
 			if(i==(rows.length-1)){
 				vdeptno +=vdeptnos[i];
 			}
			//�ڿ� ���� �� ���� ��쿡�� �޸��� �ٿ� �ݴϴ�.
 			else{
 				vdeptno +=vdeptnos[i]+",";
 			}
		}		
		//10,30,40
		//alert("vdeptno:"+vdeptno);
		location.href="./getEmpList2.kosmo?deptno="+vdeptno;
	}
	function empnoSearch(){
		
	}
	function enameSearch(){
		
	}
	function jobSearch(){
		
	}
	function cancelrow(target){
		$("#grid_emp").datagrid('cancelEdit',getRowIndex(target));
	}
	//���̹�Ƽ������ ���ν��� ȣ�� �׽�Ʈ
function procedureCall(){
	location.href="proc_salupdate.kosmo";
}
</script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function (){
/* ������ �׸��� �ʱ�ȭ ���� */		
		$("#grid_emp").datagrid({
			url:"./getEmpList.kosmo"//List<XXXVO>-�ҹ���, List<Map>-�빮��(myBatis)
		  , columns:[[
							{field:'empno', title:'�����ȣ', width:80, align:'center', editor:'text'}
		                   ,{field:'ename', title:'�����', width:100, align:'center', editor:'text'}
		                   ,{field:'job', title:'JOB', width:120, align:'center', editor:'text'}
		                   ,{field:'hiredate', title:'�Ի�����', width:100, align:'center', editor:'text'}
		                   ,{field:'deptno', title:'�μ���ȣ', width:80, align:'center',
		                	   formatter:function(value,row){
		                		   return row.deptno||value;
		                	   },
		                	   editor:{
		                		   type:'combobox'
		                	   	  ,options:{
		                	   		   valueField:'DEPTNO'//���� ������ �Ѿ�� �ʵ�
		                	   		  ,textField:'DEPTNO'//ȭ�鿡 ��µǴ� �ʵ�
		                	   		  ,data:'DEPTNO'
		                	   		  ,url:'../dept/getDeptnoList.kosmo'
		                	   		  ,required:true
		                	   	   }///////end of options
		                	   }//////////end of editor
		                   }
		                   ,{field:'dname', title:'�μ���', width:100, align:'center', editor:'text'}
		                   ,{field:'sal', title:'�޿�', width:100, align:'center', editor:'text', hidden:'true'}
		                   ,{field:'action', title:'Action', width:80, align:'center',
		                	   formatter:function(value,row,index){
		                		   if(row.editing){
		                			   var s = '<a href="#" onclick="saverow(this)">Save</a>';
		                			   var c = '<a href="#" onclick="cancelrow(this)">Cancel</a>';
		                			   return s+" "+c;
		                		   }
		                		   else{
		                			   var e = '<a href="#" onclick="editrow(this)">Edit</a>';
		                			   var d = '<a href="#" onclick="deleterow(this)">Delete</a>';
		                			   return e+" "+d;
		                		   }
		                	   }///////////end of formatter
		                   }//////////////end of action
		                ]],
		    			onEndEdit:function(index,row){
		    				var ed = $(this).datagrid('getEditor', {
		    					index: index,
		    					field: 'DNAME'
		    				});
		    				row.DNAME = $(ed.target).combobox('getText');
		    			},
		    			onBeforeEdit:function(index,row){
		    				row.editing = true;
		    				$(this).datagrid('refreshRow', index);
		    			},
		    			onAfterEdit:function(index,row){
		    				row.editing = false;
		    				$(this).datagrid('refreshRow', index);
		    			},
		    			onCancelEdit:function(index,row){
		    				row.editing = false;
		    				$(this).datagrid('refreshRow', index);
		    			}	 		                
/* 		  ,data: [
						{empno:'6000', ename:'�̼���',job:'����',hiredate:'2009-10-25',deptno:40,dname:'�ؿܿ���'}
					   ,{empno:'7000', ename:'������',job:'����',hiredate:'2009-10-25',deptno:40,dname:'�ؿܿ���'}
		          ] */
		});

/* ������ �׸��� �ʱ�ȭ  ��   */		
	});/////////////////////end of ready
	function getRowIndex(target){
		var tr = $(target).closest('tr.datagrid-row');
		return parseInt(tr.attr('datagrid-row-index'));
	}
	function editrow(target){
		$("#grid_emp").datagrid('beginEdit',getRowIndex(target));
	}
	//�ڹٽ�ũ��Ʈ������ ���� �̸��� �Լ��� �������� �ʽ��ϴ�. -  �޼ҵ� �����ε��� �������� �ʴ´�.
	//deletrow(); or deleterow(1,'�ȳ�');
	function deleterow(target){
		$.messager.confirm('Confirm','���������Ͻðڽ��ϱ�?',function(r){
			if(r){
				var vempnos="";
				var empnoArr=[];
				var rows = $("#grid_emp").datagrid('getSelections');//�ο쿡 ���� Object
				//����ڰ� ������ �ο쿡 ���� Object�� �̿��ϸ� field�� ������ �� �ִ�.
				if(rows==null){
					alert("������ ����� �����ϼ���.");
					return;//deleterow�Լ� Ż��
				}
				for(var i=0;i<rows.length;i++){
					empnoArr.push(rows[i].empno);
				}
				//�迭�� ��� ���� ����غ���
		 		for(var i=0;i<rows.length;i++){
		 			if(i==(rows.length-1)){
		 				vempnos +=empnoArr[i];
		 			}
					//�ڿ� ���� �� ���� ��쿡�� �޸��� �ٿ� �ݴϴ�.
		 			else{
		 				vempnos +=empnoArr[i]+",";
		 			}
				}					
				location.href="./empDelete.kosmo?empnos="+vempnos;//������ ��û(���۹��:get)
				//ȭ��󿡼��� �����ȴ�-���� �� ���� selectó���� ���̹Ƿ� �ǹ̾���.
				//$("#grid_emp").datagrid('deleteRow',getRowIndex(target));
			}
		});
	}
	
</script>
<!-- ���� �߰��ϱ� ���� -->
<!-- ���̺��� ���� �߰��� ���� ������Ϲ�ư -->
<div id="tbar_empList">
<!-- �˻� ���� �߰� ȭ�� �Դϴ�.  -->
<form id="f_search">
	<table>
		<tr>
			<td width="140px">
			<label width="80px">�����ȣ</label>
			<!-- 
<input class="easyui-searchbox" data-options="prompt:'Please Input Value',searcher:doSearch" style="width:100%">			
			 -->
			<input id="empno" name="empno"  class="easyui-searchbox" data-options="prompt:'�����ȣ', searcher:empnoSearch" style="width:60px">
			</td>
			<td width="180px">
			<label width="70px">�����</label>
			<input id="ename" name="ename" class="easyui-searchbox" data-options="prompt:'�����', searcher:enameSearch" style="width:110px">
			</td>
			<td width="180px">
			<label width="70px">JOB</label>
			<input id="job" name="job" class="easyui-searchbox" data-options="prompt:'JOB', searcher:jobSearch" style="width:110px">
			</td>
		</tr>
		<tr>
			<td colspan="4">
		    <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="searchALL()">�����ȸ</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-man" plain="true" onClick="empInsert()">������</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="empUpdate()">�������</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="deleterow()">�������</a>			
			<a href="#" class="easyui-linkbutton" iconCls="icon-tip" plain="true" onClick="procedureCall()">���ν���ȣ��</a>			
			</td>
		</tr>		
	</table>
</form>	
<!-- �˻� ���� �߰� ȭ�� �Դϴ�.  -->	
</div>
<!-- ���� �߰��ϱ�  ��   -->
<!-- ���� �߰��ϱ�   �� -->
<!-- ���̺� �׸��� -->
<table id="grid_emp" toolbar="#tbar_empList" class="easyui-datagrid" title="������" style="width:1000px;height:400px"></table>
<!-- ������� ���� ���̾�α� â �߰� ���� -->
<div id="dlog_empUpd" buttons="#linkbtn_empUpd" class="easyui-dialog" title="������" style="width:400px;height:350px;" closed="true"
        data-options="iconCls:'icon-man',resizable:true,modal:true">
 	<form id="f_empUpd" style="padding:15px 10px">
<!-- �����ȣ ���� -->
 		<div style="margin-bottom:10px">
 		<label>�����ȣ :</label>
 		<input id="uempno" name="empno" class="easyui-textbox" required="true">
 		</div>
<!-- �����ȣ  �� --> 		
<!-- ����� ���� --> 
        <div style="margin-bottom:10px">	
 		<label>����� :</label>
 		<input id="uename" name="ename" class="easyui-textbox" required="true">
 		</div>
<!-- �����  �� --> 	
<!-- JOB ���� --> 
        <div style="margin-bottom:10px">	
 		<label>JOB :</label>
 		<input id="ujob" name="job" class="easyui-textbox" required="true">
 		</div>
<!-- JOB  �� --> 	
<!-- �׷��ڵ� ���� --> 
        <div style="margin-bottom:10px">		
 		<label>MGR :</label>
 		<input id="umgr" name="mgr" class="easyui-textbox" required="true">
 		</div>
<!-- �׷��ڵ�  �� --> 	
<!-- �Ի����� ���� --> 	
		<div style="margin-bottom:10px">	
 		<label>�Ի����� :</label>
 		<input id="uhiredate" name="hiredate" class="easyui-datebox" required="true">
 		</div>
<!-- �Ի�����  �� --> 	
<!-- �޿� ���� --> 
	    <div style="margin-bottom:10px">		
 		<label>�޿� :</label>
 		<input id="usal" name="sal" class="easyui-textbox" required="true">
 		</div>
<!-- �޿�  �� --> 	
<!-- �μ�Ƽ�� ���� --> 	
        <div style="margin-bottom:10px">	
 		<label>�μ�Ƽ�� :</label>
 		<input id="ucomm" name="comm" class="easyui-textbox" required="true">
 		</div>
<!-- �μ�Ƽ��  �� --> 	
<!-- �μ���ȣ ���� --> 	
		<div style="margin-bottom:10px">	
 		<label>�μ���ȣ :</label>
 		<input id="udeptno" name="deptno" class="easyui-combobox" required="true">
 		</div>
<!-- �μ���ȣ  �� --> 	
 	</form>       
</div>
<!-- ������ ���̾�α� â�� ��ư �߰� ���� -->
<div id="linkbtn_empUpd">
    <a href="javascript:void(0)" class="easyui-linkbutton c1"  onclick="empUpdateAction()">����</a>
    <a href="javascript:void(0)" class="easyui-linkbutton c5" onclick="$('#dlog_empUpd').dialog('close')">�ݱ�</a>
</div>
<!-- ������ ���̾�α� â�� ��ư �߰� �� -->
<!-- ������� ���� ���̾�α� â �߰�  ��  -->
<!-- ��� ��� ���̾�α� â �߰� ���� -->
<div id="dlog_empIns" buttons="#linkbtn_empIns" class="easyui-dialog" title="������" style="width:400px;height:350px;" closed="true"
        data-options="iconCls:'icon-man',resizable:true,modal:true">
 	<form id="f_empIns" style="padding:15px 10px">
<!-- �����ȣ ���� -->
 		<div style="margin-bottom:10px">
 		<label>�����ȣ :</label>
 		<input id="empno" name="empno" class="easyui-textbox" required="true">
 		</div>
<!-- �����ȣ  �� --> 		
<!-- ����� ���� --> 
        <div style="margin-bottom:10px">	
 		<label>����� :</label>
 		<input id="ename" name="ename" class="easyui-textbox" required="true">
 		</div>
<!-- �����  �� --> 	
<!-- JOB ���� --> 
        <div style="margin-bottom:10px">	
 		<label>JOB :</label>
 		<input id="job" name="job" class="easyui-textbox" required="true">
 		</div>
<!-- JOB  �� --> 	
<!-- �׷��ڵ� ���� --> 
        <div style="margin-bottom:10px">		
 		<label>MGR :</label>
 		<input id="mgr" name="mgr" class="easyui-textbox" required="true">
 		</div>
<!-- �׷��ڵ�  �� --> 	
<!-- �Ի����� ���� --> 	
		<div style="margin-bottom:10px">	
 		<label>�Ի����� :</label>
 		<input id="hiredate" name="hiredate" class="easyui-datebox" required="true">
 		</div>
<!-- �Ի�����  �� --> 	
<!-- �޿� ���� --> 
	    <div style="margin-bottom:10px">		
 		<label>�޿� :</label>
 		<input id="sal" name="sal" class="easyui-textbox" required="true">
 		</div>
<!-- �޿�  �� --> 	
<!-- �μ�Ƽ�� ���� --> 	
        <div style="margin-bottom:10px">	
 		<label>�μ�Ƽ�� :</label>
 		<input id="comm" name="comm" class="easyui-textbox" required="true">
 		</div>
<!-- �μ�Ƽ��  �� --> 	
<!-- �μ���ȣ ���� --> 	
		<div style="margin-bottom:10px">	
 		<label>�μ���ȣ :</label>
 		<input id="deptno" name="deptno" class="easyui-combobox" required="true">
 		</div>
<!-- �μ���ȣ  �� --> 	
 	</form>       
</div>
<!-- ������ ���̾�α� â�� ��ư �߰� ���� -->
<div id="linkbtn_empIns">
    <a href="javascript:void(0)" class="easyui-linkbutton c1"  onclick="empInsertAction()">����</a>
    <a href="javascript:void(0)" class="easyui-linkbutton c5" onclick="$('#dlog_empIns').dialog('close')">�ݱ�</a>
</div>
<!-- ������ ���̾�α� â�� ��ư �߰� �� -->
<!-- ��� ��� ���̾�α� â �߰�   ��  -->
</body>
</html>















<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
//�� �������� ��ȸ�ϱ� -IN���� �ǽ�
function searchALL(){
	//����ڰ� ������ �μ���ȣ�� ���� ���� ����
	var vdeptno="";
	var vdeptnos=[];
	var rows=$("#grid_emp").datagrid('getSelections');
	alert(rows);//Object,Object,Object
	//����ڰ� ������ �μ���ȣ�� �迭�� ���
	for(var i=0;i<rows.length;i++){
		vdeptnos.push(rows[i].deptno);
	} 
	//�迭�� ��� ���� ����غ���
	for(var i=0;i<rows.length;i++){
		//10,30...���ڿ� �޸��� ���̴ٰ� �� ���������� ������ �ʽ��ϴ�.
		if(i==(rows.length-1)){
			vdeptno +=vdeptnos[i];
		}
		//�ڿ� ���� �� ���� ��쿡�� �޸��� �ٿ��ش�.
		else{
			vdeptno +=vdeptnos[i]+",";
		}
	}
	//10,30,40
	alert("vdeptno:"+vdeptno);
	location.href="./getEmpList2.kosmo?deptno="+vdeptno;
}
//�����Ϲ�ư Ŭ��������
function empInsert(){
	$('#deptno').combobox({
		url:'./dept/getDeptnoList.kosmo'
		,valueField:'DEPTNO'
		,textField:'DEPTNO'
	});
	$('#dlg_empIns').dialog('open');
}
function empnoSearch(){
	
}
function enameSearch(){
	
}
function jobSearch(){
	
}
function cancelrow(){
	$("#grid_emp").datagrid('cancelEdit',getRowIndex(target));
}
</script>
</head>
<body>
<script type="text/javascript">
$(document).ready(function(){
	/*������ �׸��� �ʱ�ȭ ����  */
	$("#grid_emp").datagrid({
	//url:"./empList.json"
	url:"./getEmpList.kosmo"
		,columns:[[
			{field:'empno',title:'�����ȣ',width:80,align:'center',editor:'text'}
			,{field:'ename',title:'�����',width:100,align:'center',editor:'text'}
			,{field:'job',title:'JOB',width:120,align:'center',editor:'text'}
			,{field:'hiredate',title:'�Ի�����',width:120,align:'center',editor:'text'}
			,{field:'deptno',title:'�μ���ȣ',width:80,align:'center',	
				formatter:function(value,row){
				return row.deptno||value;
			},
			editor:{
				type:'combobox'
			,options:{
				valueField:'DEPTNO',//���� ������ �Ѿ�� �ʵ�
				textField:'DEPTNO',//ȭ�鿡 ��µǴ� �ʵ�
				url:'../dept/getDeptnoList.kosmo',
				required:true
			}////////////////////end of options
			}/////////////////////////end of editor
				}
			,{field:'dname',title:'�μ���',width:100,align:'center',editor:'text'}
			,{field:'action',title:'Action',width:100,align:'center',
			formatter:function(value,row,index){
		      if(row.editing){
		       var s ='<a href="#" onClick="saverow(this)">Save</a>&nbsp';
		       var c ='<a href="#" onClick="cancelrow(this)">Cancel</a>';
		        return s+c;
		       }
		      else{
		          var e='<a href="#" onClick="editrow(this)">Edit</a>&nbsp';
		           var d='<a href="#" onClick="deleterow(this)">Delete</a>';
		           return e+d;
		          }
		}//////////////////end of formatter
	}/////////////////////end of action
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
	/* ,data: [
		{empno:'6000', ename:'�̼���',job:'����',hiredate:'2009-10-25',deptno:40,dname:'�ؿܿ���'}
		,{empno:'7000', ename:'������',job:'����',hiredate:'2009-10-25',deptno:40,dname:'�ؿܿ���'}
		] */
	});

	/*������ �׸��� �ʱ�ȭ ��  */
});///////////////////////////////////end of ready
function getRowIndex(target){
	var tr=$(target).closest('tr.datagrid-row');
	return parseInt(tr.attr('datagrid-row-index'));
}
function editrow(target){
	$("#grid_emp").datagrid('beginEdit',getRowIndex(target));
}
function deleterow(target){
	$.messager.confirm('Confirm','���� �����Ͻðڽ��ϱ�?',function(r){
		if(r){
			var vempnos="";
			var empnoArr=[];
			var rows =$("#grid_emp").datagrid('getSelections');//�ο쿡 ���� Object
			//����ڰ� ������ �ο쿡 ���� Object�� �̿��ϸ� field�� ������ �� �ִ�.
			if(rows==null){
				alert("������ ����� �����ϼ���");
				return;
			}
			for(var i=0;i<rows.length;i++){
				empnoArr.push(rows[i].empno);
			}
			for(var i=0;i<rows.length;i++){
				if(i==(rows.length-1)){
					vempnos +=empnoArr[i];
				}
				else{
					vempnos +=empnoArr[i]+",";
				}
			}
			alert("����ڰ� ������ �����ȣ:"+vempnos);
			location.href="./empDelete.kosmo?empnos="+vempnos;//������ ��û(���۹��:get)
			//ȭ��󿡼��� ���� �ȴ�.-������ ���� selectó�� �� ���̹Ƿ� �ǹ̰� ����.
		//	$("#grid_emp").datagrid('deleteRow',getRowIndex(target));
		}
	});
}
</script>
<!--���� �߰��ϱ� ����-->
<!-- ���̺��� ���� �߰��� ���� ������Ϲ�ư -->
<div id="tbar_empList">
<!-- �˻� ���� �߰� ȭ�� �Դϴ�.  -->
<form id="f_search">
	<table>
		<tr>
			<td width="140px">
			<label width="80px">�����ȣ</label>

			<input id="empno" name="empno" class="easyui-searchbox" data-options="prompt:'�����ȣ', searcher:empnoSearch" style="width:60px">
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
		    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="empUpdForm()">�������</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="empInsert()">������</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="deleterow()">�������</a>			
			</td>
		</tr>		
	</table>
</form>	
<!-- �˻� ���� �߰� ȭ�� �Դϴ�.  -->	
</div>
<!--���� �߰��ϱ� ��-->
<!-- ���̺� �׸��� -->
<table id="grid_emp" toolbar="tbar_empList"class="easyui-datagrid"title="������"style="width:1000px;height:400px">
</table>
<!--��� ��� ���̾�α�â �߰� ����  -->
<div id="dlog_empIns" buttons="#linkbtn_empIns" class="easyui-dialog" title="������" style="width:400px;height:200px;" closed="true"
     data-options="iconCls:'icon-man',resizable:true,modal:true">
     <form id="f_empIns">
     <!--�����ȣ����  -->
     <label>��� ��ȣ</label>
     <input id="empno" name="empno" class="easyui-textbox" required="true">
     <!--�����ȣ�� -->
      <!--����̸� ����  -->
     <label>��� �̸�</label>
     <input id="ename" name="ename" class="easyui-textbox"required="true">
     <!--����̸� �� -->
      <!--JOB ����  -->
     <label>job</label>
     <input id="job" name="job" class="easyui-textbox"required="true">
     <!--JOB �� -->
      <!--�׷��ڵ� ���� -->
     <label>mgr</label>
     <input id="mgr" name="mgr" class="easyui-textbox"required="true">
     <!--�׷��ڵ� �� -->
      <!--�Ի����ڽ��� -->
     <label>�Ի�����:</label>
       <input id="hiredate" name="hiredate" class="easyui-datebox" required="required">
     <!--�Ի����� �� -->
      <!--�޿����� -->
     <label>�޿�:</label>
       <input id="sal" name="sal" class="easyui-textbox"required="true">
     <!--�޿� �� -->
      <!--�μ�Ƽ����� -->
     <label>�μ�Ƽ��:</label>
       <input id="comm" name="comm" class="easyui-textbox"required="true">
     <!--�μ�Ƽ�� �� -->
      <!--�μ���ȣ���� -->
     <label>�μ���ȣ:</label>
       <input id="deptno" name="deptno" class="easyui-combobox">
     <!--�μ���ȣ �� -->
     </form>
</div>
<!--��� ��� ���̾�α�â �߰� ��  -->
<!--������ ���̾�α� â�� ��ư �߰� ����  -->
<div>
	<a href="javascriptvoid(0)" class="easyui-linkbutton" onclick="$('dlog_empIns').dialog('open')">����</a>
	<a href="javascriptvoid(0)" class="easyui-linkbutton" onclick="$('dlog_empIns').dialog('close')">�ݱ�</a>
</div>
<!--������ ���̾�α� â�� ��ư �߰� ��  -->
</body>
</html>
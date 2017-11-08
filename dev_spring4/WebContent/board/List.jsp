<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.Map" %>    
<%
Integer total=null;
total=(Integer)session.getAttribute("total");
String imgPath="../images/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�۸��</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
//���ΰ�ħ ó���� �� Ȥ�� ���ǰ˻� ����� ���� ������ �� Ȱ�밡��.
   function searchALL()
   {
      location.href="./getBoardList.kosmo?page=1&pageSize=10";
      $("#pg_board").pagination({
    	  total:<%=total%>,
    	  pageSize:10,
    	  onSelectPage:function(pageNumber,pageSize){
    		  pageMove(pageNumber,pageSize);
    	  }
      });
   }
   function pageMove(pageNumber,pageSize){
	   $("#grid_board").datagrid({
		   idField:"itemid",
		   url:"./jSonGetBoardList.kosmo?page="+pageNumber+"&pageSize="+pageSize
	   });
   }
   function emailSend()
   {
      $("#f_email").attr("method","get");
      $("#f_email").attr("action","./emailSendAction.jsp");
      $("#f_email").submit();
   }
   function writeForm()
   {
      $("#dlg_boardIns").dialog('open').dialog('setTitle','�۵��');
   }
   function mailForm()
   {
	      $("#cb_email").combobox({
	    	  valueField:'value'
	    	  ,textField:'value'
	    	  ,data:[{
	    		  label:'1'
	    		  ,value:'@hanmail.net'
	    	  },
	    	  {
	    		  label:'2'
	    		  ,value:'@gmail.com'
	    	  }
	    	  ,{
	    		  label:'3'
	    	     ,value:'@naver.com'		    
	    	  }]
	      ,onSelect:function(record){
	    	  $("#e_email").val(record.text);
	      }
	      });
      $("#dlg_email").dialog('open').dialog('setTitle','���Ͼ���');
   }
   function boardInsert()
   {
      $("#f_boardIns").attr("method","post");
      $("#f_boardIns").attr("action","./boardInsert.kosmo");
      $("#f_boardIns").submit();
   }
</script>
</head>
<body>
<script type="text/javascript">
/* datagrid�� ���� �ʱ�ȭ�� html�±׳��� ó���� �� ������ easyui����� �� ������ ���ؼ��� ��ũ��Ʈ�� 
   ó���� �δ� ���� �����ϴ�.
*/
   $(document).ready(function (){
      /* datagrid �ʱ�ȭ (�ٸ� UI�ַ�ǰ� �������)*/
      $("#grid_board").datagrid({
    	  idField:'itemid'
    	  /* ,url:'./jSonGetBoardList.kosmo' */
         ,columns:[[
            {field:'B_NO',title:'��ȣ',width:60,editor:'text',align:'center'}
            ,{field:'B_TITLE',title:'����',width:460,editor:'text'}
            ,{field:'B_NAME',title:'�ۼ���',width:100,editor:'text',align:'center'}
            ,{field:'B_DATE',title:'�ۼ���',width:100,editor:'text',align:'center'}
            ,{field:'B_FILE',title:'÷������',width:200,editor:'text',align:'center'}
            ,{field:'B_HIT',title:'��ȸ��',width:80,editor:'text',align:'center'}
         ]]
      });/////////////////////////end of datagrid
      $("#pg_board").pagination({
    	  total:<%=total%>,
    	  pageSize:10,
    	  onSelectPage:function(pageNumber,pageSize){
    		  pageMove(pageNumber,pageSize);
    	  }
      });
   });/////////////////////////////end of ready
</script>
<!-- �̸���ȭ�� ���� -->
<div id="dlg_email" buttons="#dlg_emailBtn" class="easyui-dialog" closed="true" style="width:600px">
   <form id="f_email" method="post" enctype="multipart/form-data" style="padding:20px 50px">
   <div style="margin-bottom:10px">
      <input id="e_email" name="e_email" class="easyui-textbox" label="�޴� ���" required="true" style="width:200px">
      <input id="cb_email" name="cb_email" class="easyui-combobox">
   </div>
   <div style="margin-bottom:10px">
      <input name="e_title" class="easyui-textbox" label="����" required="true" style="width:100%">
   </div>
   <div style="margin-bottom:10px">
      <input name="e_name" class="easyui-textbox" label="�ۼ���" required="true" style="width:100%">
   </div>
   <div style="margin-bottom:10px">
      <input name="e_content" class="easyui-textbox" multiline="true" label="����" required="true" style="width:100%;height:120px">
   </div>
   </form>
</div>
<div id="dlg_emailBtn">
   <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="emailSend()">������</a>
   <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg_email').dialog('close')">�ݱ�</a>
</div>

<!-- �̸���ȭ�� �� -->

<!-- ���� ���� -->
<div id="tbar_board">
   <form id="f_search">   
   <table>
      <!-- ���� �˻� ȭ�� �߰� -->
      <!-- ��ư �߰� -->
      <tr>
         <td>
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchALL()">��ü��ȸ</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="writeForm()">�۵��</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="updateForm()">�ۼ���</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="deleteForm()">�ۻ���</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-man" onclick="mailForm()">����</a>
         </td>
      </tr>
   </table>
   </form>
</div>
<!-- ����  ��   -->
<!-- ������ �׸��� ���� -->
<table id="grid_board" title="MVC��� ������ �Խ���" fitColumns="true" singleSelect="true" toolbar="#tbar_board" pagination="#pg_board" class="easyui-datagrid" style="width:1000px;height:400px">
<!-- ��ȸ����� ������ ����ϱ� -->
<%
   List<Map<String,Object>> boardList =
            (List<Map<String,Object>>)request.getAttribute("boardList");
   if(boardList !=null){
	   out.print("dd"+boardList.size());
      for(int i=0;i<boardList.size();i++){//NullPointerException �Ͼ �� �ִ�.
         Map<String,Object> rMap = boardList.get(i);
%>
   <tr>
      <td><%=rMap.get("B_NO") %></td>
      <td align="left">
      <%
      //�� ���?
    if(Integer.parseInt(rMap.get("B_POS").toString())>0){
    	for(int j=0;j<Integer.parseInt(rMap.get("B_POS").toString());j++){
    	out.print("&nbsp;&nbsp");
    	}//////////end of for
      %>
      <img src="<%=imgPath %>enter.png" width="8" height="8">
      <%
      }//////////////////////////////end of if
      %>
      <a href="./getBoardDetail.kosmo?b_no=<%=rMap.get("B_NO")%>"><%=rMap.get("B_TITLE") %></a></td>
      <td><%=rMap.get("B_NAME") %></td>
      <td><%=rMap.get("B_DATE") %></td>
      <td>
<%
//÷�������� �ִ� ���.
	if(rMap.get("B_FILE")!=null){
%>
<a href="./downLoad.jsp?bFile=<%=rMap.get("B_FILE") %>">
<%=rMap.get("B_FILE") %>
</a>
<%
	}else{
%>
   &nbsp;
 <%
	}
  %>  
  	</td> 
      <td><%=rMap.get("B_HIT") %></td>
   </tr>
<%
      }////////////////end of for
   }///////////////////end of if
%>   
</table>
<!-- ������ �׸���  ��   -->
<!-- ���������̼� ����  -->
<div id="pg_board" class="easyui-pagination" style="width:1000px;height:20px"></div>
<!-- ���������̼�   ��   -->
<!--================== �۵�� ȭ�� �߰� ���� ==================-->
<div id="dlg_boardIns" buttons="#dlg_btnInsert" class="easyui-dialog" closed="true" style="width:600px">
   <form id="f_boardIns" method="post" enctype="multipart/form-data" style="padding:20px 50px">
   <div style="margin-bottom:10px">
      <input name="b_title" class="easyui-textbox" label="����" required="true" style="width:100%">
   </div>
   <div style="margin-bottom:10px">
      <input name="b_name" class="easyui-textbox" label="�ۼ���" required="true" style="width:100%">
   </div>
   <div style="margin-bottom:10px">
      <input name="b_content" class="easyui-textbox" multiline="true" label="����" required="true" style="width:100%;height:120px">
   </div>
   <div style="margin-bottom:10px">
      <input name="bfile" class="easyui-filebox" label="÷������" required="true" style="width:100%">
   </div>
   <div style="margin-bottom:10px">
      <input name="b_pw" class="easyui-textbox" label="���" required="true" style="width:100%">
   </div>            
   </form>
</div>
<!--�۵�� ȭ�鿡  �����ư�� ��� ��ư �߰��ϱ� -->
<div id="dlg_btnInsert">
   <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="boardInsert()">����</a>
   <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg_boardIns').dialog('close')">�ݱ�</a>
</div>
<!--================== �۵�� ȭ�� �߰�   ��  ==================-->
</body>
</html>











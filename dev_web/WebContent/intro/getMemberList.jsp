<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%@ page import="java.util.List" %> 
    <%@ page import="java.util.List" %> <%@ page import="com.vo.MemberVO" %>     
    <%
   
    List<MemberVO> listmvo = (List<MemberVO>) request.getAttribute("memList");
    
   
%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/js/commons.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
function memoInsertForm(to_id){
	/* $("#dlg_memoIns").dialog('open').dialog('setTitle','��������');
	$("#f_memoIns").form('clear'); */
	cmm_window_popup('memoForm.jsp?to_id='+to_id,500,300,'memoForm');
}
function memoInsert(){
	$("#f_memoIns").attr("method","post");
	$("#f_memoIns").attr("action","./memoInsert.mem");
	$("#f_memoIns").submit();
}
</script>
</head>
<body>
<table border="1" borderColor="gray" width="100%" height="100%">
<tr><td>
<table id="tb_memberList" title="ȸ����� ����" singleSelect="true" rownumbers="true" class="easyui-datagrid" style="width:1000px;height:400px">
   <thead>
   <tr>
   
   <th field= "mem_name" width="150" align="center"> ����</th>
   <th field= "mem_id" width="150" align="center"> ���̵�</th>
   <th field= "mem_tel" width="200" align="center" >��ȭ��ȣ</th>
   <th field= "gender" width="100" align="center">����</th>
   <th field= "send" width="100" align="center">��������</th>
   </tr>
      </thead>
   <!--db���� ��ȸ�� ��� ����ϱ�  -->
   <% if(listmvo==null || listmvo.size()==0) {  %>   
      
      
      <tr>
      <td colspan="4" align="center">��ȸ����� �����ϴ�.</td>
      </tr>
      
      <%
   }
   else{
      
   
      for(int i=0;i<listmvo.size();i++){
         
      
      %>
      
      
      
      
      
      <tr>
      
      <td align ="center"> <%=listmvo.get(i).getMem_name()%> </td>
      <td align ="center"> <%=listmvo.get(i).getMem_id()%> </td>
      <td align ="center"> <%=listmvo.get(i).getMem_tel()%> </td>
      <td align ="center"> <%=listmvo.get(i).getGender()%> </td>
      <td align ="center">
      <%
   //	String sid = (String)session.getAttribute("sid");
      //�� �޴� ���̵�� �ٸ���?
    	if(!sid.equals(listmvo.get(i).getMem_id())){
      %>
      <a class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="memoInsertForm('<%=listmvo.get(i).getMem_id()%>')"> �������� 
      <%
      }
      else{
      %>
      &nbsp;
      <%
      }
      %>
      </td>
      </tr>
      
      
      <%
      } // end of for
   }
      
      %>
   
</table>

</td></tr>

</table>
<!-- �������� ��ư Ŭ������ �� �������� ȭ�� ���� -->
<!-- <div id="dlg_memoIns" class="easyui-dialog" style="width:500px" closed="true" buttons="#dlg_button">
<form action="f_memoIns" style="margin:();padding:20px 50px">
<div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #CCCCCC">�������</div>
<div style="margin-bottom:10px">
<label style="width:200">�޴� ���:</label>
<input name="to_id" class="easyui-textbox" style="width:70%">
</div>
<div style="margin-bottom:10px">
<label style="width:200">������ ���:</label>
<input name="from_id" class="easyui-textbox" style="width:70%">
</div>
<div style="margin-bottom:10px">
<label style="width:200">��        ��:</label>
<input name="memo_content" class="easyui-textbox" style="width:70%;height:100px">
</div>
<div id="#dlg_button" align-"center">
<a class="easyui-linkbutton c5" iconCls="icon-ok" plain="true" onClick()="memoInsert()">����</a>
<a class="easyui-linkbutton c5" iconCls="icon-cancel" plain="true" onClick()="javascript:$('#dlg_memoIns').dialog('close')"
style="width:90px">���</a>

</div>
</form>
</div> -->
</body>
</html>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.List, java.util.Map, java.util.HashMap" %>    
<%
   //insert here -  1을 출력
   List<Map<String,Object>> boardList = 
                     (List<Map<String,Object>>)request.getAttribute("boardList");
    //out.print("size:"+boardList.size());//1
    Map<String,Object> rMap = new HashMap<String,Object>();
    if(boardList!=null){
       rMap = boardList.get(0);
    }
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>글상세보기</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
//댓글 쓰기 화면을 호출 할 때
function repleForm(){
	$("#dlg_boardIns").dialog('open').dialog('setTitle','댓글쓰기');
}
//댓글 쓰기 처리할 때(DB반영하기)
function boardInsert(){
	$("#f_boardIns").attr("method","post");
	$("#f_boardIns").attr("action","./boardInsert.kosmo");
	$("#f_boardIns").submit();
}
//수정 화면을 호출 할 때
function UpdateForm(){
	$("#ub_title").textbox('setValue',$("#b_title").val());
	$("#ub_name").textbox('setValue',$("#b_name").val());
	$("#ub_email").textbox('setValue',$("#b_email").val());
	$("#ub_date").textbox('setValue',$("#b_date").val());
	$("#ub_content").textbox('setValue',$("#b_content").val());
	$("#ub_pw").textbox('setValue',$("#b_pw").val());
	$("#dlg_boardUpd").dialog('open').dialog('setTitle','글수정하기');
}
//수정 처리할 때(DB반영하기)
function boardUpdate(){
	$("#f_boardIUpd").attr("method","post");
	$("#f_boardUpd").attr("action","./boardInsert.kosmo");
	$("#f_boardUpd").submit();
}
//삭제 화면 호출할 때- 화면만 띄우기
function deleteForm(){
	$("#dlg_boardDel").dialog('open').dialog('setTitle','글삭제');
}
//삭제 처리할 때(DB반영 하기)
function boardDelete(){
       //db엣 가져온 비번과 사용자가 입력한 비번이 같니?
             if($("#b_pw").val()=='<%=rMap.get("B_PW")%>')
                {
                $.messager.confirm('Confirm','정말 삭제하시겠습니까?',function(r){
                   if(r){
                      $("#f_boardDel").attr("method","get");
                      $("#f_boardDel").attr("action","./boardDelete.kosmo");
                      $("#f_boardDel").submit();
                   }
                })
                }
             else{
                $.messager.confirm('Confirm','비밀번호가 틀립니다.',function(r){
                   if(r){
                      $("#pw").textbox('setValue','');
                   }
                })
             }
    }
</script>
</head>
<body>
<script type="text/javascript">
   $(document).ready(function(){
      $("#b_title").textbox('setValue','<%=rMap.get("B_TITLE")%>');
      $("#b_name").textbox('setValue','<%=rMap.get("B_NAME")%>');
      $("#b_date").textbox('setValue','<%=rMap.get("B_DATE")%>');
      $("#b_email").textbox('setValue','<%=rMap.get("B_EMAIL")%>');
      $("#b_content").textbox('setValue','<%=rMap.get("B_CONTENT")%>');
      $("#b_file").textbox('setValue','<%=rMap.get("B_FILE")%>');
   });
</script>
<div id="p" class="easyui-panel" title="글상세보기" style="width:800px;height:350px;padding:20px 20px;background:#fafafa;"
        data-options="iconCls:'icon-save',closable:true,
                collapsible:true,minimizable:true,maximizable:true,footer:'#btn_read'">
   <div style="margin-bottom:10px">
      <input id="b_title" name="b_title" class="easyui-textbox" label="제목" required="true" style="width:90%">
   </div>
   <div style="margin-bottom:10px">
      <input id="b_date" name="b_date" class="easyui-textbox" label="작성일" required="true" style="width:90%">
   </div>   
   <div style="margin-bottom:10px">
      <input id="b_name" name="b_name" class="easyui-textbox" label="작성자" required="true" style="width:90%">
   </div>
      <div style="margin-bottom:10px">
      <input id="b_email" name="b_email" class="easyui-textbox" label="이메일" required="true" style="width:90%">
   </div>
   <div style="margin-bottom:10px">
      <input id="b_content" name="b_content" class="easyui-textbox" multiline="true" label="내용" required="true" style="width:90%;height:120px">
   </div>
   <div style="margin-bottom:10px">
      <input id="b_file" name="b_file" class="easyui-textbox" label="첨부파일" required="true" style="width:90%">
   </div>
</div>
<!--글등록 화면에  저장버튼과 취소 버튼 추가하기 -->
<div align="right" id="btn_read">
   <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="searchALL()">답글</a>
   <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="updateForm()">글수정</a>
   <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="deleteForm()">글삭제</a>
   <a href="#" class="easyui-linkbutton" iconCls="icon-list" onclick="javascript:location.href='./getBoardList.kosmo'">글목록</a>
</div>   
<!--댓글 쓰기 화면 추가 시작  -->
<!-- 
다이얼로그 추가
form태그 추가
hidden으로 글번호(b_no:새글,댓글구분),그룹번호(b_group:같은번호,끼워넣을경우)
,차수번호(b_pos),순번(b_step)
입력받을 수 있는 콤포넌트-textbox,filebox,combobox
 -->
 <!--다이얼 로그 추가-->
<div id="dlg_boardIns" buttons="#dlg_btnInsert" class="easyui-dialog" closed="true"style="width:600px">
<form id="f_boardIns" method="post" enctype="multipart/form-data" style="padding:20px 50px">
<input type="hidden" id="b_no" value="<%=rMap.get("B_NO")%>">
<input type="hidden" id="b_group" value="<%=rMap.get("B_GROUP")%>">
<input type="hidden" id="b_pos" value="<%=rMap.get("B_POS")%>">
<input type="hidden" id="b_step" value="<%=rMap.get("B_STEP")%>">
<input type="hidden" id="b_seq" value="<%=rMap.get("B_SEQ")%>">
<input type="hidden" id="org_file" value="<%=rMap.get("B_FILE")%>">
<input class="easyui-textbox">
   <div style="margin-bottom:10px">
      <input id="ub_title" name="b_title" class="easyui-textbox" label="제목" required="true" style="width:90%">
   </div>
   <div style="margin-bottom:10px">
      <input id="ub_name" name="b_name" class="easyui-textbox" label="작성자" required="true" style="width:90%">
   </div>
   <div style="margin-bottom:10px">
      <input id="ub_email" name="b_email" class="easyui-textbox" label="이메일" required="true" style="width:90%">
   </div>   
   <div style="margin-bottom:10px">
      <input id="ub_content" name="b_content" class="easyui-textbox" multiline="true" label="내용" required="true" style="width:90%;height:120px">
   </div>
   <div style="margin-bottom:10px">
      <input id="ub_file" name="b_file" class="easyui-textbox" label="첨부파일" required="true" style="width:90%">
   </div>
   <div style="margin-bottom:10px">
      <input id="ub_pw" name="b_pw" class="easyui-textbox" label="비번" required="true" style="width:90%">
   </div>
</form>
</div>
<!--댓글쓰기 버튼 추가  -->
<div id="dlg_btnInsert">
<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onClick="boardInsert()">저장</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onClick="javascript:$('#dlg_boardIns').dialog('close')">저장</a>
</div>
<!--댓글 쓰기 화면 추가 끝  -->
<!-- 수정화면 추가 시작 -->
<div id="dlg_boardUpd" buttons="#dlg_btnUpdate" class="easyui-dialog" closed="true"style="width:600px">
<form id="f_boardUpd" method="post" enctype="multipart/form-data" style="padding:20px 50px">
<input type="hidden" id="b_no" name="b_no" value="<%=rMap.get("B_NO")%>">
<input type="hidden" id="b_group" name="b_group" value="<%=rMap.get("B_GROUP")%>">
<input type="hidden" id="b_pos" name="b_pos" value="<%=rMap.get("B_POS")%>">
<input type="hidden" id="b_step" name="b_step" value="<%=rMap.get("B_STEP")%>">
<input type="hidden" id="org_file" name="org_file" value="<%=rMap.get("B_FILE")%>">
<input class="easyui-textbox">
   <div style="margin-bottom:10px">
      <input id="b_title" name="b_title" class="easyui-textbox" label="제목" required="true" style="width:90%">
   </div>
   <div style="margin-bottom:10px">
      <input id="b_name" name="b_name" class="easyui-textbox" label="작성자" required="true" style="width:90%">
   </div>
   <div style="margin-bottom:10px">
      <input id="b_email" name="b_email" class="easyui-textbox" label="이메일" required="true" style="width:90%">
   </div>   
   <div style="margin-bottom:10px">
      <input id="b_content" name="b_content" class="easyui-textbox" multiline="true" label="내용" required="true" style="width:90%;height:120px">
   </div>
   <div style="margin-bottom:10px">
      <input id="b_file" name="b_file" class="easyui-textbox" label="첨부파일" required="true" style="width:90%">
   </div>
   <div style="margin-bottom:10px">
      <input id="b_pw" name="b_pw" class="easyui-textbox" label="비번" required="true" style="width:90%">
   </div>
</form>
</div>
<!--수정 버튼 추가  -->
<div id="dlg_btnUpdate">
<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onClick="boardUpdate()">저장</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onClick="javascript:$('#dlg_boardUpd').dialog('close')">저장</a>
</div>
<!-- 수정화면 추가 끝 -->
<!--글 삭제 기능 구현 추가 시작  -->
<div id="dlg_boardDel" buttons="#dlg_btnDelete" class="easyui-dialog" closed="true" style="width:350px">
<form id="f_boardDel" method="get">
<input type="hidden" id="b_no" name="b_file" value="<%=rMap.get("B_NO") %>">
<input type="hidden" id="b_seq" name="b_file" value="<%=rMap.get("B_SEQ") %>">
<input type="hidden" id="b_file" name="b_file" value="<%=rMap.get("B_FILE") %>">
<div style="margin-bottom:10px">
<input id="b_pw" name="b_pw" class="easyui-textbox"label="비번"required="true"
style="width:150px">
</div>
</form>
</div>
<!--삭제 버튼 추가  -->
<div id="dlg_btnDelete">
<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onClick="boardDelete()">삭제</a>
<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onClick="javascript:$('#dlg_boardDel').dialog('close')">저장</a>
</div>
<!-- 글 삭제 기능 구현 추가 끝 -->
</body>
</html>
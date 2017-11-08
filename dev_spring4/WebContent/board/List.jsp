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
<title>글목록</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
//새로고침 처리할 때 혹은 조건검색 결과를 새로 가져올 때 활용가능.
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
      $("#dlg_boardIns").dialog('open').dialog('setTitle','글등록');
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
      $("#dlg_email").dialog('open').dialog('setTitle','메일쓰기');
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
/* datagrid에 대한 초기화를 html태그내에 처리할 수 있지만 easyui기능을 더 누리기 위해서는 스크립트로 
   처리해 두는 것이 유리하다.
*/
   $(document).ready(function (){
      /* datagrid 초기화 (다른 UI솔루션과 공통사항)*/
      $("#grid_board").datagrid({
    	  idField:'itemid'
    	  /* ,url:'./jSonGetBoardList.kosmo' */
         ,columns:[[
            {field:'B_NO',title:'번호',width:60,editor:'text',align:'center'}
            ,{field:'B_TITLE',title:'제목',width:460,editor:'text'}
            ,{field:'B_NAME',title:'작성자',width:100,editor:'text',align:'center'}
            ,{field:'B_DATE',title:'작성일',width:100,editor:'text',align:'center'}
            ,{field:'B_FILE',title:'첨부파일',width:200,editor:'text',align:'center'}
            ,{field:'B_HIT',title:'조회수',width:80,editor:'text',align:'center'}
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
<!-- 이메일화면 시작 -->
<div id="dlg_email" buttons="#dlg_emailBtn" class="easyui-dialog" closed="true" style="width:600px">
   <form id="f_email" method="post" enctype="multipart/form-data" style="padding:20px 50px">
   <div style="margin-bottom:10px">
      <input id="e_email" name="e_email" class="easyui-textbox" label="받는 사람" required="true" style="width:200px">
      <input id="cb_email" name="cb_email" class="easyui-combobox">
   </div>
   <div style="margin-bottom:10px">
      <input name="e_title" class="easyui-textbox" label="제목" required="true" style="width:100%">
   </div>
   <div style="margin-bottom:10px">
      <input name="e_name" class="easyui-textbox" label="작성자" required="true" style="width:100%">
   </div>
   <div style="margin-bottom:10px">
      <input name="e_content" class="easyui-textbox" multiline="true" label="내용" required="true" style="width:100%;height:120px">
   </div>
   </form>
</div>
<div id="dlg_emailBtn">
   <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="emailSend()">보내기</a>
   <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg_email').dialog('close')">닫기</a>
</div>

<!-- 이메일화면 끝 -->

<!-- 툴바 시작 -->
<div id="tbar_board">
   <form id="f_search">   
   <table>
      <!-- 조건 검색 화면 추가 -->
      <!-- 버튼 추가 -->
      <tr>
         <td>
            <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchALL()">전체조회</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-add" onclick="writeForm()">글등록</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="updateForm()">글수정</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="deleteForm()">글삭제</a>
            <a href="#" class="easyui-linkbutton" iconCls="icon-man" onclick="mailForm()">메일</a>
         </td>
      </tr>
   </table>
   </form>
</div>
<!-- 툴바  끝   -->
<!-- 데이터 그리드 시작 -->
<table id="grid_board" title="MVC기반 계층형 게시판" fitColumns="true" singleSelect="true" toolbar="#tbar_board" pagination="#pg_board" class="easyui-datagrid" style="width:1000px;height:400px">
<!-- 조회결과가 있으면 출력하기 -->
<%
   List<Map<String,Object>> boardList =
            (List<Map<String,Object>>)request.getAttribute("boardList");
   if(boardList !=null){
	   out.print("dd"+boardList.size());
      for(int i=0;i<boardList.size();i++){//NullPointerException 일어날 수 있다.
         Map<String,Object> rMap = boardList.get(i);
%>
   <tr>
      <td><%=rMap.get("B_NO") %></td>
      <td align="left">
      <%
      //너 댓글?
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
//첨부파일이 있는 경우.
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
<!-- 데이터 그리드  끝   -->
<!-- 페이지네이션 시작  -->
<div id="pg_board" class="easyui-pagination" style="width:1000px;height:20px"></div>
<!-- 페이지네이션   끝   -->
<!--================== 글등록 화면 추가 시작 ==================-->
<div id="dlg_boardIns" buttons="#dlg_btnInsert" class="easyui-dialog" closed="true" style="width:600px">
   <form id="f_boardIns" method="post" enctype="multipart/form-data" style="padding:20px 50px">
   <div style="margin-bottom:10px">
      <input name="b_title" class="easyui-textbox" label="제목" required="true" style="width:100%">
   </div>
   <div style="margin-bottom:10px">
      <input name="b_name" class="easyui-textbox" label="작성자" required="true" style="width:100%">
   </div>
   <div style="margin-bottom:10px">
      <input name="b_content" class="easyui-textbox" multiline="true" label="내용" required="true" style="width:100%;height:120px">
   </div>
   <div style="margin-bottom:10px">
      <input name="bfile" class="easyui-filebox" label="첨부파일" required="true" style="width:100%">
   </div>
   <div style="margin-bottom:10px">
      <input name="b_pw" class="easyui-textbox" label="비번" required="true" style="width:100%">
   </div>            
   </form>
</div>
<!--글등록 화면에  저장버튼과 취소 버튼 추가하기 -->
<div id="dlg_btnInsert">
   <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="boardInsert()">저장</a>
   <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg_boardIns').dialog('close')">닫기</a>
</div>
<!--================== 글등록 화면 추가   끝  ==================-->
</body>
</html>











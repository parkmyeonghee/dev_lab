<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>사원목록</title>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
//기본 날짜포맷을 재정의
	$.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'/'+(m<10? "0"+m:""+m)+'/'+(d<10? "0"+d:""+d);
	}
//날짜 포맷을 적용	
	$.fn.datebox.defaults.parser = function(s){
		var t = Date.parse(s);
		if (!isNaN(t)){
			return new Date(t);
		} else {
			return new Date();
		}
	}	
	//사원정보 수정 버튼 클릭했을 때 시작
	function empUpdate(){
		var row = $("#grid_emp").datagrid('getSelected');
		if(row == null)
		{
			alert("수정할 로우를 선택하세요");
			return;//해당 함수 탈출할 때 -empUpdate함수
		}
		$("#uempno").textbox('readonly',true);//true:읽기전용 false:수정가능
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
	//사원등록 폼에서 저장 버튼을 클릭했을 때
	//다이얼로그창에서 입력받은 후 서버로 전송한다.
	function empUpdateAction()
	{
		$("#f_empUpd").attr("method","get");
		$("#f_empUpd").attr("action","./empUpdate.kosmo");
		$("#f_empUpd").submit();
	}	
	//사원정보 수정 버튼 클릭했을 때 끝
	//사원등록 버튼 클릭했을 때
	function empInsert(){
 		$('#deptno').combobox({
		    url:'../dept/getDeptnoList.kosmo'
		   ,valueField:'DEPTNO'
	 	   ,textField:'DEPTNO'
		});
		$('#dlog_empIns').dialog('open');		
	}
	//사원등록 폼에서 저장 버튼을 클릭했을 때
	//다이얼로그창에서 입력받은 후 서버로 전송한다.
	function empInsertAction()
	{
		$("#f_empIns").attr("method","get");
		$("#f_empIns").attr("action","./empInsert.kosmo");
		$("#f_empIns").submit();
	}
//점조건으로 조회하기 - IN구문 실습
	function searchALL(){
		//사용자가 선택한 부서번호를 담을 변수 선언
		var vdeptno="";
		var vdeptnos = [];
		var rows = $("#grid_emp").datagrid('getSelections');
		alert(rows);//Object, Object, Object
		//사용자가 선택한 부서번호를 배열 담기
 		for(var i=0;i<rows.length;i++){
			vdeptnos.push(rows[i].deptno);
		}
		//배열에 담긴 정보 출력해보기
 		for(var i=0;i<rows.length;i++){
			//alert(vdeptnos[i]);
			//10,30...값 뒤에 콤마를 붙이다가 맨 마지막에는 붙이지 않습니다.
 			if(i==(rows.length-1)){
 				vdeptno +=vdeptnos[i];
 			}
			//뒤에 값이 더 있을 경우에는 콤마를 붙여 줍니다.
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
	//마이바티스에서 프로시저 호출 테스트
function procedureCall(){
	location.href="proc_salupdate.kosmo";
}
</script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function (){
/* 데이터 그리드 초기화 시작 */		
		$("#grid_emp").datagrid({
			url:"./getEmpList.kosmo"//List<XXXVO>-소문자, List<Map>-대문자(myBatis)
		  , columns:[[
							{field:'empno', title:'사원번호', width:80, align:'center', editor:'text'}
		                   ,{field:'ename', title:'사원명', width:100, align:'center', editor:'text'}
		                   ,{field:'job', title:'JOB', width:120, align:'center', editor:'text'}
		                   ,{field:'hiredate', title:'입사일자', width:100, align:'center', editor:'text'}
		                   ,{field:'deptno', title:'부서번호', width:80, align:'center',
		                	   formatter:function(value,row){
		                		   return row.deptno||value;
		                	   },
		                	   editor:{
		                		   type:'combobox'
		                	   	  ,options:{
		                	   		   valueField:'DEPTNO'//실제 서버에 넘어가는 필드
		                	   		  ,textField:'DEPTNO'//화면에 출력되는 필드
		                	   		  ,data:'DEPTNO'
		                	   		  ,url:'../dept/getDeptnoList.kosmo'
		                	   		  ,required:true
		                	   	   }///////end of options
		                	   }//////////end of editor
		                   }
		                   ,{field:'dname', title:'부서명', width:100, align:'center', editor:'text'}
		                   ,{field:'sal', title:'급여', width:100, align:'center', editor:'text', hidden:'true'}
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
						{empno:'6000', ename:'이순신',job:'영업',hiredate:'2009-10-25',deptno:40,dname:'해외영업'}
					   ,{empno:'7000', ename:'김유신',job:'영업',hiredate:'2009-10-25',deptno:40,dname:'해외영업'}
		          ] */
		});

/* 데이터 그리드 초기화  끝   */		
	});/////////////////////end of ready
	function getRowIndex(target){
		var tr = $(target).closest('tr.datagrid-row');
		return parseInt(tr.attr('datagrid-row-index'));
	}
	function editrow(target){
		$("#grid_emp").datagrid('beginEdit',getRowIndex(target));
	}
	//자바스크립트에서는 같은 이름의 함수를 지원하지 않습니다. -  메소드 오버로딩이 지원되지 않는다.
	//deletrow(); or deleterow(1,'안녕');
	function deleterow(target){
		$.messager.confirm('Confirm','정말삭제하시겠습니까?',function(r){
			if(r){
				var vempnos="";
				var empnoArr=[];
				var rows = $("#grid_emp").datagrid('getSelections');//로우에 대한 Object
				//사용자가 선택한 로우에 대한 Object를 이용하면 field에 접근할 수 있다.
				if(rows==null){
					alert("삭제할 사원을 선택하세요.");
					return;//deleterow함수 탈출
				}
				for(var i=0;i<rows.length;i++){
					empnoArr.push(rows[i].empno);
				}
				//배열에 담긴 정보 출력해보기
		 		for(var i=0;i<rows.length;i++){
		 			if(i==(rows.length-1)){
		 				vempnos +=empnoArr[i];
		 			}
					//뒤에 값이 더 있을 경우에는 콤마를 붙여 줍니다.
		 			else{
		 				vempnos +=empnoArr[i]+",";
		 			}
				}					
				location.href="./empDelete.kosmo?empnos="+vempnos;//서버에 요청(전송방식:get)
				//화면상에서만 삭제된다-삭제 후 새로 select처리할 것이므로 의미없다.
				//$("#grid_emp").datagrid('deleteRow',getRowIndex(target));
			}
		});
	}
	
</script>
<!-- 툴바 추가하기 시작 -->
<!-- 테이블내에 툴바 추가해 보기 도서등록버튼 -->
<div id="tbar_empList">
<!-- 검색 조건 추가 화면 입니다.  -->
<form id="f_search">
	<table>
		<tr>
			<td width="140px">
			<label width="80px">사원번호</label>
			<!-- 
<input class="easyui-searchbox" data-options="prompt:'Please Input Value',searcher:doSearch" style="width:100%">			
			 -->
			<input id="empno" name="empno"  class="easyui-searchbox" data-options="prompt:'사원번호', searcher:empnoSearch" style="width:60px">
			</td>
			<td width="180px">
			<label width="70px">사원명</label>
			<input id="ename" name="ename" class="easyui-searchbox" data-options="prompt:'사원명', searcher:enameSearch" style="width:110px">
			</td>
			<td width="180px">
			<label width="70px">JOB</label>
			<input id="job" name="job" class="easyui-searchbox" data-options="prompt:'JOB', searcher:jobSearch" style="width:110px">
			</td>
		</tr>
		<tr>
			<td colspan="4">
		    <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="searchALL()">사원조회</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-man" plain="true" onClick="empInsert()">사원등록</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="empUpdate()">사원수정</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="deleterow()">사원삭제</a>			
			<a href="#" class="easyui-linkbutton" iconCls="icon-tip" plain="true" onClick="procedureCall()">프로시저호출</a>			
			</td>
		</tr>		
	</table>
</form>	
<!-- 검색 조건 추가 화면 입니다.  -->	
</div>
<!-- 툴바 추가하기  끝   -->
<!-- 툴바 추가하기   끝 -->
<!-- 테이블 그리기 -->
<table id="grid_emp" toolbar="#tbar_empList" class="easyui-datagrid" title="사원목록" style="width:1000px;height:400px"></table>
<!-- 사원정보 수정 다이얼로그 창 추가 시작 -->
<div id="dlog_empUpd" buttons="#linkbtn_empUpd" class="easyui-dialog" title="사원등록" style="width:400px;height:350px;" closed="true"
        data-options="iconCls:'icon-man',resizable:true,modal:true">
 	<form id="f_empUpd" style="padding:15px 10px">
<!-- 사원번호 시작 -->
 		<div style="margin-bottom:10px">
 		<label>사원번호 :</label>
 		<input id="uempno" name="empno" class="easyui-textbox" required="true">
 		</div>
<!-- 사원번호  끝 --> 		
<!-- 사원명 시작 --> 
        <div style="margin-bottom:10px">	
 		<label>사원명 :</label>
 		<input id="uename" name="ename" class="easyui-textbox" required="true">
 		</div>
<!-- 사원명  끝 --> 	
<!-- JOB 시작 --> 
        <div style="margin-bottom:10px">	
 		<label>JOB :</label>
 		<input id="ujob" name="job" class="easyui-textbox" required="true">
 		</div>
<!-- JOB  끝 --> 	
<!-- 그룹코드 시작 --> 
        <div style="margin-bottom:10px">		
 		<label>MGR :</label>
 		<input id="umgr" name="mgr" class="easyui-textbox" required="true">
 		</div>
<!-- 그룹코드  끝 --> 	
<!-- 입사일자 시작 --> 	
		<div style="margin-bottom:10px">	
 		<label>입사일자 :</label>
 		<input id="uhiredate" name="hiredate" class="easyui-datebox" required="true">
 		</div>
<!-- 입사일자  끝 --> 	
<!-- 급여 시작 --> 
	    <div style="margin-bottom:10px">		
 		<label>급여 :</label>
 		<input id="usal" name="sal" class="easyui-textbox" required="true">
 		</div>
<!-- 급여  끝 --> 	
<!-- 인센티브 시작 --> 	
        <div style="margin-bottom:10px">	
 		<label>인센티브 :</label>
 		<input id="ucomm" name="comm" class="easyui-textbox" required="true">
 		</div>
<!-- 인센티브  끝 --> 	
<!-- 부서번호 시작 --> 	
		<div style="margin-bottom:10px">	
 		<label>부서번호 :</label>
 		<input id="udeptno" name="deptno" class="easyui-combobox" required="true">
 		</div>
<!-- 부서번호  끝 --> 	
 	</form>       
</div>
<!-- 사원등록 다이얼로그 창에 버튼 추가 시작 -->
<div id="linkbtn_empUpd">
    <a href="javascript:void(0)" class="easyui-linkbutton c1"  onclick="empUpdateAction()">저장</a>
    <a href="javascript:void(0)" class="easyui-linkbutton c5" onclick="$('#dlog_empUpd').dialog('close')">닫기</a>
</div>
<!-- 사원등록 다이얼로그 창에 버튼 추가 끝 -->
<!-- 사원정보 수정 다이얼로그 창 추가  끝  -->
<!-- 사원 등록 다이얼로그 창 추가 시작 -->
<div id="dlog_empIns" buttons="#linkbtn_empIns" class="easyui-dialog" title="사원등록" style="width:400px;height:350px;" closed="true"
        data-options="iconCls:'icon-man',resizable:true,modal:true">
 	<form id="f_empIns" style="padding:15px 10px">
<!-- 사원번호 시작 -->
 		<div style="margin-bottom:10px">
 		<label>사원번호 :</label>
 		<input id="empno" name="empno" class="easyui-textbox" required="true">
 		</div>
<!-- 사원번호  끝 --> 		
<!-- 사원명 시작 --> 
        <div style="margin-bottom:10px">	
 		<label>사원명 :</label>
 		<input id="ename" name="ename" class="easyui-textbox" required="true">
 		</div>
<!-- 사원명  끝 --> 	
<!-- JOB 시작 --> 
        <div style="margin-bottom:10px">	
 		<label>JOB :</label>
 		<input id="job" name="job" class="easyui-textbox" required="true">
 		</div>
<!-- JOB  끝 --> 	
<!-- 그룹코드 시작 --> 
        <div style="margin-bottom:10px">		
 		<label>MGR :</label>
 		<input id="mgr" name="mgr" class="easyui-textbox" required="true">
 		</div>
<!-- 그룹코드  끝 --> 	
<!-- 입사일자 시작 --> 	
		<div style="margin-bottom:10px">	
 		<label>입사일자 :</label>
 		<input id="hiredate" name="hiredate" class="easyui-datebox" required="true">
 		</div>
<!-- 입사일자  끝 --> 	
<!-- 급여 시작 --> 
	    <div style="margin-bottom:10px">		
 		<label>급여 :</label>
 		<input id="sal" name="sal" class="easyui-textbox" required="true">
 		</div>
<!-- 급여  끝 --> 	
<!-- 인센티브 시작 --> 	
        <div style="margin-bottom:10px">	
 		<label>인센티브 :</label>
 		<input id="comm" name="comm" class="easyui-textbox" required="true">
 		</div>
<!-- 인센티브  끝 --> 	
<!-- 부서번호 시작 --> 	
		<div style="margin-bottom:10px">	
 		<label>부서번호 :</label>
 		<input id="deptno" name="deptno" class="easyui-combobox" required="true">
 		</div>
<!-- 부서번호  끝 --> 	
 	</form>       
</div>
<!-- 사원등록 다이얼로그 창에 버튼 추가 시작 -->
<div id="linkbtn_empIns">
    <a href="javascript:void(0)" class="easyui-linkbutton c1"  onclick="empInsertAction()">저장</a>
    <a href="javascript:void(0)" class="easyui-linkbutton c5" onclick="$('#dlog_empIns').dialog('close')">닫기</a>
</div>
<!-- 사원등록 다이얼로그 창에 버튼 추가 끝 -->
<!-- 사원 등록 다이얼로그 창 추가   끝  -->
</body>
</html>















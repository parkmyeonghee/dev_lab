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
<title>도서목록</title>
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
	var g_title;//전역변수-닫기버튼 클릭진전에 onmouseover제목정보를 담을 변수
	function choCheck(str)
	{
		var cho = ["ㄱ","ㄲ","ㄴ","ㄷ","ㄸ","ㄹ","ㅁ","ㅂ","ㅃ","ㅅ","ㅆ","ㅇ"
			           ,"ㅈ","ㅉ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ"];
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
		var vindex;//사용자가 선택한 로우값을 담을 변수
		var row = $("#tb_bookList").datagrid('getSelected');
		if(row){//자바스크립트에서는 0이 아니면 모두 다 true
			vindex = $("#tb_bookList").datagrid('getRowIndex',row);
		}
		$("#tb_bookList").datagrid('deleteRow',vindex);
	}
	function b_write(){
		$("#dlg_bookIns").dialog('open').dialog('setTitle','도서정보 등록');
	}
	//다이얼로그창에서 저장버튼을 클릭했을 때 호출
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
	//도서검색
	function b_search(){
		var vab_title = $("#tbox_word").val();//자바의 정석
		var choKeyword = choCheck(vab_title);
		//alert("choKeyword:"+choKeyword+", "+vab_title);
		//초성 검색 구분
		if(vab_title!="" && choKeyword==""){//초성검색
			choMode = "Y";
		}
		else{//일반검색
			choMode = "N";
		}
		var param = "ab_title="+vab_title+"&choMode="+choMode;
		// ./getBookList.bk?ab_title=ㅈ&choMode=N
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
			  alert(e.responseText);//에러가 발생했을 때 클라이언트측에 내려지는 소스
		  }
		});	//////////end of ajax
	}///////////////end of b_search
	//도서삭제
	function b_remove(){
		
	}
	//페이지 이동 처리
	function pageMove(pageNumber,pageSize){
		//alert("pageMove호출:"+pageNumber+" , "+pageSize);
/*
도서목록 조회 결과를 datagrid콤퍼넌트에 출력할 때 두 가지 방법이 가능하다.
조회결과를 List와 같은 자료구조에 담고 그 주소번지를 request에 담았을 때
변화 부분에 대해서는 요청이 유지되는 것으로 판단(WAS)하므로 변화된 부분이 결과에 반영되지 않고 있다.
1번 방법으로는 datagrid에 변화된 정보가 반영되지 못한다.
해결방법
JSON을 출력하는 jsp페이지를 사용한다.
1)자바코드를 이용하는 방법 - request속성을 이용한다.

2)JSON코드를 이용하는 방법
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
		$("#tbox_word").val(pab_title);//선택한 도서제목가져와서 텍스트박스에 담기
	}
	function titleChoice(ctd,psb_no,psb_titles){
		ctd.className="listIn";
		//선택한 도서의 제목으로 상세조회 처리-부분페이지 변경(ajax)
		bookDetail(pab_no);
	}
	function titleCancel(ctd){
		ctd.className="listOut";
	}
	function bookDetail(pab_no){
		console.log("bookDetail 호출 성공");
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
	$(document).ready(function (){//html문서에 DOM구성이 준비되었을 때
		//alert("ready");		
		$("#tbox_word").keyup(function(){
			//alert("keyup");
			b_search();
		});	
/* 페이징 처리  시작  */		
			$("#pg_book").pagination({
				total: <%=stotal%>,
				pageSize: 10,
				onSelectPage: function(pageNumber, pageSize){
					pageMove(pageNumber, pageSize);
				}
			});
/* 페이징 처리  끝  */
/* 데이타그리드 처리  시작  */
			$("#tb_bookList").datagrid({
				url:'./getBookList.bk'//jSonBookList.jsp-> json출력물
			   ,onDblClickCell:function (index,field,value){
					//alert("11");//이벤트감지 테스트
					var row = $("#tb_bookList").datagrid("getSelected");
					$("#bab_title").textbox('setValue',row.ab_title);
					$("#bab_author").textbox('setValue',row.ab_author);
					$("#bab_publisher").textbox('setValue',row.ab_publisher);
				}
			});
/* 데이타그리드 처리  끝     */
});
</script>
<!-- 화면 전체를 감싸줄 DIV태그 추가 시작 -->
<div id="cc" class="easyui-layout" style="width:1000px;height:500px;">
<!-- North영역 시작 -->
<!-- 도서검색 바 시작 -->
<div data-options="region:'north',title:'도서검색',split:true" style="width:1000px;height:200px;">
	<div id="d_book">
		<input id="tbox_word" type="text" style="width:200px"/>
    </div>
    <div id="d_bookTitle"></div>
</div>
<!-- 도서검색 바  끝   -->
<!-- North영역  끝   -->
<!-- Center영역 시작 -->
<div data-options="region:'center',title:'도서목록',split:true" style="width:1000px;height:440px;">
	<table id="tb_bookList" toolbar="#tbar_bookList" singleSelect="true" class="easyui-datagrid" style="width:950px;height:400px" rownumbers="true">
	<!-- 테이블 헤더 구성하기 -->
		<thead>
		<tr>
			<th field="ab_no" align="center" width="80">번호</th>
			<th field="ab_title" align="center" width="250">도서제목</th>
		    <th field="ab_author" align="center" width="120">저자</th>
		    <th field="ab_publisher" align="center" width="150">출판사</th>
		    <th field="ab_img" align="center" width="150">첨부파일</th>
		</tr>
		</thead>
	</table>
</div>
<!-- Center영역  끝 -->
</div>
<!-- 화면 전체를 감싸줄 DIV태그 추가   끝 -->

<!-- 테이블내에 툴바 추가해 보기 도서등록버튼 -->
<div id="tbar_bookList">
<!-- 검색 조건 추가 화면 입니다.  -->
<form id="f_search">
	<table>
		<tr>
			<td width="240px">
			<label width="120px">도서제목</label>
			<input name="ab_title" class="easyui-textbox" style="width:120px">
			</td>
			<td width="180px">
			<label width="60px">저자</label>
			<input name="ab_author" class="easyui-textbox" style="width:120px">
			</td>
			<td width="210px">
			<label width="90px">출판사</label>
			<input name="ab_publisher" class="easyui-textbox" style="width:120px">
			</td>
			<td width="370px">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="4">
		    <a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onClick="b_search()">도서조회</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="b_write()">도서등록</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="b_remove()">도서삭제</a>			
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="addRow()">행추가</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="removeRow()">행삭제</a>
			</td>
		</tr>		
	</table>
</form>	
<!-- 검색 조건 추가 화면 입니다.  -->	
</div>
<!-- 데이터그리드와 텍스트박스 바인딩 처리 해보기 시작  -->
	<div id="d_bookBind">
	<table>
		<tr>
			<td width="240px">
			<label width="120px">도서제목</label>
			<input id="bab_title" name="ab_title" class="easyui-textbox" style="width:120px">
			</td>
			<td width="180px">
			<label width="60px">저자</label>
			<input id="bab_author" name="ab_author" class="easyui-textbox" style="width:120px">
			</td>
			<td width="210px">
			<label width="90px">출판사</label>
			<input id="bab_publisher" name="ab_publisher" class="easyui-textbox" style="width:120px">
			</td>
			<td width="370px">&nbsp;</td>
		</tr>
</table>	
</div>	
<!-- 데이터그리드와 텍스트박스 바인딩 처리 해보기  끝  -->
<!-- 페이지 네비게이션 시작 -->
<div id="pg_book" class="easyui-pagination" style="border:1px solid #ccc;width:1000px"></div>
<!-- 페이지 네비게이션  끝   -->
<!-- 이부분은 도서 등록 버튼을 클릭했을 때 팝업창으로 처리할 화면 입니다.
     처음 페이지가 로딩 되었을 때는 꺼두었다가 등록을 클릭했을 때 띄울 화면 입니다.
 -->
 <div id="dlg_bookIns" buttons="#dlg_buttons" class="easyui-dialog" closed="true" style="width:600px">
 	<div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #CCCCCC">도서정보 등록</div>
<!-- 서버로 사용자가 입력한 정보를 전송합니다.(form전송으로 처리하기) -->
	<form id="f_bookIns" enctype="multipart/form-data" style="margin:0;padding:20px 50px"> 	
 	<div style="margin-bottom:10px">
 	<input name="ab_title" class="easyui-textbox" label="도서제목 : " style="width:100%">
 	</div>
 	<div style="margin-bottom:10px">
 	<input name="ab_author" class="easyui-textbox" label="저자 : " style="width:100%">
 	</div>
 	<div style="margin-bottom:10px">
 	<input name="ab_publisher" class="easyui-textbox" label="출판사 : " style="width:100%">
 	</div>
 	<div style="margin-bottom:10px">
 	<input name="ab_price" class="easyui-textbox" label="가격 : " style="width:100%">
 	</div>
  	<div style="margin-bottom:10px">
 	<input id="ab_pubdate" name="ab_pubdate"  label="출판일" type="text" class="easyui-datebox" required="required" style="width:200px">
 	</div>	
  	<div style="margin-bottom:10px">
 	<input name="ab_img" class="easyui-filebox" label="이미지 : " style="width:100%">
 	</div>
 	</form>	
 </div>
 <div id="dlg_buttons">
	<a href="#" class="easyui-linkbutton c1" iconCls="icon-ok" plain="true" onClick="b_insert()" style="width:90px">저장</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" plain="true" onClick="javascript:$('#dlg_bookIns').dialog('close')" style="width:90px">취소</a>
</div>
</body>
</html>







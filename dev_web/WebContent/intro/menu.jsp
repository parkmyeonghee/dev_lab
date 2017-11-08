<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>  
<%
    //세션에 담긴 정보를 화면에서 사용하기
    String sname = (String)session.getAttribute("sname");   
	//out.print("세션이름:"+sname);
%>
<table border="1" borderColor="red" width="100%" height="100%">
	<tr>
		<td valign="top">
		<table>
			<tr>
				<td>
				<!-- 로그인 화면 배치 할 곳  -->
					<!-- 장면1 -->
					<%
					    //자바땅
						//쿠키에 저장된 이름이 있니?
					if(sname == null){
					%>
					<!--================== 로그인 폼 화면 시작 =====================-->
					<div id="d_login">
					<table width="200" height="80" border="1" borderColor="orange">
						<tr>
							<td colspan="2">로그인</td>
						</tr>
						<tr>
							<td>
							<input type="text" name="mem_id" id="imem_id" value="아이디를입력하세요" onClick="idText()">
							</td>
							<td rowspan="2">
								<input type="button" value="로그인" onClick="login()">
							</td>
						</tr>
						<tr>
							<td>
							<input type="text" name="mem_pw" id="imem_pw" value="비밀번호를입력하세요"  onClick="pwText()">
							</td>				
						</tr>
						<tr>
							<td colspan="2" align="center">회원가입</td>
						</tr>
					</table>
					</div>	
					<!--================== 로그인 폼 화면  끝 =====================-->
<%
					}
					else{
%>					
	<jsp:include page="logout.jsp" flush="false"/>
<%
					}
%>				
				</td>
			</tr>
			<tr>
				<td>
				<!-- 메뉴 화면 배치 할  곳 -->
					<table>
						<tr><td height="15%"><a href="./index.jsp?menu=loginForm">로그인</a></td></tr>
<!-- 인증 처리를 한 후에 메뉴가 보이도록 구현해 보기(세션)
화면을 구성하는 템플릿을 top.jsp, menu.jsp, bottom.jsp, main.jsp로 분할하여
페이지를 작성하였다.
이 중 로그인 화면 처리를 menu.jsp페이지에 추가하였고 인증처리 부분을 ajax를
적용하여 부분 페이지 처리를 하였다.
로그인 후 세션 정보를 생성하고 생성된 세션 정보를 화면에서 사용하려고 하였으나
부분페이지에 소스가 반영되어 세션정보가 반영이 되지 않아서 div태그를 이용하여
로그인 성공했을때 코드를 추가하자.
 -->		
<div id="d_menu">
<%
if(sname != null){
%>
	<tr><td height="15%"><a href="./index.jsp?menu=memo">쪽지관리</a></td></tr>
	<tr><td height="15%"><a href="./index.jsp?menu=board">게시판</a></td></tr>
<%
	}
%>
</div>						
						<!-- 인증 처리를 한 후에 메뉴가 보이도록 구현해 보기(세션) -->								
						<tr><td height="15%"><a href="./index.jsp?menu=guest">방명록</a></td></tr>
						<tr><td height="15%"><a href="javascript:popupView()">팝업창</a></td></tr>
						<tr><td height="40%">&nbsp;</td></tr>
</table>
				<!-- 메뉴 화면 배치 할  곳 -->				
				</td>
			</tr>			
		</table>
		</td>
	</tr>
</table>
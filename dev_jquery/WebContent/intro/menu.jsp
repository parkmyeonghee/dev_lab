<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<table border="1" borderColor="red" width="100%" height="100%">
	<tr>
		<td valign="top">
			<table>
				<tr>
					<td>
      				<!-- 로그인화면 --> <!-- 장면1 -->
					 <!--HTML 구역 : login 폼 화면 시작 -->
					<div id="d_login">
						<table width="200" height="80" border="1" borderColor="orange">
							<tr>
								<td colspan="2">로그인</td>
							</tr>
							<tr>
								<td><input type="text" name="mem_id" id="imem_id"
									value="아이디를 입력하세요" onClick="idText()"></td>
								<td rowspan="2"><input type="button" value="로그인"
									onClick="login()"></td>
							</tr>
							<tr>
								<td><input type="text" name="mem_pw" id="imem_pw"
									value="비밀번호를 입력하세요" onClick="pwText()"></td>
							</tr>
							<tr>
								<td colspan="2" align="center">회원가입</td>
							</tr>
						</table><!-- 로그인화면폼 끝 -->
						</div>
					
					</td>
				</tr>
				<tr>
					<td>
						<!-- 메뉴화면 배치할 곳 -->
						<table>
							<tr>
								<td height="15%" zz><a href="./index.jsp?menu=loginForm">로그인</a></td>
							</tr>
							<tr>
								<td height="15%"><a href="./index.jsp?menu=board">게시판</a></td>
							</tr>
							<tr>
								<td height="15%"><a href="./index.jsp?menu=guest">방명록</a></td>
							</tr>
							<tr>
								<td height="15%"><a href="javascript:popupView()">팝업창</a></td>
							</tr>
							<tr>
								<td height="40%">&nbsp;</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
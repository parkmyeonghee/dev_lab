<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="javax.mail.*, javax.mail.internet.*, java.util.Properties" %>
<%
   request.setCharacterEncoding("euc-kr");

/* 받는쪽 정보 */
   String e_email=request.getParameter("e_email");   
   String cb_email=request.getParameter("cb_email");
   e_email=e_email+cb_email;
   String e_title=request.getParameter("e_title");   
   String e_content=request.getParameter("e_content");   
   String e_name=request.getParameter("e_name");   
/* 보내는쪽 정보 */
   String smtpServer = "smtp.naver.com";
   final String sendId = "mh_122";
   final String sendPw="tayoaa031";
   String sendAddress="mh_122@naver.com";
   int smtpPort=465;
   //메일서버의 정보 등록
   Properties props = System.getProperties();
   props.put("mail.smtp.host", smtpServer);
   props.put("mail.smtp.port", smtpPort);
   props.put("mail.smtp.auth", true);
   props.put("mail.smtp.ssl.enable", true);
   props.put("mail.smtp.ssl.trust", smtpServer);
   
   //Session session2 = Session.getDefaultInstance(props, new Authenticator(){
   Session session2 = Session.getInstance(props, new Authenticator(){
      protected PasswordAuthentication getPasswordAuthentication(){
         return new PasswordAuthentication(sendId, sendPw);
      }
   });
   session2.setDebug(true);
   Message mimeMessage = new MimeMessage(session2);
   mimeMessage.setFrom(new InternetAddress(sendAddress));
   mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(e_email));
   mimeMessage.setSubject(e_title);
   mimeMessage.setText(e_content);
   Transport.send(mimeMessage); //전송
   if(session2!=null){
	   session2=null;
   }
   if(mimeMessage!=null){
	   mimeMessage=null;
   }
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/themes/color.css">
<link rel="stylesheet" type="text/css" href="http://www.jeasyui.com/easyui/demo/demo.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
<script type="text/javascript" src="http://www.jeasyui.com/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
function mailSuccess(){
	
location.href="./List.jsp";
$("#dlg_emailSuccess").dialog('close');
}
</script>
</head>
<body>
<div id="dlg_emailSuccess"title="처리결과" buttons="#dlg_btnEmail"
	class="easyui-dialog" closed="false" style="width:300px">
<div style="margin-top:10px;margin-bottom:10px">
<label>메일 전송 되었습니다.</label>
</div>
</div>
<div id="dlg_btnEmail">
<a href="#" class="easyui-;inkbutton" iconCls="icon-cancel" onClick="mailSuccess()">
닫기
</a>
</div>
</body>
</html>
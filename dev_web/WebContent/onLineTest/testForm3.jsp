<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script type="text/javascript" src="/dev_web/js/jquery-1.11.1.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function() {
    $('input[type="checkbox"][name="ckbox"]').click(function(){
        if ($(this).prop('checked')) {
            $('input[type="checkbox"][name="ckbox"]').prop('checked', false);
            $(this).prop('checked', true);
        }
    });
});
</script>
</head>
<body>
������ ��Ƽ�̵���� Ư¡���� ���� ��������?
<br>
<input type="checkbox" name="ckbox"  value="1">
1.������ �����ͷ� ��ȯ�Ͽ� ���� ó���Ѵ�
<br>
<input type="checkbox" name="ckbox"  value="1">
2.���� �����ڿ� ����� ���� ��ȣ �ۿ뿡 ���� �����Ͱ� ���޵ȴ�.
<br>
<input type="checkbox" name="ckbox"  value="1">
3.�����Ͱ� ����� ���ÿ� ���� ���������� ó���Ǵ� �������� Ư¡�� ������.
<br>
<input type="checkbox" name="ckbox"  value="1">
4.����,�׸�,���� ���� ���� �̵� �����Ͽ� ó���Ѵ�.
<br>
����:3
<br>
<input type="button" id="next" value="��������"> &nbsp 
<input type="button" id="return" value="��������">

</body>
</html>
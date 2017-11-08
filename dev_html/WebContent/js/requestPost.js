/**
 * 
 */
var request=null;//통신객체 변수선언
//함수 안에 함수를 또 정의 할 수 없다.
function createRequest(){
	try {
		//사파리,크롬,파이어폭스,익스플로러9.0
		request = new XMLHttpRequest();
	} catch (trymicrosoft) {
		try {
		request =  new ActiveXObject("Msxml2.XMLHTTP");
		} catch (othermicrosoft) {
			try {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (failed) {
				request = null;
			}
		}
	}
	if(request ==null){
		alert("통신객체 생성 실패ㅠㅅㅜ");
	}
}
function requestProcess(){
	if(request.readyState==4){
		document.getElementById("requestDisplay").innerHTML =request.responseText;//requestPost.xml(html)
	}
}/////////end of requestprocess

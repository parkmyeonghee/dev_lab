/********************************************************************************************
 * @param el:element(span 안에는 텍스트노드)-태그 정보
 * @param text : 변경할 값(보드판매량)을 담을 변수
 * @returns 해당없음- 직접변경
 *********************************************************************************************/
function replaceText(el,text){
	//기존의 노드에 들어 있는 값을 초기화 시킨다.
	clearText(el);
	//지운 자리에 새로운 텍스트 노드추가하기
	var newNode= document.createTextNode(text);
	el.appendChild(newNode);
}
/*******************************************************************************************
 * 
 * @param el(span)
 * @returns 해당없음
******************************************************************************************* */
function clearText(el){//el:span id=borders_sold
	if(el !=null){
		if(el.childNodes){//el.childNodes -span태그에 자식노드
			for(var i=0;el.childNodes.length;i++){
				//childNode변수에 1000
				var childNode=el.childNodes[i];
				el.removeChild(childNode);
			}/////end of for
		}/////end of inner if
	}/////end of outter if
}///////end of clearText
/********************************************************************************************
 * 노드의 값을 읽어오기 구현
 * @param el(span)
 * @returns text
 ********************************************************************************************/
function getText(el)
{
	var text="";
	if(el !=null){
//childNodes는 지정된 객체의 직접적인 자식개체인
//html elements와 TextNode개체들의 컬렉션을 반환한다.
	
		if(el.childNodes){
			for(i=0;i<el.childNodes.length;i++){
				var childNode= el.childNodes[i];
				//너 텍스트 노드니?
				if(childNode.nodeValue !=null){
					text +=childNode.nodeValue;//1000
				}
			}
		}
	}
	return text;
}
/***********************************************************************************
 * 모두와 같이쓰는 코드이다.
 * @param url:팝업창으로 열어줄 페이지 경로
 * @param popupwidth:팝업창의 폭
 * @param popupheight:팝업창의 높이
 * @param popupname:팝업창의 이름
 * 자바스크립트는 html을 도매형태로 그려서 하나하나 ....?
 * 화면그리는 부분에도 직접관여할 수 있다.
 * 대소문자 주의 해야한다.
 **********************************************************************************/
function cmm_window_popup(
		url
		,popupwidth
		,popupheight
		,popupname) 
{
	//Top=(window.screen.height)윈도우에 접근함 스크린의 높이의 값을 주워줌
	Top=(window.screen.height-popupheight)//3 y축의 높이를 준다 3으로 나누어주는거임
	//1920*1080(사용자가 사용하는 해상도) /600*400(팝업창띄우는 화면의 사이즈)이면 (1080-400)/3 이런식으로 되는것임!
	Left=(window.screen.width-popupwidth)//2 
	if(Top<0)Top=0; //top이  0이면 나오지 않음 0,0부터 시작을 하는것임
	if(Left<0)Left=0;
	options="location=no,fullscreen=no,status=yes"
	options+=",left="+Left+",top="+Top //꼭지점의 좌표
	options+=",width="+popupwidth+",height="+popupheight;
	popupname=window.open(url,popupname,options);//팝업창은 얘가 열어주는것이다. 부모창이 잇을경우
	//popupname이라는 이름을 준것이다. 열어주는 아이는 window.open
	popupname.focus();
	}
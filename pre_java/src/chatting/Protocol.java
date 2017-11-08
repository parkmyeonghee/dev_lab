package ChattingProject;

public class Protocol {
	public final static int WAITROOM_IN					 = 100; 	    //대기실 입장
	public final static int LOG_IN_ROOMCHECK 	 = 110; 	    //대기실 입장
	public final static int ROOM_MAKE  				 = 130; 	    //방 만들기
	public final static int ROOM_IN   					 = 150; 		//대화방 입장
	public final static int MESSAGE   					 = 200;		//일반대화
	public final static int WHISPER   					 = 250;		//귓속말
	public final static int CHANGE     	 				 = 300;  	    //대화명 변경
	public final static int STATE_CHANGE 			 = 350;  	    //대화명 변경
	public final static int ROOM_OUT     			 = 400;		//대화방 나가기	
	public final static int CLOSE        					 = 500;		//창끄기
	public final static int JOIN = 600;	//회원가입
	public final static int DUP = 650; 	//ID중복검사
	public final static int LOGIN = 700;		//로그인
	public final static int SSIBAL = 750;		//작동이 안되느는 거지같은 친구 
}

package com.ch13;
/*
 * 100#ss#입장 하셨습니다.
 * 100:대화방입장
 * 200:일반대화
 * 300:귓속말
 * 400:강퇴
 * 500:퇴장
 * 읽기->쓰기
 * 클라이언트측 run메소드에서는?
 * 읽기(듣기)
 * 쓰기는 어디서?
 * 이벤트 처리할 떄
 * 메시지를 입력한 후 엔터 쳤을 떄 
 * 혹은 전송버튼을 클릭했을 때 
 */

public class ThreadExam extends Thread {
	//자바가 호출한다.
	//언제? -start()호출 되면 그 때 호출 된다.
	public void run(){
		System.out.println("run메소드 호출");
	}
	//main스레드 이다.
	public static void main(String[] args) {
		System.out.println("main메소드 호출");
		ThreadExam te = new ThreadExam();
		Thread th1 = new Thread(te);
		th1.start();
		}

}

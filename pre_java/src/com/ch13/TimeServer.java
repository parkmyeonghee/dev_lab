package com.ch13;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class TimeServer extends Thread {
	ServerSocket ss = null;
	Socket s = null;
	int port = 2008;
	public TimeServer(){
		
	}
		//현재 시간정보를 반환하는 메소드 구현
	public String getTime(){
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int min = cal.get(Calendar.MINUTE);
		int sec= cal.get(Calendar.SECOND);
		return (hour<10? "0"+hour:""+hour)+":"+
					(min<10? "0"+min:""+min)+":"+
					(sec<10? "0"+sec:""+sec);
		//return "15:25:45";
	}
	public void run(){
		boolean isStop =false;
		try {
			ss=new ServerSocket(2008);
		} catch (IOException ie) {
			System.out.println("Can't bind port"+port);
			System.exit(0);
		}
		System.out.println("Time Server Started successfuly.....");
		try {
			s =ss.accept();//서버에 접속해온 클라이언트 소켓 정보획득
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			while(!isStop){
				oos.writeObject(getTime());
				try {
					sleep(1000);//1초동안 정지
				} catch (InterruptedException ie) {
					System.out.println("다른 스레드에게 가로치기 당하면 잡힌다.");
				}
			}
		} catch (IOException e) {
		}
	}

	public static void main(String[] args) {
		TimeServer ts = new TimeServer();
		ts.start();
	}

}

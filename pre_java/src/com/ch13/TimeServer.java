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
		//���� �ð������� ��ȯ�ϴ� �޼ҵ� ����
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
			s =ss.accept();//������ �����ؿ� Ŭ���̾�Ʈ ���� ����ȹ��
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			while(!isStop){
				oos.writeObject(getTime());
				try {
					sleep(1000);//1�ʵ��� ����
				} catch (InterruptedException ie) {
					System.out.println("�ٸ� �����忡�� ����ġ�� ���ϸ� ������.");
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

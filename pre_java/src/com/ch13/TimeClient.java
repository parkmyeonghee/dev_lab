package com.ch13;

import java.io.ObjectInputStream;
import java.net.Socket;

public class TimeClient extends Thread {
	public void run(){
		//Ÿ�Ӽ����� ������ ����
		Socket socket = null;
		//Ÿ�Ӽ������� �����ϴ� �ð� ���� �о����
		ObjectInputStream ois= null;
		//������ ���� ���� �ð� ������ ���� ����
		String s_time= null;
		try {
			socket = new Socket("192.168.0.84",2008);
			ois= new ObjectInputStream(socket.getInputStream());
			while((s_time=(String)ois.readObject())!=null){
				System.out.println(s_time);
				try {
					sleep(1000);
				} catch (InterruptedException ie) {
				}
			}
		} catch (Exception e) {
			System.out.println("Ÿ�Ӽ����� �����K �� �����ϴ�.");
		}
	}

	public static void main(String[] args) {
		TimeClient tc = new TimeClient();
		tc.start();
	}

}

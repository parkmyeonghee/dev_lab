package com.Chatting;

import java.util.List;
import java.util.Vector;
/**************************************************************
 * ���� ����� �� �� 
 *List<Room> roomList = new Vector<Room> ();
 *List<ChattingServerThread> chatList= new Vector<ChattingServwrThread>();
 */
public class Room {
	List<String> userList = new Vector<String>();
	String title = null; //������
	String state=null; //�ʰ� �ִ°�(��: ����,������)
	String password = null; //���
	int max =0; //�ִ� �����ο�
	int current=0;
	public Room(){
		
	}
	public Room(String title
			,String state
			,String password
			,String max){
		this.title=title;
		this.state=state;
		this.password=password;
		this.max=Integer.parseInt(max);
	}
	public List<String> getUserList() {
		return userList;
	}
	public void setUserList(List<String> userList) {
		this.userList = userList;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	
}

package com.ChattingProject;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;


public class CS_DBThread extends Thread{
	String ifmem;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	CServer cs;
	String chatName="";
	String state=" ";
	String roomName=null;
	
public CS_DBThread(CServer cs){
	 this.cs = cs;
	
  	try {
		oos = new ObjectOutputStream(cs.communsoc.getOutputStream());
		ois = new ObjectInputStream(cs.communsoc.getInputStream());
/*		String note = (String)ois.readObject();
		cs.jta_display.append(note+"cst29\n");
		//메시지가 추가 될때마다 화면 이동처리하기!
		cs.jta_display.setCaretPosition(cs.jta_display.getDocument().getLength());
		
		StringTokenizer st = new StringTokenizer(note, "|");
		st.nextToken();
		this.broadCasting(note);*/
		}catch(Exception e){
			cs.jta_display.append("^0^예외는:" +e.toString()+"\n");
			}	
	}//CS_DBThread(CServer cs)생성자 끝


public void broadCasting(String note){
	synchronized(this){
		for(CS_DBThread cst:cs.chatList){ //chatList에 클라이언트 들어있음
			cst.send(note);
		}
	}
}

//서버측에서 클라이언트 측으로 전송하는 메소드
public void send(String note){
	try {
		oos.writeObject(note);
	} catch (Exception e) {
	}
}//send끝

/////////////서버측 run()-듣기,쓰기-switch문:ID중복검사,회원가입,로그인,
public void run(){
		boolean isStop = false;
		try {
			    run_start: while(!isStop){//브레이크 후에 요기로 돌아와서 대기
				String note = (String)ois.readObject();
				cs.jta_display.append(note+"@cst70\n");
				cs.jta_display.setCaretPosition(cs.jta_display.getDocument().getLength());
				StringTokenizer st = null;
				int protocol =0;
				if(note != null){
					st = new StringTokenizer(note,"|");
					protocol = Integer.parseInt(st.nextToken());//프로토콜
				}
//////////////switch문				
			switch(protocol){
			case Protocol.LOG_IN_ROOMCHECK:{
				chatName = st.nextToken();
				//늦게 들어온 사람도 앞 사람 대화명 알아야함.
				for(CS_DBThread cst:cs.chatList){
					String currentName = cst.chatName;
					String currentState = cst.state;
					this.send(Protocol.WAITROOM_IN+"|"+currentName+"|"+currentState);
				}
				for(CS_DBThread cst:cs.chatList){
					String roomName = cst.roomName;
					this.send(Protocol.LOG_IN_ROOMCHECK+"|"+roomName);
				}
				//사용자 추가하기
				cs.chatList.add(this);
				this.broadCasting(note);
			}break;
			case Protocol.WAITROOM_IN:{
				chatName = st.nextToken();
				//늦게 들어온 사람도 앞 사람 대화명 알아야함.
				for(CS_DBThread cst:cs.chatList){
					String currentName = cst.chatName;
					String currentState = cst.state;
					this.send(Protocol.WAITROOM_IN+"|"+currentName+"|"+currentState);
				}
				for(CS_DBThread cst:cs.chatList){
					String roomName = cst.roomName;
					this.send(Protocol.LOG_IN_ROOMCHECK+"|"+roomName);
				}
				//사용자 추가하기
				cs.chatList.add(this);
				this.broadCasting(note);
			}break;
			case Protocol.DUP:{
				String id = st.nextToken();
				
				final String _URL="jdbc:oracle:thin:@192.168.0.84:1521:orcl";
				final String _DRIVER="oracle.jdbc.driver.OracleDriver";
				final String _USER="SCOTT";
				final String _PW="tiger";
				String sql = "select id from chat_mem where id ='"+id+"'";
				Connection con=null;
				Statement stmt = null;
				ResultSet rs = null;
				Class.forName(_DRIVER);
				con =DriverManager.getConnection(_URL, _USER, _PW);
				stmt=con.createStatement();
				rs= stmt.executeQuery(sql);
					
				boolean tf = rs.next();
			    this.send(Protocol.DUP+"|"+tf);//클라이언트 스레드 run()으로
				rs.close();
				stmt.close();
				con.close();

			}break;//Protocol.DUP끝
			case Protocol.MESSAGE:{
				String nickName = st.nextToken();
				//String roomName = st.nextToken();
				String msg = st.nextToken();
				if(roomName!=null){
					for (CS_DBThread cst : cs.chatList) {
					if (cst.roomName.equals(roomName)) {
						cst.send(Protocol.MESSAGE+"|"+nickName+"|"+msg);
						
					}else{
						return;
					}
				}
			}
			}break;
			case Protocol.CLOSE:{
				//Vector에서 그 사람 삭제
				//ChattingServerThread에서 this는 현재 접속한 사용자의 정보를 가지고 있고
				//cst는 현재 서버에 접속해 있는 사용자 하나하나를 구분 할 수 있따.
				cs.chatList.remove(this);
				
				String nickName = st.nextToken();
				String msg = "님 접속 종료!";
				this.broadCasting(Protocol.CLOSE+"|"+nickName+"|"+msg);
				break run_start;
			}
			case Protocol.CHANGE:{
				String nickName = st.nextToken();
				String afterName = st.nextToken();
				String msg = nickName+"님의 대화명이 "+afterName+"로 변경되었습니다.\n";
				chatName=afterName;
				this.broadCasting(Protocol.CHANGE+"|"+nickName+"|"+afterName+"|"+msg);
			}break;
			case Protocol.STATE_CHANGE:{
				String nickName = st.nextToken();
				String afterState = st.nextToken();
				state = afterState;
				this.broadCasting(Protocol.STATE_CHANGE+"|"+nickName+"|"+afterState);
			}break;
			case Protocol.WHISPER:{
				String nickName = st.nextToken(); //nickName
				String whisperName = st.nextToken(); //whisperName
				String msg = st.nextToken();
		/*		System.out.println("닉넴:"+nickName);
				System.out.println("귓말상대:"+whisperName);
				System.out.println("메세지"+msg);*/
			for (CS_DBThread cst : cs.chatList) {
				if (cst.chatName.equals(whisperName)) {
					//상대방에게
					cst.send(Protocol.WHISPER + "|" + nickName + "|" + whisperName + "|" + msg);
					//나에게
					//this.send(Protocol.WHISPER + "|" + nickName + "|" + whisperName + "|" + msg);
					break;
				}
			}
			
			}break;
			case Protocol.ROOM_MAKE:{
				// 프로토콜|닉네임|방제목 받음
				String nickName = st.nextToken(); //닉네임 받기
				roomName = st.nextToken(); //방제목 받기
				System.out.println("서버스레드 룸네임:"+roomName);
				this.broadCasting(Protocol.ROOM_MAKE+"|"+nickName+"|"+roomName);
				
			}break;
			case Protocol.ROOM_IN:{
				// 프로토콜|닉네임|방제목 받음
				String nickName = st.nextToken(); //닉네임 받기
				roomName = st.nextToken(); //방제목 받기
				
				this.broadCasting(Protocol.ROOM_IN+"|"+nickName+"|"+roomName);
				
			}break;		
					
			//서버의 회원가입 듣기,쓰기
			case Protocol.JOIN:{
					String id = st.nextToken();
					String pw = st.nextToken();
					String name = st.nextToken();
					String email = st.nextToken();
					final String _URL="jdbc:oracle:thin:@192.168.0.42:1521:orcl";
					final String _DRIVER="oracle.jdbc.driver.OracleDriver";
					final String _USER="scott";
					final String _PW="tiger";
					
					String sql0 = "select id from chat_mem where id ='"+id+"'";
					String sql1
							="insert into chat_mem(id, password, name, email) values('"
											+id+"', '"+pw+"', '"+name+"', '"+email+"')";
					String sql2 = "commit";
					Connection con=null;
					Statement stmt = null;
					ResultSet rs0 = null;
					ResultSet rs1 = null;
					ResultSet rs2 = null;
					Class.forName(_DRIVER);
					con =DriverManager.getConnection(_URL, _USER, _PW);
					stmt=con.createStatement();
					rs0= stmt.executeQuery(sql0);
					
					boolean tf = rs0.next();
					if(tf==true){
							this.send(Protocol.DUP+"|"+tf);
							return;
					}
					else{
						rs1= stmt.executeQuery(sql1);
						rs2= stmt.executeQuery(sql2);
						rs1.close();
						rs2.close();
						stmt.close();
						con.close();
						
						this.send(Protocol.JOIN+"|"+"success");
						cs.jta_display.append("cst에서 join success?? "+Protocol.JOIN+"|"+"success");
						}
						}break;
	//로그인					
	case Protocol.LOGIN:{
//		cs.jta_display.append("서버쓰레드 케이스 로긴");
				String id = st.nextToken();
				String pw = st.nextToken();
				final String _URL="jdbc:oracle:thin:@192.168.0.42:1521:orcl";
				final String _DRIVER="oracle.jdbc.driver.OracleDriver";
				final String _USER="scott";
				final String _PW="tiger";
				String sql = "select 'true' from dual "
						+ "where exists (select id from chat_mem where id = '"
						+id+"' and password='"+pw+"')";
				
				Connection con=null;
				Statement stmt = null;
				ResultSet rs = null;
				Class.forName(_DRIVER);
				con =DriverManager.getConnection(_URL, _USER, _PW);
				stmt=con.createStatement();
				rs = stmt.executeQuery(sql);
				
				boolean tf = rs.next();
				System.out.println("tf: "+tf);
				this.send(Protocol.LOGIN+"|"+tf);
				
					rs.close();
					stmt.close();
					con.close();
			}break;
	//마지막-방나가기		
	case Protocol.ROOM_OUT:{
		String nickName = st.nextToken();
		String roomName =st.nextToken();
		this.roomName=null;
		this.broadCasting(Protocol.ROOM_OUT+"|"+nickName+"|"+roomName);
				
				}break;

				}// switch문 끝
			} // while문 끝
		} // run()의 처음 try끝
		catch (Exception e) {
		}
	} // run()끝

}// 클래스 끝

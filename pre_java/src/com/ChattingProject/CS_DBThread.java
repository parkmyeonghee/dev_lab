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
		//�޽����� �߰� �ɶ����� ȭ�� �̵�ó���ϱ�!
		cs.jta_display.setCaretPosition(cs.jta_display.getDocument().getLength());
		
		StringTokenizer st = new StringTokenizer(note, "|");
		st.nextToken();
		this.broadCasting(note);*/
		}catch(Exception e){
			cs.jta_display.append("^0^���ܴ�:" +e.toString()+"\n");
			}	
	}//CS_DBThread(CServer cs)������ ��


public void broadCasting(String note){
	synchronized(this){
		for(CS_DBThread cst:cs.chatList){ //chatList�� Ŭ���̾�Ʈ �������
			cst.send(note);
		}
	}
}

//���������� Ŭ���̾�Ʈ ������ �����ϴ� �޼ҵ�
public void send(String note){
	try {
		oos.writeObject(note);
	} catch (Exception e) {
	}
}//send��

/////////////������ run()-���,����-switch��:ID�ߺ��˻�,ȸ������,�α���,
public void run(){
		boolean isStop = false;
		try {
			    run_start: while(!isStop){//�극��ũ �Ŀ� ���� ���ƿͼ� ���
				String note = (String)ois.readObject();
				cs.jta_display.append(note+"@cst70\n");
				cs.jta_display.setCaretPosition(cs.jta_display.getDocument().getLength());
				StringTokenizer st = null;
				int protocol =0;
				if(note != null){
					st = new StringTokenizer(note,"|");
					protocol = Integer.parseInt(st.nextToken());//��������
				}
//////////////switch��				
			switch(protocol){
			case Protocol.LOG_IN_ROOMCHECK:{
				chatName = st.nextToken();
				//�ʰ� ���� ����� �� ��� ��ȭ�� �˾ƾ���.
				for(CS_DBThread cst:cs.chatList){
					String currentName = cst.chatName;
					String currentState = cst.state;
					this.send(Protocol.WAITROOM_IN+"|"+currentName+"|"+currentState);
				}
				for(CS_DBThread cst:cs.chatList){
					String roomName = cst.roomName;
					this.send(Protocol.LOG_IN_ROOMCHECK+"|"+roomName);
				}
				//����� �߰��ϱ�
				cs.chatList.add(this);
				this.broadCasting(note);
			}break;
			case Protocol.WAITROOM_IN:{
				chatName = st.nextToken();
				//�ʰ� ���� ����� �� ��� ��ȭ�� �˾ƾ���.
				for(CS_DBThread cst:cs.chatList){
					String currentName = cst.chatName;
					String currentState = cst.state;
					this.send(Protocol.WAITROOM_IN+"|"+currentName+"|"+currentState);
				}
				for(CS_DBThread cst:cs.chatList){
					String roomName = cst.roomName;
					this.send(Protocol.LOG_IN_ROOMCHECK+"|"+roomName);
				}
				//����� �߰��ϱ�
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
			    this.send(Protocol.DUP+"|"+tf);//Ŭ���̾�Ʈ ������ run()����
				rs.close();
				stmt.close();
				con.close();

			}break;//Protocol.DUP��
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
				//Vector���� �� ��� ����
				//ChattingServerThread���� this�� ���� ������ ������� ������ ������ �ְ�
				//cst�� ���� ������ ������ �ִ� ����� �ϳ��ϳ��� ���� �� �� �ֵ�.
				cs.chatList.remove(this);
				
				String nickName = st.nextToken();
				String msg = "�� ���� ����!";
				this.broadCasting(Protocol.CLOSE+"|"+nickName+"|"+msg);
				break run_start;
			}
			case Protocol.CHANGE:{
				String nickName = st.nextToken();
				String afterName = st.nextToken();
				String msg = nickName+"���� ��ȭ���� "+afterName+"�� ����Ǿ����ϴ�.\n";
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
		/*		System.out.println("�г�:"+nickName);
				System.out.println("�Ӹ����:"+whisperName);
				System.out.println("�޼���"+msg);*/
			for (CS_DBThread cst : cs.chatList) {
				if (cst.chatName.equals(whisperName)) {
					//���濡��
					cst.send(Protocol.WHISPER + "|" + nickName + "|" + whisperName + "|" + msg);
					//������
					//this.send(Protocol.WHISPER + "|" + nickName + "|" + whisperName + "|" + msg);
					break;
				}
			}
			
			}break;
			case Protocol.ROOM_MAKE:{
				// ��������|�г���|������ ����
				String nickName = st.nextToken(); //�г��� �ޱ�
				roomName = st.nextToken(); //������ �ޱ�
				System.out.println("���������� �����:"+roomName);
				this.broadCasting(Protocol.ROOM_MAKE+"|"+nickName+"|"+roomName);
				
			}break;
			case Protocol.ROOM_IN:{
				// ��������|�г���|������ ����
				String nickName = st.nextToken(); //�г��� �ޱ�
				roomName = st.nextToken(); //������ �ޱ�
				
				this.broadCasting(Protocol.ROOM_IN+"|"+nickName+"|"+roomName);
				
			}break;		
					
			//������ ȸ������ ���,����
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
						cs.jta_display.append("cst���� join success?? "+Protocol.JOIN+"|"+"success");
						}
						}break;
	//�α���					
	case Protocol.LOGIN:{
//		cs.jta_display.append("���������� ���̽� �α�");
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
	//������-�泪����		
	case Protocol.ROOM_OUT:{
		String nickName = st.nextToken();
		String roomName =st.nextToken();
		this.roomName=null;
		this.broadCasting(Protocol.ROOM_OUT+"|"+nickName+"|"+roomName);
				
				}break;

				}// switch�� ��
			} // while�� ��
		} // run()�� ó�� try��
		catch (Exception e) {
		}
	} // run()��

}// Ŭ���� ��

package com.Chatting.color;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import com.sun.glass.events.WindowEvent;

import jdk.nashorn.internal.scripts.JO;

public class ChattingClient extends JFrame implements ActionListener {
	//선언부
	Socket socket =null;
	//대화명을 담을 변수 선언
	String nickName = null;
	//화면 배치 시작
	JPanel jp_first = new JPanel();
	//JTextArea에는 부분 색상 적용이 불가 합니다
	// 오직 텍스트로만 출력
	// 이미지를 처리 할 수 없다.
	//텍스트도 그리는 개념으로 처리하는 클래스가 필요
	//JTextArea jta_display = new JTextArea();
	StyledDocument sd_display = new DefaultStyledDocument(new StyleContext());
	//글꼴과 폰트크기 적용할 떼
	JTextPane jtp_display = new  JTextPane(sd_display);
	//이미지를 보여줄 수 있는 친구들
	JScrollPane jsp_display= new JScrollPane(jtp_display,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel jp_frist_south = new JPanel();
	JTextField jtf_msg = new JTextField();
	JButton jbtn_send = new JButton("전송");
	JPanel jp_second = new JPanel();
	String cols[] = {"대화명"};
	String data[][] = new String[0][1];
	DefaultTableModel dtm_room = new DefaultTableModel(data,cols);
	JTable jt_room = new JTable(dtm_room);
	JScrollPane jsp_room = new JScrollPane(jt_room,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
			,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JPanel jp_second_south= new JPanel();
	JButton jbtn_whisper = new JButton("귓속말");
	JButton jbtn_change = new JButton("대화명변경");
	JButton jbtn_roomout = new JButton("나가기");
	JButton jbtn_close = new JButton("종료");
	JButton jbtn_fontColor= new JButton("글자색");
	JButton jbtn_fontStyle= new JButton("폰트스타일");
	JFrame jf_fontColor = null;
	//사용자가 선택한 색상 정보를 담을 변수 선언 - 서버로 전송할 떄 색상정보도 전송
	String fontColor ="0";//사용자가 선택한 색상정보 담기
	
	ObjectInputStream ois = null; //듣기
	ObjectOutputStream oos = null; //말하기
	//화면 배치 끝
	
	//생성자
	//1)화면처리
	//2)서버소켓생성
	//3)클라이언트 소켓정보를 받아온다.
	//2)스레드 생성하고 start() 호출
	public ChattingClient(){
		//창닫기 버튼을 클릭했을 때
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we){
				exitChat();
				System.exit(0);
			}
		});
	nickName = JOptionPane.showInputDialog("대화명을 입력하세요:");
	try {
		socket = new Socket("192.168.0.31",3000);
		oos= new ObjectOutputStream(socket.getOutputStream());
		ois= new ObjectInputStream(socket.getInputStream());
		//서버로 메시지 전송하기
		oos.writeObject(Protocol.ROON_IN+"|"+nickName+"|"+fontColor);
		ChattingClientThread cct = new ChattingClientThread(this);
		cct.start();
	} catch (Exception e) {
		e.printStackTrace();
		}
	}
	public void exitChat(){
		try {
			oos.writeObject(Protocol.ROON_OUT+"|"+this.nickName+"|"+fontColor);
		} catch (Exception e) {
		}
	}
	//화면 처리부
	public void initDisplay(){
		jbtn_change.addActionListener(this);
		jbtn_send.addActionListener(this);
		jbtn_whisper.addActionListener(this);
		jbtn_close.addActionListener(this);
		jbtn_fontColor.addActionListener(this);
		jbtn_fontStyle.addActionListener(this);
		jbtn_roomout.addActionListener(this);
		jtf_msg.addActionListener(this);//이벤트 감지 (jvm)-actionPerformed
		this.setLayout(new GridLayout(1,2));
		jp_first.setLayout(new BorderLayout());
		
		jp_frist_south.setLayout(new BorderLayout());
		jp_frist_south.add("Center",jtf_msg);
		jp_frist_south.add("East",jbtn_send);
		
		jp_first.add("Center", jsp_display);
		jp_first.add("South", jp_frist_south);
		
		jp_second.setLayout(new BorderLayout());
		jp_second_south.setLayout(new GridLayout(3,2));
		jp_second_south.add(jbtn_fontColor);
		jp_second_south.add(jbtn_fontStyle);
		jp_second_south.add(jbtn_whisper);
		jp_second_south.add(jbtn_change);
		jp_second_south.add(jbtn_roomout);
		jp_second_south.add(jbtn_close);
		jp_second.add("Center", jsp_room);
		jp_second.add("South", jp_second_south);
		
		
		this.add(jp_first);
		this.add(jp_second);
		this.setTitle(nickName+"님의 대화창");
		this.setSize(500,500);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource(); //이벤트가 감지된 컴포넌트의 주소번지를 담고
		String msg= jtf_msg.getText();//사용자가 입력한 메시지를 담는다.
		if(obj==jtf_msg || obj==jbtn_send){
		try {
			oos.writeObject(Protocol.MESSAGE+"|"+
					nickName+"|"+
					msg+"|"+fontColor);
		} catch (Exception e) {
			}
		jtf_msg.setText(""); //메시지 전송후 초기화
		}///////////end of 메시지 전송
		else if(obj==jbtn_fontColor){
			jf_fontColor = new JFrame();
			JColorChooser jcc_color= new JColorChooser();
			ColorSelectionModel  model=
					jcc_color.getSelectionModel();
			ChangeListener listener =
					new ChangeListener(){ //한번에 처리하기 위해서!

						@Override
						public void stateChanged(ChangeEvent e) {
							Color forColor = jcc_color.getColor();
							fontColor=String.valueOf(forColor.getRGB());
							System.out.println("사용자가 선택한 색상"+fontColor);
						}
			};
			model.addChangeListener(listener);
			jf_fontColor.add("Center",jcc_color);
			jf_fontColor.setSize(600,500);
			jf_fontColor.setVisible(true);
		}
		else if(obj==jbtn_fontStyle){
			
		}
	//대화명 변경버튼 클릭했을때
	else if(obj==jbtn_change){
		//변경할 대화명 입력받기
		String afterName =JOptionPane.showInputDialog("변경할 대화명을 입력세요");
		//대화명이 널이거나 문자열의 길이가 1보다 작으면 처음부터 다시
		if(afterName==null||afterName.trim().length()<1){
			JOptionPane.showMessageDialog(this
													,"변경할 대화명을 입력하세요"
														,"INFO"
														,JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		//메시지 전송
		try {
			oos.writeObject(Protocol.CHANGE+"|"+
					nickName+"|"+
					afterName+"|"+
					nickName+"님의 대화명이"+afterName+"으로 변경"+"|"+fontColor);
		} catch (Exception e) {
		}//////end of 대화명 변경 끝
	}else if(obj==jbtn_whisper){
		//귓속말 상대를 선택(테이블) 하기
		int row=jt_room.getSelectedRow();
		//상대를 선택하지 않았니? - 귓속말 상대를 선택하세요 메시지
		if(row==-1){
			JOptionPane.showMessageDialog(this
					,"귓속말 상대를 선택하세요"
					,"INFO"
					,JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		//상대를 선택했니? -네
		else{
			//상대방의 이름
			//선택한 상대의 이름을 테이블에서 읽어와서 name변수에 담기
			String name=(String)dtm_room.getValueAt(row, 0);
		
		//만일 선택한 상대가 나 자신이면 다른 상대를 선택하세요
		//메시지 처리하기
		if(nickName.equals(name)){
			JOptionPane.showMessageDialog(this
					,"다른 상대를 선택하세요"
					,"INFO"
					,JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		// 귓속말 입력받기
		String msg1 =
				JOptionPane.showInputDialog
				(name+"님에게 보낼 메시지 입력하세용");
		//귓속말 전송하기
		try {
			oos.writeObject(Protocol.WHISPER+"|"+
									nickName+"|"+
									name+"|"+
									msg1+"|"+fontColor);
		} catch (Exception e) {
		}
		}////end of else
	}///////end of  귓속말
	else if(obj==jbtn_close || obj==jbtn_roomout){
		exitChat();
		System.exit(0);
	}///////////////end of 메시지 전송
}/////////end of actionperformed
	public static void main(String[] args) {
		ChattingClient cc =
				new ChattingClient();
		cc.initDisplay();
	}

}

package ChattingProject;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/*요기서 cc인스턴스화 (cc에서도 요기ccl의 원본사용가능)
cc에서 cct인스턴스화 (cct에서도 cc의 원본사용가능)
*/
import javax.swing.border.EmptyBorder;


public class CC_Login implements ActionListener{
	//테스트용
	JTextArea jta_test;

	CC_Membership ccm;
	
	public JFrame Login_GUI = new JFrame();

	private JTextField jtf_id; //id 받는 텍스트 필드
	private JTextField jt_pw; //pw 받는 텍스트 필드
	private JButton btn_login = new JButton("로그인");
	private JButton btn_join = new JButton("회원가입");
	
	String nickName = null;
	Socket clientsoc = null;
	ObjectInputStream ois = null;//듣기
	ObjectOutputStream oos= null;//말하기
	ChattingClient cc = null;
	
	
	 String path = this.getClass().getResource("").getPath();
	   ImageIcon mainpic = new ImageIcon(getClass().getResource("mainchat.png"));
	   public JPanel Login_Pane=new JPanel(){
	   public void paintComponent(Graphics g) {
	      g.drawImage(mainpic.getImage(), 0, 0, null);
	      setOpaque(false);
	       super.paintComponents(g);
	      } 
	   };

/////생성자
	//1)화면처리
	//2)서버소켓 생성
	//3)클라이언트 소켓정보를 받아온다.
	//4)스레드 생성하고 start() 호출	
public CC_Login(){
	initDisplay();
	try {
		clientsoc = new Socket("127.0.0.1",3002);
		ois = new ObjectInputStream(clientsoc.getInputStream());//또는 new DataInputStream()
		oos = new ObjectOutputStream(clientsoc.getOutputStream());
        CClientThread cct = new CClientThread(this);
		cct.start();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
//로그인 창구성 메소드
public void initDisplay(){
	   
	 Login_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     Login_GUI.setBounds(100, 100, 350, 599);
     //Login_Pane = new JPanel();
     Login_Pane.setBorder(new EmptyBorder(5, 5, 5, 5));
     Login_GUI.setContentPane(Login_Pane);
     Login_Pane.setLayout(null);
     
     JLabel jl_id = new JLabel("ID");
     jl_id.setBounds(20, 281, 92, 35);
     Login_Pane.add(jl_id);
     
     JLabel jl_pw = new JLabel("PassWord");
     jl_pw.setBounds(20, 331, 101, 35);
     Login_Pane.add(jl_pw);
     
     jtf_id = new JTextField();
     jtf_id.setBounds(129, 285, 169, 27);
     Login_Pane.add(jtf_id);
     jtf_id.setColumns(10);
     
    jt_pw= new JTextField();
    jt_pw.setBounds(129, 335, 169, 27);
    Login_Pane.add(jt_pw);
     jt_pw.setColumns(10);
 
 //테스트용
     jta_test= new JTextArea();
     jta_test.setBounds(29, 135, 300, 100);
     Login_Pane.add(jta_test);
     jt_pw.setColumns(10);
     
     btn_join.setBounds(173, 452, 128, 40);
     btn_login.setBounds(33, 452, 128, 40);
     Login_Pane.add(btn_login);
     Login_Pane.add(btn_join);
     
     
	
	btn_join.addActionListener(this);
	btn_login.addActionListener(this);

	
	Login_GUI.setVisible(true);
	Login_GUI.setTitle("서버 접속");
}

//ccm(회원가입)에서 id 쓰고 중복확인 버튼 누르면 호출하는 메소드
public void dup(String id){
	try {
		oos.writeObject(Protocol.DUP+"|"+id);
	} catch (IOException e) {
		e.printStackTrace();
	}
			}

//회원가입에서 정보 쓰고 join버튼 누르면 호출	
public void join(String id, String pw, String name, String email){
		try {
			oos.writeObject(Protocol.JOIN+"|"+id+"|"+pw+"|"+name+"|"+email);
		
System.out.println("cc에서 회원가입 정보 내보냄: "+Protocol.JOIN+"|"+id+"|"+pw+"|"+name+"|"+email);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	
//id, pw 쓰고 login 버튼 누르면 호출
public void login1(String id, String pw){
	try {
		System.out.println("oos:"+oos);
		oos.writeObject(Protocol.LOGIN+"|"+id+"|"+pw);

		System.out.println("ccl에서로그인 정보 내보냄: "+Protocol.LOGIN+"|"+id+"|"+pw);
		} catch (IOException e) {
		e.printStackTrace();
		}	
}

//로그인실패 메소드
public void l_fail(){
	jtf_id.setText("");
	jt_pw.setText("");
    
	JOptionPane.showMessageDialog(Login_GUI
        ,"비밀번호가 틀리거나 존재하지 않는 ID입니다."
        ,"INFO"
        ,JOptionPane.INFORMATION_MESSAGE);
}

//로그인 성공 메소드
public void l_success(){
 jta_test.append("l_success()탐");
	JOptionPane.showMessageDialog(Login_GUI
        ,"로그인 성공!"
        ,"INFO"
        ,JOptionPane.INFORMATION_MESSAGE);
	
	cc = new ChattingClient(this, clientsoc, oos, ois);
	Login_GUI.setVisible(false);
}
	
@Override
public void actionPerformed(ActionEvent ae) {
	Object obj = ae.getSource();
	//회원가입 버튼
	if(obj==btn_join){
			//ccm 최초인스턴스
			ccm = new CC_Membership(this);
			ccm.initDisplay();
		}
	//로그인	버튼
	else if(obj==btn_login){
			String id = jtf_id.getText();
			String pw = jt_pw.getText();
		//	 l_success(); //테스트용
			login1(id, pw);
			
		}
	}

//메인메소드
public static void main(String[] args) {
			CC_Login ccl = new CC_Login();
	}
}

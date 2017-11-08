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
/*��⼭ cc�ν��Ͻ�ȭ (cc������ ���ccl�� ������밡��)
cc���� cct�ν��Ͻ�ȭ (cct������ cc�� ������밡��)
*/
import javax.swing.border.EmptyBorder;


public class CC_Login implements ActionListener{
	//�׽�Ʈ��
	JTextArea jta_test;

	CC_Membership ccm;
	
	public JFrame Login_GUI = new JFrame();

	private JTextField jtf_id; //id �޴� �ؽ�Ʈ �ʵ�
	private JTextField jt_pw; //pw �޴� �ؽ�Ʈ �ʵ�
	private JButton btn_login = new JButton("�α���");
	private JButton btn_join = new JButton("ȸ������");
	
	String nickName = null;
	Socket clientsoc = null;
	ObjectInputStream ois = null;//���
	ObjectOutputStream oos= null;//���ϱ�
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

/////������
	//1)ȭ��ó��
	//2)�������� ����
	//3)Ŭ���̾�Ʈ ���������� �޾ƿ´�.
	//4)������ �����ϰ� start() ȣ��	
public CC_Login(){
	initDisplay();
	try {
		clientsoc = new Socket("127.0.0.1",3002);
		ois = new ObjectInputStream(clientsoc.getInputStream());//�Ǵ� new DataInputStream()
		oos = new ObjectOutputStream(clientsoc.getOutputStream());
        CClientThread cct = new CClientThread(this);
		cct.start();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
//�α��� â���� �޼ҵ�
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
 
 //�׽�Ʈ��
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
	Login_GUI.setTitle("���� ����");
}

//ccm(ȸ������)���� id ���� �ߺ�Ȯ�� ��ư ������ ȣ���ϴ� �޼ҵ�
public void dup(String id){
	try {
		oos.writeObject(Protocol.DUP+"|"+id);
	} catch (IOException e) {
		e.printStackTrace();
	}
			}

//ȸ�����Կ��� ���� ���� join��ư ������ ȣ��	
public void join(String id, String pw, String name, String email){
		try {
			oos.writeObject(Protocol.JOIN+"|"+id+"|"+pw+"|"+name+"|"+email);
		
System.out.println("cc���� ȸ������ ���� ������: "+Protocol.JOIN+"|"+id+"|"+pw+"|"+name+"|"+email);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	
//id, pw ���� login ��ư ������ ȣ��
public void login1(String id, String pw){
	try {
		System.out.println("oos:"+oos);
		oos.writeObject(Protocol.LOGIN+"|"+id+"|"+pw);

		System.out.println("ccl�����α��� ���� ������: "+Protocol.LOGIN+"|"+id+"|"+pw);
		} catch (IOException e) {
		e.printStackTrace();
		}	
}

//�α��ν��� �޼ҵ�
public void l_fail(){
	jtf_id.setText("");
	jt_pw.setText("");
    
	JOptionPane.showMessageDialog(Login_GUI
        ,"��й�ȣ�� Ʋ���ų� �������� �ʴ� ID�Դϴ�."
        ,"INFO"
        ,JOptionPane.INFORMATION_MESSAGE);
}

//�α��� ���� �޼ҵ�
public void l_success(){
 jta_test.append("l_success()Ž");
	JOptionPane.showMessageDialog(Login_GUI
        ,"�α��� ����!"
        ,"INFO"
        ,JOptionPane.INFORMATION_MESSAGE);
	
	cc = new ChattingClient(this, clientsoc, oos, ois);
	Login_GUI.setVisible(false);
}
	
@Override
public void actionPerformed(ActionEvent ae) {
	Object obj = ae.getSource();
	//ȸ������ ��ư
	if(obj==btn_join){
			//ccm �����ν��Ͻ�
			ccm = new CC_Membership(this);
			ccm.initDisplay();
		}
	//�α���	��ư
	else if(obj==btn_login){
			String id = jtf_id.getText();
			String pw = jt_pw.getText();
		//	 l_success(); //�׽�Ʈ��
			login1(id, pw);
			
		}
	}

//���θ޼ҵ�
public static void main(String[] args) {
			CC_Login ccl = new CC_Login();
	}
}

package BaseBall;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.ch5.BaseBallGame;

public class BaseBallGameView {
	//��ü�� ���԰��� �ذ��ϱ�
	BaseBallGameLogic bgLogic = new BaseBallGameLogic(this);
	BaseBallGameEvent bgEvent = new BaseBallGameEvent(this,bgLogic);
	
	JMenuBar jmb=new JMenuBar();
	JMenu jm_file=new JMenu("����");
	JMenuItem jmi_new=new JMenuItem ("������");
	JMenuItem jmi_clear=new JMenuItem ("�����");
	JMenuItem jmi_dap=new JMenuItem ("����");
	JMenuItem jmi_exit=new JMenuItem ("����");
	//Jframe�� �ڹٿ��� �����ϴ� Ŭ���� �Դϴ�.
	 JFrame jf_game=new JFrame();
	//javax.swing.Jframe jf_game=new javax.swing.Jframe();
	 JPanel jp_center = new JPanel();
	 //��ġ-jp_center ������ �߾ӿ� ��ġ
	 JTextArea jta_display=new JTextArea();
	 //jtextarea�� ��ũ�� �� �߰��ϱ�
	 JScrollPane jsp_display = new JScrollPane(jta_display);
	 //��ġ-jp_center������ ���ʿ� ��ġ
	 JTextField jtf_input=new JTextField();
	 JPanel jp_east = new JPanel();
	 //�����ӹ�ư,�����ư,������ư,�����ư ->jp_east������ ��ġ�� ����.
	 JButton jbt_new=new JButton("������");
	 JButton jbt_dap=new JButton("����");
	 JButton jbt_clear=new JButton("�����");
	 JButton jbt_exit=new JButton("����");
	 Font f =new Font("HY�߰��",Font.BOLD,14); //��Ʈ �̸� ���� ũ��
	 public BaseBallGameView(){
		 bgLogic.nanSu();
	 }
	
	
	

		public void initDisplay(){
			System.out.println("initDisplay ȣ�⼺��");
			//�޴�������,�޴�,�޴��� �߰��ϱ�
			jmi_new.addActionListener(bgEvent);
			jmi_dap.addActionListener(bgEvent);
			jmi_clear.addActionListener(bgEvent);
			jmi_exit.addActionListener(bgEvent);
			jm_file.add(jmi_new);
			jm_file.add(jmi_dap);
			jm_file.add(jmi_clear);
			jm_file.add(jmi_exit);
			jmb.add(jm_file);
			jf_game.setJMenuBar(jmb);
			//�̺�Ʈ �ҽ��� �̺�Ʈ ó���� ����ϴ� �ڵ鷯 Ŭ������ ����
			jbt_clear.addActionListener(bgEvent);//this=>baseballgame=>actionperformed�޼ҵ尡 ���ȿ� ������
			jbt_new.addActionListener(bgEvent);
			jbt_dap.addActionListener(bgEvent);
			jtf_input.addActionListener(bgEvent);
			jbt_exit.addActionListener(bgEvent);
			jp_center.setLayout(new BorderLayout(0,20));
			jp_east.setLayout(new GridLayout(5,1,10,10));
			//jp_center.setBackground(Color.pink);
			//jp_east.setBackground(Color.red);
			//jp_center������ jta_display�� �߾ӿ� ��ġ�ϰ�
			//jp_center������ jtf-input�� ��ġ����
			jp_center.add("Center",jsp_display);
			jp_center.add("South",jtf_input);
			//jp_east������ ��ư 4�� ���̱�
			//��ư�� ��Ʈ �����ϱ�
			jbt_new.setFont(f);
			jbt_dap.setFont(f);
			jbt_clear.setFont(f);
			jbt_exit.setFont(f);
			//��ư���� ������
			jbt_new.setBackground(new Color(144,225,225));//��ư������
			jbt_new.setForeground(new Color(3,0,102));//���ڻ� ����
			jbt_dap.setBackground(new Color(255,167,167));
			jbt_dap.setForeground(new Color(3,0,102));
			jbt_clear.setBackground(new Color(219,165,229));
			jbt_clear.setForeground(new Color(3,0,102));
			jbt_exit.setBackground(new Color(88,229,92));
			jbt_exit.setForeground(new Color(3,0,102));
			
			
			jp_east.add(jbt_new);
			jp_east.add(jbt_dap);
			jp_east.add(jbt_clear);
			jp_east.add(jbt_exit);
			jf_game.setBackground(new Color(140,140,140));
			//���� ������ JFrame�� ���̱�
			//jp_east.setLayout(new GridLayout(4,1,2,2));
			jf_game.add("Center",jp_center);
			jf_game.add("East",jp_east);
			String title="�߱� ���� ����";
			jf_game.setTitle(title);//������ �����ؼ� ���ش�.
			jf_game.setSize(500,550);//width,height
			jf_game.setVisible(true);
			
			
		}

	public static void main(String[] args) {
		BaseBallGameView bgView= new BaseBallGameView();
		bgView.initDisplay();
	}

}

package com.ch5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseballGameArray implements ActionListener {

	JMenuBar jmb=new JMenuBar();
	JMenu jm_file=new JMenu("����");
	JMenuItem jmi_new=new JMenuItem ("������");
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
		JButton jbtns[]=new JButton[4];
		String btn_label[]={"������","����","�����","����"};
	 Font f =new Font("HY�߰��",Font.BOLD,14); //��Ʈ �̸� ���� ũ��
	 int count=0;//��������
	 
	//ȭ��ó���ϱ�
	public void initDisplay(){
		System.out.println("initDisplay ȣ�⼺��");
		//�޴�������,�޴�,�޴��� �߰��ϱ�
		jm_file.add(jmi_new);
		jm_file.add(jmi_dap);
		jm_file.add(jmi_exit);
		jmb.add(jm_file);
		jf_game.setJMenuBar(jmb);
		for(int i=0;i<jbtns.length;i++){
			jbtns[i]=new JButton(btn_label[i]);
			jbtns[i].setFont(f);//��Ʈ�����ϱ� �迭�� 4���� �ʿ� ���� for���� �־�����
			jp_east.add(jbtns[i]);
		}
		//�̺�Ʈ �ҽ��� �̺�Ʈ ó���� ����ϴ� �ڵ鷯 Ŭ������ ����
		jbtns[2].addActionListener(this);
		jtf_input.addActionListener(this);
		jbtns[3].addActionListener(this);
		jp_center.setLayout(new BorderLayout(0,20));
		jp_east.setLayout(new GridLayout(5,1,10,10));//������ �����ؼ� �����ϰ� ������ �ȴ�.
		//jp_center.setBackground(Color.pink);
		//jp_east.setBackground(Color.red);
		//jp_center������ jta_display�� �߾ӿ� ��ġ�ϰ�
		//jp_center������ jtf-input�� ��ġ����
		jp_center.add("Center",jsp_display);
		jp_center.add("South",jtf_input);
		//jp_east������ ��ư 4�� ���̱�
		
		//��ư���� ������
		jbtns[0].setBackground(new Color(144,225,225));//��ư������
		jbtns[0].setForeground(new Color(3,0,102));//���ڻ� ����
		jbtns[1].setBackground(new Color(255,167,167));
		jbtns[1].setForeground(new Color(3,0,102));
		jbtns[2].setBackground(new Color(219,165,229));
		jbtns[2].setForeground(new Color(3,0,102));
		jbtns[3].setBackground(new Color(88,229,92));
		jbtns[3].setForeground(new Color(3,0,102));
		
		
		
		jf_game.setBackground(new Color(140,140,140));
		//���� ������ JFrame�� ���̱�
		//jp_east.setLayout(new GridLayout(4,1,2,2));
		jf_game.add("Center",jp_center);
		jf_game.add("East",jp_east);
		String title="�߱� ���� ����-�迭";
		jf_game.setTitle(title);//������ �����ؼ� ���ش�.
		jf_game.setSize(500,550);//width,height
		jf_game.setVisible(true);
		
		
	}
	//�� ���� �ϱ�
	//�̺�Ʈ ó���ϱ�
	//���θ޼ҵ�
	public static void main(String[] args) {
		BaseballGameArray bGame= new BaseballGameArray();
		bGame.initDisplay();

	}
	//actionperformed�޼ҵ�� �ݹ� �޼ҵ�
	@Override
	public void actionPerformed(ActionEvent ae) {
		//�׼��̺�Ʈ �ڿ� �ִ°� ������ �ٲ� �� �ִ�.
		//�̺�Ʈ�� �߻��� ������Ʈ�� �ּҹ��� ��������- � ��ư�� ������?
		Object obj=ae.getSource();//����� ��ư�� �ּҹ��� ��������
		//object�� ��� Ŭ������ �ƹ���
		System.out.println(jbtns[2]+","+ae.getSource());
		//����� ��ư�� Ŭ������ �� ȣ��
		if(obj==jbtns[2]){
			jta_display.setText("");
		}//����ڰ� ���� �Է��ϰ� ���� ���� �� ȣ��
		else if(obj==jtf_input){
			String user=jtf_input.getText();//string Ÿ������ �Ǿ� �ִ�.
			jta_display.append(++count+"."+user+":"+"0��0��"+"\n");
			jtf_input.setText("");//���ڿ��� �� ���� �����ش�.
		}//���� ��ư�� Ŭ������ �� ȣ��
		else if(obj==jbtns[3]){
			System.exit(0);//�ڹٰ���ӽŰ� ������� ��������.
		}
	}


}

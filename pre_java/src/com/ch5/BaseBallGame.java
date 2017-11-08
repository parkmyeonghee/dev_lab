package com.ch5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseBallGame implements ActionListener{
	//�����
	//�޴��߰��ϱ�
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
	 JButton jbt_new=new JButton("������");
	 JButton jbt_dap=new JButton("����");
	 JButton jbt_clear=new JButton("�����");
	 JButton jbt_exit=new JButton("����");
	 Font f =new Font("HY�߰��",Font.BOLD,14); //��Ʈ �̸� ���� ũ��
	 int cnt=0;//��������
	 int com[]=new int[3];//���Ͱ� ä���� ���� ���
	 int my[]=new int[3];//����ڰ� �Է��� �� ���
	 public BaseBallGame(){
		 nanSu();
	 }
	 
	 //����ڰ� �Է��� ���ڸ� �޾Ƽ� �迭�� ��� ����

void userInput(String input){
	int temp=0;
	if(input.length()!=3){
		JOptionPane.showMessageDialog(jf_game,"���ڸ� ���ڸ� �Է��ϼ���"
				,"INFO",JOptionPane.INFORMATION_MESSAGE);
		return;//userinput�޼ҵ� Ż��
	}
	temp=Integer.parseInt(input);
	my[0]=temp/100;
	my[1]=(temp%100)/10;
	my[2]=temp%10;
}
public void nanSu(){
	com[0]=(int)(Math.random()*10);
	do{
		com[1]=(int)(Math.random()*10);
	}while(com[0]==com[1]);
	  do {
		  com[2]=(int)(Math.random()*10);
	}while(com[0]==com[2]||com[1]==com[2]);
}
	//ȭ��ó���ϱ�
	public void initDisplay(){
		System.out.println("initDisplay ȣ�⼺��");
		//�޴�������,�޴�,�޴��� �߰��ϱ�
		jm_file.add(jmi_new);
		jm_file.add(jmi_dap);
		jm_file.add(jmi_exit);
		jmb.add(jm_file);
		jf_game.setJMenuBar(jmb);
		//�̺�Ʈ �ҽ��� �̺�Ʈ ó���� ����ϴ� �ڵ鷯 Ŭ������ ����
		jbt_clear.addActionListener(this);//this=>baseballgame=>actionperformed�޼ҵ尡 ���ȿ� ������
		jbt_new.addActionListener(this);
		jbt_dap.addActionListener(this);
		jtf_input.addActionListener(this);
		jbt_exit.addActionListener(this);
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
	//�� ���� �ϱ�
	String Ya9Run()
	{
		int ball=0;
		int strike=0;
		//������ ����
		for(int i=0; i<com.length; i++)
		{
			for(int j=0; j<my.length; j++)
			 {
				//���ڰ� �����ϴ�? -����:�� Ȯ��
				if(com[i]==my[j]){
				//�ڸ��� ��ġ�ϴ�? -����:��Ʈ����ũ Ȯ��
					if(i==j){
						strike++;
					}else
					{
						ball++;
					}
					 }
				  
			   	}//////out of end inner for
			   				
			}/////out of end outter for
	//////////////////////////////////������///////////////////////
		  if(strike==3)
			{
			return "�����Դϴ�";
			}
		   else
		   {return strike+"��"+ball+"�� ���� �־��׿�";
		   }
			}

	//�̺�Ʈ ó���ϱ�
	//���θ޼ҵ�
	public static void main(String[] args) {
		BaseBallGame bGame= new BaseBallGame();
		bGame.initDisplay();

	}
	//actionperformed�޼ҵ�� �ݹ� �޼ҵ�
	@Override
	public void actionPerformed(ActionEvent ae) {
		//�׼��̺�Ʈ �ڿ� �ִ°� ������ �ٲ� �� �ִ�.
		//�̺�Ʈ�� �߻��� ������Ʈ�� �ּҹ��� ��������- � ��ư�� ������?
		Object obj=ae.getSource();//����� ��ư�� �ּҹ��� ��������
		//object�� ��� Ŭ������ �ƹ���
		System.out.println(jbt_clear+","+ae.getSource());
		//����� ��ư�� Ŭ������ �� ȣ��
		if(obj==jbt_clear){
			jta_display.setText("");
		}
		//�����ӹ�ư�� Ŭ���ߴ�?
		else if(obj==jbt_new){
			cnt=0;
			nanSu();
			jta_display.setText("");
			jtf_input.setText("");
			jtf_input.requestFocus();
			
		}
		//�̺�Ʈ�ҽ��� �ּҹ����� �����ư�� �ּҹ����� ����?
		else if(obj==jbt_dap){
			System.out.println("======�����ư Ŭ��=======");
			jta_display.append("����:"+com[0]
									 +com[1]
									 +com[2]+"\n");			
		}//����ڰ� ���� �Է��ϰ� ���� ���� �� ȣ��
		else if(obj==jtf_input){
			String user=jtf_input.getText();//����ڰ� �Է��� ���ڸ� ���� ����
			userInput(user);
			jta_display.append(++cnt+"."+user+":"+Ya9Run()+"\n");
			jtf_input.setText("");
				}
		

	/*	else if(obj==jtf_input){
			String user=jtf_input.getText();//string Ÿ������ �Ǿ� �ִ�.
			jta_display.append(++count+"."+user+":"+"0��0��"+"\n");
			jtf_input.setText("");//���ڿ��� �� ���� �����ش�.
		}//���� ��ư�� Ŭ������ �� ȣ��*/

		else if(obj==jbt_exit){
			System.exit(0);//�ڹٰ���ӽŰ� ������� ��������.
		}
	}
	
}


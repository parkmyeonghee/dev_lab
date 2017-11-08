package com.ChattingProject;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CC_Membership extends JFrame implements ActionListener{
//ccl ���� �ּ� �޴� ������
	CC_Login ccl;
	public CC_Membership(CC_Login ccl){
		this.ccl = ccl;
	}
	
	String id;
	String pw;
	String pw2;
	String name;
	String email;
	String dup_id;
	   public JTextField jtf_signup_id;
	   public JTextField jtf_signup_pw;
	   public JTextField jtf_signup_pw2;
	   public JTextField jtf_signup_name;
	   public JTextField jtf_signup_email;
	   public JButton btn_signup_ok = new JButton("Ȯ��");
	   public JButton btn_signup_cancel = new JButton("���");
	  

	   String path = this.getClass().getResource("").getPath();
       ImageIcon member = new ImageIcon(getClass().getResource("member.png"));
         public JPanel contentPane =new JPanel(){
         public void paintComponent(Graphics g) {
            g.drawImage(member.getImage(), 0, 0, null);
            setOpaque(false);
             super.paintComponents(g);
            }
         };


	JButton jb_duplication= new JButton("ID�ߺ��˻�");
	JFrame jf_duplication = new JFrame("ID �ߺ��˻� â");
	JPanel jp_dup = new JPanel();
	JTextField jtf_dup_id = new JTextField(10);
	JButton jb_dup_check = new JButton("�ߺ����� Ȯ��");


	
////////ȸ������ â ���� �޼ҵ�
public void initDisplay(){

    Image chattingicon= new ImageIcon(path+"chatting.png").getImage();
    this.setIconImage(chattingicon);


		btn_signup_ok.addActionListener(this);
		btn_signup_cancel.addActionListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setBounds(100, 100, 450, 651);
	     // contentPane = new JPanel();
	      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	      setContentPane(contentPane);
	      contentPane.setLayout(null);
	      
	      JLabel jl_id = new JLabel();
	      jl_id.setText("���̵�");
	      jl_id.setBounds(54, 53, 43, 24);
	      contentPane.add(jl_id);
	      
	      jtf_signup_id = new JTextField();
	      jtf_signup_id.setBounds(150, 49, 156, 27);
	      contentPane.add(jtf_signup_id);
	      jtf_signup_id.setColumns(10);
	      
	      jb_duplication.setBounds(320, 49, 100, 30);
	      contentPane.add(jb_duplication);
	      jb_duplication.addActionListener(this);
	      
	      JLabel jl_pw = new JLabel();
	     jl_pw.setText("��й�ȣ");
	     jl_pw.setBounds(54, 119, 61, 24);
	      contentPane.add(jl_pw);
	      
	      jtf_signup_pw = new JTextField();
	      jtf_signup_pw.setColumns(10);
	      jtf_signup_pw.setBounds(150, 115, 156, 27);
	      contentPane.add(jtf_signup_pw);
	      
	      JLabel jl_pw2 = new JLabel();
	     jl_pw2.setText("��й�ȣȮ��");
	     jl_pw2.setBounds(54, 179, 61, 24);
	      contentPane.add(jl_pw2);
	      
	      jtf_signup_pw2 = new JTextField();
	      jtf_signup_pw2.setColumns(10);
	      jtf_signup_pw2.setBounds(150, 175, 156, 27);
	      contentPane.add(jtf_signup_pw2);
	      
	      JLabel jl_email = new JLabel();
	     jl_email.setText("email");
	     jl_email.setBounds(54, 242, 61, 24);
	      contentPane.add(jl_email);
	      
	      
	      jtf_signup_email  = new JTextField();
	      jtf_signup_email.setColumns(10);
	      jtf_signup_email .setBounds(150, 238, 156, 27);
	      contentPane.add(jtf_signup_email );
	      
	     JLabel jl_name= new JLabel();
	     jl_name.setText("�̸�");
	     jl_name.setBounds(54, 303, 61, 24);
	      contentPane.add(jl_name);
	      
	      jtf_signup_name = new JTextField();
	      jtf_signup_name.setColumns(10);
	      jtf_signup_name.setBounds(150, 299, 72, 27);
	      contentPane.add(jtf_signup_name);
	      
	      btn_signup_ok.setBounds(54, 502, 125, 29);
	      contentPane.add(btn_signup_ok);
	      
	      btn_signup_cancel.setBounds(246, 502, 125, 29);
	      contentPane.add(btn_signup_cancel);
	       this.setVisible(true);
	       this.setTitle("ȸ������");
	       

	}

///////////ID�ߺ��˻� â ���� �޼ҵ�
public void initDup(){
	jf_duplication.add("Center",jp_dup);
	jp_dup.add(jtf_dup_id );
	jp_dup.add(jb_dup_check);
	jb_dup_check.addActionListener(this);
	jf_duplication.setSize(200, 100);
	jf_duplication.setVisible(true);
}
/////////////ID�ߺ� ��� �޼ҵ�
public void warning(){
	JOptionPane.showMessageDialog(this
            , "���̵� "
            , "INFO"
            , JOptionPane.INFORMATION_MESSAGE);
}


@Override
public void actionPerformed(ActionEvent ae) {
	Object obj = ae.getSource();
	//ȸ������ ��ư
	if(obj==btn_signup_ok){
		id=jtf_signup_id.getText();
		pw=jtf_signup_pw.getText();
		pw2=jtf_signup_pw2.getText();
		name=jtf_signup_email.getText();
		email=jtf_signup_name.getText();
//ccl.jta_test.append("id:"+id+"pw:"+pw+"pw2:"+pw2+"\n");		
		//�Է� �� �� ������ ������
		if(id.equals("")|pw.equals("")|pw2.equals("")|name.equals("")|email.equals(""))
		{
			JOptionPane.showMessageDialog(this
		             ,"��� ������ �Է��ϼž� �մϴ�."
		             ,"INFO"
		             ,JOptionPane.INFORMATION_MESSAGE);	
			return;
		}
		//pw != pw2 �̸�
		else if(!pw.equals(pw2)){
			JOptionPane.showMessageDialog(this
		             ,"��й�ȣ�� ���� ��ġ���� �ʽ��ϴ�."
		             ,"INFO"
		             ,JOptionPane.INFORMATION_MESSAGE);	
			return;
		}
		ccl.join(id,pw,name,email);
//		ccl.jta_test.append("ccm���� ȸ������ ������ ccl�� jon�޼ҵ忡 �ѱ�: "+id+pw+name+email+"\n");

	//ȸ������â���� ID�ߺ��˻� ��ư�� ������
	}
	else if(obj==jb_duplication){
		initDup();
	//�ߺ��˻� â���� Ȯ�ι�ư�� ������
	}else if(obj==jb_dup_check){
		dup_id = jtf_dup_id.getText();
		ccl.dup(dup_id);
	}
	else if(obj==btn_signup_cancel){
		this.dispose();
	}
	}
}




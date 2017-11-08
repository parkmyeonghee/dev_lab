package com.ch15;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class MyEditor extends JFrame implements ActionListener {
	//�����
	String path ="src\\com\\images\\";
	//�޴��� �߰��ϱ�
	JMenuBar jmb = new JMenuBar();
	JMenu jm_file= new JMenu("File");
	JMenuItem jmi_new = new JMenuItem("New"
			,new ImageIcon(path+"new.gif"));
	JMenuItem jmi_open = new JMenuItem("Open"
			,new ImageIcon(path+"open.gif"));
	JMenuItem jmi_save = new JMenuItem("Save"
			,new ImageIcon(path+"save.gif"));
	JSeparator js_file= new JSeparator();
	JMenuItem jmi_file = new JMenuItem("File"
			,new ImageIcon(path+"file.gif"));
	JMenuItem jmi_exit = new JMenuItem("Exit"
			,new ImageIcon(path+"exit.gif"));
	JMenu jm_edit= new JMenu("Edit");
	JMenuItem jmi_copy = new JMenuItem("Copy"
			,new ImageIcon(path+"copy.gif"));
	JMenuItem jmi_cut = new JMenuItem("Cut"
			,new ImageIcon(path+"cut.gif"));
	JMenuItem jmi_paste = new JMenuItem("Paste"
			,new ImageIcon(path+"copy.gif"));
	JTextArea jta_display = new JTextArea();
	JScrollPane jsp_display = new JScrollPane(jta_display);
	JFileChooser jfc = new JFileChooser();
	//������
	public MyEditor(){
		initDisplay();
	}
	//���̾� �α�â ����
	public void showDialog(){
		MyEditorDialog myDia = new MyEditorDialog(this);
		myDia.setResizable(false);
		Point poi = getLocation();
		poi.translate(70, 70);//��ǥ��
		myDia.setLocation(poi);
		myDia.initDisplay();
	}
	//ȭ��ó����
	public void initDisplay(){
		//�͸�Ŭ������ �̺�Ʈ ó���ϱ�
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt){
				System.exit(0);
			}
			
		});
	
		//this=myEditor(ȭ������:JFrame|�̺�Ʈó��:ActionListener)
		//���ȿ� actionPerformed�� �����ߴٴ� ���̴�
		//ActionListener��� �������̽��� ����ü Ŭ���� ����
		//ActionListener al = new MyEditor();
		//jmi_new.addActionListener(al);
		jmi_new.addActionListener(this);
		jmi_open.addActionListener(this);
		jmi_save.addActionListener(this);
		jmi_copy.addActionListener(this);
		jmi_paste.addActionListener(this);
		jmi_cut.addActionListener(this);
		jmi_exit.addActionListener(this);
		
		jm_file.add(jmi_new);
		jm_file.add(jmi_open);
		jm_file.add(jmi_save);
		jm_file.add(jmi_file);
		jm_file.add(jmi_exit);
		jmb.add(jm_file);
		
		jm_file.setMnemonic('F');
		jm_edit.setMnemonic('E');
		
		jm_edit.add(jmi_copy);
		jm_edit.add(jmi_cut);
		jm_edit.add(jmi_paste);
		jmb.add(jm_edit);
		
		this.setJMenuBar(jmb);
		this.add("Center",jsp_display);
		this.setTitle("���� ���� �޸���");
		this.setSize(500, 300);
		this.setVisible(true);
	}
	//���θ޼ҵ�
	public static void main(String[] args) {
		MyEditor me = new MyEditor();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj==jmi_open){
			int intRet = jfc.showOpenDialog(this);
			//yes Ȥ�� ok��ư�� �������� ��
			if(intRet==JFileChooser.APPROVE_OPTION){
				//������ ���� ó���ϱ�
				FileReader fr = null;
				BufferedReader myReader = null;
				try {
				String strLine = null;
				//file��ü�� ���ϸ��� ��ü�� ����� �ִ� Ŭ����
				File myFile= jfc.getSelectedFile();
				//���õ� ������ ���� ��θ� �����Ͽ� BufferReader
				//��ü�� �����ϱ�
				/*BufferedReader myReader =
						new BufferedReader(
								new FileReader(myFile.getAbsolutePath()); �ܵ����� �а� ���� ����*/
				fr = new FileReader(myFile.getAbsolutePath());
				myReader = new BufferedReader(fr);
				//�о� ���� �ؽ�Ʈ�� JTextArea�� ����
				jta_display.setText(myReader.readLine());
				//2�� ���Ĵ� ��ٲٱ� �ڵ带 �־� append�ϱ�
				while((strLine=myReader.readLine())!=null){
					jta_display.append("\n"+strLine);
				}
				} catch (IOException ie) {
				}finally{
					try {
						if(myReader!=null) myReader.close();
					} catch (IOException ie) {
					}
				}
			}
		}
		//save �޴� ������ ó��
		else if(obj==jmi_save){
			//���� ��ȭ ���ڸ� ����
			save();
		}//////////end of save
		else if(obj==jmi_new){//�� ���� ó��
			showDialog();
			//jta_display.setText("");
		}
		else if(obj==jmi_copy){//�����ϱ�
			jta_display.copy();
		}
		else if(obj==jmi_paste){//�ٿ��ֱ�
			jta_display.paste();
		}
		else if(obj==jmi_cut){//�߶󳻱�
			jta_display.cut();
		}
		else if(obj==jmi_exit){
			System.exit(0);
		}
	}///////////////////////////ensd of actionperformed
	public void save(){
		int intRet = jfc.showSaveDialog(this);
		if(intRet==JFileChooser.APPROVE_OPTION){
			//������ �����ϴ� ó��
			BufferedWriter myWriter =null;
			PrintWriter myPwriter = null;
			FileWriter myFwriter = null;
			try {
				File myFile = jfc.getSelectedFile();
				myFwriter = new FileWriter(myFile.getAbsolutePath());
				myWriter = new BufferedWriter(myFwriter);
				myPwriter= new PrintWriter(myWriter);
				myPwriter.write(jta_display.getText());
			} catch (Exception e) {
			}finally{
				try {
					if(myFwriter!=null) myFwriter.close();
					if(myWriter!=null) myWriter.close();
					if(myPwriter!=null)myPwriter.close();
				} catch (Exception e2) {
				}
			}
		}
	}
}

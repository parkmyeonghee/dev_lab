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
	//선언부
	String path ="src\\com\\images\\";
	//메뉴바 추가하기
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
	//생성자
	public MyEditor(){
		initDisplay();
	}
	//다이얼 로그창 띄우기
	public void showDialog(){
		MyEditorDialog myDia = new MyEditorDialog(this);
		myDia.setResizable(false);
		Point poi = getLocation();
		poi.translate(70, 70);//좌표값
		myDia.setLocation(poi);
		myDia.initDisplay();
	}
	//화면처리부
	public void initDisplay(){
		//익명클래스로 이벤트 처리하기
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt){
				System.exit(0);
			}
			
		});
	
		//this=myEditor(화면제공:JFrame|이벤트처리:ActionListener)
		//내안에 actionPerformed를 구현했다는 것이다
		//ActionListener라는 인터페이스의 구현체 클래스 역할
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
		this.setTitle("내가 만든 메모장");
		this.setSize(500, 300);
		this.setVisible(true);
	}
	//메인메소드
	public static void main(String[] args) {
		MyEditor me = new MyEditor();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj==jmi_open){
			int intRet = jfc.showOpenDialog(this);
			//yes 혹은 ok버튼을 선택했을 때
			if(intRet==JFileChooser.APPROVE_OPTION){
				//파일을 여는 처리하기
				FileReader fr = null;
				BufferedReader myReader = null;
				try {
				String strLine = null;
				//file객체는 파일명을 객체로 만들어 주는 클래스
				File myFile= jfc.getSelectedFile();
				//선택된 파일의 절대 경로를 지정하여 BufferReader
				//객체를 생성하기
				/*BufferedReader myReader =
						new BufferedReader(
								new FileReader(myFile.getAbsolutePath()); 단독으로 읽고 쓰고 ㄴㄴ*/
				fr = new FileReader(myFile.getAbsolutePath());
				myReader = new BufferedReader(fr);
				//읽어 들인 텍스트를 JTextArea에 쓰기
				jta_display.setText(myReader.readLine());
				//2행 이후는 행바꾸기 코드를 넣어 append하기
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
		//save 메뉴 아이템 처리
		else if(obj==jmi_save){
			//저장 대화 상자를 오픈
			save();
		}//////////end of save
		else if(obj==jmi_new){//새 파일 처리
			showDialog();
			//jta_display.setText("");
		}
		else if(obj==jmi_copy){//복사하기
			jta_display.copy();
		}
		else if(obj==jmi_paste){//붙여넣기
			jta_display.paste();
		}
		else if(obj==jmi_cut){//잘라내기
			jta_display.cut();
		}
		else if(obj==jmi_exit){
			System.exit(0);
		}
	}///////////////////////////ensd of actionperformed
	public void save(){
		int intRet = jfc.showSaveDialog(this);
		if(intRet==JFileChooser.APPROVE_OPTION){
			//파일을 저장하는 처리
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

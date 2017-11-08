package com.ch6;
/*************************************************************
 * 이벤트 처리 순서
 * 1.이벤트 소스(상세조회)가 이벤트 발생시 감지할 수 있는 인터페이스 구현 
 * :이벤트가 일어난 이벤트 소스는 JVM이 감지
 * 2.이벤트 발생시에 처리할 내용은 콜백메소드인
 * actionPerformed메소드에 재정의 한다.
 * 3.이벤트 소스(상세조회)와 이벤트 처리를 담당하는 클래스를 매핑한다.
 *************************************************************/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import com.ch5.BaseBallGame;


public class AddressBook implements ActionListener {//이벤트 발생시 감지할 수 있는 인터페이스
	static AddressBook adrbook=null;
	JFrame jf_book=new JFrame();
	AddressPopup apopup = new AddressPopup();
	JMenuBar jmb=new JMenuBar();
	JMenu jm_edit=new JMenu("편집");
	JMenuItem jmi_search=new JMenuItem ("상세조회");
	JMenuItem jmi_in=new JMenuItem ("입력");
	JMenuItem jmi_change=new JMenuItem ("수정");
	JMenuItem jmi_delete=new JMenuItem ("삭제");
	JSeparator js_file =new JSeparator();
	JMenuItem jmi_exit=new JMenuItem ("종료");
	JTextArea jta_display = new JTextArea("☆★첸백시☆★");
	/**************************************************************
	 * AddressPopup에서 확인 버튼을 클릭했을 때 호출 될 메소드 구현
	 * AddressPopup클래스에 AddressBook객체에 대한 주소번지가 필요하다.
	 **************************************************************/

	public void initDisplay(){
		
		jmi_search.addActionListener(this);
		//this는 이벤트 처리를 담당하는 이벤트 핸들러 클래스이다.
		//여기서는 직접 actionPerformed메소드를 구현하였으므로 
		//나 자신이 이벤트 처리를 담당하는 클래스가 된다.

		jmi_in.addActionListener(this);
		jmi_change.addActionListener(this);
		jmi_delete.addActionListener(this);
		jmi_exit.addActionListener(this);
		jm_edit.add(jmi_search);
		jm_edit.add(jmi_in);
		jm_edit.add(jmi_change);
		jm_edit.add(jmi_delete);
		jm_edit.add(js_file);
		jm_edit.add(jmi_exit);
		jmb.add(jm_edit);
		jf_book.setJMenuBar(jmb);
		jf_book.add("Center",jta_display);
		String title="이런 귀한곳에 누추한 주소록이";
		jf_book.setTitle(title);//변수를 선언해서 해준다.
		jf_book.setSize(500,550);//width,height
		jf_book.setVisible(true);
		
		
	}

	public void refresh(){
		jta_display.setText("집에 가고싶다.");
		
	}
	public static void main(String[] args) {
		/*AddressBook abook= new AddressBook();
		abook.initDisplay();*/
		adrbook= new AddressBook();
		adrbook.initDisplay();
		
	

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//상세조회|입력|수정|삭제
		String jmi_label = e.getActionCommand();
		System.out.println("actionPerformed 호출 성공"+jmi_label+",주번:"+e.getSource());
		//상세조회를 클릭했니?
		//if("상세조회".equals(jmi_label))덜 안전함
		if(jmi_search==e.getSource()){
		//if("상세조회".equals(jmi_label)){
			apopup.setTitle(jmi_label);
			apopup.initDisplay2(this);
		}
		else if(jmi_in==e.getSource()){
			apopup.setTitle(jmi_label);
			apopup.initDisplay2(this);
		}
		else if(jmi_change==e.getSource()){
			apopup.setTitle(jmi_label);
			apopup.initDisplay2(this);
		}
		else if(jmi_delete==e.getSource()){
			apopup.setTitle(jmi_label);
			apopup.initDisplay2(this);
		}
		else if(e.getSource()==jmi_exit){
			System.exit(0);
		}
		apopup.click();
	
	}

}

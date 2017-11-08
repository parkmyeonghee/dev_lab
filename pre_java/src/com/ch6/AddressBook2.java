package com.ch6;
/**********************************************
 * 이벤트 처리 순서
 * 1.이벤트 소스(상세조회)가 이벤트 발생시
 * 감지할 수  있는 인터페이스 구현 
 * :이벤트가 일어난 이벤트 소스는 JVM이 감지
 * 2.이벤트 발생시에 처리할 내용은
 *   콜백메소드인 actionPerformed메소드에 재정의
 *   한다.
 * 3.이벤트 소스(상세조회)와 이벤트 처리를 담당하는
 *   클래스를 매핑한다.  
 *********************************************/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class AddressBook2 {
	AddressBookEvent aEvent=new AddressBookEvent(this);
	
	JFrame jf_book = new JFrame(); //화면생성
	AddressPopup2 apopup = new AddressPopup2(this);
	JMenuBar jmb = new JMenuBar();
	
	JMenu jm_file = new JMenu("편집");
	JMenuItem jmi_specific = new JMenuItem("상세조회");
	JMenuItem jmi_input = new JMenuItem("입력");
	JMenuItem jmi_modify = new JMenuItem("수정");
	JMenuItem jmi_delete = new JMenuItem("삭제");
	JSeparator js_file = new JSeparator();
	JMenuItem jmi_exit = new JMenuItem("종료");
	
	JTextArea jta_display = new JTextArea("테스트");
	/********************************************************************************
	 * AddressPopup에서 확인 버튼을 클릭했을 때 호출 될 메소드 구현
	 * AddressPopup클래스에 AddressBook2객체에 대한 주소번지가 필요합니다.
	 *******************************************************************************/
	public void refresh(){
		jta_display.setText("나는 새로고침 되었다.");
	}
	
	public void initDisplay(){
		java.lang.System.out.println("initDisplay 호출성공");
		//this는 이벤트 처리를 담당하는 이벤트 핸들러 클래스이다.
		//여기서는 직접 actionPerformed메소드를 구현하였으므로
		//나 자신이 이벤트 처리를 담당하는 클래스가 됩니다.
		jmi_specific.addActionListener(aEvent);
		jmi_input.addActionListener(aEvent);
		jmi_exit.addActionListener(aEvent);
		//메뉴 추가 - 2)화면에 붙여넣기
		jm_file.add(jmi_specific);
		jm_file.add(jmi_input);
		jm_file.add(jmi_modify);
		jm_file.add(jmi_delete);	
		jm_file.add(js_file);
		jm_file.add(jmi_exit);
		jmb.add(jm_file);
		jf_book.setJMenuBar(jmb);//게임화면에 메뉴바 세팅해
		jf_book.add("Center",jta_display);
		String title = "주소록2";
		jf_book.setTitle(title);		
		jf_book.setSize(500,300);//메소드 밖에서 생성된 화면에 크기부여	
		jf_book.setVisible(true);//보이게 해라?
		//괄호 안에는 boolean을 넣어야 한다고 설정되어 있음.
		

		
		
		
					
		//3)
		//이벤트 소스와 이벤트 처리를 담당하는 핸들러 클래스의 연결
//		jmi_specific.addActionListener(this);//이벤트소스명.핸들러클래스(주소번지);		
	
		}

	public static void main(String[] args) {
		AddressBook2 aEvent = new AddressBook2();
		aEvent.initDisplay();
	}

	

}













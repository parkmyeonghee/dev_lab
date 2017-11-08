package com.Chatting.color;

import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JScrollBar;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ChattingClientThread extends Thread {
	ChattingClient cc =null;
	public ChattingClientThread(ChattingClient cc){
		this.cc=cc;
	}
	public SimpleAttributeSet makeAttributeSet(String  style[]){
		SimpleAttributeSet sas = new SimpleAttributeSet();
		//��Ʈ �÷�
		sas.addAttribute(StyleConstants.ColorConstants.Foreground
				,new Color(Integer.parseInt(style[0])));
		//��Ʈ Ÿ��
		switch(style[1]){
		case "Font.ITALIC":
			sas.addAttribute(StyleConstants.CharacterConstants.Italic, true);
			break;
		case "Font.BOLD":
			sas.addAttribute(StyleConstants.CharacterConstants.Bold, true);
			break;
		}
		//��Ʈ ������
		sas.addAttribute(StyleConstants.CharacterConstants.Size, Integer.parseInt(style[2]));
		return sas;
	}
	//run�޼ҵ�� �������� ���� ������ ��⸸ �ϴ� �� �Դϴ�.
	//Ŭ���̾�Ʈ�� ���ϱ�� �̺�Ʈ(chattingClient)���� ó�� �մϴ�.
	public void run(){
		//message =100
		String message ="";
		boolean isStop = false;
		while(!isStop){
			try {
				message= (String)cc.ois.readObject(); //�޼����� �޾ƿ��� ����
				StringTokenizer st =null;
				int protocol=0;
				if(message !=null){
					st=new StringTokenizer(message,"|");
					protocol=Integer.parseInt(st.nextToken());//100
				}
				switch(protocol){
				case Protocol.ROON_IN:{
				//��ȭ�� ��������
					String nickName = st.nextToken();
					String fontColor = st.nextToken();
					String fontType= st.nextToken();
					String fontSize = st.nextToken();
					String style[] = new String[3];
					style[0] = fontColor;
					style[1]= fontType;
					style[2]=fontSize;
					SimpleAttributeSet sas= new makeAttributeSet(style);
					Vector<String>v_name= new Vector<String>();
					v_name.add(nickName);
					cc.dtm_room.addRow(v_name);
					cc.jsp_room.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
						public void adjustmentValueChanged(AdjustmentEvent e) {
							JScrollBar src=(JScrollBar) e.getSource();
							src.setValue(src.getMaximum());
						}
					});
					SimpleAttributeSet sas =makeAttributeSet(fontColor);
				//ȭ�鿡 �������� �����Ͽ����ϴ�. ����ϱ�
					try {
						cc.sd_display.insertString(cc.sd_display.getLength()
								,"######"+nickName+"���� �����Ͽ����ϴ�.#####\n"
								, sas);
					} catch (Exception e) {
					}
					cc.jtp_display.setCaretPosition(cc.sd_display.getLength());
				}break;
				//200|����|���� ���͵� ��?|��������
				case Protocol.MESSAGE:{//�Ϲݴ�ȭ- ���ڰ� ��ȭ
				String nickName = st.nextToken();
				String msg = st.nextToken();
				String fontColor =st.nextToken();
				SimpleAttributeSet sas =makeAttributeSet(fontColor);
				try {
					cc.sd_display.insertString(cc.sd_display.getLength()
							,"######"+"["+nickName+"]"+msg+"\n"
							, sas);
				} catch (Exception e) {
				}
				cc.jtp_display.setCaretPosition(cc.sd_display.getLength());
				}break;
				case Protocol.WHISPER:{//�ӼӸ�-1:1��ȭ
					String nickName = st.nextToken();
					String otherName=st.nextToken();
					String msg1 = st.nextToken();
					//������� ȭ�鿡 �ӼӸ� ����ϱ�
					String fontColor =st.nextToken();
					SimpleAttributeSet sas =makeAttributeSet(style);
					try {
						cc.sd_display.insertString(cc.sd_display.getLength()
								,"**�ӼӸ�**"+nickName+"����"+otherName+"����"+msg1+"\n"
								, sas);
					} catch (Exception e) {
					}
					cc.jtp_display.setCaretPosition(cc.sd_display.getLength());
				}break;
				
				case Protocol.CHANGE:{//��ȭ�� ����
					//���� ��ȭ�� ��������
					String nickName =st.nextToken();
					//���� ��ȭ�� ��������
					String afterName =st.nextToken();
					//���̺� ��ȭ�� �����ϱ�
					String fontColor =st.nextToken();
					for(int i =0;i<cc.dtm_room.getRowCount();i++){
						//��ȭ�� �������� ���� ���̺��� ������ ��ȭ���� �޴´�.
						String cname = (String)cc.dtm_room.getValueAt(i, 0);
						if(nickName.equals(cname)){
							//������ ��ȭ������ ���̺��� ��ȭ���� �����Ѵ�.
							cc.dtm_room.setValueAt(afterName, i, 0);
							break;
						}
					}
					//�޽��� ����ϱ�
					SimpleAttributeSet sas =makeAttributeSet(fontColor);
					try {
						cc.sd_display.insertString(cc.sd_display.getLength()
								,nickName+"���� ��ȭ����"+afterName+"���� ����"+"\n"
								, sas);
					} catch (Exception e) {
					}
					cc.jtp_display.setCaretPosition(cc.sd_display.getLength());
					//st.nextToken()�� �־��־ �ȴ�.
					//ä�� �˾�â�� Ÿ��Ʋ �ٿ��� ��ȭ���� �����Ѵ�.
					if(nickName.equals(cc.nickName)){
						cc.setTitle(afterName+"���� ��ȭâ");
						cc.nickName=afterName;
					}
				}break;
				case Protocol.ROON_OUT:{//�泪����
				//�������� �Ѿ�� �޽��� - 500|����
				//��ȭ���� �޾ƿ´�
					String name= st.nextToken();
					String fontColor =st.nextToken();
				//���� ����� ȭ�鿡 ����� �ش�.
					SimpleAttributeSet sas =makeAttributeSet(fontColor);
					try {
						cc.sd_display.insertString(cc.sd_display.getLength()
								,name+"���� �����Ͽ����ϴ�"+"\n"
								, sas);
					} catch (Exception e) {
					}
					cc.jtp_display.setCaretPosition(cc.sd_display.getLength());
				//���̺��� ������ ������� �̸��� ������ �ش�.
					for(int i=0;i<cc.dtm_room.getRowCount();i++){
						String n1 = (String)cc.dtm_room.getValueAt(i,0);
						if(name.equals(n1)){ //������ ����� ���� ����� ã�ƶ�
							cc.dtm_room.removeRow(i);
						}
					}
				}break;
				case Protocol.CLOSE:{//�����ư ������ ��
					//�������� �Ѿ�� �޽��� - 500|����
					String name = st.nextToken();
					String msg = st.nextToken();
					String fontColor =st.nextToken();
					SimpleAttributeSet sas =makeAttributeSet(fontColor);
					try {
						cc.sd_display.insertString(cc.sd_display.getLength()
								,msg+"����"+"\n"
								, sas);
					} catch (Exception e) {
					}
					cc.jtp_display.setCaretPosition(cc.sd_display.getLength());
				}break;
				}////////////////end of switch
			} catch (Exception e) {
			}{
				
			}
		}
	}
}

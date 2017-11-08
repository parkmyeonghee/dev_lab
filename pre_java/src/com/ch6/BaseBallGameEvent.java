package com.ch6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseBallGameEvent implements ActionListener{
	//�����
	int cnt = 0;//��������
	BaseBallGameView bgView = null;
	BaseBallGameLogic bgLogic = null;
	public BaseBallGameEvent(BaseBallGameView bgView) {
		this.bgView = bgView;
	}
	public BaseBallGameEvent(BaseBallGameView bgView
			               , BaseBallGameLogic bgLogic) {
		this.bgView = bgView;
		this.bgLogic = bgLogic;
	}	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//�̺�Ʈ�� �߻��� ������Ʈ�� �ּҹ��� �������� - � ��ư�� ������?
		Object obj = ae.getSource();//������ư�� �ּҹ��� ��������
		//System.out.println(jbt_clear+" , "+ae.getSource());
		//����� ��ư�� Ŭ������ �� ȣ��
		if(obj==bgView.jbt_clear){
			bgView.jta_display.setText("");
		}
		//�����ӹ�ư�� Ŭ���ߴ�?
		else if(obj == bgView.jbt_new){
			cnt = 0;
			bgLogic.nanSu();
			bgView.jta_display.setText("");
			bgView.jtf_input.setText("");
			bgView.jtf_input.requestFocus();
		}
		//�����ư�� Ŭ���ߴ�?
		//�̺�Ʈ�ҽ��� �ּҹ����� �����ư�� �ּҹ����� ����?
		else if(obj==bgView.jbt_dap){
			System.out.println("==========�����ư Ŭ�� �׽�Ʈ==========");
			bgView.jta_display.append("������ "+bgLogic.com[0]
					                    +bgLogic.com[1]
					                    +bgLogic.com[2]+"\n");
		}
		//����ڰ� ���� �Է��ϰ� ���� ���� �� ȣ��
		else if(obj==bgView.jtf_input){
			String user = bgView.jtf_input.getText();//����ڰ� �Է��� ���ڸ� ���� ����ȴ�.
			bgLogic.userInput(user);	
			bgView.jta_display.append(++cnt+"."+user+" : "+bgLogic.Ya9Run()+"\n");
			bgView.jtf_input.setText("");
		}
		//���� ��ư�� Ŭ������ �� ȣ��
		else if(obj==bgView.jbt_exit){
			System.exit(0);//�ڹٰ���ӽŰ� ������� �����.
		}
	}///////////////////// end of actionPerformed ///////////////////////
}

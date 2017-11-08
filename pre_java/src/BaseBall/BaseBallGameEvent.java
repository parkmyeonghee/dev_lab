package BaseBall;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BaseBallGameEvent   implements ActionListener{
	//�����
	 int cnt=0;
	 BaseBallGameView bgView =null;
	 BaseBallGameLogic bgLogic=null;
	 

	 public BaseBallGameEvent(BaseBallGameView bgView) {
		 this.bgView=bgView;
	 }
	public BaseBallGameEvent(BaseBallGameView bgView
										,BaseBallGameLogic bgLogic) {
		this.bgView=bgView;
		this.bgLogic=bgLogic;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();//����� ��ư�� �ּҹ��� ��������
		//object�� ��� Ŭ������ �ƹ���
		System.out.println(bgView.jbt_clear+","+e.getSource());
		//����� ��ư�� Ŭ������ �� ȣ��
		if(obj==bgView.jbt_clear || obj==bgView.jmi_clear){
			bgView.jta_display.setText("");
		}
		//�����ӹ�ư�� Ŭ���ߴ�?
		else if(obj==bgView.jbt_new||obj==bgView.jmi_new){
			cnt=0;
			bgLogic.nanSu();
			bgView.jta_display.setText("");
			bgView.jtf_input.setText("");
			bgView.jtf_input.requestFocus();
			
		}
		//�̺�Ʈ�ҽ��� �ּҹ����� �����ư�� �ּҹ����� ����?
		else if(obj==bgView.jbt_dap||obj==bgView.jmi_dap){
			System.out.println("======�����ư Ŭ��=======");
			bgView.jta_display.append("����:"+bgLogic.com[0]
									 +bgLogic.com[1]
									 +bgLogic.com[2]+"\n");			
		}//����ڰ� ���� �Է��ϰ� ���� ���� �� ȣ��
		else if(obj==bgView.jtf_input){
			String user=bgView.jtf_input.getText();//����ڰ� �Է��� ���ڸ� ���� ����
			bgLogic.userInput(user);
			bgView.jta_display.append(++cnt+"."+user+":"+bgLogic.Ya9Run()+"\n");
			bgView.jtf_input.setText("");
				}
		else if(obj==bgView.jbt_exit||obj==bgView.jmi_exit){
			System.exit(0);//�ڹٰ���ӽŰ� ������� ��������.
		}
	}
	}


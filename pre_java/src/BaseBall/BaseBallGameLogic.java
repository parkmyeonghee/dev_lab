package BaseBall;

import javax.swing.JOptionPane;

public class BaseBallGameLogic {
	 int com[]=new int[3];//���Ͱ� ä���� ���� ���
	 int my[]=new int[3];//����ڰ� �Է��� �� ���
	 BaseBallGameView bgView =null;//�������
	 public BaseBallGameLogic(BaseBallGameView bgView){
		//bgView(����) 
		 this.bgView=bgView;
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
	 
	 //����ڰ� �Է��� ���ڸ� �޾Ƽ� �迭�� ��� ����

void userInput(String input){
	int temp=0;
	if(input.length()!=3){
		JOptionPane.showMessageDialog(bgView.jf_game,"���ڸ� ���ڸ� �Է��ϼ���"
				,"INFO",JOptionPane.INFORMATION_MESSAGE);
		return;//userinput�޼ҵ� Ż��
	}
	temp=Integer.parseInt(input);
	my[0]=temp/100;
	my[1]=(temp%100)/10;
	my[2]=temp%10;
}

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

}

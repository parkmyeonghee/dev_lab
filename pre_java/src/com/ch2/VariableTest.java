package com.ch2;

public class VariableTest {

	public static void main(String[] args) {
		//���� �� �� �����ϱ�
		int a=1;
		int b=2;
		//�� ���� ���� ���� ���� �����ϱ�
		int result=0;
		//�� ���� �� ����� result������ ���
		result=a+b;//3
		System.out.println("��"+result);
		result=a-b;//-1
		System.out.println("��"+result);
		//ù��°���� �ι�° ������ ���� �� �Ŀ� ������� result������ ��ƺ���
		//result=0;�� �ּ����� ó���ϸ� result���� -1�� �ʱ�ȭ �Ǿ��־ ���� 14���ȴ�.
		//�ּ�ó���� ���ϸ� �ʱ�ȭ�� 0���� �Ǿ� �Ʒ� ������� ������ ��ġ�� �ʴ´�.
		result=0;//�ʱ�ȭ�� �����ָ� ���ǰ��� -1���� ������ �Ѵ�.
		for(int i=1;i<=5;i++){
			result=result+i;
			
		}
		System.out.println("1���� 5������ ����"+result);//15
	}

}

package com.ch2;
/*
 * @param ȫ�浿 �л��� ����
 * @param �̼��� �л��� ����
 * @return �� �л��� ������ ��ȯ�ϱ�
 */
public class ReturnType2 {

	static int hap(int jumsu1,int jumsu2){
		int tot=0;
		tot=jumsu1+jumsu2;
		return tot;
		
	}
	/*
	 * 
	 */
	static void avg(){//���ӻ��� �ʿ䰡 �������� ������ void�� ���� �����۾��̶�� �Ҹ�
		//int tot=jumsu1+jumsu2;
		int tot=hap(80,90);//���� ȣ���� �Ǿ���.
		System.out.println(tot);
		System.out.println(hap(80,90));
		//double avg1=tot/2.0;
		double avg1=hap(80,90)/2.0;//���ϰ��� �־ �����ϴ�.
		System.out.println("���:"+avg1);//���� �޼ҵ忡�� ���� �� ��� ����Ÿ���� �ʿ���
	}
	public static void main(String[] args) {
		avg();

	}

}

package com.ch8;

import com.ch7.Sonata;
/*
 * try..catch����� ���ܰ� �߻��� ���ɼ��� �ִ� �ڵ带 ���๮���� �ִ´�.
 * ���� ���ܻ�Ȳ�� �߻����� ������ ���� �Ͱ� ����.
 * try catch����� ����ϸ� ������ �߻��ϴ��� ������ ���� �Ǿ�� �� �ڵ尡 �հų�
 * �������� ����� ������ �� �ִ�.
 * ��Ƽ ����� ����� ��쿡�� ����Ŭ���� ���� ����Ŭ���� ���� �ۼ� �Ѵ�.
 */
public class ExceptionExam1 {
	public ExceptionExam1(){
		try {
			showNumberFormatException("�Ϳ����Ÿ��");	
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	void showNumberFormatException(String input){//"0","100","���ڿ�",null

			int in =0;
			 in = Integer.parseInt(input);
		System.out.println("����ڰ� �Է��� ��:"+in);
	}
	public static void main(String[] args) {
		
		new ExceptionExam1(); //ui�ַ�� �����Ҷ� ���̝���
		Sonata myCar=null; //���� ��ü�� �޸𸮿� Ȱ��ȭ����
		//null�� ���¿����� ���� �ּҹ����� �Ҵ� ���� �ʾҴ�.
		try {
			System.out.println(myCar.speed);
			myCar.come();
			//Ŭ���� �ϳ��� ��Ӱ��� �������ֶ�
	/*	} catch (NullPointerException ne) {
			System.out.println(ne.toString());*/
		}catch(Exception e){ //nullpoint���� �׳� exception�� �� ���� Ŭ�����̴�.
		System.out.println(e.toString());
	}
		System.out.println("����");

}
}

package com.ch7;
/*
 * sql�ڵ带 String�� ������ ��ȿ������ ����.
 */
public class StringTest {

	public static void main(String[] args) {
		String str ="hello";
		System.out.println(str.replace('l', 'L'));
		System.out.println(str);
		//charŸ���� l�� �빮��L�� �ٲپ� �ּ���
		str=str.replace('l', 'L');
		System.out.println(str);
		//���Կ����ڷ� �� �� �޾���� �ٲ��.
		String tmp ="java";//1
		System.out.println("1:"+tmp);
		tmp +=" hello";//3 tmp= tmp+" hello"
		System.out.println("2:"+tmp);
		tmp +=" world!!";//3
		System.out.println("3:"+tmp);
		System.out.println("==================================");
		StringBuilder sb = new StringBuilder("hello");//������ �ٲ�
		sb.append(" java");
		System.out.println(sb);
		}

}

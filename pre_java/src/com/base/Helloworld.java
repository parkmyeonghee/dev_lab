package com.base;
/*
������ �������� �� �� �ִ�.
-Ÿ�� ������=(���� ������:==)��;
�������� ���� ����� �� ����. ex) int class=10; , int int=100; ��� �Ұ���
�������� ���ڷ� ������ �� ����.
Ư�����ڴ� _��$�� ��밡���ϴ�.
������ ��� ���
-Ÿ���� ����� �ʿ�� ����.
-���� ���� ������� �ʴ´�.(�������� ����Ѵ�.)
������ ����ϴ� ����
-���� �� �� �ִ�.
-�ּҹ������� ����ϱ� ����.
-�ϰ�ó�� �� �� �ִ�.(�ϳ��� �����ϴ��� ��ü�� �� ���� �� �� �ִ�.)
-������ ���� ���:
1.�� ���� �ϳ��� ���� �� �ִ�.
2.���ÿ� �� ������ ������ �Ұ����ϴ�.
->�ذ� ���: �迭
3.���� Ÿ�Ը� ���� �� �ִ�. ex)int,double���ÿ� ���� �� ����.
*/

public class Helloworld {
	static int x=10;// ���� Ÿ���� ���� �� �ִ� ������ �Ҵ�.������ �޸� ����(�ּ� ����)
	static int y=20; /*class�ȿ� ���� ������ �� �� Ÿ���� ���´�. ���θ޼ҵ� �ȿ� static�� �ֱ⶧����
	����� class���̶� �ٿ��ش�.
	*/

	/*
	�����
	
	������
	
	����� ���� �߰� �޼ҵ� ����
	
	���� �޼ҵ� ���� �� ���� -exe���Ϸ� ���� �� �ִ�.= ������ �� �ִ�.
	 */
	void go(){
		System.out.println("go�޼ҵ� ȣ�� ����");
	}

	
	public static void main(String[] args) {
		System.out.println("Hello world!!!!");
		System.out.println(10);//��� ����� �޴´�.
		x=30;//�ι�° ���� �ִ°��� �ȴ�.
		/*int x=30;���ÿ� ���� �ָ� ���߿� �� ���� ���´�.
		int���� �ָ� ������ �ѹ� �� �Ѱ��̶� �ٸ� ���� �ǹ�����.�ٸ� �μ��� �Ǵ°Ͱ� �������� ����*/
		System.out.println(x); //10->30
		System.out.println(y);//println�� �ٹٲ�,print�� ���� ���� ����
		System.out.println(x+y);//30->50
		System.out.println(y/x);//����� �������� ���� �޶��� 
		System.out.println(x/y);
		System.out.println(x*y);
		
	
	}
	}


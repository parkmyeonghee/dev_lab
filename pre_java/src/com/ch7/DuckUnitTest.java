package com.ch7;

public class DuckUnitTest {

	public static void main(String[] args) {
		Duck duck=null;
		//Duck duck=new Duck();�ܵ����� �ν��Ͻ�ȭ �Ұ�.
		//myduck�� ����ü Ŭ������ MallardDuck�̴�.
		Duck myDuck = new MallardDuck();
		//herduck�� ����ü Ŭ������ woodduck�̴�.
		Duck herDuck= new WoodDuck();
		//himduck�� ����ü Ŭ������ rudderduck�̴�.
		Duck himDuck = new RubberDuck();
		MallardDuck malDuck = new MallardDuck();
		WoodDuck wooDuck= new WoodDuck();
		RubberDuck rubDuck = new RubberDuck();
		duck=myDuck;
		duck=malDuck;
		duck=wooDuck;
		duck=rubDuck;
		/*malDuck=wooDuck;
		malDuck=rudDuck;*/
		//������(����������)�̶�� �Ѵ�.
		//����ο� �������� Ŭ���� Ÿ���� �ٸ� �� �������� ���� �� �ִ�.
		myDuck.display();//û�տ���
		herDuck.display();//��������
		himDuck.display();//������
		//�����ʿ� �� ūŸ���� �� �� ����.
		//malDuck=(MallardDuck)wooDuck;
		herDuck=(MallardDuck)myDuck;
		herDuck.display();
		MallardDuck mDuck=null;
		mDuck=malDuck;
		/*
		 * ���
		 * ����Ÿ���� ��� ��������ȯ �� �� �ִ�.
		 * ����:�Ǽ��� ���� �� ����.
		 * ����Ÿ���� ��쿡�� ��������ȯ �� �� �ִ�.(���������� �չ�)
		 * ��Ÿ�Խÿ��� ClassCastException�� ������
		 * :����Ÿ���� ��� ������ �����ʿ��� �ڽ�Ŭ������ ���
		 */
		

	}

}

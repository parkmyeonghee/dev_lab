package com.ch4;
class Param{
	int ival;
}

public class Testparam {
	void effectParam(Param p){
		p=new Param();//��ü ���� ���纻�� �ϳ��� �� ����� ���̴�. �����̸��� ������ �ٸ� ����
		p.ival=500;
		//insert here->sub ival
		System.out.println("sub ival==>"+p.ival);
	}

	public static void main(String[] args) {
		 Testparam tp=new  Testparam();
		Param p = new Param();
		p.ival=100; //�����Լ� �̰� �ȿ����� ����� �� �ִ�.
		tp.effectParam(p);
		System.out.println("main ival==>"+p.ival);
		//insert here->sub ival

	}

}

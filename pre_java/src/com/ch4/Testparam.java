package com.ch4;
class Param{
	int ival;
}

public class Testparam {
	void effectParam(Param p){
		p=new Param();//객체 생성 복사본이 하나가 더 생기는 것이다. 변수이름이 같을뿐 다른 존재
		p.ival=500;
		//insert here->sub ival
		System.out.println("sub ival==>"+p.ival);
	}

	public static void main(String[] args) {
		 Testparam tp=new  Testparam();
		Param p = new Param();
		p.ival=100; //로컬함수 이곳 안에서만 사용할 수 있다.
		tp.effectParam(p);
		System.out.println("main ival==>"+p.ival);
		//insert here->sub ival

	}

}

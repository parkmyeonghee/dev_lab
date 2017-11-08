package com.design;

public class MallardDuck extends Duck {
	public MallardDuck(){ //생성자를 꼭 만들어서 초기화를 해주고 해라
		//무엇을 초기화 할 것인가? 또는 무엇을 결정할 것인가?
			flyBehavior = new FlyWithWings();
			quackBehavior = new Quack(); 
			//얘가 결정을 다 하는 아이라서 인터페이스와 어떻게 우는지 알려줘야함
			//그러나 Duck을 쓸 수 있기 때문에 선언을 해주면 안된다
			//해주면 복사본이 생겨서 실행이 되지 않음
			
		}
	@Override
	public void display() {
		System.out.println("나는 청둥오리ㅂ_ㅂ");
	}

}

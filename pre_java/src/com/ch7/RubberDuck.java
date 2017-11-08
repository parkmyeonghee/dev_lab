package com.ch7;

public class RubberDuck extends Duck{
public RubberDuck(){
		
	}
	public RubberDuck(int eye,int leg){
		this.eye=eye;
		this.leg=leg;
	}

	@Override
	public String toString(){//object클래스의 메소드 재정의
		return "나는 고무오리 입니다.";
	}
	@Override
	public void display() {
		System.out.println("나는 나무오리 입니다.");
	}

/*public void toString(){메소드 오버라이딩 불만족
	
}*/
	public static void main(String[] args) {
		RubberDuck myDuck = new RubberDuck();
		System.out.println(myDuck.toString());

	}

}

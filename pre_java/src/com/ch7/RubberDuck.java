package com.ch7;

public class RubberDuck extends Duck{
public RubberDuck(){
		
	}
	public RubberDuck(int eye,int leg){
		this.eye=eye;
		this.leg=leg;
	}

	@Override
	public String toString(){//objectŬ������ �޼ҵ� ������
		return "���� ������ �Դϴ�.";
	}
	@Override
	public void display() {
		System.out.println("���� �������� �Դϴ�.");
	}

/*public void toString(){�޼ҵ� �������̵� �Ҹ���
	
}*/
	public static void main(String[] args) {
		RubberDuck myDuck = new RubberDuck();
		System.out.println(myDuck.toString());

	}

}

package com.ch6;

public class Pride2017Test {
	Pride2017 methodA(){
		Pride2017 pride = new Pride2017();
		pride.door=5;
		return pride;
	}
void methodB(Pride2017 herCar){
	herCar.door=6;
}
	public static void main(String[] args) {
		Pride2017Test pt = new Pride2017Test();
		Pride2017 himCar=new Pride2017(2);
		System.out.println("himCar.door:"+himCar.door);//0 door��� ������ ���ؼ� ������ �ʱ�ȭ���� �׷��� ����Ʈ���� 0�̳���
		Pride2017 myCar=pt.methodA();//�����ϰ� �޼ҵ�� �޾Ƴ´�(��������)
		Pride2017 herCar=new Pride2017();
		pt.methodB(herCar);
		System.out.println(" "+herCar.door);//6
		System.out.println(" "+myCar.door);//5
		

	}

}

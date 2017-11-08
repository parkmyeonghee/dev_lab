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
		System.out.println("himCar.door:"+himCar.door);//0 door라는 변수에 대해서 별도의 초기화ㄴㄴ 그래서 디폴트값인 0이나옴
		Pride2017 myCar=pt.methodA();//선언만하고 메소드로 받아냈당(리턴해줌)
		Pride2017 herCar=new Pride2017();
		pt.methodB(herCar);
		System.out.println(" "+herCar.door);//6
		System.out.println(" "+myCar.door);//5
		

	}

}

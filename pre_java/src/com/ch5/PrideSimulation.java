package com.ch5;

public class PrideSimulation {
	void PrideInfo(Pride Pride){
		System.out.println(Pride.speed+","+Pride.carName+","+Pride.wheelNum);
	}
	void PrideInfoList(Pride cars[]){
		for(int i=0;i<cars.length;i++){
			Pride meCar=cars[i];
			System.out.println(meCar.speed+","+meCar.carName+","+meCar.wheelNum);
		}
	}

	public static void main(String[] args) {
		Pride myCar = new Pride();
		myCar.speed=100;
		myCar.carName="프라이드2015년형";
		myCar.wheelNum=4;
		Pride herCar = new Pride();
		herCar.speed=120;
		herCar.carName="프라이드2016년형";
		herCar.wheelNum=5;
		Pride himCar = new Pride();
		himCar.speed=140;
		himCar.carName="프라이드2017년형";
		himCar.wheelNum=6;
		PrideSimulation ps= new PrideSimulation();
		ps.PrideInfo(herCar);
		ps.PrideInfo(himCar);
		ps.PrideInfo(myCar);
		Pride cars[]=new Pride[3];
		cars[0]=herCar;
		cars[1]=myCar;
		cars[2]=himCar;
		ps.PrideInfoList(cars);

	}

}

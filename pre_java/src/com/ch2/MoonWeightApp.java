package com.ch2;

public class MoonWeightApp {
	
	//static moonWeight
	 double moonWeight(double earth){
			
			double w=0.0;
			w=earth*0.17;
			//w=(earth*17)/100;
			return w;
			
		}
		/*
		 * 1.static안에서 non-static을 호출할 때에는
		 * 반드시 객체 생성할 것.
		 * 2.똑같은 상황이면(non-static:non-static,static:static)상황이면
		 * 객체 생성없이 바로 호출 가능하다.
		 */
	
public static void main(String[] args) {
	
	//System.out.println(args[0]);//60
	//System.out.println(args[0]+10);//6010
	String su=args[0];
	//double d = new double(10.5)
	double earth = Double.parseDouble(args[0]);
	//System.out.println(earth+10);
	MoonWeightApp mw= new MoonWeightApp();
	double w= mw.moonWeight(earth);
	System.out.println("지구몸무게:"+su);
	System.out.println("달몸무게:"+w);
	
}

}
package com.ch5;

public class HPSimulation {
	void methodA(HP himHP){
		System.out.println("himHP:"+himHP);
		System.out.println("himHP.i:"+himHP.i);// 100
	}
	
	void methodB(HP meHP){
		System.out.println("meHP:"+meHP);
		System.out.println("meHP.i:"+meHP.i);// 100
	}
	
	
	void methodC(HP otherHP){
		System.out.println("otherHP.i:"+otherHP.i);//0
	}
	

	public static void main(String[] args) {
		HP hps[]=new HP[2];
		HP myHP= new HP();
		myHP.i=10;
		hps[0]=myHP;
		//HP herHP= null;
		HP herHP =new HP();
		hps[1]=herHP;
		herHP=myHP;//herHP=new HP();
		herHP.i=100;
		HPSimulation hs = new HPSimulation();
		hs.methodA(myHP);
		hs.methodB(herHP);
		hs.methodC(hps[1]);
		/*System.out.println(myHP);
		System.out.println(myHP.toString());//8번줄과 같은 의미이다.
		System.out.println(herHP);
		System.out.println(herHP.toString());
		System.out.println(myHP+","+herHP+",|"+hps[0]+","+hps[1]);*/
		}

}
//hps-주소번지

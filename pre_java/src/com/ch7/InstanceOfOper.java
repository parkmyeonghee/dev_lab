package com.ch7;

import java.util.Vector;

public class InstanceOfOper {
	Vector vec = new Vector();//늘었다 줄었다 한다.
	Vector<String> bread = new Vector<String>(10,10);//내 안에 String만 담을 수 있다.
	Object objs[]=new Object[3];
	public InstanceOfOper(){
		System.out.println("bread.size():"+bread.size());
		String name ="이순신";
		//methodA(name);
		//methodA(10);
		Sonata myCar=new Sonata();
		//methodA(myCar);
		objs[0]=name;
		objs[1]=10;
		objs[2]=myCar;
		methodB(objs);
		vec.add(name); //vector메모리 공간에 넣어주쟈
		vec.add(10);
		vec.add(myCar);
		vec.add(2,true);//끼워넣기가 가능하다.
		vec.remove(3);//해당 위치의 값을 삭제한다.
		System.out.println("size값을 확인하기"+vec.size());
		methodB(vec);
	}
	private void methodB(Object[] objs2) {
		System.out.println("====================================");
		for(int i=0;i<objs2.length;i++){
			if(objs[i] instanceof Sonata){
				Sonata herCar =(Sonata)objs2[i];
				System.out.println(herCar);
			}
			else if(objs2[i] instanceof String){
				String str=(String)objs2[i];
				System.out.println(str);
			}
			else if(objs2[i] instanceof Integer){
				Integer it=(Integer)objs2[i];
				System.out.println(it);
			}
		}
		System.out.println("======================================");
	}
	void methodB(Vector v){
		//Vector에는 여러개의 object를 담을 수 있다.
		//Vector에 들어있는 값 출력해 보기
		for(int i=0;i<v.size();i++){
			System.out.println(v.get(i));
		}
	}
/*	void methodA(String name){
		System.out.println("name:"+name);
	}*/
	void methodA(Object obj){
		//소나타 타입?
		if(obj instanceof Sonata){
			Sonata herCar =(Sonata)obj;
			System.out.println(herCar);
		}
		//String 타입?
		else if(obj instanceof String){
			String str=(String)obj;
			System.out.println(str);
		}
		//Integer타입?
		else if(obj instanceof Integer){
			Integer it =(Integer)obj;
			System.out.println(it);
		}
		System.out.println(obj);
	}
	public static void main(String[] args) {
		new InstanceOfOper(); //생성자호출
	}

}

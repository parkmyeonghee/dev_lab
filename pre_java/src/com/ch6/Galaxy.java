package com.ch6;
/*
 * 값을 호출하는 방법
 * 1)call by value(원시타입)-복사본
 * 2)pass by value(참조타입)-원본
 * 생성자를 호출하는 방법
 * new Galaxy();
 * new Galaxy(true,false,"골드");
 */
public class Galaxy {
	boolean power;//false
	boolean wifi;
	String color;//null
	//생성자도 non-static영역이므로 내안에 있는 변수 혹은
	//메소드를 객체생성없이 직접 호출할 수 있다.
	public Galaxy(){//디폴트 생성자에서 전역변수에 대한 초기화
		//생성자 호출
		System.out.println("생성자 호출 성공데스네");
		power=false;
		wifi=false;
		color="흰색";
		isOnOff();
	}
	public Galaxy(boolean power){
		power=true; //이 안에서만 사용할 수 있다. 그것이 문제
		//this.power=power;
		
	}
	public Galaxy(boolean power,boolean wifi){
		
	}
	public Galaxy(boolean power,boolean wifi,String color){
		
	}
public boolean isOnOff(){
	System.out.println("isOnOff 호출성공");
	if(power)power=false;
	else power=true;
	return power;
}
public boolean isWifi(){
	if(wifi) wifi =false;
	else wifi =true;
	return wifi;
}
public String toString(){
	String name="나는 갤럭시 입니당";
			return name;
}

}

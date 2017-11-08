package com.ch11;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
	//빵을 제공하는 메소드 -생크림빵,바게트,피자빵
	public String getBread(){
		String bread =null;
		switch((int)(Math.random()*5)){
		case 0: bread ="생크림빵";
			break;
		case 1 : bread="피자빵";
			break;
		case 2 : bread="바게트";
			break;
		case 3 : bread="식빵";
			break;
		case 4 : bread="초코케이크";
			break;
		}
		return bread;
	}
	//빵진열대를 구현해 보기 -ArrayList구현
	//List<빵>빵리스트 = new ArrayList<빵>();
	public List<String> push(){
		List<String> breadList = new ArrayList<String>();
		for(int i=0;i<20;i++){
			breadList.add(getBread());
		}
	return breadList; //리턴타입
	}
	public void push(List<String> breadList){
		for(int i=0;i<20;i++){
			breadList.add(getBread());
			//파라미터를 이용
		}
	}
}

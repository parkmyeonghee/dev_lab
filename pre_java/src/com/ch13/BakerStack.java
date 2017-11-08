package com.ch13;

import java.util.List;
import java.util.Vector;

public class BakerStack {
	List<String> breadList=
			new Vector<String>();
	//빵을 가져가는 메소드
	public synchronized String pop(String cbread){
		String bread = null;
		for(int i=0;i<breadList.size();i++){
			if(cbread.equals(breadList.get(i))){//도너츠 주세요? -네
				breadList.remove(cbread);
				break;
			}
			else{
			try {
				System.out.println("빵이 없습니다. 잠시만 기다려 주세요");
				wait();//데드락 상태를 방지하기 위해 사용한다.
			} catch (InterruptedException e) {
				System.out.println("빵 훔쳐가지마 이 괴도 루팡ㅇㅅㅇ!");
			}
		}
		}/////////////end of for
		return bread;
	}
	//빵을 진열하는 메소드
	public synchronized void push(String bread){
		System.out.println("빵 가져가세요");
		notify();
		//진열대에 빵 추가하기
		breadList.add(bread);
	}
}
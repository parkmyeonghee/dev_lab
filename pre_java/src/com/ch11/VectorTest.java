package com.ch11;

import java.util.List;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		List<String> fruit = new Vector<String>();
		fruit.add("딸기");//0->0->1
		fruit.add("수박");//1->1->2
		fruit.add("메론");//2->3
		fruit.add(2,"거봉"); //수박은 다음순서로 밀린당. 2->3
		fruit.add(0,"키위");//0
		fruit.remove("사과");
		for(;;){
			
		}
	}

}

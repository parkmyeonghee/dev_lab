package com.ch11;

import java.util.List;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		List<String> fruit = new Vector<String>();
		fruit.add("����");//0->0->1
		fruit.add("����");//1->1->2
		fruit.add("�޷�");//2->3
		fruit.add(2,"�ź�"); //������ ���������� �и���. 2->3
		fruit.add(0,"Ű��");//0
		fruit.remove("���");
		for(;;){
			
		}
	}

}

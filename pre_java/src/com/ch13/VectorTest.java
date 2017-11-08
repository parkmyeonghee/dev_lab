package com.ch13;

import java.util.List;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector<String>breadList = new Vector<String>(5);
		String cbread[]={"도너츠","생크림","식빵","도너츠","생크림"};
		breadList.copyInto(cbread); //선언부가 List이면 copyinto사용ㄴ
		for(int i=0;i<cbread.length;i++){
			breadList.add(i,cbread[i]);
		}
		for(String bread:breadList){
			System.out.println(bread);
		}
		for(int i =0;i<breadList.size();i++){
			if("도너츠".equals(breadList.get(i))){
				breadList.remove("도너츠");
				break;// 한 개만 삭제가 된다. 없으면 두개 삭제
			}
		}
		System.out.println("==============================");
		for(String bread:breadList){
			System.out.println(bread);
		}
	}

}

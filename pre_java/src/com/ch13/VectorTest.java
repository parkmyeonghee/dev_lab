package com.ch13;

import java.util.List;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		Vector<String>breadList = new Vector<String>(5);
		String cbread[]={"������","��ũ��","�Ļ�","������","��ũ��"};
		breadList.copyInto(cbread); //����ΰ� List�̸� copyinto��뤤
		for(int i=0;i<cbread.length;i++){
			breadList.add(i,cbread[i]);
		}
		for(String bread:breadList){
			System.out.println(bread);
		}
		for(int i =0;i<breadList.size();i++){
			if("������".equals(breadList.get(i))){
				breadList.remove("������");
				break;// �� ���� ������ �ȴ�. ������ �ΰ� ����
			}
		}
		System.out.println("==============================");
		for(String bread:breadList){
			System.out.println(bread);
		}
	}

}

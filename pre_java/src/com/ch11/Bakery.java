package com.ch11;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
	//���� �����ϴ� �޼ҵ� -��ũ����,�ٰ�Ʈ,���ڻ�
	public String getBread(){
		String bread =null;
		switch((int)(Math.random()*5)){
		case 0: bread ="��ũ����";
			break;
		case 1 : bread="���ڻ�";
			break;
		case 2 : bread="�ٰ�Ʈ";
			break;
		case 3 : bread="�Ļ�";
			break;
		case 4 : bread="��������ũ";
			break;
		}
		return bread;
	}
	//�������븦 ������ ���� -ArrayList����
	//List<��>������Ʈ = new ArrayList<��>();
	public List<String> push(){
		List<String> breadList = new ArrayList<String>();
		for(int i=0;i<20;i++){
			breadList.add(getBread());
		}
	return breadList; //����Ÿ��
	}
	public void push(List<String> breadList){
		for(int i=0;i<20;i++){
			breadList.add(getBread());
			//�Ķ���͸� �̿�
		}
	}
}

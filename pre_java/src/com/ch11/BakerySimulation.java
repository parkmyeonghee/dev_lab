package com.ch11;

import java.util.ArrayList;
import java.util.List;

public class BakerySimulation {
	public BakerySimulation()
	{
		// breadListPrint1();
		 breadListPrint2();
	}
	public void breadListPrint1()
	{
		Bakery bk = new Bakery();
		List<String> breadList=bk.push();
		for(int i=0;i<breadList.size();i++){
			String bread = breadList.get(i);
			//System.out.println(bread);
			System.out.println(breadList.get(i));
			//System.out.println(breadList.get(i).toString());
		}
		System.out.println("==============================");
		for(String bread:breadList){ //개선된 for문
			System.out.println(bread);
		}
	}
	public void breadListPrint2()
	{
		Bakery bk = new Bakery();
		List<String> breadList=new ArrayList<String>();
		bk.push(breadList);
		for(int i=0;i<breadList.size();i++){
			System.out.println(breadList.get(i));
}
	}
	public static void main(String[] args) {
		new BakerySimulation();
	}

}

package com.ch5;

public class EnglishT {

	public static void main(String[] args) {
		int eng[]={85,90,40,70,65,75,95};
		MaxSearch ms=new MaxSearch();
		int max=ms.max(eng);
		int min=ms.min(eng);
		System.out.println("최대값:"+max+",최소값:"+min);
		
	}

}

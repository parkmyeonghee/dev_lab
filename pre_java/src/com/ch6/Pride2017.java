package com.ch6;

public class Pride2017 {
	int door =0;
	public Pride2017(){
		new Sonata2017();
		//this.door= new Sonata2017().door;
		this.door=Sonata2017.door;//소나타의 도어수 재사용
	}
public Pride2017(int door){
	
}
	public static void main(String[] args) {
		Pride2017 pri = new Pride2017();
		System.out.println("도어 수:"+pri.door);//4
	}

}

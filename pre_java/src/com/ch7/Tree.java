package com.ch7;

public class Tree {
	String name =null;
	public Tree(){
		this("소나무");
		System.out.println("Tree디폴트 생성자 호출");
	}
public Tree(String name){
	this.name=name;
	System.out.println("Tree(Stirng)생성자 호출");
}
	public static void main(String[] args) {
		new Tree();
	}

}

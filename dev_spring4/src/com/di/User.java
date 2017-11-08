package com.di;

public class User {
	private String name=null;
	private int age=0;
	private String country=null;
	public User(String name,int age,String country){
		this.name=name;
		this.age=age;
		this.country=country;
	}
	public String toString(){
		return name+"is"
					+age+"years old,living in"
					+country;			
	}
}

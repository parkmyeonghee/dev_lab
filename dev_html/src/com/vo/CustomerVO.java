package com.vo;

public class CustomerVO {
	
	private String name =null;
	private String tel =null;
	private String address=null;
	public CustomerVO(){}
	public CustomerVO(String name
								,String tel
								,String address){
		this.name=name;
		this.tel=tel;
		this.address=address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}

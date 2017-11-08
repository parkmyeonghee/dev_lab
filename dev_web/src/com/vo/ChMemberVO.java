package com.vo;

public class ChMemberVO {
	private String id = null; // null 일경우는 nullpoint일어날 수 있다 빈문자열은 안일어남
	private String pw =null;
	private String name=null;
	private String email=null;
	public ChMemberVO(){ //디폴트 생성자 null,null,null,null
	
	}
	public ChMemberVO(String id,String pw,
			String name, String email){
		this.id=id;
		this.pw=pw;
		this.name=name;
		this.email=email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}

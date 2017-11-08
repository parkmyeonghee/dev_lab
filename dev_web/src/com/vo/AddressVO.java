package com.vo;

public class AddressVO {
	//사용자의 선택에 대한 정보를 담을 = " ;
	private int      id  = 0;
	private String name  = "" ;
	private String address = "";
	private String hp    = "";
	private String gender = "" ;
	private String relationship= "";
	private String birthday = "";
	private String comments = "";
	private String registerdate = "";
	private String command =null;    
	//입력,수정,삭제시 오라클 서버의 리턴값.
	private int result = 0; //0 이면 입력 실패
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getGender () {
		return gender ;
	}
	public void setGender(String gender ) {
		this.gender  = gender ;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(String registerdate) {
		this.registerdate = registerdate;
	}
}

package com.vo;

public class AddressVO {
	//������� ���ÿ� ���� ������ ���� = " ;
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
	//�Է�,����,������ ����Ŭ ������ ���ϰ�.
	private int result = 0; //0 �̸� �Է� ����
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

package com.vo;
//DB������ ���̺� ������ ���εǴ� Ŭ����
//VO(Value Object)
//�ڹٿ� ����Ŭ���� ���̿��� �����ϴµ� ����ϴ� Ŭ����
//DTO(Data Transfer Object)����
public class MemberVO {
	private int     no            =0;
	private String mem_id     ="";
	private String mem_pw    ="";
	private String mem_name ="";
	private String mem_tel     ="";
	private String gender       ="";
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}   
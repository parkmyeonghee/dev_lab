package com.vo;

public class BoardMasterVO {
	  private int b_no    =0;    
	  private String b_title ="";    
	  private String b_name  ="";   
	  private String b_content="";       
	  private int b_hit   =0;   
	  private String b_date  ="";
	  private String b_pw    ="";  
	  private int b_group =0; 
	  private int b_pos   =0;                      
	  private int b_step  =0;
	  private String b_email="";//원칙은null,"":NullPointException,NimberFormatException
	  private int page=0; //현재 내가 바라보는 페이지 번호
	  private int pageSize=0; //한 페이지에 출력할 로우의 수
	  private int start=0; //해당 페이지의 시작번호
	  private int end=0; //해당 페이지의 끝 번호
	public int getB_no() {
		return b_no;
	}
	public void setB_no(int b_no) {
		this.b_no = b_no;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public int getB_hit() {
		return b_hit;
	}
	public void setB_hit(int b_hit) {
		this.b_hit = b_hit;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public String getB_pw() {
		return b_pw;
	}
	public void setB_pw(String b_pw) {
		this.b_pw = b_pw;
	}
	public int getB_group() {
		return b_group;
	}
	public void setB_group(int b_group) {
		this.b_group = b_group;
	}
	public int getB_pos() {
		return b_pos;
	}
	public void setB_pos(int b_pos) {
		this.b_pos = b_pos;
	}
	public int getB_step() {
		return b_step;
	}
	public void setB_step(int b_step) {
		this.b_step = b_step;
	}
	public String getB_email() {
		return b_email;
	}
	public void setB_email(String b_email) {
		this.b_email = b_email;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}                       

}

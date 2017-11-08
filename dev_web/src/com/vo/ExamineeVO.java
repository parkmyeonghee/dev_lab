package com.vo;

public class ExamineeVO {     
	  private String test_no   =""; 
	  private String t_name    ="";  
	  private String t_hp      ="";  
	  private String t_address ="";  
	  private String decision  ="";  
	  private int score     =0;  
	  private String take_yn   ="";
	  private TakeVO tVO =null;
	public String getTest_no() {
		return test_no;
	}
	public void setTest_no(String test_no) {
		this.test_no = test_no;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public String getT_hp() {
		return t_hp;
	}
	public void setT_hp(String t_hp) {
		this.t_hp = t_hp;
	}
	public String getT_address() {
		return t_address;
	}
	public void setT_address(String t_address) {
		this.t_address = t_address;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getTake_yn() {
		return take_yn;
	}
	public void setTake_yn(String take_yn) {
		this.take_yn = take_yn;
	}
	public TakeVO gettVO() {
		return tVO;
	}
	public void settVO(TakeVO tVO) {
		this.tVO = tVO;
	} 
                               
}

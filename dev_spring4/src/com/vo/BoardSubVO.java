package com.vo;

public class BoardSubVO {
	 	private int b_no   =0;
	    private int b_seq  =0;
	    private String b_file ="";
	    private String org_file="";
	    private double b_size =0.0;
		public int getB_no() {
			return b_no;
		}
		public void setB_no(int b_no) {
			this.b_no = b_no;
		}
		public int getB_seq() {
			return b_seq;
		}
		public void setB_seq(int b_seq) {
			this.b_seq = b_seq;
		}
		public String getB_file() {
			return b_file;
		}
		public void setB_file(String b_file) {
			this.b_file = b_file;
		}
		public double getB_size() {
			return b_size;
		}
		public void setB_size(double b_size) {
			this.b_size = b_size;
		}
		public String getOrg_file() {
			return org_file;
		}
		public void setOrg_file(String org_file) {
			this.org_file = org_file;
		}
}

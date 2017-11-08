package com.sungjuk;
import java.util.*;

public class Sungjuk_Logic {
	public int hap(int java, int html, int orcle){
		return java+html+orcle;
	}
	public double avg (int hap){
		return hap/3.0;
	}
/*	public int rank(int hap){
		int rank=1;
		if(hap
		rank++;
	}
	*/
	public char hak (double avg){
		char hak;
		switch ((int)avg/10) {
		case 9: hak='A';
		break;
		case 8 :hak='B';
		break;
		case 7 :hak='C';
		break;
		case 6 :hak='D';
		break;
		default:
			hak='F';
		}
		return hak;
	}	
	public static void main(String[] args) {
	
	
	}
	
}

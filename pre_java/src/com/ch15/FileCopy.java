package com.ch15;

import java.io.FileInputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {
		String path ="src\\com\\vo\\";
		try {
			FileInputStream fis = 
					new FileInputStream(path+"DeptVo.java");
			int data=0;
			data=fis.read();
			while((data=fis.read()) !=-1){
			char ch = (char)data;
			System.out.print(ch);
			}
		} catch (IOException ie) {
		}
	}

}

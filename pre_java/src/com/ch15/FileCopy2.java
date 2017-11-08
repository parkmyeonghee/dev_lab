package com.ch15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy2 {

	public static void main(String[] args) {
		String path ="src\\com\\vo\\";
		FileInputStream fis = null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream(path+"DeptVo.java");
			fos=new FileOutputStream(path+"DeptVo2.java");
			int data=0;
			//data=fis.read();
			while((data=fis.read()) !=-1){
			//char ch = (char)data;
			//System.out.print(ch);
				fos.write(data);
			}
		} catch (IOException ie) {
		}finally{
			try {
			if(fos!=null) fos.close();	
			if(fis!=null) fos.close();	
			} catch (Exception e) {
			}
		}
	}


}

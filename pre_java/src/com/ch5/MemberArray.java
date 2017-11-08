package com.ch5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.vo.MemberVo;

public class MemberArray {
		MemberVo mvos[]=  new MemberVo[3];
		Object objs[][] = new Object[5][3];
	public void memberVoInit(){
		MemberVo mvo  = new MemberVo();
		mvo.setNo(1);
		mvo.setMem_id("aaa");
		mvo.setMem_pw("111");
		mvo.setMem_name("È«±æµ¿");
		mvo.setMem_tel("000-000-0000");
		mvos[0]=mvo;
		mvo = new MemberVo();
		mvo.setNo(2);
		mvo.setMem_id("bbb");
		mvo.setMem_pw("222");
		mvo.setMem_name("±èÀ¯½Å");
		mvo.setMem_tel("111-111-1111");
		mvos[1]=mvo;
		mvo = new MemberVo();
		mvo.setNo(3);
		mvo.setMem_id("ccc");
		mvo.setMem_pw("333");
		mvo.setMem_name("°­°¨Âù");
		mvo.setMem_tel("222-222-2222");
		mvos[2]=mvo;
	}
	public void objectArray(){
		objs[0]=new Integer[]{1,2,3};
		objs[1]=new String[]{"aaa","bbb","ccc"};
		objs[2]=new String[]{"111","222","333"};
		objs[3]=new String[]{"È«±æµ¿","±èÀ¯½Å","°­°¨Âù"};
		objs[4]=new String[]{"000-000-0000","111-111-1111","222-222-2222"};
	}
	public static void main(String[] args) {
		MemberArray ma = new MemberArray();
		ma.memberVoInit();
		for(MemberVo mvo:ma.mvos){
			System.out.println(mvo.getNo()+","+
									mvo.getMem_id()+","+
									mvo.getMem_pw()+","+
									mvo.getMem_name()+","+
									mvo.getMem_tel());
		}
		System.out.println("======================================");
		ma.objectArray();
		for(int i=0;i<ma.objs[0].length;i++){
			for(int j=0;j<ma.objs.length;j++){
				System.out.println(ma.objs[j][i]+",");
			}
			System.out.println();
		}
	}////////////////////////end of main
}////////////////////////////////////end of memberarray

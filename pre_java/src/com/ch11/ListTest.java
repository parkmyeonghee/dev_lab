package com.ch11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import com.ch7.Sonata;

public class ListTest {
	
	public ArrayList getArrayList(){
		ArrayList myMember= new ArrayList();
		return myMember;
	}
	public List getArrayList2(){
		ArrayList myMember= new ArrayList();
	/*	myMember = new Vector();
		myMember = new LinkedList();
		myMember = new Stack();*/
		myMember.add("이순신");
		myMember.add("10");
		myMember.add(new Sonata());
		return myMember;
	}
	public List getArrayList3(){
		List<Object> myMember = new ArrayList<Object>();
	/*	myMember = new Vector();
		myMember = new LinkedList();
		myMember = new Stack();*/
		myMember.add("이순신");
		myMember.add("10");
		myMember.add(new Sonata());//주소번지출력
		for(Iterator<Object> iter=myMember.iterator();iter.hasNext();){
			Object obj = iter.next();
			System.out.println(obj);
		}
		return myMember;
	}
	public void getArrayList2Print(List myMember){//파라미터로
		for(int i=0;i<myMember.size();i++){
			if(myMember.get(i) instanceof String)
			{
			String str=(String)myMember.get(i);
			System.out.println(str);
		}
		else if(myMember.get(i) instanceof Integer){
			int in =(Integer)myMember.get(i);
			System.out.println(in);
		}
		else if(myMember.get(i) instanceof Integer){
			Sonata myCar=(Sonata)myMember.get(i);
			System.out.println(myCar);
			System.out.println(myCar.speed);
		}
	}
}
	public static void main(String[] args) {
		ListTest li = new ListTest();
		List myMember =li.getArrayList2();
	//	li.getArrayList2Print(myMember);
		li.getArrayList3();
	}

}

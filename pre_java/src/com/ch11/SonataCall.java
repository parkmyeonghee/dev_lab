package com.ch11;

import java.util.List;
import java.util.Vector;

import javax.swing.JButton;

import com.ch7.Sonata;

public class SonataCall {
	
	public static void main(String[] args) {
		List<Sonata> carList = new Vector<Sonata>();
		carList.add(new Sonata());
		carList.add(new Sonata());
		carList.add(new Sonata());
		for(int i=0;i<carList.size();i++){
			System.out.println(carList.get(i));
		}
		JButton jbtn= new JButton("����");
		System.out.println(jbtn); //��ư�� ���� �� ������ �� ���´�.
		
	}

}

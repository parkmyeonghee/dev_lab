package com.ch2;

public class JFrameTest {

	public static void main(String[] args) {

		javax.swing.JFrame jf =
				new javax.swing.JFrame();
		int Width=300;
		int Height=200;
		String title ="전자계산기";
		jf.setTitle(title);
		jf.setSize(Width,Height);
		jf.setVisible(true);
		
	}

}

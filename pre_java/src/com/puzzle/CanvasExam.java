package com.puzzle;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

class MyCanvas extends Canvas{
	public void paint(Graphics g){
		System.out.println("paint ȣ��");
		g.setColor(Color.pink);
		g.drawRect(20, 20, 100, 100);//�׸���ġ,ũ��
		
	}
}

public class CanvasExam {

	public static void main(String[] args) {
		//JFrame�� ����Ʈ ���̾ƿ���
		//BorderLayout�̴�.
		JFrame jf = new JFrame();
		MyCanvas mc = new MyCanvas();
		jf.setLocation((int)200.5, 200);
		jf.setResizable(false);
		jf.add("Center",mc);
		jf.setSize(200, 200);
		jf.setVisible(true);
	}

}

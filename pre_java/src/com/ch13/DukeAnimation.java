package com.ch13;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class DukeAnimation extends Frame implements Runnable {
	//�����
	int frame = 0;//Image�迭�� ���� �ε����� ���� ����
	int delay = 0;//�ð� ������ ���� ����
	Thread animator = null;//start()ȣ��
	Image frameImg[] = null;//�̹����� ���� ��ü - 10��
	Dimension offDimension;
	Image offImage;
	Graphics offGraphics;
	//������  - ��������� �ʱ�ȭ
	public DukeAnimation(){
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent evt){
				dispose();
				System.exit(0);
			}
		});
		//initDisplay();�����ڿ��� �޼ҵ带 ȣ���ϴ� ���� �ð����� ���� �� �ִ�.
		delay = 100;//0.1��
		frameImg = new Image[10];
		for(int i=1;i<=10;i++){
			frameImg[i-1] = 
					Toolkit.getDefaultToolkit().
										getImage("src/com/images/FRAME"+i+".gif"); 
		}
		showAni();
	}
	//insert here - ���ϸ��̼� ��� ����
	public void showAni(){
		animator = new Thread(this);
		animator.start();//run()ȣ��
	}
	public void update(Graphics g){
		Dimension d = getSize();
		if(offGraphics == null 
	   || (d.width != offDimension.width)
	   || (d.height != offDimension.height)
	   ){
			offDimension = d;
			offImage = createImage(d.width,d.height);
			offGraphics = offImage.getGraphics();
		}
		offGraphics.setColor(getBackground());
		offGraphics.fillRect(0,0,d.width,d.height);
		offGraphics.setColor(Color.BLACK);
		paintFrame(offGraphics);
		paint(g);
		
	}
	//�̹����� ȭ�鿡 �׸��� ����
	public void paint(Graphics g){//repaint()ȣ���ϸ� paint()�� ȣ��˴ϴ�.
		if(offImage !=null){
			g.drawImage(offImage, 0, 50, null);
		}
	}
	public void paintFrame(Graphics g){//repaint()ȣ���ϸ� paint()�� ȣ��˴ϴ�.
		g.drawImage(frameImg[frame%10], 0, 0, null);
	}	
	//ȭ��ó����
	public void initDisplay(){
		setBackground(Color.red);
		this.setSize(100, 200);
		this.setVisible(true);
		showAni();
	}
	//run�޼ҵ�- ������ ��ٸ���, ���������� ���񽺸� �����ϰų� �ް�
	//�;��, ������ �纸�Ҳ���, (����)
	@Override
	public void run() {
		//long tm = System.currentTimeMillis();
		while(true){
			repaint();//paint()ȣ��
			try {
				//tm+=delay;
				Thread.sleep(100);//0.1�ʵ��� ���
			} catch (InterruptedException e) {
				break;
			}
			frame++;
		}
	}
	//���θ޼ҵ�
	public static void main(String[] args) {
		DukeAnimation da = new DukeAnimation();
		da.initDisplay();
	}

}

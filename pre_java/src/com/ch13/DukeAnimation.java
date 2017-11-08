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
	//선언부
	int frame = 0;//Image배열에 대한 인덱스를 담을 변수
	int delay = 0;//시간 지연값 담을 변수
	Thread animator = null;//start()호출
	Image frameImg[] = null;//이미지를 담을 객체 - 10장
	Dimension offDimension;
	Image offImage;
	Graphics offGraphics;
	//생성자  - 멤버변수의 초기화
	public DukeAnimation(){
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent evt){
				dispose();
				System.exit(0);
			}
		});
		//initDisplay();생성자에서 메소드를 호출하는 것은 시간차가 있을 수 있다.
		delay = 100;//0.1초
		frameImg = new Image[10];
		for(int i=1;i<=10;i++){
			frameImg[i-1] = 
					Toolkit.getDefaultToolkit().
										getImage("src/com/images/FRAME"+i+".gif"); 
		}
		showAni();
	}
	//insert here - 에니메이션 재생 시작
	public void showAni(){
		animator = new Thread(this);
		animator.start();//run()호출
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
	//이미지를 화면에 그리기 구현
	public void paint(Graphics g){//repaint()호출하면 paint()가 호출됩니다.
		if(offImage !=null){
			g.drawImage(offImage, 0, 50, null);
		}
	}
	public void paintFrame(Graphics g){//repaint()호출하면 paint()가 호출됩니다.
		g.drawImage(frameImg[frame%10], 0, 0, null);
	}	
	//화면처리부
	public void initDisplay(){
		setBackground(Color.red);
		this.setSize(100, 200);
		this.setVisible(true);
		showAni();
	}
	//run메소드- 순서를 기다린다, 지속적으로 서비스를 제공하거나 받고
	//싶어요, 순서를 양보할께요, (상태)
	@Override
	public void run() {
		//long tm = System.currentTimeMillis();
		while(true){
			repaint();//paint()호출
			try {
				//tm+=delay;
				Thread.sleep(100);//0.1초동안 얼려
			} catch (InterruptedException e) {
				break;
			}
			frame++;
		}
	}
	//메인메소드
	public static void main(String[] args) {
		DukeAnimation da = new DukeAnimation();
		da.initDisplay();
	}

}

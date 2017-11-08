package com.puzzle;  
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Puzzle extends Frame implements ActionListener{
	JPanel 	pGame,pButton;
	JButton bStart, bStop, bHint, bExit;
	Dimension windowsize;
	ImgCanvas CVS;
	Dialog dHit;   
	
	public Puzzle(){ 
		
		CVS = new ImgCanvas(this);	//Canvas
		CVS.addMouseListener(new MouseEventHandler());
//		pGame=new JPanel(new FlowLayout());
		pGame=new JPanel();
		CVS.setSize(390,390);
		pGame.add(CVS);
		
		pGame.setBorder(new EtchedBorder());
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent evt){
				dispose();
				System.exit(0);
			}
		});
		
		bStart = new JButton("시작");
		bStop = new JButton("정지");
		bHint = new JButton("힌트");
		bExit = new JButton("나가기");
		pButton=new JPanel(new GridLayout(1,4));
		pButton.add(bStart);
		pButton.add(bStop);
		pButton.add(bHint);
		pButton.add(bExit);
		
		bStart.addActionListener(this);
		bStop.addActionListener(this);
		bHint.addActionListener(this);
		bExit.addActionListener(this);
		
		this.setTitle("즐거운 퍼즐게임");
		setSize(400,460);
		setResizable(false);
		add("North",pGame);
		add("South",pButton);
		setVisible(true);
	}
		
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == bStart)
			CVS.start();	//랜덤이미지
		else if(e.getSource() == bStop)
			CVS.repaint();	//중지
		else if(e.getSource() == bHint)
			CVS.hint();	//힌트
		else if(e.getSource() == bExit){
			dispose();		//나가기
			System.exit(0);
		}			
	}
	public static void main(String args[]){
		Puzzle pz = new Puzzle();
		//pz.setVisible(true);
	}
	class MouseEventHandler extends MouseAdapter{
		//마우스이벤트
		public void mouseClicked(MouseEvent evt){
			CVS.mouseClick(evt.getPoint());
		}
		/*			
		public void mouseEntered(MouseEvent evt){}
		public void mouseExited(MouseEvent evt){}
		public void mousePressed(MouseEvent evt){}
		public void mouseReleased(MouseEvent evt){}
		*/
	}
	
	public void showDlg()
	{
		DlgDap dd = new DlgDap(this);
		dd.setResizable(false);
		Point f = getLocation();
		f.translate(100, 200);
		dd.setLocation(f);
		dd.show();
	}
}
	
class ImgCanvas extends Canvas{
	Puzzle p;
	private Image img[];
	int imgSort[];
	String imgName = "";
	String imgPath = "src/com/puzzle/";
	int blankX, blankY;
	static int imgWidth=0, imgHeight=0, imgCnt=3;
	static int imgX=0, imgY=0;
	boolean isGame=false;
	Random r;
	
	public ImgCanvas(Puzzle pz){
		p = pz;
		img = new Image[imgCnt*imgCnt];	//이미지 객체 배열 생성
		imgSort=new int[imgCnt*imgCnt];	//이미지 객체의 인덱스 값을 갖는 배열 생성
		r=new Random();
		//MediaTracker이미지에만 적용되는 쓰레드역할 단독 사용해야 함.
		/*
		 * 이미지가 올려지는 동안 부분적으로 보여지는 것을 볼 수 있다.
		 * 이런 현상을 방지하기 위해 사용한다.
		 * MediaTracker는 그림이 완전히 올려지면 그 이미지를 보여준다.
		 */
		MediaTracker tracker = new MediaTracker(this);
		imgSorting(false);
		
		for (int i=0;i<img.length;i++){
			//이미지 배열로 생성
			imgName = i + ".jpg";
			//자바에서 이미지를 로딩하기 위해서는 Toolkit클래스의 메서드로 이미지 객체를 생성한 다음 MediaTracker를 통해서 로딩한다.
			img[i] = Toolkit.getDefaultToolkit().getImage(imgPath+imgName);
			//---이 줄 빠지면 무한루프 돈다.
			tracker.addImage(img[i],i);
			try{
				tracker.waitForID(i);
			}catch(Exception e){}
			//---여기까지
		}
	}
	
	public void imgSorting(boolean k){
		int i,j, iRandom1,iRandom2;
		int iTmp;	
		//imgCnt = 3;
		for (i=0;i<imgCnt*imgCnt;i++)
			imgSort[i]=i;		//imgSort인덱스 초기화... imgSort[0]=0; imgSort[1]=1...
			
		if (k==true){
			//쉐이크함
			for (i=0;i<1000;i++){
				iRandom1=r.nextInt(imgCnt*imgCnt);
				do{
					iRandom2=r.nextInt(imgCnt*imgCnt);	
				}while(iRandom1==iRandom2);
				iTmp=imgSort[iRandom1];
				imgSort[iRandom1]=imgSort[iRandom2];
				imgSort[iRandom2]=iTmp;
			}
		}
		
		for (i=0;i<imgCnt*imgCnt;i++){
			if (imgSort[i]==8){
				//8.gif 즉 블랭크의 좌표값
				blankX=(i%imgCnt)*imgWidth;//1%3=1*100=100;
				blankY=i/imgCnt*imgHeight; //1%3=1*80=80
				break;
			}	
		}	
	}
	
	public void paint(Graphics g){
		System.out.println("paint 호출 성공");
		imgWidth = img[0].getWidth(this);	//이미지 가로세로 크기
		imgHeight = img[0].getHeight(this);
		System.out.println(imgWidth+", "+imgHeight);
		int k=0;	//0-8
		
		for (int i=0;i<imgCnt;i++){
			for (int j=0;j<imgCnt;j++){
				//img[0~8] 객체 불러옴
				//img변수 이미지 객체, imgSort[k]
				//1)이미지객체,시작점x좌표,시작점y좌표,이미지폭,이미지높이,이미지옵져버 
				//시스템 내부에는 이미지를 로딩하는 스레드가 있습니다.
				//ImageObserver 인터페이스를 구현한 클래스가 JComponent이고 이것은 JPanel의 부모 클래스 입니다.
				//Canvas의 부모클래스가 JComponent이므로 여기서는 this를 넣어준다.
				g.drawImage(img[imgSort[k]],j*imgWidth, i*imgHeight, imgWidth,imgHeight, this);//imgSort[k]의 값에 해당되는 이미지를 불러옴
				k=k+1;
			}
		}
		if (isGame==true && isDap()==true){
			//정답표시
//			System.out.println("정답");
			p.showDlg();
		}
	}////////////////end of paint
	
	public boolean isDap(){
		for (int i=0;i<imgCnt*imgCnt;i++)
			if (imgSort[i]!=i){
				return false;
			}
		
		return true;
	}
	
	public void mouseClick(Point p){
		if(isGame==true){
			//게임 실행중에 이미지 클릭
			int iClickIndex=0;
			int iBlankIndex=0;
			int iTmp=0;
			
			imgX=(int)(p.getX()/imgWidth)*imgWidth;		//포인터의 x좌표
			imgY=(int)(p.getY()/imgHeight)*imgHeight;	//포인터의 y좌표
			
			if (Math.abs(blankX-imgX) + Math.abs(blankY-imgY)==imgWidth){	//블랭크 바로옆에껄 클릭
				iClickIndex=(imgY/imgHeight)*imgCnt + imgX/imgWidth;		//클릭한 좌표 이미지의 인덱스를 구한다.
				iBlankIndex=(blankY/imgHeight)*imgCnt + blankX/imgWidth;	//블랭크 좌표 인덱스 값
				//array 바꿈
				iTmp=imgSort[iClickIndex];	//imgArr[iClickedIndex]의 value 와 imgArr[iBlankIndex]의 value를 스왑
				imgSort[iClickIndex]=imgSort[iBlankIndex];
				imgSort[iBlankIndex]=iTmp;
				//블랭크의 좌표값 저장
				blankX=imgX;	//blankX좌표 대입
				blankY=imgY;	//blankY좌표 대입
				repaint();
			}
		}
	}
	
	public void start(){		
		imgSorting(true);//이미지 섞기.
		isGame=true;
		repaint();
	}
	
	public void hint(){
		isGame=false;
		imgSorting(false);
		repaint();
	}
}  
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
		
		bStart = new JButton("����");
		bStop = new JButton("����");
		bHint = new JButton("��Ʈ");
		bExit = new JButton("������");
		pButton=new JPanel(new GridLayout(1,4));
		pButton.add(bStart);
		pButton.add(bStop);
		pButton.add(bHint);
		pButton.add(bExit);
		
		bStart.addActionListener(this);
		bStop.addActionListener(this);
		bHint.addActionListener(this);
		bExit.addActionListener(this);
		
		this.setTitle("��ſ� �������");
		setSize(400,460);
		setResizable(false);
		add("North",pGame);
		add("South",pButton);
		setVisible(true);
	}
		
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == bStart)
			CVS.start();	//�����̹���
		else if(e.getSource() == bStop)
			CVS.repaint();	//����
		else if(e.getSource() == bHint)
			CVS.hint();	//��Ʈ
		else if(e.getSource() == bExit){
			dispose();		//������
			System.exit(0);
		}			
	}
	public static void main(String args[]){
		Puzzle pz = new Puzzle();
		//pz.setVisible(true);
	}
	class MouseEventHandler extends MouseAdapter{
		//���콺�̺�Ʈ
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
		img = new Image[imgCnt*imgCnt];	//�̹��� ��ü �迭 ����
		imgSort=new int[imgCnt*imgCnt];	//�̹��� ��ü�� �ε��� ���� ���� �迭 ����
		r=new Random();
		//MediaTracker�̹������� ����Ǵ� �����忪�� �ܵ� ����ؾ� ��.
		/*
		 * �̹����� �÷����� ���� �κ������� �������� ���� �� �� �ִ�.
		 * �̷� ������ �����ϱ� ���� ����Ѵ�.
		 * MediaTracker�� �׸��� ������ �÷����� �� �̹����� �����ش�.
		 */
		MediaTracker tracker = new MediaTracker(this);
		imgSorting(false);
		
		for (int i=0;i<img.length;i++){
			//�̹��� �迭�� ����
			imgName = i + ".jpg";
			//�ڹٿ��� �̹����� �ε��ϱ� ���ؼ��� ToolkitŬ������ �޼���� �̹��� ��ü�� ������ ���� MediaTracker�� ���ؼ� �ε��Ѵ�.
			img[i] = Toolkit.getDefaultToolkit().getImage(imgPath+imgName);
			//---�� �� ������ ���ѷ��� ����.
			tracker.addImage(img[i],i);
			try{
				tracker.waitForID(i);
			}catch(Exception e){}
			//---�������
		}
	}
	
	public void imgSorting(boolean k){
		int i,j, iRandom1,iRandom2;
		int iTmp;	
		//imgCnt = 3;
		for (i=0;i<imgCnt*imgCnt;i++)
			imgSort[i]=i;		//imgSort�ε��� �ʱ�ȭ... imgSort[0]=0; imgSort[1]=1...
			
		if (k==true){
			//����ũ��
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
				//8.gif �� ��ũ�� ��ǥ��
				blankX=(i%imgCnt)*imgWidth;//1%3=1*100=100;
				blankY=i/imgCnt*imgHeight; //1%3=1*80=80
				break;
			}	
		}	
	}
	
	public void paint(Graphics g){
		System.out.println("paint ȣ�� ����");
		imgWidth = img[0].getWidth(this);	//�̹��� ���μ��� ũ��
		imgHeight = img[0].getHeight(this);
		System.out.println(imgWidth+", "+imgHeight);
		int k=0;	//0-8
		
		for (int i=0;i<imgCnt;i++){
			for (int j=0;j<imgCnt;j++){
				//img[0~8] ��ü �ҷ���
				//img���� �̹��� ��ü, imgSort[k]
				//1)�̹�����ü,������x��ǥ,������y��ǥ,�̹�����,�̹�������,�̹��������� 
				//�ý��� ���ο��� �̹����� �ε��ϴ� �����尡 �ֽ��ϴ�.
				//ImageObserver �������̽��� ������ Ŭ������ JComponent�̰� �̰��� JPanel�� �θ� Ŭ���� �Դϴ�.
				//Canvas�� �θ�Ŭ������ JComponent�̹Ƿ� ���⼭�� this�� �־��ش�.
				g.drawImage(img[imgSort[k]],j*imgWidth, i*imgHeight, imgWidth,imgHeight, this);//imgSort[k]�� ���� �ش�Ǵ� �̹����� �ҷ���
				k=k+1;
			}
		}
		if (isGame==true && isDap()==true){
			//����ǥ��
//			System.out.println("����");
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
			//���� �����߿� �̹��� Ŭ��
			int iClickIndex=0;
			int iBlankIndex=0;
			int iTmp=0;
			
			imgX=(int)(p.getX()/imgWidth)*imgWidth;		//�������� x��ǥ
			imgY=(int)(p.getY()/imgHeight)*imgHeight;	//�������� y��ǥ
			
			if (Math.abs(blankX-imgX) + Math.abs(blankY-imgY)==imgWidth){	//��ũ �ٷο����� Ŭ��
				iClickIndex=(imgY/imgHeight)*imgCnt + imgX/imgWidth;		//Ŭ���� ��ǥ �̹����� �ε����� ���Ѵ�.
				iBlankIndex=(blankY/imgHeight)*imgCnt + blankX/imgWidth;	//��ũ ��ǥ �ε��� ��
				//array �ٲ�
				iTmp=imgSort[iClickIndex];	//imgArr[iClickedIndex]�� value �� imgArr[iBlankIndex]�� value�� ����
				imgSort[iClickIndex]=imgSort[iBlankIndex];
				imgSort[iBlankIndex]=iTmp;
				//��ũ�� ��ǥ�� ����
				blankX=imgX;	//blankX��ǥ ����
				blankY=imgY;	//blankY��ǥ ����
				repaint();
			}
		}
	}
	
	public void start(){		
		imgSorting(true);//�̹��� ����.
		isGame=true;
		repaint();
	}
	
	public void hint(){
		isGame=false;
		imgSorting(false);
		repaint();
	}
}  
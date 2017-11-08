package puzzlegame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class main implements ActionListener {
	
	
	public main(){
		
		initDisplay();
	}
	String path = this.getClass().getResource("").getPath();
	ImageIcon start = new ImageIcon(getClass().getResource("start.png"));
	ImageIcon exit = new ImageIcon(getClass().getResource("exit.png"));
	ImageIcon backpic = new ImageIcon(getClass().getResource("mainpic.jpg"));
	//버튼이미지 가능
	JFrame jf_main = new JFrame();
	JPanel jp_south = new JPanel();
    JPanel jp_center = new JPanel(){
        public void paintComponent(Graphics g) {
            g.drawImage(backpic.getImage(), 0, 0, null);
            setOpaque(false);
            super.paintComponent(g);
           } 
    };
	JButton jbtn_start = new JButton(start);
	//JButton jbtn_stage = new JButton("스테이지");
	JButton jbtn_exit = new JButton(exit);

	
	public void initDisplay(){
		jf_main.setTitle("퍼즐게임");
		jf_main.setSize(1000,1000);
		jf_main.setVisible(true);	
		jf_main.add("Center", jp_center);
		jf_main.add("South", jp_south);
		jp_south.add(jbtn_start);
		//jp_south.add(jbtn_stage);
		jp_south.add(jbtn_exit);
		
		//버튼 이미지만 보이게 하기
		jbtn_start.setBorderPainted(false);
		jbtn_start.setContentAreaFilled(false);
		jbtn_start.addActionListener(this);	
		
		jbtn_exit.setBorderPainted(false);
		jbtn_exit.setContentAreaFilled(false);
		jbtn_exit.addActionListener(this);	
		
		jp_south.setBackground(new Color(255,255,255));
		Image puzzleicon= new ImageIcon(path+"puzzle.png").getImage();
		 jf_main.setIconImage(puzzleicon);//이미지 아이콘 삽입
	
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj==jbtn_start){
			
			 PuzzleEx puzzle = new PuzzleEx();
			 jf_main.dispose();
			 
			
		//puzzlegmae();	
		}else if(obj==jbtn_exit){
			System.exit(0);
		}	
		
	}

	public static void main(String[] args) {
		new main();
		
	}
	}
	

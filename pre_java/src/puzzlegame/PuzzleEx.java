package puzzlegame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class MyButton extends JButton {

    private boolean isLastButton;
    
    
    
    public MyButton() {

        super();

        initUI();
    }

    public MyButton(Image image) {

        super(new ImageIcon(image));

        initUI();
    }

    private void initUI() {

        isLastButton = false;
        BorderFactory.createLineBorder(Color.gray);

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.yellow));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.gray));
            }
        });
    }

    public void setLastButton() {
        
        isLastButton = true;
    }

    public boolean isLastButton() {

        return isLastButton;
    }
}

public class PuzzleEx extends JFrame implements ActionListener {

	int p_height = 3;
	int p_width = 2;
	
	String path = this.getClass().getResource("").getPath();
	ImageIcon main = new ImageIcon(getClass().getResource("maingo.png"));
	ImageIcon dap = new ImageIcon(getClass().getResource("dap.png"));
	ImageIcon restart = new ImageIcon(getClass().getResource("restart.png"));
	ImageIcon exit = new ImageIcon(getClass().getResource("exit2.png"));

	private boolean dap_flag = true;
	
	private JPanel jp_dap;
	
	
	
    private JPanel panel;
    private JPanel panel2;
    private JPanel panel3;
    
    private JButton jbtn_main = new JButton(main);
    private JButton jbtn_dap = new JButton(dap);
    private JButton jbtn_refresh = new JButton(restart);
    private JButton jbtn_exit = new JButton(exit);
    
    
    private BufferedImage source;
    private ArrayList<MyButton> buttons;

    ArrayList<Point> solution = new ArrayList();

    private Image image;
    private MyButton lastButton;
    private int width, height;
    private final int DESIRED_WIDTH = 1500;
    private BufferedImage resized;

    public PuzzleEx() {

        initUI();
    }

    private void initUI() {
    	
    	
    	
    	for(int i=0;i<p_height;i++){
    		
    		for(int j=0;j<p_width;j++){
    			 solution.add(new Point(i, j));
    		}
    		
    		
    	}

    

        buttons = new ArrayList();

        panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.gray));
        panel.setLayout(new GridLayout(p_height, p_width, 0, 0));
        
        panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createLineBorder(Color.gray));
      
        Font f = new Font("맑은 고딕",Font.BOLD,40);
		jbtn_main.setFont(f);
		jbtn_dap.setFont(f);
		jbtn_refresh.setFont(f);
		jbtn_exit.setFont(f);
        
        
        
        panel3 = new JPanel();
        panel3.add(jbtn_main);
        panel3.add(jbtn_dap);
        panel3.add(jbtn_refresh);
        panel3.add(jbtn_exit);
        
    	jbtn_main.setBorderPainted(false);
		jbtn_main.setContentAreaFilled(false);
        jbtn_main.addActionListener(this);
        
      	jbtn_dap.setBorderPainted(false);
    	jbtn_dap.setContentAreaFilled(false);
        jbtn_dap.addActionListener(this);
        
      	jbtn_refresh.setBorderPainted(false);
    	jbtn_refresh.setContentAreaFilled(false);
        jbtn_refresh.addActionListener(this);
        
      	jbtn_exit.setBorderPainted(false);
    	jbtn_exit.setContentAreaFilled(false);
        jbtn_exit.addActionListener(this);
		
    	panel3.setBackground(new Color(255,255,255));
		this.add("South",panel3);
        
        

        try {
            source = loadImage();
            int h = getNewHeight(source.getWidth(), source.getHeight());
            resized = resizeImage(source, DESIRED_WIDTH, h,
                    BufferedImage.TYPE_INT_ARGB);

        } catch (IOException ex) {
            Logger.getLogger(PuzzleEx.class.getName()).log(
                    Level.SEVERE, null, ex);
        }

        width = resized.getWidth(null);
        height = resized.getHeight(null);

        add(panel, BorderLayout.CENTER);

        for (int i = 0; i < p_height ; i++) {

            for (int j = 0; j < p_width ; j++) {

                image = createImage(new FilteredImageSource(resized.getSource(),
                        new CropImageFilter(j * width / p_width, i * height / p_height,
                                (width / p_width), height / p_height)));
                MyButton button = new MyButton(image);
                button.putClientProperty("position", new Point(i, j));

                if (i == p_height-1 && j == p_width-1) {
                    lastButton = new MyButton();
                    lastButton.setBorderPainted(false);
                    lastButton.setContentAreaFilled(false);
                    lastButton.setLastButton();
                    lastButton.putClientProperty("position", new Point(i, j));
                } else {
                    buttons.add(button);
                }
            }
        }

        Collections.shuffle(buttons);
        buttons.add(lastButton);

        for (int i = 0; i < p_height*p_width ; i++) {

            MyButton btn = buttons.get(i);
            panel.add(btn);
            btn.setBorder(BorderFactory.createLineBorder(Color.gray));
            btn.addActionListener(new ClickAction());
        }
        
        Image puzzleicon= new ImageIcon(path+"puzzle.png").getImage();
		 this.setIconImage(puzzleicon);

        pack();
        setTitle("Puzzle");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
        
        
        
        
    }

    private int getNewHeight(int w, int h) {

        double ratio = DESIRED_WIDTH / (double) w;
        int newHeight = (int) (h * ratio);
        return newHeight;
    }

    private BufferedImage loadImage() throws IOException {

    	
    	String path = this.getClass().getResource("").getPath();
    //	Random random = new Random();
    	
    	BufferedImage bimg = ImageIO.read(new File(path+"1.jpg"));
    	//BufferedImage bimg1 = ImageIO.read(new File(path+"mikey.jpg"));
    	//BufferedImage bimg2 = ImageIO.read(new File(path+"insideout.jpg"));
    
    		
    	return bimg;
    	}


    private BufferedImage resizeImage(BufferedImage originalImage, int width,
            int height, int type) throws IOException {

        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();

        return resizedImage;
    }

    private class ClickAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {

            checkButton(e);
            checkSolution();
        }

        private void checkButton(ActionEvent e) { //이부분 수정     수정 버그발생

            int lidx = 0;
            for (MyButton button : buttons) {
                if (button.isLastButton()) {
                    lidx = buttons.indexOf(button);
                }
            }

            JButton button = (JButton) e.getSource();
            int bidx = buttons.indexOf(button);

           
            
            
            if ((bidx - 1 == lidx) || (bidx + 1 == lidx) || (bidx - p_width == lidx) || (bidx + p_width == lidx)) {
                Collections.swap(buttons, bidx, lidx);
                updateButtons();
            }
            
        }

        private void updateButtons() {

            panel.removeAll();

            for (JComponent btn : buttons) {

                panel.add(btn);
            }

            panel.validate();
        }
    }

    private void checkSolution() {

        ArrayList<Point> current = new ArrayList();

        for (JComponent btn : buttons) {
            current.add((Point) btn.getClientProperty("position"));
        }

        if (compareList(solution, current)) {
            JOptionPane.showMessageDialog(panel, "Finished",
                    "Congratulation", JOptionPane.INFORMATION_MESSAGE);
            
            p_height = p_height + 1;
        	p_width = p_width +1;
        	this.remove(panel);
			this.remove(panel3);
			this.initUI();
            
        }
    }

    public static boolean compareList(List ls1, List ls2) {
        return ls1.toString().contentEquals(ls2.toString());
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                PuzzleEx puzzle = new PuzzleEx();
               
            }
        });
    }

    
    
    public void dap() throws IOException {
    	
    	 	
    	
    	
    	ImageIcon backpic = new ImageIcon(getClass().getResource("1.jpg"));
    	    	
    	
    	jp_dap = new JPanel(){
            public void paintComponent(Graphics g) {
                          
                
                g.drawImage(backpic.getImage(), 0, 0, 400, 400, null);
                
                setOpaque(false);
                super.paintComponent(g);
               } 
        };
        
        
    	
        JFrame jf_dap = new JFrame();
    	
    	
        jf_dap.setTitle("정답화면");
		jf_dap.setSize(400,400);
		jf_dap.setVisible(true);
		jf_dap.add(jp_dap);
		//jp_dap.add(jbtn_dap);

		jbtn_dap.setBorderPainted(false);
		jbtn_dap.setContentAreaFilled(false);
    	 
    	
    	
    	
    	
    }
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtn_refresh){
			
			this.remove(panel);
			this.remove(panel3);
			this.initUI();
				
			
		}
		
		else if(e.getSource()==jbtn_main){
			
			this.dispose();
			new main();
			
			
		}
		else if(e.getSource()==jbtn_exit){
			
			
			System.exit(0);
			
		}
		else if(e.getSource()==jbtn_dap){
			
			
			try {
				this.dap();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		
		
	}
}
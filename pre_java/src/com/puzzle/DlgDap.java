package com.puzzle;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JDialog;

public class DlgDap extends JDialog implements ActionListener
{
	String msg = new String("축하합니다");
	Panel p = new Panel();
	Button ok = new Button("OK");
	Button exit = new Button("끝내기");
	
	public DlgDap(Frame f)
	{
		super(f, "정답", true);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent evt)
			{
				dispose();
			}
		});
	}
	
	public void show()
	{
		
		p.setLayout(new GridLayout(1, 2));
		ok.addActionListener(this);
		exit.addActionListener(this);

		add("Center", new Label(msg, Label.CENTER));
		
		p.add(ok);
		p.add(exit);
		add("South", p);
		setSize(150, 90);
		super.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Object tmp = e.getSource();

		if(tmp.equals(ok))
		{
			dispose();
		}
		
		if(tmp.equals(exit))
		{
			dispose();
			System.exit(0);
		}
	}
/*	public static void main(String[] args){
		DlgDap dd = new DlgDap(new Frame());
		dd.show();
	}*/
}

package ejemplojuego;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingAnimation{
	Thread th;
	ImageIcon images;
	JFrame frame;
	JLabel lbl;
	int i = 0;
	int j;

	public static void main(String[] args){
		SwingAnimation sa = new SwingAnimation();
	}

	public SwingAnimation(){
		frame = new JFrame("Animation Frame");
		th = new Thread();
		lbl = new JLabel();
		Panel panel = new Panel();
		panel.add(lbl);
		frame.add(panel, BorderLayout.CENTER);
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(j = 1; j <= 2; j++){
			SwingAnimator();
			if (j == 2)
				j = 0;
		}
	}

	public void SwingAnimator(){
		try{
			for(i = 1; i <= 5; i++){
				images = new ImageIcon("images/img" + i + ".gif");
				lbl.setIcon(images);
				th.sleep(1000);
			}
		}
		catch(InterruptedException e){}
	}
}
package com.gabizou;

import javax.swing.*;
import java.awt.*;

public class Exercise13_1 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Exercise13_1 g = new Exercise13_1();
		g.setTitle("Exercise13_1");
		g.setSize(200,200);
		g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.setVisible(true);
	}

	public Exercise13_1(){
		add(new GridPanel());
	}
	class GridPanel extends JPanel
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			for(int i = 1; i <= 2; i++)
			{
				g.setColor(Color.blue);
				g.drawLine(0, (0+ (i * getHeight() / 3)),
						getWidth(), (0 + (i *(getHeight()/3))));
				g.setColor(Color.red);
				g.drawLine((0 + (i * (getWidth() / 3))), 0, 
						(0 + (i * (getWidth() / 3))), getHeight());

			}
		}
	}



}

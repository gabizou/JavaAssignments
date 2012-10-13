package com.gabizou;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class PosPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x = 20;
	private int y = 20;
	private String msg = "";
	
	
	public PosPanel() {
		//mouse move handler method to show positioning of mouse
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				msg = "(" +x +"," + y+ ")";
				repaint();
			}
		});
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(msg, x, y);
	}

}

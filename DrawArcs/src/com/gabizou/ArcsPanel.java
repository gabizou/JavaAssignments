package com.gabizou;

import java.awt.Graphics;

import javax.swing.JPanel;

// The class for drawing arcs on a panel
class ArcsPanel extends JPanel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int i;
	
	// Draw four blazes of a fan
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);

		int x = xCenter - radius;
		int y = yCenter - radius;

		g.fillArc(x, y, 2 * radius, 2 * radius, 0+i, 30);
		g.fillArc(x, y, 2 * radius, 2 * radius, 90+i, 30);
		g.fillArc(x, y, 2 * radius, 2 * radius, 180+i, 30);
		g.fillArc(x, y, 2 * radius, 2 * radius, 270+i++, 30);
	}

	@Override
	public void run() {

		try {
			for(;;) { 
			repaint();
			Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


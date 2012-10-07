package com.gabizou;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

class OvalButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6826755750951476302L;

	public OvalButton() {
	}

	public OvalButton(String text) {
		super(text);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// Draw an oval
		super.paintComponent(g);
		g.drawOval(5, 5, getWidth() - 10, getHeight() - 10);
	}

	/** Override get method for preferredSize */
	public Dimension getPreferredSize() {
		return new Dimension(100, 50);
	}

	/** Override get method for minimumSize */
	public Dimension getMinimumSize() {
		return new Dimension(100, 50);
	}
}
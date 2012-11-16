package com.gabizou;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class DrawArcs extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * ArcsPanel arcpanel1 = new ArcsPanel();
	 * this.add(arcpanel1);
	 * Thread thread1 = new Thread(arcpanel1);
	 * thread1.start();
	 */

	public DrawArcs() {
		setTitle("DrawArcs");
		int n = 4;
		
		this.setLayout(new GridLayout(1,n));
		for (int i=0; i<n; i++) {
			ArcsPanel panel = new ArcsPanel();
			this.add(panel);
			Thread thread = new Thread(panel);
			thread.start();
		}
	}

	/** Main method */
	public static void main(String[] args) {
		DrawArcs frame = new DrawArcs();

		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(250, 300);
		frame.setVisible(true);
	}
}

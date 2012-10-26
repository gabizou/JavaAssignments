package com.gabizou;

import java.awt.*;

import javax.swing.*;

public class Exercise18_10 extends JApplet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */

	public Exercise18_10() {
		add(new TemperatureHistogram(), BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame(" Temperature Historgram");

		Exercise18_10 applet = new Exercise18_10();

		frame.add(applet,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		applet.init();
		applet.start();
		frame.setSize(500,180);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}

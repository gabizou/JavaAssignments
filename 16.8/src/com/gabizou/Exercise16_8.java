package com.gabizou;

import java.awt.*;
import javax.swing.*;

public class Exercise16_8 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public Exercise16_8() {
		//initialize the Position panel
		PosPanel jp = new PosPanel();
		//set layout
		setLayout(new BorderLayout());
		add(jp);
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Exercise16_8 mousepos = new Exercise16_8();
		mousepos.setTitle("Altering messages");
		mousepos.setLocationRelativeTo(null);
		mousepos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mousepos.setVisible(true);
	}
	


}

package com.gabizou;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Exercise17_11 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */

	public JTextField jtfMessage1 = new JTextField("Type anything",30);

	private JTextField jtfMessage2 = new JTextField(3);

	JRadioButton jrbLeft, jrbCenter, jrbRight;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Definine the main method

		Exercise17_11 frame = new Exercise17_11();
		frame.setTitle("ButtonDemo");
		frame.pack();
		frame.setSize(500,150);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public Exercise17_11() {
		JPanel jp1= new JPanel();
		jp1.setLayout(new BorderLayout());
		jp1.add(jtfMessage1,BorderLayout.EAST);
		jp1.add(new JLabel("Text Field"),BorderLayout.WEST);
		add(jp1,BorderLayout.NORTH);

		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout());
		jp2.add(new JLabel("Horizontal Alignment"), BorderLayout.NORTH);
		jp2.add(jrbRight = new JRadioButton("Right"));
		jp2.add(jrbCenter = new JRadioButton("Center"));
		jp2.add(jrbLeft = new JRadioButton("Left"));
		ButtonGroup group = new ButtonGroup();

		group.add(jrbLeft);
		group.add(jrbCenter);
		group.add(jrbRight);
		add(jp2,BorderLayout.WEST);

		JPanel jp3 = new JPanel();

		jp3.add(new JLabel("Column Size"),BorderLayout.CENTER);
		add(jp3,BorderLayout.CENTER);
		jp3.add(jtfMessage2,BorderLayout.EAST);
		jrbLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfMessage1.setHorizontalAlignment(SwingConstants.LEFT);
			}
		});

		jrbRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfMessage1.setHorizontalAlignment(SwingConstants.RIGHT);
			}
		});

		jrbCenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfMessage1.setHorizontalAlignment(SwingConstants.CENTER);
			}
		});

		jtfMessage2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfMessage1.setColumns(Integer.parseInt(jtfMessage2.getText()));
				jtfMessage2.requestFocusInWindow();
			}
		});
	}

}

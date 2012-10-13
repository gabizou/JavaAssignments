package com.gabizou;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Exercise17_15 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */

	//Create ScrollBars for Colors
	private JScrollBar jscb1 = new JScrollBar(JScrollBar.HORIZONTAL);
	private JScrollBar jscb2 = new JScrollBar(JScrollBar.HORIZONTAL);
	private JScrollBar jscb3 = new JScrollBar(JScrollBar.HORIZONTAL);

	//Define Lables for Colors
	JLabel jlb1 = new JLabel("Red");
	JLabel jlb2 = new JLabel("Green");
	JLabel jlb3 = new JLabel("Blue");
	JLabel jlbl = new JLabel("Show Colors");

	//Privatize the color values
	private int redvalue, bluevalue, greenvalue;

	private Color color;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exercise17_15 frame = new Exercise17_15();
		frame.setTitle("Exercise17_15");
		frame.pack();
		frame.setSize(500, 250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	//Main Constructor
	public Exercise17_15() {
		JPanel jp4 = new JPanel();
		jp4.add(jlbl,BorderLayout.CENTER);
		jlbl.setForeground(Color.pink);
		add(jp4,BorderLayout.CENTER);
		JPanel jp1 = new JPanel();
		jp1.setLayout(new BorderLayout());
		add(jp1, BorderLayout.SOUTH);
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		jp1.add(jp2, BorderLayout.WEST);
		jp1.add(jp3, BorderLayout.CENTER);
		jp2.setLayout(new GridLayout(3,1));
		jp2.add(jlb1);
		jp2.add(jlb2);
		jp2.add(jlb3);
		jp3.setLayout(new GridLayout(3,1));
		jp3.add(jscb1);
		jp3.add(jscb2);
		jp3.add(jscb3);
		jscb1.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				redvalue= jscb1.getValue();
				color = new Color(redvalue,greenvalue,bluevalue);
				jlbl.setForeground(color);
			}
		});
		jscb2.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				bluevalue= jscb2.getValue();
				color = new Color(redvalue,greenvalue,bluevalue);
				jlbl.setForeground(color);
			}
		});
		jscb3.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				greenvalue= jscb3.getValue();
				color = new Color(redvalue,greenvalue,bluevalue);
				jlbl.setForeground(color);
			}
		});
	}

}

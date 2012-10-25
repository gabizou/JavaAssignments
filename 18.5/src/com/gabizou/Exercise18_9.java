package com.gabizou;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercise18_9 extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jlblDecimal = new JLabel("Decimal");
	private JLabel jlblHex = new JLabel("Hex");
	private JLabel jlblBinary = new JLabel("Binary");

	private JTextField jtfDecimal = new JTextField(20);
	private JTextField jtfHex = new JTextField(20);
	private JTextField jtfBinary = new JTextField(20);

	private static final int HEX_BASE = 16;
	private static final int BINARY_BASE = 2;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Exercise18_9");
		frame.add(new Exercise18_9());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public Exercise18_9() {

		JPanel p = new JPanel(new BorderLayout());
		JPanel p1 = new JPanel(new GridLayout(3,1));
		JPanel p2 = new JPanel(new GridLayout(3,1));

		p1.add(jlblDecimal);
		p1.add(jlblHex);
		p1.add(jlblBinary);

		p2.add(jtfDecimal);
		p2.add(jtfHex);
		p2.add(jtfBinary);

		p.add(p1,BorderLayout.WEST);
		p.add(p2, BorderLayout.EAST);

		jtfDecimal.setHorizontalAlignment(JTextField.RIGHT);
		jtfHex.setHorizontalAlignment(JTextField.RIGHT);
		jtfBinary.setHorizontalAlignment(JTextField.RIGHT);

		add(p);

		jtfDecimal.addActionListener(new Listener());
		jtfHex.addActionListener(new Listener());
		jtfBinary.addActionListener(new Listener());
	}

	public class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== jtfDecimal) {
				String decimal = jtfDecimal.getText();
				int value = Integer.parseInt(decimal);

				String hex = decimalToHex(value);
				jtfHex.setText(hex);

				String binary = decimalToBinary(value);
				jtfBinary.setText(binary);
			} else if(e.getSource()==jtfHex) {
				String hex = jtfHex.getText();

				int decimal = hexToDecimal(hex);
				jtfDecimal.setText(""+ decimal);

				String binary = decimalToBinary(decimal);
				jtfBinary.setText(binary);
			} else {
				String binary = jtfBinary.getText();

				int decimal = binaryToDecimal(binary);
				jtfDecimal.setText(""+decimal);

				String hex = decimalToHex(decimal);
				jtfHex.setText(hex);
			}
		}

	}

	private static String decimalToHex(int value) {
		if(value<10) {
			return value+"";
		} else if(value< HEX_BASE) {
			return character(value);
		} else {
			return decimalToHex(value/HEX_BASE) + decimalToHex(value%HEX_BASE);
		}
	}

	private static String character(int value) {
		String str = "";
		switch(value) {
		case 10: str = "A"; break;
		case 11: str = "B"; break;
		case 12: str = "C"; break;
		case 13: str = "D"; break;
		case 14: str = "E"; break;
		case 15: str = "F"; break;
		}
		return str;
	}
	
	private static String decimalToBinary(int value) {
		if(value == 0) {
			return "0";
		} else if(value == 1) {
			return "1";
		}
		if(value% BINARY_BASE== 0) {
			return decimalToBinary(value/BINARY_BASE) +"0";
		} else {
			return decimalToBinary(value/BINARY_BASE) + "1";
		}
	}
	
	private static int hexToDecimal(String hex) {
		if(hex.length()==0) {
			return 0;
		} else if(hex.charAt(0)=='A'|| hex.charAt(0)=='a') {
			return (int) (Math.pow(16, hex.length()-1))*10+
					hexToDecimal(hex.substring(1));
		} else if(hex.charAt(0)=='B'|| hex.charAt(0)=='b') {
			return (int) (Math.pow(16, hex.length()-1))*11+
					hexToDecimal(hex.substring(1));
		} else if(hex.charAt(0)=='C'|| hex.charAt(0)=='c') {
			return (int) (Math.pow(16, hex.length()-1))*12+
					hexToDecimal(hex.substring(1));
		} else if(hex.charAt(0)=='D'|| hex.charAt(0)=='d') {
			return (int) (Math.pow(16, hex.length()-1))*13+
					hexToDecimal(hex.substring(1));
		} else if(hex.charAt(0)=='E'|| hex.charAt(0)=='e') {
			return (int) (Math.pow(16, hex.length()-1))*14+
					hexToDecimal(hex.substring(1));
		} else if(hex.charAt(0)=='F'|| hex.charAt(0)=='f') {
			return (int) (Math.pow(16, hex.length()-1))*15+
					hexToDecimal(hex.substring(1));
		} else {
			return(int) (Math.pow(16, hex.length()-1 *
					(int)(hex.charAt(0)-48)+ 
					hexToDecimal(hex.substring(1))));
		}
	}
	
	private static int binaryToDecimal(String binary) {
		if(binary.length()==0) {
			return 0;
		} else if(binary.charAt(0)=='0') {
			return (int) ((Math.pow(2, binary.length()-1)*0)+
					binaryToDecimal(binary.substring(1)));
		} else {
			return (int) ((Math.pow(2, binary.length()-1)*1)+
					binaryToDecimal(binary.substring(1)));
		}
	}

}

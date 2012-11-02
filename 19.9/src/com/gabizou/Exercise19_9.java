package com.gabizou;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Exercise19_9 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static int NameSize = 32;
	final static int StreetSize = 32;
	final static int CitySize = 20;
	final static int StateSize = 2;
	final static int ZipSize = 5;
	final static int RecordSize = (NameSize + StreetSize + CitySize + StateSize + ZipSize);

	private RandomAccessFile randomfile;
	private JTextField jtfName = new JTextField(NameSize);
	private JTextField jtfStreet = new JTextField(StreetSize);
	private JTextField jtfCity = new JTextField(CitySize);
	private JTextField jtfState = new JTextField(StateSize);
	private JTextField jtfZip = new JTextField(ZipSize);

	private JButton jbtAdd = new JButton("Add");
	private JButton jbtFirst = new JButton("First");
	private JButton jbtNext = new JButton("Next");
	private JButton jbtPrevious = new JButton("Previous");
	private JButton jbtLast = new JButton("Last");

	public Exercise19_9() {
		try {
			randomfile = new RandomAccessFile("output.txt","rw");
		} catch(IOException ex) {
			System.out.print("Error: "+ ex);
			System.exit(0);
		}

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(3,1));
		p1.add(new JLabel("Name"));
		p1.add(new JLabel("Street"));
		p1.add(new JLabel("City"));

		JPanel jpState = new JPanel();
		jpState.setLayout(new BorderLayout());
		jpState.add(new JLabel("State"), BorderLayout.WEST);
		jpState.add(jtfState,BorderLayout.CENTER);

		JPanel jpZip = new JPanel();
		jpZip.setLayout(new BorderLayout());
		jpZip.add(new JLabel("Zip"), BorderLayout.WEST);
		jpZip.add(jtfZip,BorderLayout.CENTER);

		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		p2.add(new JLabel("State"), BorderLayout.WEST);
		p2.add(jpZip,BorderLayout.CENTER);

		JPanel p3 = new JPanel();
		p3.setLayout(new BorderLayout());
		p3.add(new JLabel("State"), BorderLayout.CENTER);
		p3.add(p2,BorderLayout.EAST);

		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(3,1));
		p4.add(jtfName);
		p4.add(jtfStreet);
		p4.add(p3);

		JPanel jpAddress = new JPanel(new BorderLayout());
		jpAddress.add(p1, BorderLayout.WEST);
		jpAddress.add(p4, BorderLayout.CENTER);
		jpAddress.setBorder(new BevelBorder(BevelBorder.RAISED));

		JPanel jpButton = new JPanel();
		jpButton.add(jbtAdd);
		jpButton.add(jbtFirst);
		jpButton.add(jbtNext);
		jpButton.add(jbtPrevious);
		jpButton.add(jbtLast);

		add(jpAddress, BorderLayout.CENTER);
		add(jpButton, BorderLayout.SOUTH);
		jbtAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteRecord();
			}
		});

		jbtFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(randomfile.length()>0) readAddress(0);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});

		jbtNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					long currentPosition = randomfile.getFilePointer();
					if(currentPosition <randomfile.length()) 
						readAddress(currentPosition);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});

		jbtPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					long currentPosition = randomfile.getFilePointer();
					if(currentPosition - 2 * RecordSize > 0) {
						readAddress(currentPosition -2 *2 * RecordSize);
					} else {
						readAddress(0);
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});

		jbtLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					long lastPosition = randomfile.length();
					if(lastPosition > 0) {
						readAddress(lastPosition -2 * RecordSize);
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});

		try {
			if(randomfile.length()>0) {
				readAddress(0);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}	
	}

	public void WriteRecord() {
		try {
			randomfile.seek(randomfile.length());
			FixedLengthStringIO.writeFixedLengthString(jtfName.getText(),NameSize, randomfile);
			FixedLengthStringIO.writeFixedLengthString(jtfStreet.getText(),StreetSize, randomfile);
			FixedLengthStringIO.writeFixedLengthString(jtfCity.getText(),CitySize, randomfile);
			FixedLengthStringIO.writeFixedLengthString(jtfState.getText(),StateSize, randomfile);
			FixedLengthStringIO.writeFixedLengthString(jtfZip.getText(),ZipSize, randomfile);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void readAddress(long position) throws IOException {
		randomfile.seek(position);
		String name = FixedLengthStringIO.readFixedLengthString(NameSize, randomfile);
		String street = FixedLengthStringIO.readFixedLengthString(StreetSize, randomfile);
		String city = FixedLengthStringIO.readFixedLengthString(CitySize, randomfile);
		String state = FixedLengthStringIO.readFixedLengthString(StateSize, randomfile);
		String zip = FixedLengthStringIO.readFixedLengthString(ZipSize, randomfile);
		jtfName.setText(name);
		jtfStreet.setText(street);
		jtfCity.setText(city);
		jtfState.setText(state);
		jtfZip.setText(zip);
	}

	public static void main(String[] args) {
		Exercise19_9 frame = new Exercise19_9();
		frame.pack();
		frame.setTitle("Exercise19_9");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}


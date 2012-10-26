package com.gabizou;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class Exercise18_17 extends JApplet implements ActionListener {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField jtfCar1Speed;
	private JTextField jtfCar2Speed;
	private JTextField jtfCar3Speed;
	private JTextField jtfCar4Speed;
	private RaceCar car1;
	private RaceCar car2;
	private RaceCar car3;
	private RaceCar car4;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame frame = new JFrame();
		JApplet applet = new Exercise18_17();

		frame.add(applet);
		frame.setTitle("Exercise18_17");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(3);
		frame.setSize(400,200);
		frame.setVisible(true);

	}

	class RaceCar extends JPanel implements Runnable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int xBase;
		private int sleepTime;


		public void run() {
			try {
				while(true) {
					repaint();
					Thread.sleep(sleepTime);
				}
			}
			catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}

		public void setSpeed(int speed) {
			sleepTime = speed;
		}

		@Override
		public void paintComponent(Graphics g) {


			super.paintComponent(g);

			int yBase = getHeight();
			if(xBase > getWidth())
				xBase = -20;
			else
				xBase++;
			g.setColor(Color.black);
			g.fillOval(xBase+10, yBase-10, 10, 10);
			g.fillOval(xBase+30, yBase-10, 10, 10);
			g.setColor(Color.green);
			g.fillRect(xBase, yBase-20,50,10);
			g.setColor(Color.red);
			Polygon polygon = new Polygon();
			polygon.addPoint(xBase+10, yBase-20);
			polygon.addPoint(xBase+20, yBase-30);
			polygon.addPoint(xBase+30, yBase-30);
			polygon.addPoint(xBase+40, yBase-20);
			g.fillPolygon(polygon);
		}

	}

	public Exercise18_17() {
		jtfCar1Speed = new JTextField(4);
		jtfCar2Speed = new JTextField(4);
		jtfCar3Speed = new JTextField(4);
		jtfCar4Speed = new JTextField(4);

		car1 = new RaceCar();
		car2 = new RaceCar();
		car3 = new RaceCar();
		car4 = new RaceCar();

		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("Car 1: "));
		panel1.add(jtfCar1Speed);
		panel1.add(new JLabel("Car 2: "));
		panel1.add(jtfCar2Speed);
		panel1.add(new JLabel("Car 3: "));
		panel1.add(jtfCar3Speed);
		panel1.add(new JLabel("Car 4: "));
		panel1.add(jtfCar4Speed);

		JPanel panel2 = new JPanel(new GridLayout(4,1));
		panel2.add(car1);
		panel2.add(car2);
		panel2.add(car3);
		panel2.add(car4);
		add(panel1,"North");
		add(panel2, "Center");

		jtfCar1Speed.addActionListener(this);
		jtfCar2Speed.addActionListener(this);
		jtfCar3Speed.addActionListener(this);
		jtfCar4Speed.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== jtfCar1Speed) {
			car1.setSpeed(Integer.parseInt(jtfCar1Speed.getText()));
		} else if(e.getSource()== jtfCar2Speed) {
			car1.setSpeed(Integer.parseInt(jtfCar2Speed.getText()));
		} else if(e.getSource()== jtfCar3Speed) {
			car1.setSpeed(Integer.parseInt(jtfCar3Speed.getText()));
		} else if(e.getSource()== jtfCar4Speed) {
			car1.setSpeed(Integer.parseInt(jtfCar4Speed.getText()));
		}
	}
}

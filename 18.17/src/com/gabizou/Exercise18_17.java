package com.gabizou;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Exercise18_17 extends JApplet implements ActionListener {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected List<RaceCar> carList; 

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
		private Thread thread;
		protected JTextField carSpeed;
		protected int carID;
		protected JLabel carLabel;

		public RaceCar(int ID) {
			this.xBase = 0;
			this.thread = new Thread(this);
			this.sleepTime = 10;

			this.carID = ID;

			setBorder(BorderFactory.createLineBorder(Color.BLACK));
			thread.start();
			this.carSpeed = new JTextField(4);
			this.carLabel = new JLabel("Car "+carID+": ");
		}

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
		
		public JLabel getLabel() {
			return carLabel;
		}

		public void setSpeed(int speed) {
			sleepTime = speed;
		}

		public JTextField getSpeed() {
			return carSpeed;
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

		int n = 4;

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel(new GridLayout(n,1));
		this.carList = new ArrayList<RaceCar>();

		for(int i=0; i<n; i++) {

			RaceCar car = new RaceCar(i+1);
			panel1.add(car.carLabel);
			panel1.add(car.getSpeed());
			panel2.add(car);
			car.getSpeed().addActionListener(this);
			carList.add(car);
		}

		add(panel1,"North");
		add(panel2, "Center");
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		for (RaceCar rc : carList) { 
			if (rc.getSpeed().equals(source)) {
				String entry = rc.getSpeed().getText();
				rc.setSpeed(Integer.parseInt(entry));
			}
		}
	}
}

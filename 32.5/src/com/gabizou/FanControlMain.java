package com.gabizou;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;

public class FanControlMain extends JApplet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static FanControl fanControl;
	
	@Override
	public void init() {
		getContentPane().add(fanControl = new FanControl());
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Exercise32_5");
		
//		ThreadFanControl applet = new ThreadFanControl();
		fanControl = new FanControl();
		frame.add(fanControl);
//		frame.getContentPane().add(applet, BorderLayout.CENTER);

		frame.setSize(300,300);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

class FanControl extends JPanel implements ActionListener, AdjustmentListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton jbtStart, jbtStop, jbtReverse;
	private JScrollBar jscb;
	private Fan fan;

	public FanControl() {
		JPanel p1 = new JPanel(); // Button Panel
		p1.setLayout(new GridLayout(1,3));
		p1.add(jbtStart = new JButton("Start"));
		p1.add(jbtStop = new JButton("Stop"));
		p1.add(jbtReverse = new JButton("Reverse"));
		p1.setBorder(new LineBorder(Color.black, 1));

		JPanel p2 = new JPanel();  // ScrollBar Panel
		p2.setLayout(new BorderLayout());
		p2.add("North", p1);
		p2.add("Center", fan = new Fan());
		p2.add("South", jscb = new JScrollBar(JScrollBar.HORIZONTAL, 100,100,0,800));
		jscb.setMaximum(1000);
		
		jbtStart.addActionListener(this);
		jbtStop.addActionListener(this);
		jbtReverse.addActionListener(this);
		jscb.addAdjustmentListener(this);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String arg = e.getActionCommand();
		if(e.getSource() instanceof JButton) {
			if("Start".equals(arg)) {
				start();
			} else if ("Stop".equals(arg)) {
				stop();
			} else if ("Reverse".equals(arg)) {
				reverse();
			}
		}
	}
	
	@Override
	public void adjustmentValueChanged(AdjustmentEvent arg0) {
		fan.setSpeed((jscb.getMaximum()-jscb.getValue())/10);
	}
	
	private void reverse() {
		fan.reverse();
		
	}
	private void stop() {
		fan.stop();
		
	}
	private void start() {
		fan.start();		
	}

	public Dimension getPreferredSize() {
		return new Dimension(200,200);
	}

}

class Fan extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xCenter, yCenter;
	private int fanRadius, bladeLength;
	private int angle = 100;
	private int direction = 1;
	private int speed = 10;

	protected Thread thread = new Thread(this);
	protected boolean isSuspended = true;

	public Fan() {
		thread.start();
	}

	public void setSpeed(int ms) {
		this.speed = ms;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		fanRadius = (int)(Math.min(getSize().width, getSize().height)*0.9 *0.5);
		xCenter = (getSize().width)/2;
		yCenter = (getSize().height)/2;
		bladeLength = (int)(fanRadius *0.9);
		angle = (angle + direction)%360;
		g.setColor(Color.black);
		g.drawOval(xCenter- fanRadius, yCenter- fanRadius, 2*fanRadius, 2*fanRadius);
		drawBlade(g, angle);
		drawBlade(g, angle +  90);
		drawBlade(g, angle + 180);
		drawBlade(g, angle + 270);
	}

	private void drawBlade(Graphics g, int angel) {
		g.setColor(Color.BLACK);
		g.fillArc(xCenter-bladeLength, yCenter-bladeLength, 2*bladeLength, 2*bladeLength, angle, 30);
	}

	Lock lock = new ReentrantLock();
	Condition suspended = lock.newCondition();
	
	public void run() {
		try {
			while(true) {
				repaint();
				Thread.sleep(speed);
				while(isSuspended){
					lock.lock();
					suspended.await();
					lock.unlock();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void start() {
		lock.lock();
		isSuspended = false;
		suspended.signalAll();
		lock.unlock();

	}

	public void stop() {
		lock.lock();
		isSuspended = true;
		lock.unlock();

	}

	public void reverse() {
		direction = -direction;

	}
}
package com.gabizou;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class Exercise18_2 extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JApplet applet = new Exercise18_2();
		applet.init();
		applet.start();
		frame.add(applet);
		frame.setSize(300,300);
		frame.setLocationRelativeTo(null);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);


	}

	private StillClock clock = new StillClock();

	Timer timer = new Timer(1000, new TimerListener());
	public Exercise18_2() {
		add(clock);
	}

	public void start() {
		timer.start();
	}

	public void stop() {
		timer.stop();
	}

	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			clock.setCurrentTime();
			clock.repaint();
		}
	}

	class StillClock extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int hour;
		private int minute;
		private int second;
		private boolean hourHandVisible = true;
		private boolean minuteHandVisible = true;
		private boolean secondHandVisible = true;

		public StillClock() {
			setCurrentTime();
		}

		public StillClock(int hour, int minute, int second) {
			this.hour = hour;
			this.minute = minute;
			this.second = second;
		}

		public int getHour() {
			return hour;
		}

		public void setHour(int hour) {
			this.hour = hour;
			repaint();
		}

		public int getMinute() {
			return minute;
		}

		public void setMinute(int minute) {
			this.minute = minute;
			repaint();
		}

		public int getSecond() {
			return second;
		}

		public void setSecond(int second) {
			this.second = second;
			repaint();
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			int clockRadius = (int)(Math.min(getWidth(), getHeight())*0.8*0.5);

			int xCenter = getWidth()/2;
			int yCenter = getHeight()/2;

			g.setColor(Color.black);
			g.drawOval(xCenter- clockRadius, yCenter - clockRadius,
					2* clockRadius, 2* clockRadius);
			g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
			g.drawString("9", xCenter - clockRadius + 3, yCenter +5);
			g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);
			g.drawString("3", xCenter+ clockRadius -10, yCenter + 3);

			if(secondHandVisible) {
				int sLength = (int)(clockRadius *0.8);
				int xSecond = (int)(xCenter + sLength * Math.sin(second* 
						(2 * Math.PI/60)));
				int ySecond = (int)(yCenter - sLength * Math.cos(second *
						(2 * Math.PI/60)));
				g.setColor(Color.red);
				g.drawLine(xCenter, yCenter, xSecond, ySecond);
			}
			if (minuteHandVisible) {
				int mLength = (int)(clockRadius *0.65);
				int xMinute = (int)(xCenter + mLength * Math.sin(minute* 
						(2 * Math.PI/60)));
				int yMinute = (int)(yCenter - mLength * Math.cos(minute *
						(2 * Math.PI/60)));
				g.setColor(Color.blue);
				g.drawLine(xCenter, yCenter, xMinute, yMinute);
			}
			if (hourHandVisible) {
				int hLength = (int)(clockRadius *0.5);
				int xHour = (int)(xCenter + hLength * Math.sin((hour % 12 + minute/60.0) * 
						(2 * Math.PI/60)));
				int yHour = (int)(yCenter - hLength * Math.cos((hour % 12 + minute/60.0) *
						(2 * Math.PI/60)));
				g.setColor(Color.green);
				g.drawLine(xCenter, yCenter, xHour, yHour);
			}
		}
		public void setCurrentTime() {
			Calendar calendar = new GregorianCalendar();
			this.hour = calendar.get(Calendar.HOUR_OF_DAY);
			this.minute = calendar.get(Calendar.MINUTE);
			this.second = calendar.get(Calendar.SECOND);
		}

		public Dimension getPreferedSize() {
			return new Dimension(300,300);
		}

		public boolean isHourHandVisible() {
			return hourHandVisible;
		}

		public boolean isMinuteHandVisible() {
			return hourHandVisible;
		}

		public boolean isSecondHandVisible() {
			return secondHandVisible;
		}

		public void setHourHandVisible( boolean hourHandVisible) {
			this.hourHandVisible = hourHandVisible;
			repaint();
		}

		public void setMinuteHandVisible(boolean minuteHandVisible) {
			this.minuteHandVisible = minuteHandVisible;
			repaint();
		}

		public void setSecondHandVisible(boolean secondHandVisible) {
			this.secondHandVisible = secondHandVisible;
			repaint();
		}
	}


}

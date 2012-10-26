package com.gabizou;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.Timer;

class TemperatureHistogram extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double temperature[] = new double[24];
	private boolean firstTime = true;
	private double newTemp;
	private int current = 23;
	private int interval, width, individualWidth, height;

	public TemperatureHistogram() {
		for (int i=0; i<temperature.length; i++)
			temperature[i] = 0; 
		Timer timer = new Timer(1000, new Listener());
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {

		width = getSize().width;
		height = getSize().height;

		interval = (width-40)/24;
		individualWidth = (int)(((width-40)/24)*0.60);

		if (firstTime) {
			firstTime = false;

			int x = 30;

			for (int i=0; i<24; i++) {
				g.drawString(i+"", x, height-35 );
				x += interval;
			}

			FontMetrics fm = g.getFontMetrics();
			String title = "Current Time: "+new Date();
			g.drawLine(10, height-45, width-10, height-45);
			g.drawString(title, (width-fm.stringWidth(title))/2, height-20);
		}
		else {
			int previous = (current-1+24)%24;
			g.setColor(getBackground());
			g.fillRect(interval*previous+30, height-45-(int)temperature[previous],
					individualWidth, (int)temperature[previous]);

			g.setColor(Color.black);
			g.drawRect(interval*previous+30, height-45-(int)temperature[previous],
					individualWidth, (int)temperature[previous]);

			g.setColor(getBackground());
			g.drawRect(interval*current+30, height-45-(int)temperature[current],
					individualWidth, (int)temperature[current]);

			g.setColor(Color.red);
			temperature[current] = newTemp;
			g.fillRect(interval*current+30, height-45-(int)temperature[current],
					individualWidth, (int)temperature[current]);
		}
	}

	class Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			current = (current+1)%24;
			newTemp = (int)(Math.random()*40 + 50);
			repaint();
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(300, 100);
	}
}
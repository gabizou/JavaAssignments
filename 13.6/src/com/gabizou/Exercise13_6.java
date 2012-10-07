package com.gabizou;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Exercise13_6 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	public Exercise13_6() {
		setLayout(new GridLayout(2,2,5,5));
		add(new FigurePanel(FigurePanel.ARC));
		add(new FigurePanel(FigurePanel.POLYGON));
		add(new FigurePanel(FigurePanel.ARC,true));
		add(new FigurePanel(FigurePanel.POLYGON, true));
	}
	public static void main(String[] args) {
		Exercise13_6 fr = new Exercise13_6();
		fr.setSize(400,400);
		fr.setTitle("Exercise13_6");
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setVisible(true);

	}
	//Inclusion of the FigurePanel as a nested class
	//FigurePanel handles the drawing of all shapes
	class FigurePanel extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public static final int LINE = 1;
		public static final int RECTANGLE = 2;
		public static final int ROUND_RECTANGLE = 3;
		public static final int OVAL = 4;
		public static final int ARC = 5;
		public static final int POLYGON = 6;

		private int type = 1;
		private boolean filled = false;

		/** Construct a default FigurePanel */
		public FigurePanel() {
		}

		/** Construct a FigurePanel with the specified type */
		public FigurePanel(int type) {
			this.type = type;
		}

		/** Construct a FigurePanel with the specified type and filled */
		public FigurePanel(int type, boolean filled) {
			this.type = type;
			this.filled = filled;
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			//Get the appropriate size for the figure
			int width = getWidth();
			int height = getHeight();

			switch (type) {
			case LINE: //Display two cross lines
				g.setColor(Color.BLACK);
				g.drawLine(10, 10, width - 10 , height -10);
				g.drawLine(width -10, 10, 10, height -10);
				break;
			case RECTANGLE: //Display a rectangle
				g.setColor(Color.blue);
				if( filled)
					g.fillRect((int)(0.1 * width), (int)(0.1 * height),
							(int)(0.8 * width), (int)(0.8 * height));
				else
					g.drawRect((int)(0.1 * width), (int)(0.1 * height),
							(int)(0.8 * width), (int)(0.8 * height));
				break;
			case ROUND_RECTANGLE: //Display a round-cornered rectangle
				g.setColor(Color.red);
				if( filled)
					g.fillRoundRect((int)(0.1 * width), (int)(0.1 * height),
							(int)(0.8 * width), (int)(0.8 * height), 20, 20);
				else
					g.drawRoundRect((int)(0.1 * width), (int)(0.1 * height),
							(int)(0.8 * width), (int)(0.8 * height), 20, 20);
				break;
			case OVAL: //Display an Oval
				g.setColor(Color.black);
				if (filled)
					g.fillOval((int)(0.1 * width), (int)(0.1 * height),
							(int)(0.8 * width), (int)(0.8 * height));
				else
					g.drawOval((int)(0.1 * width), (int)(0.1 * height),
							(int)(0.8 * width), (int)(0.8 * height));
				break;
			case ARC: //Display an arc
				g.setColor(Color.blue);
				if (filled) {
					g.fillArc((int)(0.1 * width), (int)(0.1 * height),
							(int)(0.8 * width), (int)(0.8 * height), 
							0, 30);
					g.fillArc((int)(0.1 * width), (int)(0.1 * height),
							(int)(0.8 * width), (int)(0.8 * height), 
							90, 30);
					g.fillArc((int)(0.1 * width), (int)(0.1 * height),
							(int)(0.8 * width), (int)(0.8 * height), 
							180, 30);
					g.fillArc((int)(0.1 * width), (int)(0.1 * height),
							(int)(0.8 * width), (int)(0.8 * height), 
							270, 30);
				} else {
					g.drawArc((int)(0.1 * width), (int)(0.1 * height),
							(int)(0.8 * width), (int)(0.8 * height), 
							0, 30);
					g.drawArc((int)(0.1 * width), (int)(0.1 * height),
							(int)(0.8 * width), (int)(0.8 * height), 
							90, 30);
					g.drawArc((int)(0.1 * width), (int)(0.1 * height),
							(int)(0.8 * width), (int)(0.8 * height), 
							180, 30);
					g.drawArc((int)(0.1 * width), (int)(0.1 * height),
							(int)(0.8 * width), (int)(0.8 * height), 
							270, 30);
				}
				break;
			
			case POLYGON:
				g.setColor(Color.red);
				int radius = (int)(0.4 * Math.min(width, height));
				int xCenter = (int)(0.4 * width);
				int yCenter = (int)(0.4 * height);
				Polygon p = new Polygon();
				p.addPoint(xCenter+ radius, yCenter);
				
				p.addPoint((int)(xCenter + radius * Math.cos(2 * Math.PI/6)),
						(int)(yCenter - radius* Math.sin(2*Math.PI/6)));
				
				p.addPoint((int)(xCenter + radius * Math.cos(2 * 2* Math.PI/6)),
						(int)(yCenter - radius* Math.sin(2*2*Math.PI/6)));
				
				p.addPoint((int)(xCenter + radius * Math.cos(3* 2* Math.PI/6)),
						(int)(yCenter - radius* Math.sin(3*2*Math.PI/6)));
				
				p.addPoint((int)(xCenter + radius * Math.cos(4* 2* Math.PI/6)),
						(int)(yCenter - radius* Math.sin(4*2*Math.PI/6)));
				
				p.addPoint((int)(xCenter + radius * Math.cos(5* 2* Math.PI/6)),
						(int)(yCenter - radius* Math.sin(5*2*Math.PI/6)));
				
				
				if(filled){
					g.fillPolygon(p);
				} else {
					g.drawPolygon(p);
				}
				break;
			}
		}

		/** Set a new figure type */
		public void setType(int type) {
			this.type = type;
			repaint();
		}

		/** Return figure type */
		public int getType() {
			return type;
		}

		/** Set a new filled property */
		public void setFilled(boolean filled) {
			this.filled = filled;
			repaint();
		}

		/** Check if the figure is filled */
		public boolean isFilled() {
			return filled;
		}

		@Override // Specify preferred size
		public Dimension getPreferredSize() {
			return new Dimension(80, 80);
		}
	}

}

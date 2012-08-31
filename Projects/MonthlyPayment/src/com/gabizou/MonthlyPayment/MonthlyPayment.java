package com.gabizou.MonthlyPayment;

import javax.swing.JOptionPane;

public class MonthlyPayment {
	
	public static void main(String[] args)
	{
		//Commence Greeting Pane
		JOptionPane.showMessageDialog(null, "Welcome to the Monthly Payment Calculator!\nPress OK when ready to continue.");
		
		
		int p = Integer.parseInt(JOptionPane.showInputDialog("Please enter your current principle:"));
		//Requests the principle amount of the loan and places as an integer into p
		int r = Integer.parseInt(JOptionPane.showInputDialog("Now please enter your current rate:"));
		//Requests the rate and places as an integer into r
		int y = Integer.parseInt(JOptionPane.showInputDialog("And finally, please enter the amount of\nyears on the loan:"));
		//Requests the amount of years on the loan and places it into y
		
		//Calculations commence
		
		float m;
		//sets up m as the Monthly payment to be calculated.
		
		double yt = (double) y*12-1;
		double ra = (double) r/1200;
		double ra1 = (double) ra+1;
		
		System.out.println("I have p:"+p+ " and r:"+r+" and y:"+y+" as values");
		//Debug line
		m = (float) ((ra + ra/Math.pow(ra1, yt))*p);
		
		System.out.println("I have ra:"+ra+" and ra1:"+ra1+" and yt:"+yt);
		//Another debug line
		
		float t = m*y*12;
		
		float i = t-p;
		
		JOptionPane.showMessageDialog(null, "Ok. Your Monthly payment will be: "+ m +"\nAnd your total amount that you'll end up paying is: "+t +"\nWhile the total amount of interest paid is: "+ i);
				
		
	}

}

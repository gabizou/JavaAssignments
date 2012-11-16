package com.gabizou;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

public class Exercise18_3 extends Applet implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TextField amountText, paymentText, periodText, rateText, totalText;
	Button doIt;
	double principal;
	double intRate;
	double numYears;

	final int payPerYear = 12;
	NumberFormat nf;
	public Exercise18_3() {

		GridBagLayout gbag = new GridBagLayout();
		setSize(300,500);
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbag);

		Label heading = new Label("Enter interest rate, year and loan amount");
		Label rateLab = new Label("Interest Rate(e.g. 5.5 for 5.5%)");
		Label periodLab = new Label("Years");
		Label amountLab = new Label("Loan Amount");
		Label paymentLab = new Label("Monthly Paymet");
		Label totalLab = new Label("Total Payment");

		amountText = new TextField(10);
		periodText = new TextField(10);
		paymentText = new TextField(10);
		rateText = new TextField(10);
		totalText = new TextField(10);
		paymentText.setEditable(false);
		totalText.setEditable(false);

		doIt = new Button("Compute Payment");
		
		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.NORTH;
		gbag.setConstraints(heading, gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(amountLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(amountText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(periodLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(periodText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(rateLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(rateText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(paymentLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(paymentText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(totalLab, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(totalText, gbc);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(doIt, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(doIt, gbc);
		
		add(heading);
		
		add(rateLab);
		add(rateText);
		add(periodLab);
		add(periodText);
		add(amountLab);
		add(amountText);
		add(paymentLab);
		add(paymentText);
		add(totalLab);
		add(totalText);
		add(doIt);
		
		amountText.addActionListener(this);
		periodText.addActionListener(this);
		rateText.addActionListener(this);
		doIt.addActionListener(this);
		
		nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);

	}
	
	public void actionPerformed(ActionEvent ae) {
		checkValues();
	}
	
	public void checkValues() {
		try {
			double result = 0.0;
			double totalPay = 0.0;
			
			String amountStr = amountText.getText();
			String periodStr = periodText.getText();
			String rateStr = rateText.getText();
			
			try {
				if(amountStr.length() != 0 && periodStr.length() != 0 &&
						rateStr.length() != 0) {
					principal = Double.parseDouble(amountStr);
					numYears = Double.parseDouble(periodStr);
					intRate = Double.parseDouble(rateStr)/100;
					
					result = compute();
					
					paymentText.setText(nf.format(result));
					totalPay = computeTot();
					totalText.setText(nf.format(totalPay));
				}
				
				showStatus("");
			} catch (NumberFormatException exc) {
				showStatus("Invalid Data");
				paymentText.setText("");
			}
		} catch(Exception e) {
			
		}
		
	}
	
	double compute() {
		double number;
		double denom;
		double b, e;
		
		number = intRate * principal/ payPerYear;
		
		e = -(payPerYear * numYears);
		b = (intRate/payPerYear) + 1.0;
		
		denom = 1.0 - Math.pow(b,e);
		return number/denom;
	}
	double computeTot() {
		double number;
		double denom;
		double b,e;
		
		number = intRate*principal/payPerYear;
		
		e = -(payPerYear * numYears);
		b = (intRate/payPerYear) + 1.0;
		
		denom = 1.0 - Math.pow(b,e);
		
		double tot = (number/denom)*numYears*12;
		return tot;
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Exercise18_3");
		Exercise18_3 reg = new Exercise18_3();
		frame.add(reg);
		frame.setSize(400,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
	}



}

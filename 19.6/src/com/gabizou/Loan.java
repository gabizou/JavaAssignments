package com.gabizou;

public class Loan {
	
	private double anualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date loanDate;
	
	
	public Loan(double anualInterestRate, int numberOfYears, double loanAmount) {
		this.anualInterestRate = anualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
		loanDate = new java.util.Date();
	}
	
	public double getAnualInterestRate() {
		return anualInterestRate;
	}
	
	public void setAnualInterestRate(double anualInterestRate) {
		this.anualInterestRate = anualInterestRate;
	}
	
	public int getNumberOfYears() {
		return numberOfYears;
	}
	
	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}
	
	public double getLoanAmount() {
		return loanAmount;
	}
	
	public void setLoanAmount( double loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public double getMonthlyPayment() {
		double monthlyInterestRate = anualInterestRate/1200;
		double monthlyPayment = loanAmount* monthlyInterestRate/ 
				(1 - (Math.pow(1/ (1+monthlyInterestRate), numberOfYears* 12)));
		return monthlyPayment;
	}
	
	public double getTotalPayment() {
		double totalPayment = getMonthlyPayment() * numberOfYears * 12;
		return totalPayment;
	}
	
	public java.util.Date getLoanDate() {
		return loanDate;
	}
}

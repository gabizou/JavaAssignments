package com.gabizou;

import java.util.Scanner;

public class Exercise5 {
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter subtotal");
		double sub = input.nextDouble();
		System.out.println("Please enter the amount of tax");
		double tax = input.nextDouble();
		System.out.println("Calculating...");
		double taxpercent = tax/100;
		double total = sub * (1+taxpercent);
		System.out.println("The tax is "+ sub*taxpercent);
		System.out.println("The total is "+total);
	
	}
	

}

package com.gabizou;


import java.util.*;
import javax.swing.*;



public class Lottery {

	public static void main(String[] args)
	{
		//Generate the two numbers
		Random win1 = new Random();
		int winnum1 = win1.nextInt(10);
		Random win2 = new Random();
		int winnum2 = win2.nextInt(10);

		int n1,n2;
		//Debug line
		System.out.println("I generated these two numbers: " +winnum1 +winnum2);

		//Ask for first number.

		String strnum1 = JOptionPane.showInputDialog("Type a number from 0-9");

		for(n1 = Integer.parseInt(strnum1);(n1>9)||(n1<0);)
		{
			JOptionPane.showMessageDialog(null, "You've entered an invalid number!");
			strnum1 = JOptionPane.showInputDialog("Enter another number:");
			n1 = Integer.parseInt(strnum1,10); 

		}
		JOptionPane.showMessageDialog(null, "You chose " + strnum1 + " as your first number!");
		n1 = Integer.parseInt(strnum1);

		//define which case the person won according to the first number


		//Ask for second number.

		String strnum2 = JOptionPane.showInputDialog("Type a number from 0-9");
		n2 = Integer.parseInt(strnum2);
		for(n2 = Integer.parseInt(strnum2);(n2>9)||(n2<0);)
		{
			JOptionPane.showMessageDialog(null, "You've entered an invalid number!");
			strnum2 = JOptionPane.showInputDialog("Enter another number:");
			n2 = Integer.parseInt(strnum2,10); 

		}
		JOptionPane.showMessageDialog(null, "You chose " +strnum2 +" as your second number!");
		n2 = Integer.parseInt(strnum2);
		//Now determine whether the user won the game!

		if((n1 == winnum1) && (n2 == winnum2))
		{
			JOptionPane.showMessageDialog(null, "You won $10,000!");
		} else if((n1 == winnum1) && (n2 != winnum2))
		{
			JOptionPane.showMessageDialog(null, "You won $1,000! \n You guessed 1 number right.");
		} else if((n1 != winnum1) && (n2 == winnum2))
		{
			JOptionPane.showMessageDialog(null, "You won $1,000! \n You guessed 1 number right.");
		} else if((n1 == winnum2) && (n2 != winnum1))
		{
			JOptionPane.showMessageDialog(null, "You won $1,000! \n You guessed 1 number right.");
		} else if((n1 != winnum2) && (n2 == winnum1))
		{
			JOptionPane.showMessageDialog(null, "You won $1,000! \n You guessed 1 number right.");
		} else if((n1 == winnum2) && (n2 == winnum1))
		{
			JOptionPane.showMessageDialog(null, "You won $3,000! \n You guessed both numbers in the wrong order.");
		} else if((n1 != winnum1) && (n1 !=winnum2) && (n2 != winnum1) && (n2 != winnum1))
		{
			JOptionPane.showMessageDialog(null, "Sorry you lost the Lottery. Play again soon!");
		}

	}

}


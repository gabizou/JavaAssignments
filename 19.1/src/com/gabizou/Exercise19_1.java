package com.gabizou;

import java.io.*;

public class Exercise19_1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		int temp;
		
		BufferedWriter output = new BufferedWriter(new FileWriter("Exercise19_1.txt", true));
		for(int i= 0; i<100; i++) {
			
			temp = (int)(Math.random()*100);
			output.write(temp+ " ");
		}
		output.close();
		System.out.print("Done. D. U. N. DONE.");
		// TODO Auto-generated method stub

	}

}

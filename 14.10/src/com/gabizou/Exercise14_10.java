package com.gabizou;

public class Exercise14_10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int[] array = new int[1000000000];
		} catch (Error e) {
			e.printStackTrace();
			System.out.println("JVM ran out of Memory!");
		}
		

	}

}

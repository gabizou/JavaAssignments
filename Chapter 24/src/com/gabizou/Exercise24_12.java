package com.gabizou;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class Exercise24_12 {
	public static void main(String[] args) throws Exception {
		DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(
				"PrimeNumbers.dat")));

		input.skip(input.available() - 8 * 100);
		while (input.available() > 0) {
			System.out.println(input.readLong() + " ");
		}

		input.close();
	}
}

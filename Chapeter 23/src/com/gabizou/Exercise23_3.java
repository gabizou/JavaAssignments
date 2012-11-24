package com.gabizou;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise23_3 {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Usage: java Exercise23_3 filename.txt");
			System.exit(0);
		}

		String[] keywordString = { "throw", "continue", "interface", "throws", "default", "long",
				"transient", "do", "native", "try", "double", "abstract", "finally", "catch",
				"public", "boolean", "float", "return", "break", "for", "short", "byte", "goto",
				"static", "case", "if", "super", "catch", "implements", "switch", "char", "import",
				"synchronized", "class", "instanceof", "this", "const", "int", "new", "void",
				"else", "package", "volatile", "extends", "private", "while", "final", "protected",
				"true", "null", "false" };
		Set<String> keywordSet = new HashSet<String>(Arrays.asList(keywordString));

		int count = 0;

		BufferedReader in = null;

		try {
			in = new BufferedReader(new FileReader(args[0]));

			String s = null;
			while ((s = in.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(s);
				while (st.hasMoreTokens()) {
					String token = st.nextToken();
					if (keywordSet.contains(token))
						count++;
				}
			}
			System.out
					.println("The number of Java Language Keywords in the text file is: " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
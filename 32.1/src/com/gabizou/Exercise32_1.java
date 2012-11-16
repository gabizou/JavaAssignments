package com.gabizou;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Exercise32_1 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextArea jta;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		JFrame frame = new Exercise32_1();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(520,120);
		frame.setVisible(true);
	}
	
	public Exercise32_1() throws InterruptedException {
		
		jta = new JTextArea();
		add(jta);

		Runnable printA = new PrintChar('a', 100);
		Runnable printB = new PrintChar('b', 100);
		Runnable print100 = new PrintNum(100);

		// Create threads
		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(printB);
		Thread thread3 = new Thread(print100);

		
		jta.setText("1ab");
		// Start threads
		thread3.start();
		Thread.sleep(50);
		thread2.start();
		Thread.sleep(50);
		thread1.start();
	}
	class PrintChar implements Runnable {
		private char charToPrint; // The character to print
		private int times; // The times to repeat

		/** Construct a task with specified character and number of
		 *  times to print the character
		 */
		public PrintChar(char c, int t) {
			charToPrint = c;
			times = t;
		}

 
		/** @Override the run() method to tell the system
		 *  what the task to perform
		 */
		@Override
		public void run() {
			int i;
			if(charToPrint == 'b') {
				i = 47;
			} else {
				i = 21;
			}
			for (int n = 0; n < times; n++) {
				if(i == 63) {
					jta.append("\n");
					i=0;
				}
				jta.append(String.valueOf(charToPrint));
				i++;
			}
		}
	}
	
	class PrintNum implements Runnable {
		private int lastNum;

		/** Construct a task for printing 1, 2, ... i 
		 * 
		 */
		public PrintNum(int n) {
			lastNum = n;
		}


		/** Tell the thread how to run 
		 * 
		 */
		@Override 
		public void run() {
			int k =0;
			for (int i = 2; i <= lastNum; i++) {
				if(k == 28) {
					jta.append("\n");
					k = 2;
				}
				jta.append(String.valueOf(" "+i ));
				k++;
				
			}
		}
	}
}

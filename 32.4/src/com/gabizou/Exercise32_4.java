package com.gabizou;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise32_4 
{
	private static Integer sum = new Integer(0);

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(1000);		
		
		for(int i = 0; i < 1000; i++) {
			executor.execute(new SumTask(i));
		}		
		executor.shutdown();
	}

	static class SumTask implements Runnable {

		int id;

		protected SumTask(int n) {
			id = n;
		}

		@Override
		public synchronized void run() {
			sum++;
			System.out.println("At Thread "+ id +" Sum= "+ sum +" , ");
		}
	}
}

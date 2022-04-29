package com.buraksahin.multithread.example2;

import java.io.IOException;
import java.util.Scanner;

/**
 * Synchronized usage
 * 
 * @author buraksahin
 *
 */
public class Multithread {
	public static void main(String args[]) {
		Consumer consumer1 = new Consumer();
		consumer1.start();
		System.out.println("PRESS ENTER TO STOP CONSUMER");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		consumer1.stop();
	}
}

class Consumer extends Thread {
	public final static long SLEEP_TIME = 250;
	public final static String MESSAGE = "Consume Something";
	public static boolean isConsuming = true;

	public void run() {
		while (isConsuming) {
			System.out.println(MESSAGE);
			try {
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean stopConsume() {
		return true;
	}
}
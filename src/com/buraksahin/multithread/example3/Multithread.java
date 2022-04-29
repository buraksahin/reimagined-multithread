package com.buraksahin.multithread.example3;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

/**
 * Synchronized Join usage
 * 
 * @author buraksahin
 *
 */
public class Multithread {
	static BigDecimal  result = new BigDecimal (1);
	static BigDecimal result2 = new BigDecimal(1);
	static double elapsedTime = 0;
	public static void main(String[] args) {
		Multithread threadExample = new Multithread();
		threadExample.doWork(250);
		
		
		long startTime = System.currentTimeMillis();
		for(int v = 1; v <= 500; v++) {
			result2 = result2.multiply(new BigDecimal(v));
//			if(v%5 == 0) {
				System.out.println("xxxxxxxxxxx->>>>" + result2);				
//			}
		}
		System.out.println(System.currentTimeMillis() - startTime + "ms elapsed and calculated fact(5000)....total time!");
		System.out.println(elapsedTime + "ms elapsed....total time!");
		if(result2.compareTo(result) == 0) {
			System.out.println("OK");
		}
	}

	public BigDecimal  doWork(double value) {
		long startTime = System.currentTimeMillis();
		if (!(value > 0)) {
			return result;
		} else {
			Thread work1 = new Thread(new Runnable() {
				@Override
				public void run() {
					for (double i = 1; i <= value; i++) {
						multiply(new BigDecimal(i));
//						if(i % 5 == 0)
						System.out.println(result);
					}
				}
			});

			Thread work2 = new Thread(new Runnable() {
				@Override
				public void run() {
					for (double  i = value + 1; i <= value * 2 ; i++) {
						multiply(new BigDecimal(i));
//						if(i % 5 == 0)
						System.out.println(result);
					}
				}
			});
			work1.start();
			work2.start();
			try {
				work1.join();
				work2.join();
				if(result2.compareTo(result) == 0) {
					System.out.println("OK");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println(elapsedTime + "ms elapsed and calculated fact("+ value * 2 +")....total time!");
		return result;
	}
	
	public synchronized void multiply(BigDecimal num) {
		result = result.multiply(num);
	}
}
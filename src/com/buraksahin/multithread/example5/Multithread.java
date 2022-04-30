package com.buraksahin.multithread.example5;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Count Down Latch
 * 
 * @author buraksahin
 *
 */
public class Multithread {
	final static int MAX_THREAD = 6;
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(2);
		ExecutorService executor = Executors.newFixedThreadPool(MAX_THREAD);
		for(int i = 0; MAX_THREAD > i; i++) {
			executor.submit(new Worker(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		executor.invokeAll();
		executor.shutdown();
		System.out.println("Complete");
	}
}

class Worker implements Runnable {
	private CountDownLatch latch;

	public Worker(CountDownLatch latch){
		this.latch = latch;
	}

	public void run(){
		System.out.println("Worker Started");
		Random r = new Random();
		Long waitTime = r.nextLong(5000);
		try {
			System.out.println("it will sleep for " + waitTime + "ms");
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("---DONE---" + waitTime);
		latch.countDown();
	}
}


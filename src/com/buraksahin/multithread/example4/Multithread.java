package com.buraksahin.multithread.example4;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Thread Executor
 * 
 * @author buraksahin
 *
 */
public class Multithread {
	public static final int MAX_THREAD = 2;
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(MAX_THREAD);
		for(int i = 1; i <= MAX_THREAD; i++) {
			executor.submit(new Worker());
		}
		try {
			executor.awaitTermination(5000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("!!!!!!!!!!!!!!!!!!!!!TASKS DONE!!!!!!!!!!!!!!!!!!!!!");
	}
}

class Worker implements Runnable {
	Random random = new Random();
	@Override
	public void run() {
		System.out.println("Thread id is " + Thread.currentThread().getId());
		// TODO Auto-generated method stub
		try {
			Thread.sleep(random.nextLong(5000));
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Complete Thread id is " + Thread.currentThread().getId());
	}
	
}


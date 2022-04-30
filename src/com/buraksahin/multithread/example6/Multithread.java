package com.buraksahin.multithread.example6;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Queue
 * 
 * @author buraksahin
 *
 */
public class Multithread extends Thread{
	final static int MAX_THREAD = 6;
	final static int MAX_QUEUE_ITEM = 9;
	private static volatile BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(MAX_QUEUE_ITEM);
	
	public static void main(String[] args) {
		queue.add(new Random().nextInt(99));
		queue.add(new Random().nextInt(99));
		queue.add(new Random().nextInt(99));
		queue.add(new Random().nextInt(99));
		queue.add(new Random().nextInt(99));
		System.out.println(queue.toString());
		try {
			queue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		queue.poll();
		System.out.println(queue.toString());
	}
}

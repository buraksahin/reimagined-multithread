package com.buraksahin.multithread.example7;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

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
	
	public static void main(String[] args) throws InterruptedException {
		Thread producer = new Thread(new Runnable() {
			@Override
			public void run() {
				producer();
			}
		});
		
		Thread consumer = new Thread(new Runnable() {
			@Override
			public void run() {
				consumer();
			}
		});
		producer.start();
		consumer.start();
		producer.join();
		consumer.join();
	}
	
	private static void producer() {
		Random random = new Random();
		
		while(true) {
			try {
				Thread.sleep(3500);
				if(queue.size() < MAX_QUEUE_ITEM) {
					int item = random.nextInt(100);
					queue.put(item);
					System.out.println("Enqueuee item: " + item);
					System.out.println(queue.toString());
				}
				else {
					System.out.println("Waiting consumer..");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private static void consumer() {
		Random random = new Random();
		while(true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				int item;
				try {
					item = queue.take();
					System.out.println("Dequeue item: " + item);
					System.out.println(queue.toString());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
}

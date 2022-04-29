package com.buraksahin.multithread.example1;
import java.io.IOException;
/**
 * Basic thread usage
 * @author buraksahin
 *
 */
public class Multithread {
	public final static long SLEEP_TIME = 2500;
	public static void main(String args[]) {
		Thread thread1 = null;
		thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					System.out.format("THREAD NAME: %s --- VALUE: %d\n", Thread.currentThread().getName(), i);
					try {
						Thread.sleep(SLEEP_TIME);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					if(i == 5) {
						Thread.currentThread().stop();
					}
				}
			}
		});
		
		
		Thread thread2 = thread1;
		
		thread2.start();
		
		
	}
}

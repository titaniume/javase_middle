package cn.titanium.multithreading.atomicaccess;

import java.util.concurrent.atomic.AtomicInteger;

public class TestThread {
	
	  private static int value = 0;
	  private static AtomicInteger atomicValue =new AtomicInteger();
	  public static void main(String[] args) {
		int number =100000;
		Thread [] ts1 = new Thread[number];
		for (int i = 0; i < number; i++) {
			Thread t = new Thread(){
				public  void run(){
					value++;
				}
			};
			t.start();
			ts1[i] =t;
		}
		
		//等待这些线程全部结束x
		for (Thread t : ts1) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.printf("%d 线程进行value后，value的值变成了:%d%n",number,value);
		
		Thread [] ts2 = new Thread[number];
		for (int i =0;i<number;i++) {
			Thread t2 = new Thread(){
			public void run(){
				atomicValue.incrementAndGet();
			}
		};
		t2.start();
		ts2[i]=t2;
		}
		//等待这些线程全部结束x
		for (Thread t : ts2) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 System.out.printf("%d个线程进行atomicValue.incrementAndGet();后，atomicValue的值变成:%d%n", number,atomicValue.intValue());
	    }
}

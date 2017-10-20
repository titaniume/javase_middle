package cn.titanium.multithreading;

import cn.titanium.multithreading.synchronization.Hero;

/**
 * 死锁
 * @author Administrator
 *2017年10月20日下午12:24:43
 */
public class Deadlock {
	public static void main(String[] args) {
		
		// 1 : 演示死锁
		/*1. 线程1 首先占有对象1，接着试图占有对象2 
		2. 线程2 首先占有对象2，接着试图占有对象1 
		3. 线程1 等待线程2释放对象2 
		4. 与此同时，线程2等待线程1释放对象1 
		就会。。。一直等待下去，直到天荒地老，海枯石烂，山无棱 ，天地合。。。*/
		
		final Hero ahri =new Hero();
		ahri.name="九尾妖狐";
		final Hero annie = new Hero();
		annie.name="安妮";
		Thread t1 = new Thread(){
			public void run(){
				System.out.println("t1 已占有九尾妖狐");
				
				try {
					//停顿1000毫秒，另一个线程有足够的时间占有安妮
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("t1 试图占有安妮");
				System.out.println("t1 等待中...");
				synchronized (annie) {
					System.out.println("do something");
				}
			}
		};
		t1.start();
		Thread t2 = new Thread(){
			public void run(){
				System.out.println("t12已占有安妮");
				try {
					//停顿1000毫秒，另一个线程有足够的时间占有九尾妖狐
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("t2 试图占有九尾妖狐");
				System.out.println("t1 等待中...");
				synchronized (annie) {
					System.out.println("do something");
				}
			}
		};
		t2.start();
		
		//2 : 练习-死锁
		/*3个同步对象a, b, c
		3个线程 t1,t2,t3

		故意设计场景，使这3个线程彼此死锁*/
	}
}

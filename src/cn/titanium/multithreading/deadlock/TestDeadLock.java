package cn.titanium.multithreading.deadlock;

/**
 * 练习
 * @author Administrator
 *2017年10月20日下午12:33:03
 */
public class TestDeadLock {
	public static void main(String[] args) {
		
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		
		Thread t1 = new Thread (){
				
			public void run(){
				synchronized (a) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (b) {
						synchronized (c) {
							
						}
					}
				}
			}
		};
		Thread t2 = new Thread (){
			
			public void run(){
				synchronized (c) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (b) {
						synchronized (a) {
							
						}
					}
				}
			}
		};
		Thread t3 = new Thread (){
			
			public void run(){
				synchronized (b) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (c) {
						synchronized (a) {
							
						}
					}
				}
			}
		};
		t1.start();
		t2.start();
		t3.start();
	}
}

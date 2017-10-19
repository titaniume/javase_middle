package cn.titanium.multithreading.synchronization;

public class TestThread3 {

	public static void main(String[] args) {
		final Object someObject = new Object();
		final Hero3 gareen = new Hero3();
		gareen.name = "盖伦";
		gareen.hp = 10000;

		System.out.printf("盖伦的初始血量是 %.0f%n", gareen.hp);
		//多线程同步问题指的是多个线程同时修改一个数据的时候，导致的问题
        
        //假设盖伦有10000滴血，并且在基地里，同时又被对方多个英雄攻击
           
        //用JAVA代码来表示，就是有多个线程在减少盖伦的hp
        //同时又有多个线程在回复盖伦的hp
           
        //n个线程增加盖伦的hp  
		int n = 10000;
		Thread []  addThreads = new Thread[n];
		Thread []  reduceThreads = new Thread[n];
		for (int i = 0; i < n; i++) {
			Thread t = new Thread(){
				public void run(){
					  	//recover自带synchronized
						gareen.recover();
				
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			t.start();
			addThreads[i]=t;
		}
		 //n个线程减少盖伦的hp  
		for(int i = 0;i<n; i++){
			Thread t = new Thread(){
				public void run(){
					//recover自带synchronized
						gareen.hurt();
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			t.start();
			reduceThreads[i] =t;
		}
		
		 //等待所有增加线程结束
		for (Thread thread : addThreads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//等待所有减少线程结束
		for (Thread thread : reduceThreads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		 //代码执行到这里，所有增加和减少线程都结束了
        
        //增加和减少线程的数量是一样的，每次都增加，减少1.
        //那么所有线程都结束后，盖伦的hp应该还是初始值
           
        //但是事实上观察到的是：
                   
        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量变成了 %.0f%n", n,n,gareen.hp);
		
		
	}
}

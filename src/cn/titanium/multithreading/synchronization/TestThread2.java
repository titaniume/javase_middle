
package cn.titanium.multithreading.synchronization;
/**
 * 使用hero对象作为同步对象
 * @author Administrator
 *2017年10月19日下午2:16:12
 */
public class TestThread2 {
	 public static void main(String[] args) {
		 
	        final Hero gareen = new Hero();
	        gareen.name = "盖伦";
	        gareen.hp = 10000;
	          
	        int n = 10000;
	  
	        Thread[] addThreads = new Thread[n];
	        Thread[] reduceThreads = new Thread[n];
	          
	        for (int i = 0; i < n; i++) {
	            Thread t = new Thread(){
	                public void run(){
	                     
	                    //使用gareen作为synchronized
	                    synchronized (gareen) {
	                        gareen.recover();
	                    }
	                     
	                    try {
	                        Thread.sleep(100);
	                    } catch (InterruptedException e) {
	                        // TODO Auto-generated catch block
	                        e.printStackTrace();
	                    }
	                }
	            };
	            t.start();
	            addThreads[i] = t;
	              
	        }
	          
	        for (int i = 0; i < n; i++) {
	            Thread t = new Thread(){
	                public void run(){
	                    //使用gareen作为synchronized
	                    //在方法hurt中有synchronized(this)
	                	synchronized (gareen) {
	                		  gareen.hurt();
						}
	                  
	                     
	                    try {
	                        Thread.sleep(100);
	                    } catch (InterruptedException e) {
	                        // TODO Auto-generated catch block
	                        e.printStackTrace();
	                    }
	                }
	            };
	            t.start();
	            reduceThreads[i] = t;
	        }
	          
	        for (Thread t : addThreads) {
	            try {
	                t.join();
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        for (Thread t : reduceThreads) {
	            try {
	                t.join();
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	          
	        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量是 %.0f%n", n,n,gareen.hp);
	          
	    }
}

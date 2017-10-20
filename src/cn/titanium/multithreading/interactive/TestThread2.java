package cn.titanium.multithreading.interactive;

/**
 * 使用wait和notify进行线程交互
 * @author Administrator
 *2017年10月20日下午4:24:19
 */
public class TestThread2 {
	public static void main(String[] args) {

        final Hero2 gareen = new Hero2();
        gareen.name = "盖伦";
        gareen.hp = 616;
        Thread t1 = new Thread(){
        	public void run(){
        		  while(true){
                      
                      //无需循环判断
//                      while(gareen.hp==1){
//                          continue;
//                      }
                         
                      gareen.hurt();
                       
                      try {
                          Thread.sleep(10);
                      } catch (InterruptedException e) {
                          // TODO Auto-generated catch block
                          e.printStackTrace();
                      }
                  }
        	}
        };
        t1.start();
        Thread t2 = new Thread(){
        	public void run(){
        		  while(true){
                  
                      gareen.recover();
                       
                      try {
                          Thread.sleep(100);
                      } catch (InterruptedException e) {
                          // TODO Auto-generated catch block
                          e.printStackTrace();
                      }
                  }
        	}
        };
        t2.start();
	}
}

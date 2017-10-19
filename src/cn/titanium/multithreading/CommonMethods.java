package cn.titanium.multithreading;

/**
 * 常见的线程方法
 * @author Administrator
 *2017年10月18日下午11:38:42
 */
public class CommonMethods {
	public static void main(String[] args) {
		
		//1 : 当前线程暂停
	/*	Thread.sleep(1000); 表示当前线程暂停1000毫秒 ，其他线程不受影响 
		Thread.sleep(1000); 会抛出InterruptedException 中断异常，
		因为当前线程sleep的时候，有可能被停止，这时就会抛出 InterruptedException*/
		Thread t1 = new Thread(){
			public void run(){
				 int  scound = 0;
				 while(true){
					 try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 System.out.printf("你已经玩LOL %d 秒 %n",scound++);
				 }
			}
		};
		//t1.start();
		
		//2 : 加入到当前线程中
/*		首先解释一下主线程的概念
		所有进程，至少会有一个线程即主线程，即main方法开始执行，就会有一个看不见的主线程存在。*/
		
		//3 : 线程优先级
		
		//4 : 临时暂停
		/*当前线程，临时暂停，使得其他线程可以有更多的机会占用CPU资源*/
		
		// 5 : 守护线程
		/*守护线程的概念是： 当一个进程里，所有的线程都是守护线程的时候，结束当前进程。

		就好像一个公司有销售部，生产部这些和业务挂钩的部门。
		除此之外，还有后勤，行政等这些支持部门。

		如果一家公司销售部，生产部都解散了，那么只剩下后勤和行政，那么这家公司也可以解散了。

		守护线程就相当于那些支持部门，如果一个进程只剩下守护线程，那么进程就会自动结束。

		守护线程通常会被用来做日志，性能统计等工作。*/
		Thread t2 = new Thread(){
			int secound = 0;
			public void run(){
		    while(true){
		    	try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	System.out.printf("你已经玩游戏 %d 秒%n",secound++);
		    }
			}
		};
		t2.setDaemon(true);
		t2.start();
		
		//6 : 练习-英雄充能
		/*英雄有可以放一个技能叫做: 波动拳-a du gen。 
		每隔一秒钟，可以发一次，但是只能连续发3次。 

		发完3次之后，需要充能5秒钟，充满，再继续发。

		借助本章节学习到的知识点，实现这个效果
*/		// 8 : 练习-破解密码
		
	}
}

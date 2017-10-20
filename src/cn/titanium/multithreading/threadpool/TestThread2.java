package cn.titanium.multithreading.threadpool;

/**
 * 测试线程池
 * @author Administrator
 *2017年10月20日下午5:38:35
 */
public class TestThread2 {
	
	public static void main(String[] args) {
		
	
	ThreadPool pool = new ThreadPool();
	int sleep =1000;
	while(true){
		pool.add(new Runnable() {
			
			@Override
			public void run() {
				// System.out.println("执行任务");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		try {
			Thread.sleep(sleep);
			sleep= sleep >100 ?sleep -100:sleep;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}

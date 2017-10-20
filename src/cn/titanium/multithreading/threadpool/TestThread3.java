package cn.titanium.multithreading.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 使用java自带线程池
 * @author Administrator
 *2017年10月20日下午5:45:48
 */
public class TestThread3 {
	public static void main(String[] args) {
		
		ThreadPoolExecutor threadpool = new ThreadPoolExecutor(10, 10, 60,TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
		threadpool.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("任务1");
			}
		});
	}
}

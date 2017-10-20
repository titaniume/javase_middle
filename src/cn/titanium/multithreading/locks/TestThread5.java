package cn.titanium.multithreading.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 借助tryLock 解决死锁问题
 * 
 * @author Administrator 2017年10月20日下午7:07:15
 */
public class TestThread5 {
	  public static void main(String[] args) throws InterruptedException {
	        Lock lock_ahri = new ReentrantLock();
	        Lock lock_annie = new ReentrantLock();
	  
	        Thread t1 = new Thread() {
	            public void run() {
	                // 占有九尾妖狐
	                boolean ahriLocked = false;
	                boolean annieLocked = false;
	                  
	                try {
	                    ahriLocked = lock_ahri.tryLock(10, TimeUnit.SECONDS);
	                    if (ahriLocked) {
	                        System.out.println("t1 已占有九尾妖狐");
	                        // 停顿1000秒，另一个线程有足够的时间占有安妮
	                        Thread.sleep(1000);
	                        System.out.println("t1 试图在10秒内占有安妮");
	                        try {
	                            annieLocked = lock_annie.tryLock(10, TimeUnit.SECONDS);
	                            if (annieLocked)
	                                System.out.println("t1 成功占有安妮，开始啪啪啪");
	                            else{
	                                System.out.println("t1 老是占用不了安妮，放弃");
	                            }
	  
	                        } finally {
	                            if (annieLocked){
	                                System.out.println("t1 释放安妮");
	                                lock_annie.unlock();
	                            }
	                        }
	  
	                    }
	                } catch (InterruptedException e1) {
	                    // TODO Auto-generated catch block
	                    e1.printStackTrace();
	                } finally {
	                    if (ahriLocked){
	                        System.out.println("t1 释放九尾狐");
	                        lock_ahri.unlock();
	                    }
	                }
	  
	            }
	        };
	        t1.start();
	          
	        Thread.sleep(100);
	          
	        Thread t2 = new Thread() {
	            public void run() {
	                boolean annieLocked = false;
	                boolean ahriLocked = false;
	                                  
	                try {annieLocked = lock_annie.tryLock(10, TimeUnit.SECONDS);
	                  
	                if (annieLocked){
	                      
	                        System.out.println("t2 已占有安妮");
	                        // 停顿1000秒，另一个线程有足够的时间占有安妮
	                        Thread.sleep(1000);
	                        System.out.println("t2 试图在10秒内占有九尾妖狐");
	                        try {
	                            ahriLocked = lock_ahri.tryLock(10, TimeUnit.SECONDS);
	                            if (ahriLocked) 
	                                System.out.println("t2 成功占有九尾妖狐，开始啪啪啪");
	                            else{
	                                System.out.println("t2 老是占用不了九尾妖狐，放弃");
	                            }
	                        } 
	                        finally {
	                            if (ahriLocked){
	                                System.out.println("t2 释放九尾狐");
	                                lock_ahri.unlock();
	                            }
	                                  
	                        }
	  
	                    }
	                } catch (InterruptedException e1) {
	                    // TODO Auto-generated catch block
	                    e1.printStackTrace();
	                } finally {
	                    if (annieLocked){
	                        System.out.println("t2 释放安妮");
	                        lock_annie.unlock();
	                    }
	                          
	                }
	            }
	        };
	        t2.start();
	      
	    }
}

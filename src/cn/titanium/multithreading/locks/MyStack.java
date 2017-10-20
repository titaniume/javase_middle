package cn.titanium.multithreading.locks;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import cn.titanium.multithreading.synchronization.Hero;

/**
 * 借助Lock，把MyStack修改为线程安全的类
 * @author Administrator
 *2017年10月20日下午7:05:25
 */
public class MyStack {
	
	LinkedList<Hero> heros = new LinkedList<Hero>();
	
	Lock lock = new ReentrantLock();
	
	//把synchronized去掉
	public void push(Hero h){
		try {
			//使用lock占有锁
			lock.lock();
			heros.add(h);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//使用unlock释放锁
            //必须放在finally执行，万一heros.addLast抛出异常也会执行
			lock.unlock();
		}
	}
	
	public void pull(){
		try {
			//使用lock占有锁
			lock.lock();
			heros.removeLast();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//使用unlock释放锁
            //必须放在finally执行，万一heros.addLast抛出异常也会执行
			lock.unlock();
		}
	}
	
	public Hero peek(){
		return heros.getLast();
	}
	
	public static void main(String[] args) {
		
	}
}

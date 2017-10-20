package cn.titanium.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;



/**
 * 线程安全的类
 * @author Administrator
 *2017年10月20日上午11:59:31
 */
public class ThreadSafeClasses {
	public static void main(String[] args) {
		
		// 1 : HashMap和Hashtable的区别
		/* 1 : HashMap和Hashtable的区别
		 区别1： 
		 HashMap可以存放 null
		 Hashtable不能存放null
		区别2：
		 HashMap不是线程安全的类   public V put(K key, V value) 
		 HashTable 线程是安全的类   public synchronized V put(K key, V value)*/
		
		
		// 2 : StringBuffer和StringBuilder的区别
		/* StringBuffer 是线程安全的   public synchronized StringBuffer append(Object obj)
		   StringBuilder是非线程安全的    public StringBuilder append(Object obj)*/
		
		// 3 : ArrayList和Vector的区别
		/*ArrayList 不是线程安全的类    public boolean add(E e)
		Vector 是线程安全的类  public synchronized boolean add(E e)*/
		
		// 4 : 把非线程安全的集合转换为线程安全
/*		ArrayList是非线程安全的，换句话说，多个线程可以同时进入一个ArrayList对象的add方法
		借助Collections.synchronizedList，可以把ArrayList转换为线程安全的List。
		与此类似的，还有HashSet,LinkedList,HashMap等等非线程安全的类，都通过工具类Collections转换为线程安全的*/
		List<Integer> iList = new ArrayList<Integer>();
		List<Integer> synchronizedList = Collections.synchronizedList(iList);
		
		
		// 5 : 练习-线程安全的MyStack
		
		
		
	}
}

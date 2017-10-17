package cn.titanium.collection.relordiff;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ArrayList和LinkedList区别
 * @author Administrator
 *2017年10月17日下午11:33:21
 */
public class ArrayListVsLinkedList {
	public static void main(String[] args) {
		//1 : ArrayList和LinkedList的区别
		/*ArrayList 插入，删除数据慢
		LinkedList， 插入，删除数据快
		ArrayList是顺序结构，所以定位很快，指哪找哪。 就像电影院位置一样，有了电影票，一下就找到位置了。
		LinkedList 是链表结构，就像手里的一串佛珠，要找出第99个佛珠，必须得一个一个的数过去，所以定位慢*/
		
		
		// 2 : 插入数据
		
		List<Integer> l;
		l = new ArrayList<Integer>();
		insertFirst(l, "ArrayList");
		l = new LinkedList<Integer>();
		insertFirst(l, "LinkedList");
		
		//3 : 定位数据
		  List<Integer> List;
		  List = new ArrayList<>();
	      modify(List, "ArrayList");
	 
	      List = new LinkedList<>();
	      modify(List, "LinkedList");
	      
	     //4 : 练习-在后面插入数据
	      /*比较 ArrayList和LinkedList 在最后面插入100000条数据，谁快谁慢？为什么？*/
	      List<Integer> inserts;
	      inserts = new ArrayList<>();
          insertFirst(inserts, "ArrayList");
   
          inserts = new LinkedList<>();
           insertFirst(inserts, "LinkedList");
	}
	
	//插入数据比较
	private static void insertFirst(List<Integer> integer,String type){
		int total = 1000 * 100;
		final int number  = 5;
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			integer.add(0,number);
		}
		long end = System.currentTimeMillis();
		 System.out.printf("在%s 最前面插入%d条数据，总共耗时 %d 毫秒 %n", type, total, end - start);
	}
	
	//定位数据
	private static void modify(List<Integer> list,String type){
		int total = 100 * 1000;
        int index= total/2;
        final int number = 5;
        //初始化
        for (int i = 0; i < total; i++) {
            list.add(number);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
			int n = list.get(index);
			n++;
			list.set(index, n);
		}
        long end = System.currentTimeMillis();
        System.out.printf("%s总长度是%d，定位到第%d个数据，取出来，加1，再放回去%n 重复%d遍，总共耗时 %d 毫秒 %n", type,total, index,total, end - start);
        System.out.println();
	}
	
	public static void insert(List<Integer> list,String type){
		int total = 1000 * 100;
		final int number = 5;
		long start = System.currentTimeMillis();
		for (int i = 0; i < total; i++) {
			//把容器的一半位置插入数据
			list.add(list.size() / 2 ,number);
		}
		long end = System.currentTimeMillis();
	     System.out.printf("在%s 最中间插入%d条数据，总共耗时 %d 毫秒 %n", type, total, end - start);
	}
}

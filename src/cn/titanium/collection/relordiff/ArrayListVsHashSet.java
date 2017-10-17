package cn.titanium.collection.relordiff;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Arraylist 和HashSet区别
 * @author Administrator
 *2017年10月17日下午11:23:45
 */
public class ArrayListVsHashSet {
	public static void main(String[] args) {
		
		// 1 : 是否有顺序
	/*	ArrayList: 有顺序
		HashSet: 无顺序

		HashSet的具体顺序，既不是按照插入顺序，也不是按照hashcode的顺*/
		
		    ArrayList<Integer> numberList =new ArrayList<Integer>();
	        //List中的数据按照插入顺序存放
	        System.out.println("----------List----------");
	        System.out.println("向List 中插入 9 5 1");
	        numberList.add(9);
	        numberList.add(5);
	        numberList.add(1);
	        System.out.println("List 按照顺序存放数据:");
	        System.out.println(numberList);
	        System.out.println("----------Set----------");
	        HashSet<Integer> numberSet =new HashSet<Integer>();
	        System.out.println("向Set 中插入9 5 1");
	        //Set中的数据不是按照插入顺序存放
	        numberSet.add(9);
	        numberSet.add(5);
	        numberSet.add(1);
	        System.out.println("Set 不是按照顺序存放数据:");
	        System.out.println(numberSet);
	        
	        //2 : 能否重复
	       /* List中的数据可以重复
	        Set中的数据不能够重复
	                       重复判断标准是:
	                       首先看hashcode是否相同
			如果hashcode不同，则认为是不同数据
		            如果hashcode相同，再比较equals，如果equals相同，则是相同数据，否则是不同数据*/
	        ArrayList<Integer> numberList1 =new ArrayList<Integer>();
	        //List中的数据可以重复
	        System.out.println("----------List----------");
	        System.out.println("向List 中插入 9 9");
	        numberList1.add(9);
	        numberList1.add(9);
	        System.out.println("List 中出现两个9:");
	        System.out.println(numberList1);
	        System.out.println("----------Set----------");
	        HashSet<Integer> numberSet1 =new HashSet<Integer>();
	        System.out.println("向Set 中插入9 9");
	        //Set中的数据不能重复
	        numberSet1.add(9);
	        numberSet1.add(9);
	        System.out.println("Set 中只会保留一个9:");
	        System.out.println(numberSet1);
	        
	        //3 : 练习-不重复的随机数
	        /*生成50个 0-9999之间的随机数，要求不能有重复的*/
	        Set<Integer> num = new HashSet<Integer>();	       
	        for (int i = 0; i < 50; i++) {
	        	 int random=(int)( Math.random() * 10000);
	        	 num.add(random);
			}
	        System.out.println("得到50个不重复随机数：");
	        System.out.println(num);
	        
	        
	}
}

package cn.titanium.collection.othercollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Collections
 * @author Administrator
 *2017年10月17日下午11:03:39
 */
public class Collectionss {
	public static void main(String[] args) {
		
		//Collections是一个类，容器的工具类,就如同Arrays是数组的工具类
		//1 : 反转  reverse 使List中的数据发生发转
		  //初始化集合numbers
        List<Integer> numbers = new ArrayList<>();
         
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
         
        System.out.println("集合中的数据:");
        System.out.println(numbers);
        Collections.reverse(numbers);
        System.out.println("翻转后集合中的数据:");
        System.out.println(numbers);
        
        //2 : 混淆  shuffle 混淆List中数据的顺序
        Collections.shuffle(numbers);
        System.out.println("混淆后集合中的数据:");
        System.out.println(numbers);
        
        //3 : 排序  sort 对List中的数据进行排序
        Collections.sort(numbers);
        System.out.println("排序后集合中的数据:");
        System.out.println(numbers);
        
        //4 : 交换  swap 交换两个数据的位置
        System.out.println("集合中的数据:");
        System.out.println(numbers);
        Collections.swap(numbers, 0, 5);
        System.out.println("交换后集合中的数据:");
        System.out.println(numbers);
        
        //5 : 滚动  rotate 把List中的数据，向右滚动指定单位的长度
        System.out.println("集合中的数据:");
        System.out.println(numbers);
        Collections.rotate(numbers, 2);
        System.out.println("把集合向右滚动2个单位，标的数据后，集合中的数据:");
        System.out.println(numbers);
        
        //6 : 线程安全化
        //synchronizedList 把非线程安全的List转换为线程安全的List。
 /*       System.out.println("把非线程安全的List转换为线程安全的List");
        List<Integer> iList = new ArrayList<Integer>();
        List<Integer> snyc =(List<Integer>) Collections.synchronizedCollection(iList);*/
        
        // 7 : 练习-统计概率
	     /*   首先初始化一个List,长度是10，值是0-9。
	              然后不断的shuffle，直到前3位出现
	        3 1 4

        shuffle 1000,000 次，统计出现的概率*/
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
			list.add(i);
		}
        int count = 0;
        for (int i = 0; i < 1000 * 1000; i++) {
			Collections.shuffle(list);
			if(list.get(0)== 3 && list.get(1) == 1 && list.get(2) == 4){
				count++;
			}
		}
        double rate = count/(1000d*1000);
        System.out.println("出现的概率是"+rate*100+"%");
        
        
	}
}

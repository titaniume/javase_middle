package cn.titanium.collection.relordiff;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * HashSet LinkedHashSet TreeSet
 * @author Administrator
 *2017年10月18日上午12:48:46
 */
public class OthersSet {
	
	public static void main(String[] args) {
		/*HashSet： 无序
		LinkedHashSet： 按照插入顺序
		TreeSet： 从小到大排序*/
		
	   HashSet<Integer> numberSet1 =new HashSet<Integer>();
        //HashSet中的数据不是按照插入顺序存放
        numberSet1.add(88);
        numberSet1.add(8);
        numberSet1.add(66);
          
        System.out.println(numberSet1);
        
        
        LinkedHashSet<Integer> numberSet2 =new LinkedHashSet<Integer>();
        //LinkedHashSet中的数据是按照插入顺序存放
        numberSet2.add(88);
        numberSet2.add(8);
        numberSet2.add(888);
        System.out.println(numberSet2);
        
        TreeSet<Integer> numberSet3 =new TreeSet<Integer>();
        //TreeSet 中的数据是进行了排序的
        numberSet3.add(88);
        numberSet3.add(8);
        numberSet3.add(888);
          
        System.out.println(numberSet3);
        
        // 2 : 练习-既不重复，又有顺序
        //利用LinkedHashSet的既不重复，又有顺序的特性，把Math.PI中的数字，按照出现顺序打印出来，相同数字，只出现一次
        Set<Integer> sList =new LinkedHashSet<Integer>();
        String str = String.valueOf(Math.PI);
        //去掉点
        str= str.replace(".", "");
        char [] cr =str.toCharArray();
        for (char c : cr) {
			int num = Integer.parseInt(String.valueOf(c));
		    sList.add(num);
		}
        System.out.printf("%s中的无重复数字是：%n",String.valueOf(Math.PI));
        System.out.println(sList);
	}
}

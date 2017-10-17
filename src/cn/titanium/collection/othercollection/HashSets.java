package cn.titanium.collection.othercollection;

import java.util.HashSet;
import java.util.Iterator;

/**
 * HashSet
 * @author Administrator
 *2017年10月17日下午9:07:19
 */
public class HashSets {
	public static void main(String[] args) {
		//1 : 元素不能重复
		//Set中的元素，不能重复
		HashSet<String> hs = new HashSet<String>();
		hs.add("德玛西亚");
		System.out.println(hs);
		
		//第二次插入同样的数据，是插不进去的，容器中只会保留一个
		hs.add("德玛西亚");
		System.out.println(hs);
		
		// 2 : 没有顺序
		/*Set中的元素，没有顺序。 
		严格的说，是没有按照元素的插入顺序排列
		HashSet的具体顺序，既不是按照插入顺序，也不是按照hashcode的顺序
		不保证Set的迭代顺序; 确切的说，在不同条件下，元素的顺序都有可能不一样
		*/
	     HashSet<Integer> numbers = new HashSet<Integer>();
	     numbers.add(8);
	     numbers.add(7);
	     numbers.add(3);
	     numbers.add(2);
	     //Set元素排列，不是按照插入顺序
	     System.out.println(numbers);
	     //3 : 遍历
	     /*Set不提供get()来获取指定位置的元素 
	     	所以遍历需要用到迭代器，或者增强型for循环*/
	     HashSet<Integer> hst = new HashSet<Integer>();    
	     for (int i = 0; i <20; i++) {
			hst.add(i);
		}
	     //Set不提供get方法来获取指定位置的元素
         //numbers.get(0)
         //遍历Set可以采用迭代器iterator
	    Iterator<Integer> it = hst.iterator();
	    while (it.hasNext()) {
			Integer num = it.next();
			System.out.print(num +" ");
			
		}
	    System.out.println(" ");
	    for ( Iterator<Integer> its = hst.iterator();its.hasNext();) {
			Integer num = its.next();
			System.out.print(num +" ");
		}
	    System.out.println("  ");
	    for (Integer integer : hst) {
			System.out.print(integer+" ");
		}
	    System.out.println(" ");
	    //4:HashSet和HashMap的关系
	   /* 通过观察HashSet的源代码（如何查看源代码）
	            可以发现HashSet自身并没有独立的实现，而是在里面封装了一个Map.
	    HashSet是作为Map的key而存在的
	            而value是一个命名为PRESENT的static的Object对象，因为是一个类属性，所以只会有一个。*/
	    
	    
	 //   练习-HashSet
	    String[] str = new String[100];
      // 初始化
	  for (int i = 0; i < str.length; i++) {
		str[i] =randomString(2);
	  }
	 //打印
	 for (int i = 0; i < str.length; i++) {
		System.out.print(str[i] + " ");
		if(19 == i % 20){
			 System.out.println();
		}
      }
	 
	 HashSet<String> result = new HashSet<>();
	 for (String s1 : str) {
		int repeat = 0;
		for (String s2 : str) {
			if(s1.equalsIgnoreCase(s2)){
				repeat ++;
				if(2 == repeat){
					//当repeat==2的时候，就找到了一个非己的从重复字符串
					result.add(s2);
					break;
				}
			}
		}
	} 
	 System.out.printf("总共有 %d种重复的字符串%n", result.size());
	 if(result.size()!=0){
		 System.out.println("分别是：");
		 for (String s : result) {
			System.out.print(s +" ");
		}
	 }
	    
	}
	
	  private static String randomString(int length) {
	        String pool = "";
	        for (short i = '0'; i <= '9'; i++) {
	            pool += (char) i;
	        }
	        for (short i = 'a'; i <= 'z'; i++) {
	            pool += (char) i;
	        }
	        for (short i = 'A'; i <= 'Z'; i++) {
	            pool += (char) i;
	        }
	        char cs[] = new char[length];
	        for (int i = 0; i < cs.length; i++) {
	            int index = (int) (Math.random() * pool.length());
	            cs[i] = pool.charAt(index);
	        }
	        String result = new String(cs);
	        return result;
	    }
}

package cn.titanium.collection.others;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 比价器
 * @author Administrator
 *2017年10月18日上午9:36:04
 */
public class Comparators {
	public static void main(String[] args) {
		
		
		// 1 : Comparator
		/*假设Hero有三个属性 name,hp,damage
		一个集合中放存放10个Hero,通过Collections.sort对这10个进行排序
		那么到底是hp小的放前面？还是damage小的放前面？Collections.sort也无法确定
		所以要指定到底按照哪种属性进行排序
		这里就需要提供一个Comparator给定如何进行两个对象之间的大小比较*/
		
		// 2 : Comparable
		/*使Hero类实现Comparable接口
		在类里面提供比较算法
		Collections.sort就有足够的信息进行排序了，也无需额外提供比较器Comparator*/
		
		// 3 : 练习-自定义顺序的TreeSet
	/*	默认情况下，TreeSet中的数据是从小到大排序的，不过TreeSet的构造方法支持传入一个Comparator
		 
		public TreeSet(Comparator comparator) 
		 

		通过这个构造方法创建一个TreeSet，使得其中的的数字是倒排序的*/
		
		Comparator<Integer> cmp = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		};
		

		Set<Integer> treeset =new TreeSet<Integer>(cmp);
		for(int i = 0; i< 10; i++){
			treeset.add(i);
		}
		
		System.out.println(treeset);
		
		// 5 : 练习-Comparable
		/*借助Comparable接口，使Item具备按照价格从高到低排序。
		初始化10个Item,并且用Collections.sort进行排序，查看排序结果*/
		
		
	}
}

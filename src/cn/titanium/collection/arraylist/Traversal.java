package cn.titanium.collection.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.titanium.collection.pojo.Hero;

/**
 * 遍历
 * @author Administrator
 *2017年10月17日下午5:22:05
 */
public class Traversal {
	public static void main(String[] args) {
		
		// 1 : 用for循环遍历
		/*我们知道可以用size()和get()分别得到大小，和获取指定位置的元素，结合for循环就可以遍历出ArrayList的内容*/
		 List<Hero> heros = new ArrayList<Hero>();
		 //放5个hero
		 for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero " +i));
		}
		 
		 // 第一种遍历 for循环
		 for (int i = 0; i < heros.size(); i++) {
			Hero hero = heros.get(i);
			System.out.println(hero);
		}
		 
		  System.out.println("--------使用while的iterator-------");
		 // 2 : 迭代器遍历
		 //使用迭代器Iterator遍历集合中的元素
		 Iterator<Hero> it = heros.iterator();
		  //从最开始的位置判断"下一个"位置是否有数据
	      //如果有就通过next取出来，并且把指针向下移动
	      //直达"下一个"位置没有数据
		 while(it.hasNext()){
			 Hero hero = it.next();
			System.out.println(hero);
		 }
		 
		 System.out.println("--------使用增强型for循环-------");
		 // 3 : 用增强型for循环
		/* 使用增强型for循环可以非常方便的遍历ArrayList中的元素，这是很多开发人员的首选。

		 不过增强型for循环也有不足：
		 无法用来进行ArrayList的初始化
		 无法得知当前是第几个元素了，当需要只打印单数元素的时候，就做不到了。 必须再自定下标变量。*/
		 for (Hero hero : heros) {
			System.out.println(hero);
		}
		 
		 // 4 : 练习-删除ArrayList中的数据
		/* 首先初始化一个Hero集合，里面放100个Hero对象，名称分别是从
		 hero 0
		 hero 1
		 hero 2
		 ...
		 hero 99.

		 通过遍历的手段，删除掉名字编号是8的倍数的对象*/
		 List<Hero> hs = new ArrayList<Hero>();
		 //放5个hero
		 for (int i = 0; i < 100; i++) {
			hs.add(new Hero("hero"+i));
		}
		//准别一个临时容器，专门用来删除对象
		 List<Hero> tempList = new ArrayList<Hero>(); 
		 for (Hero hero : hs) {
			int id = Integer.parseInt(hero.name.substring(4));
			 if (0 == id % 8)
				 tempList.add(hero);
		}
		 
		 for (Hero hero : tempList) {
			 hs.remove(hero);
		}
		 System.out.println(hs);
		 
	}
}

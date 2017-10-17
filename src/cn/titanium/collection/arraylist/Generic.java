package cn.titanium.collection.arraylist;


import java.util.ArrayList;
import java.util.List;

import cn.titanium.collection.arraylist.generic.LOL;
import cn.titanium.collection.pojo.Hero;
import cn.titanium.collection.pojo.Item;

/**
 * 泛型
 * @author Administrator
 *2017年10月17日下午4:53:08
 */
public class Generic {
	
	public static void main(String[] args) {
		
		//1 : 泛型 Generic
		/*不指定泛型的容器，可以存放任何类型的元素
		指定了泛型的容器，只能存放指定类型的元素以及其子类*/
		
		//2 : 泛型的简写
		/*为了不使编译器出现警告，需要前后都使用泛型，像这样：
		List<Hero> genericheros = new ArrayList<Hero>();
		
		不过JDK7提供了一个可以略微减少代码量的泛型简写方式
		List<Hero> genericheros2 = new ArrayList<>();*/
		
		  List<Hero> genericheros = new ArrayList<Hero>();
	      List<Hero> genericheros2 = new ArrayList<>();
	      
	     
	     // 3 : 泛型的系统学习
	     //后面涉及
	      
	     // 4 : 练习-支持泛型的ArrayList 
	     /* 借助泛型和前面学习的面向对象的知识，设计一个ArrayList，使得这个ArrayList里，
	                    又可以放Hero，又可以放Item,但是除了这两种对象，其他的对象都不能放*/
	      List<LOL>  lolList = new ArrayList<>();
	      lolList.add(new Hero("大傻逼"));
	      lolList.add(new Item("砍刀"));
	      LOL a = lolList.get(0);
	      LOL b= lolList.get(1);
	      System.out.println(a +"       "+b);
	}
}

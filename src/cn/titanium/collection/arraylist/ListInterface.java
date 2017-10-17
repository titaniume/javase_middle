package cn.titanium.collection.arraylist;


import java.util.ArrayList;
import java.util.List;

import cn.titanium.collection.pojo.Hero;

/**
 * list接口
 * @author Administrator
 *2017年10月17日下午4:48:12
 */
public class ListInterface {

	public static void main(String[] args) {
		// 1 : ArrayList和ListArrayList实现了接口List
		/*ArrayList实现了接口List
		常见的写法会把引用声明为接口List类型
		注意：是java.util.List,而不是java.awt.List*/
	    //接口引用指向子类对象（多态）
		 List heros = new ArrayList();
		 heros.add(new Hero("德玛西亚"));
		 System.out.println(heros.size());
		 
		 //2 : List接口的方法
	/*	 因为ArrayList实现了List接口，所以List接口的方法ArrayList都实现了。
		 在ArrayList 常用方法章节有详细的讲解，在此不作赘述*/
	}
	
}

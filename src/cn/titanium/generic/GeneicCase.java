package cn.titanium.generic;

import java.util.ArrayList;

import cn.titanium.generic.wildcard.ADHero;
import cn.titanium.generic.wildcard.Hero;


/**
 * 泛型转换
 * @author Administrator
 *2017年10月18日下午4:45:01
 */
public class GeneicCase {
	
	public static void main(String[] args) {
		
		// 1 : 对象转型
		/*根据面向对象学习的知识，子类转父类 是一定可以成功的*/
		 Hero h = new Hero();
		 ADHero ad = new ADHero();
		 //子类转父类
		 h=ad;
		 
		 //2 : 子类泛型转父类泛型
	/*	 既然 子类对象 转 父类对象是可以成功的，那么子类泛型转父类泛型能成功吗？
		 如代码 
		 hs的泛型是父类Hero
		 adhs 的泛型是子类ADHero

		 那么 把adhs转换为hs能成功吗？
		 代码比较 复制代码*/
		 
		  ArrayList<Hero> hs =new ArrayList<>();
		  ArrayList<ADHero> adhs =new ArrayList<>();
		  //子类泛型转父类泛型
		 // hs = adhs;
		  //不可以，会矛盾
		  
		 // 4 : 练习-父类泛型能否转换为子类泛型？
		  
/*
		假设能成功
		这个时候adhs实际上指向的是泛型是Hero的容器,而这个容器里可能放的是一个APHero
		而根据泛型，直接取出来就转型成了ADHero
		所以就变成了APHero转型成ADHero，这是矛盾的。 
		所以反推，父类泛型不能转型为子类泛型*/
		  //adhs = hs;
		  
	}
}

package cn.titanium.lambda.hellolambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import cn.titanium.collection.others.Comparators;

/**
 * 比较器--lambda方式
 * 
 * @author Administrator 2017年10月18日下午5:29:26
 */
public class TestCollection {
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();

		for (int i = 0; i < 10; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(100), r.nextInt(100)));
		}
		System.out.println("初始化后的集合：");
		System.out.println(heros);
		
		//匿名类
		Comparator<Hero> c = new Comparator<Hero>() {
			
			@Override
			public int compare(Hero h1, Hero h2) {
				// TODO Auto-generated method stub
				 return h1.hp>=h2.hp?1:-1;
			}
		};
		
		//Lambda表达式
		c =(Hero h1,Hero h2)->{
			return h1.hp>= h2.hp?1:-1;
		};
		//去掉 return和大括号
		c =(Hero h1,Hero h2)->h1.hp>= h2.hp?1:-1;
		//去掉 参数类型       //有两个参数，无法去掉圆括号
		c =( h1, h2)->h1.hp>= h2.hp?1:-1;
		Collections.sort(heros,c);
		
		//直接把Lambda表达式作为参数传进去
       // Collections.sort(heros,(h1, h2)->h1.hp>=h2.hp?1:-1);
        System.out.println(heros);
	}
}

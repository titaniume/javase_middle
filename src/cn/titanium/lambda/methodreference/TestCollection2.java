package cn.titanium.lambda.methodreference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import cn.titanium.lambda.hellolambda.Hero;

//-引用构造器实现比较器-Comparator  排序
public class TestCollection2 {
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();

		for (int i = 0; i < 10; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(100), r.nextInt(100)));
		}
		System.out.println("初始化后的集合：");
		System.out.println(heros);

		Comparator<Hero> c = (h1,h2) ->h1.compareHero(h2);
		Collections.sort(heros,c);
		
		
		Collections.sort(heros,Hero::compareHero);
		System.out.println(heros);
	}
	
	
}

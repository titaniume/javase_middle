package cn.titanium.lambda.poloperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import cn.titanium.lambda.hellolambda.Hero;

/**
 * 结束操作
 * 
 * @author Administrator 2017年10月18日下午6:52:13
 */
public class TestAggregate1 {
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
		}
		System.out.println("遍历集合中的每个数据");		
		heros
			.stream()
			.forEach(h->System.out.println(h));
		System.out.println("返回一个数组");
		Object [] hs = heros
				.stream()
				.toArray();
		System.out.println(Arrays.toString(hs));
		System.out.println("返回伤害最低的那个英雄");
		Hero minDamageHero = 
		heros
			.stream()
			.min((h1,h2)->h1.damage-h2.damage)
			.get();
		System.out.println(minDamageHero);
		System.out.println("返回伤害最高的那个英雄");
		Hero maxDamageHero =
	    heros
	    	.stream()
	    	.max((h1,h2)->h1.damage-h2.damage)
	    	.get();
		System.out.println(maxDamageHero);
		System.out.println("流中数据的总数");
		long count = heros
				.stream()
				.count();
		System.out.println(count);
		System.out.println("第一个英雄");
		Hero firstHero = 
		heros
			.stream()
			.findFirst()
			.get();
		System.out.println(firstHero);
		
		// 6 : 练习-聚合操作
		/*首选准备10个Hero对象，hp和damage都是随机数。
		分别用传统方式和聚合操作的方式，把hp第三高的英雄名称打印出来*/
	}
}

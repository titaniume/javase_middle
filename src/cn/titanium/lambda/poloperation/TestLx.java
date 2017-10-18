
package cn.titanium.lambda.poloperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import cn.titanium.lambda.hellolambda.Hero;

/**
 * 练习
 * @author Administrator
 *2017年10月18日下午7:00:43
 */
public class TestLx {
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 10; i++) {
			heros.add(new Hero("heros"+i, r.nextInt(1000), r.nextInt(100)));
		}
		System.out.println("遍历集合中的每个数据");	
		heros
			.stream()
			.forEach(h->System.out.println(h));
		Collections.sort(heros,new Comparator<Hero>() {

			@Override
			public int compare(Hero h1,Hero h2) {
				// TODO Auto-generated method stub
				return (int)(h2.hp - h1.hp);
			}
		}); 	
		//获取第三个
		Hero hero = heros.get(2);
		System.out.println("通过传统方式找出来的hp第三高的英雄名称是:" + hero.name);
		
		
		//聚合方式
		String name =
	    heros
	    	.stream()
	    	.sorted((h1,h2)->h1.hp>h2.hp?-1:1)
	    	.skip(2)
	    	.map(h->h.getName())
	    	.findFirst()
	    	.get();

        System.out.println("通过聚合操作找出来的hp第三高的英雄名称是:" + name);
	}
}

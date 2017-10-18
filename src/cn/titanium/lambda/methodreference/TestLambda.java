package cn.titanium.lambda.methodreference;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.titanium.lambda.hellolambda.Hero;
import cn.titanium.lambda.hellolambda.HeroChecker;

public class TestLambda {
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
		}
		System.out.println("初始化后的集合：");
		System.out.println(heros);
		HeroChecker c = new HeroChecker() {
			
			@Override
			public boolean test(Hero h) {
				// TODO Auto-generated method stub
				return h.hp>100 && h.damage<50;
			}
		};
		
//		 System.out.println("使用匿名类过滤");
//		 filter(heros, c);
//		 System.out.println("使用Lambda表达式");
//		 filter(heros, h->h.hp>100 && h.damage<50);
//		 System.out.println("在Lambda表达式中使用静态方法");
//		 filter(heros, h-> TestLambda.testHero(h));
//		 System.out.println("直接引用静态方法");
//		 filter(heros, TestLambda::testHero);
		
		  System.out.println("使用引用对象方法  的过滤结果：");
	      //使用类的对象方法
	      TestLambda testLambda = new TestLambda();
	     // filter(heros, testLambda::testHero);
	      
	     //使用容器中的方法
	     //filter(heros, h->h.matched());
	      filter(heros, Hero::matched);
	}

	public static boolean testHero(Hero h) {
		return h.hp > 100 && h.damage < 50;
	}

	private static void filter(List<Hero> heros, HeroChecker checker) {
		for (Hero hero : heros) {
			if (checker.test(hero))
				System.out.print(hero);
		}
	}
}

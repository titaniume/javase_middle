package cn.titanium.lambda.hellolambda;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * 匿名类
 * @author Administrator
 *2017年10月18日下午5:16:36
 */
public class TestLambda1 {
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 10; i++) {
			heros.add(new Hero("hero" +i, r.nextInt(1000), r.nextInt(100)));
		}
		System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("筛选出 hp>100 && damange<50的英雄");
        HeroChecker hc = new HeroChecker() {
			
			@Override
			public boolean test(Hero h) {
			  
				return  h.hp > 100 && h.damage<50;
			}
		};
		filter(heros, hc);
	}
	
	public static void filter(List<Hero> hero,HeroChecker hc){
		for (Hero h : hero) {
			if(hc.test(h)){
				System.out.println(h);
			}
		}
	}
}

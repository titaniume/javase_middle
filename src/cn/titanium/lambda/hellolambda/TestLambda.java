package cn.titanium.lambda.hellolambda;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * 普通方式
 * @author Administrator
 *2017年10月18日下午5:16:36
 */
public class TestLambda {
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for (int i = 0; i < 10; i++) {
			heros.add(new Hero("hero" +i, r.nextInt(1000), r.nextInt(100)));
		}
		System.out.println("初始化后的集合：");
        System.out.println(heros);
        System.out.println("筛选出 hp>100 && damange<50的英雄");
        filter(heros);
	}
	
	public static void filter(List<Hero> hero){
		for (Hero h : hero) {
			if(h.hp >100 && h.damage<50){
				System.out.println(h);
			}
		}
	}
}

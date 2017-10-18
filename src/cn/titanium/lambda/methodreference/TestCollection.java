package cn.titanium.lambda.methodreference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import cn.titanium.lambda.hellolambda.Hero;

//-引用静态方法实现比较器-Comparator  排序
public class TestCollection {
	public static void main(String[] args) {
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();

		for (int i = 0; i < 10; i++) {
			heros.add(new Hero("hero " + i, r.nextInt(100), r.nextInt(100)));
		}
		System.out.println("初始化后的集合：");
		System.out.println(heros);

		
		Collections.sort(heros,(h2,h1)->TestCollection.compare(h1, h2));
		Collections.sort(heros,TestCollection::compare);
		System.out.println(heros);
	}
	
	public static int compare(Hero h1,Hero h2){
		return h1.hp>=h2.hp?1:-1;
	}
}

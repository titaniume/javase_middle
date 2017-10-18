package cn.titanium.collection.others.comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import cn.titanium.collection.others.Item;

public class TestItem {
	public static void main(String[] args) {
		
		Random r = new Random();
		List<Item> items = new ArrayList<Item>();
		for (int i = 0; i <10 ; i++) {
			items.add(new Item("Item"+i, r.nextInt(100)));
		}
		System.out.println("初始化Item:");
		System.out.println(items);
		System.out.println("使用Comparable接口排序后：");
		Collections.sort(items);
		System.out.print(items);
		
	}
}

package cn.titanium.collection.pojo;

import cn.titanium.collection.arraylist.generic.LOL;

public class Item implements LOL{

	String name;
	int price;

	public Item() {

	}

	// 初始化Item
	public Item(String name) {
		this.name = name;
	}

	public void effect() {
		System.out.println("物品使用后，可以有效果");
	}
	
	public String toString(){
		return name;
	}
	
}

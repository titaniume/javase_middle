package cn.titanium.collection.relordiff;

import java.util.HashMap;
import java.util.Set;

/**
 * Hash 
 * @author Administrator
 *2017年10月18日上午12:23:17
 */
public class HashMapVsHashTable {
	public static void main(String[] args) {
		
		//HashMap和Hashtable的区别
		/*HashMap和Hashtable都实现了Map接口，都是键值对保存数据的方式
		区别1： 
		HashMap可以存放 null
		Hashtable不能存放null
		区别2：
		HashMap不是线程安全的类
		Hashtable是线程安全的类
		鉴于目前学习的进度，不对线程安全做展开，在线程章节会详细讲解*/
		
		//HashMap和Hashtable都实现了Map接口，都是键值对保存数据的方式
		HashMap<String,String> hashMap = new HashMap<String,String>();
		//HashMap 可以用null 作为key,作value
		hashMap.put("null","123");
		hashMap.put("123","null");
		
		HashMap<String, String> hasTable = new HashMap<String, String>();
		//HashTable 不能null，作为key,value
		hasTable.put(null, "123");
		hasTable.put("123", null);
		
		//2 : 练习-反转key和value 
		/*使用如下键值对，初始化一个HashMap：
		adc - 物理英雄
		apc - 魔法英雄
		t - 坦克

		对这个HashMap进行反转，key变成value,value变成key
		提示： keySet()可以获取所有的key, values()可以获取所有的value*/
		  HashMap<String,String> map = new HashMap<>();
	      HashMap<String,String> temp = new HashMap<>();
	      map.put("adc", "物理英雄");
	      map.put("apc", "魔法英雄");
	      map.put("t", "坦克");
	      
        System.out.println("初始化后的Map:");
        System.out.println(map);
        Set<String> keys = map.keySet();
        for (String key : keys) {
            String value = map.get(key);
            temp.put(value, key);
        }
        map.clear();
        map.putAll(temp);
        System.out.println("反转后的Map:");
        System.out.println(map);
	}
}

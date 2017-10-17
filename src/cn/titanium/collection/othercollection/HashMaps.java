package cn.titanium.collection.othercollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.titanium.collection.pojo.Hero;

/**
 * HashMap
 * 
 * @author Administrator 2017年10月17日下午7:29:55
 */
public class HashMaps {
	public static void main(String[] args) {
		//1 : HashMap的键值对
		/*HashMap储存数据的方式是—— 键值对*/
		HashMap<String, String> dictionary = new HashMap<>();

		dictionary.put("adc", "物理英雄");
		dictionary.put("apc", "魔法英雄");
		dictionary.put("t", "坦克");

		System.out.println(dictionary.get("adc"));
		
		
		// 2 : 键不能重复，值可以重复
		/*对于HashMap而言，key是唯一的，不可以重复的。 
		所以，以相同的key 把不同的value插入到 Map中会导致旧元素被覆盖，只留下最后插入的元素。 
		不过，同一个对象可以作为值插入到map中，只要对应的key不一样*/
		
		HashMap<String,Hero> heroMap = new HashMap<String,Hero>();
		heroMap.put("dema", new Hero("德玛西亚"));
		System.out.println(heroMap);
		
		 //key为dema已经有value了，再以dema作为key放入数据，会导致原英雄，被覆盖
        //不会增加新的元素到Map中
        heroMap.put("dema", new Hero("de德玛西亚"));
        System.out.println(heroMap);
        
        //清空map
        heroMap.clear();
        Hero gareen = new Hero("gareen");
        
        //同一个对象可以作为值插入到map中，只要对应的key不一样
        heroMap.put("hero1", gareen);
        heroMap.put("hero2", gareen);
        System.out.println(heroMap);
        
        // 3 : 练习-查找内容性能比较
       /* 准备一个ArrayList其中存放3000000(三百万个)Hero对象，其名称是随机的,格式是hero-[4位随机数]
        		hero-3229
        		hero-6232
        		hero-9365
        		...

        		因为总数很大，所以几乎每种都有重复，把名字叫做 hero-5555的所有对象找出来
        		要求使用两种办法来寻找
        		1. 不使用HashMap，直接使用for循环找出来，并统计花 费的时间
        		2. 借助HashMap，找出结果，并统计花费的时间*/
       
        List<Hero> hs =new ArrayList<>();
        System.out.println("初始化开始");
        for (int i = 0; i < 3000000; i++) {
            Hero h = new Hero(   "hero-" + random());
            hs.add(h);
        }
        //名字作为key
        //名字相同的hero，放在一个List中，作为value
        HashMap<String, List<Hero>> hMap = new HashMap<String, List<Hero>>();
        for (Hero hero : hs) {
			List<Hero> list = hMap.get(hero.name);
			if(null == list){
				list = new ArrayList<Hero>();
				hMap.put(hero.name, list);
			}
			list.add(hero);
		}
        System.out.println("初始化结束");
        System.out.println("开始查找");
        findByIteration(hs);
        findByMap(hMap);
      
	}

	private static List<Hero> findByMap(HashMap<String,List<Hero>> m) {
		long start =System.currentTimeMillis();
        List <Hero>result= m.get("hero-6666");
        long end =System.currentTimeMillis();
        System.out.printf("通过map查找，一共找到%d个英雄，耗时%d 毫秒%n",result.size(),end-start);
        return result;
		
	}

	private static List<Hero> findByIteration(List<Hero> hs) {
		    long start =System.currentTimeMillis();
	        List<Hero> result =new ArrayList<>();
	        for (Hero h : hs) {
	            if(h.name.equals("hero-6666")){
	                result.add(h);
	            }
	        }
	        long end =System.currentTimeMillis();
	        System.out.printf("通过for查找，一共找到%d个英雄，耗时%d 毫秒%n", result.size(),end-start);
	        return result;
		
	}

	private static int random() {
		// TODO Auto-generated method stub
		 return ((int)(Math.random()*9000)+1000);
	}
}	

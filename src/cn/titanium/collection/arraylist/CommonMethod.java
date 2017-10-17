package cn.titanium.collection.arraylist;

import java.util.ArrayList;

import cn.titanium.collection.Hero;

/**
 * 常用的方法
 * @author Administrator
 *2017年10月17日下午12:07:08
 */
public class CommonMethod {
	public static void main(String[] args) {
		
		
		// 1 : 增加
		/*add 有两种用法
		第一种是直接add对象，把对象加在最后面
		 
		heros.add(new Hero("hero " + i));
		 

		第二种是在指定位置加对象
		 
		heros.add(3, specialHero);*/
		
		ArrayList<Hero> heros = new ArrayList<Hero>();
		// 把5个对象加入到ArrayList中
		for (int i = 0; i < 5; i++) {
			heros.add(new Hero("hero"+i));
		}
		System.out.println(heros.size());
	
        // 在指定位置增加对象
		Hero specialHero = new Hero("new hero");
		heros.add(2, specialHero);
		System.out.println(heros.size());
		
		
		
		//步骤 2 : 判断是否存在
		/*通过方法contains 判断一个对象是否在容器中
		判断标准： 是否是同一个对象，而不是name是否相同*/
		 System.out.print("虽然一个新的对象名字也叫 hero 1，但是contains的返回是:");
		 System.out.println(heros.contains(new Hero("hero 1")));
		 System.out.print("而对specialHero的判断，contains的返回是:");
	     System.out.println(heros.contains(specialHero));
		
	     
	     //3 : 获取指定位置的对象
	     /*通过get获取指定位置的对象，如果输入的下标越界，一样会报错*/
	     //获取指定位置的对象
	     System.out.println(heros.get(5));
	    // System.out.println(heros.get(6));
		
	     
	   //  4 : 获取对象所处的位置
	  /* indexOf用于判断一个对象在ArrayList中所处的位置
	          与contains一样，判断标准是对象是否相同，而非对象的name值是否相等*/
	   System.out.println("specialHero所处的位置:"+heros.indexOf(specialHero));
	   System.out.println("新的英雄，但是名字是\"hero 1\"所处的位置:"+heros.indexOf(new Hero("hero 1")));
	
	  // 5 : 删除
	  /* remove用于把对象从ArrayList中删除
	   remove可以根据下标删除ArrayList的元素*/
	   
	   
	   heros.remove(2);
       System.out.println("删除下标是2的对象");
       System.out.println(heros.size());
       System.out.println("删除special hero");
       heros.remove(specialHero);
       System.out.println(heros.size());
       
       
       //6 : 替换
      /* set用于替换指定位置的元素*/
       System.out.println("把下标是5的元素，替换为\"hero 5\"");
       heros.set(2, new Hero("hero 5"));
       System.out.println(heros.toString());
       
       
       //7 : 获取大小
       /*size 用于获取ArrayList的大小*/
       System.out.println("这个list集合的size():"+heros.size());
       
       // 8 : 转换为数组
      /* toArray可以把一个ArrayList对象转换为数组。
	       需要注意的是，如果要转换为一个Hero数组，那么需要传递一个Hero数组类型的对象给toArray()，
	       这样toArray方法才知道，你希望转换为哪种类型的数组，否则只能转换为Object数组*/
       
       Hero[] hs =(Hero[])heros.toArray(new Hero[] {});
       System.out.println("hs数组的长度："+hs.length);
      
       
       //9 : 把另一个容器所有对象都加进来
       /*addAll 把另一个容器所有对象都加进来*/
       //把另一个容器里所有的元素，都加入到该容器里来
       ArrayList newList = new ArrayList();
       newList.addAll(heros);
       System.out.println("把前面的ArrayList的元素都加入到当前ArrayList:");
       System.out.println("newList :\t" +newList.toString());
       
      // 10 : 清空
      /* clear 清空一个ArrayList*/
      /* System.out.println("ArrayList heros:\t" + heros);
       System.out.println("使用clear清空");
       heros.clear();
       System.out.println("ArrayList heros:\t" + heros);*/
       
       // 11 : 练习-判断是否相同
       /*如果就是要判断集合里是否存在一个 name等于 "hero 1"的对象，应该怎么做？*/
       //方法一：
  /*     String name = "hero1";
       for (int i = 0; i < heros.size(); i++) {
		Hero h = (Hero)heros.get(i);
		System.out.println(h);
		if(name.equals(h.getName())){
			System.out.printf("找到了name是%s的对象",name);
			break;
		}
	}*/
       //方法二：
       for (Hero h : heros) {
		 String name = h.getName();
		 if(name.contains("hero1")){
			 System.out.printf("找到了name是%s的对象",name);
				break;
		 }
	}
       
       
       // 13 : 练习-MyStringBuffer
       
	}
}

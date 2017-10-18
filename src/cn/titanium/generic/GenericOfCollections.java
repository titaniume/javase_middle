package cn.titanium.generic;

import java.util.ArrayList;



import java.util.List;

import cn.titanium.generic.genofcollecections.ADHero;
import cn.titanium.generic.genofcollecections.APHero;
import cn.titanium.generic.genofcollecections.Hero;

/**
 * 集合中的泛型
 * @author Administrator
 *2017年10月18日上午10:40:12
 */
public class GenericOfCollections {
	public static void main(String[] args) {
		
		//1 : 不使用泛型
		/*不使用泛型带来的问题
		ADHero（物理攻击英雄） APHero（魔法攻击英雄）都是Hero的子类
		ArrayList 默认接受Object类型的对象，所以所有对象都可以放进ArrayList中
		所以get(0) 返回的类型是Object
		接着，需要进行强制转换才可以得到APHero类型或者ADHero类型。
		如果软件开发人员记忆比较好，能记得哪个是哪个，还是可以的。 但是开发人员会犯错误，比如第20行，会记错，把第0个对象转换为ADHero,这样就会出现类型转换异常*/
	
		ArrayList heros = new ArrayList();
		heros.add(new APHero());
		heros.add(new ADHero());
		
		APHero ap = (APHero)heros.get(0);
		ADHero ad =(ADHero)heros.get(1);
		
		//2 : 使用泛型
		/*使用泛型的好处：
		泛型的用法是在容器后面添加<Type>
		Type可以是类，抽象类，接口
		泛型表示这种容器，只能存放APHero，ADHero就放不进去了。*/
		 ArrayList<APHero> hs = new ArrayList<APHero>();
		 hs.add(new APHero());
		 //ADHero就不能放进去了
		 //hs.add(new ADHero());
		 
		  //获取的时候也不需要进行转型，因为取出来一定是APHero
		 APHero apHero = hs.get(0);
		 
		 
		 //3 : 子类对象
		/*  假设容器的泛型是Hero,那么Hero的子类APHero,ADHero都可以放进去 
		 和Hero无关的类型Item还是放不进去*/
		 ArrayList<Hero> hero = new ArrayList<Hero>();
		 //只有作为Hero的子类可以放进去    
		hero.add(new APHero());
		hero.add(new ADHero());
		
		 //和Hero无关的类型Item还是放不进去
		//hero.add(new Item());
		
		// 4 : 泛型的简写
		//为了不使编译器出现警告，需要前后都使用泛型，像这样：
		/*ArrayList<Hero> heros = new ArrayList<Hero>();
		 

		不过JDK7提供了一个可以略微减少代码量的泛型简写方式
		 
		ArrayList<Hero> heros2 = new ArrayList<>();*/
		
		ArrayList<Hero> hero3 = new ArrayList<Hero>();
        //后面可以只用<>
        ArrayList<Hero> heros4 = new ArrayList<>();
        
        //5 : 练习-泛型
       /*根据数字类的知识，设计一个集合，这个集合里即可以放整数，也可以放浮点数，但是不能放字符串*/
        List<Number> numbers = new ArrayList<Number>();
        numbers.add(123);
        numbers.add(222.123);
        numbers.add(555f);
        //numbers.add("test");
	}
}

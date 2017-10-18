package cn.titanium.generic;

import java.util.ArrayList;

import cn.titanium.generic.wildcard.ADHero;
import cn.titanium.generic.wildcard.APHero;
import cn.titanium.generic.wildcard.Hero;
import cn.titanium.generic.wildcard.Item;

/**
 * 通配符
 * 
 * @author Administrator 2017年10月18日上午11:10:49
 */
public class Wildcard {
	public static void main(String[] args) {

		// 1 : ? extends
		/*
		 * ArrayList heroList<? extends Hero> 表示这是一个Hero泛型或者其子类泛型 heroList
		 * 的泛型可能是Hero heroList 的泛型可能是APHero heroList 的泛型可能是ADHero 所以
		 * 可以确凿的是，从heroList取出来的对象，一定是可以转型成Hero的
		 */

		ArrayList<APHero> apHeroList = new ArrayList<APHero>();
		apHeroList.add(new APHero());
		ArrayList<? extends Hero> heroList = apHeroList;

		Hero hero = heroList.get(0);

		// 但是，不能往里面放东西
		// heroList.add(new ADHero()); //编译错误，因为heroList的泛型 有可能是ADHero

		// 2 : ? super
		/*
		 * ArrayList heroList<? super Hero> 表示这是一个Hero泛型或者其父类泛型
		 * heroList的泛型可能是Hero heroList的泛型可能是Object 可以往里面插入Hero以及Hero的子类
		 * 但是取出来有风险，因为不确定取出来是Hero还是Object
		 */

		// ? super Hero 表示 suList的泛型是Hero或者其父类泛型
		ArrayList<? super Hero> suList = new ArrayList<Object>();

		// 所以就可以插入Hero
		suList.add(new Hero());
		// 也可以插入子类
		suList.add(new ADHero());
		suList.add(new APHero());

		// 但是，不能从里面取数据出来,因为其泛型可能是Object,而Object是强转Hero会失败
		// Hero Hero = suList.get(0);

		// 3 : 泛型通配符?
		/*
		 * 泛型通配符? 代表任意泛型 既然?代表任意泛型，那么换句话说，这个容器什么泛型都有可能
		 * 
		 * 所以只能以Object的形式取出来 并且不能往里面放对象，因为不知道到底是一个什么泛型的容器
		 */

		ArrayList<ADHero> adHero = new ArrayList<ADHero>();
		// //?泛型通配符，表示任意泛型
		ArrayList<?> gList = adHero;

		// ?的缺陷1： 既然?代表任意泛型，那么换句话说，你就不知道这个容器里面是什么类型
		// 所以只能以Object的形式取出来
		Object object = gList.get(0);

		// ?的缺陷2： 既然?代表任意泛型，那么既有可能是Hero,也有可能是Item
		// 所以，放哪种对象进去，都有风险，结果就什么什么类型的对象，都不能放进去
		/*gList.add(new Item()); // 编译错误 因为?代表任意泛型，很有可能不是Item
		gList.add(new Hero()); // 编译错误 因为?代表任意泛型，很有可能不是Hero
		gList.add(new APHero()); // 编译错误 因为?代表任意泛型，很有可能不是APHero
*/	
		
		// 4 : 总结
		/*如果希望只取出，不插入，就使用? extends Hero
		如果希望只取出，不插入，就使用? extends Hero
	           如果希望，又能插入，又能取出，就不要用通配符？*/
		
		//5 : 练习- extends
		
		// 6: 练习-二叉树 
		/*把练习-支持泛型的二叉树改造成 支持泛型 <T extends Comparable>，并在比较的时候使用compare方法*/
		
	}
}

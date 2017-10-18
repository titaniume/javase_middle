package cn.titanium.lambda;

/**
 * jdk 8新特效，lambda
 * @author Administrator
 *2017年10月18日下午5:06:31
 */
public class HelloLambda {
	public static void main(String[] args) {
		
		//1 : 普通方法
		/*使用一个普通方法，在for循环遍历中进行条件判断，筛选出满足条件的数据*/
		
		//2 : 匿名类方式
		/*首先准备一个接口HeroChecker，提供一个test(Hero)方法
		然后通过匿名类的方式，实现这个接口*/
		
		// 3 : Lambda方式
		/*使用Lambda方式筛选出数据
		 
		filter(heros,(h)->h.hp>100 && h.damage<50);		 

		同样是调用filter方法，从上一步的传递匿名类对象，变成了传递一个Lambda表达式进去
		 
		h->h.hp>100 && h.damage<50*/
		
		// 4 : 设置eclipse以支持Lambda
		//菜单->Window->Preferences->Java-Compiler->Compiler compliance leve: 设置为1.8即可
	
		//5 : 从匿名类演变成Lambda表达式
	/*	Lambda表达式可以看成是匿名类一点点演变过来
		1. 匿名类的正常写法
		 
		HeroChecker c1 = new HeroChecker() {
		    public boolean test(Hero h) {
		        return (h.hp>100 && h.damage<50);
		    }
		};
		 
		2. 把外面的壳子去掉
		只保留方法参数和方法体
		参数和方法体之间加上符号 ->
		 
		HeroChecker c2 = (Hero h) ->{
			return h.hp>100 && h.damage<50;
		};
		 
		3. 把return和{}去掉
		 
		HeroChecker c3 = (Hero h) ->h.hp>100 && h.damage<50;
		 
		4. 把 参数类型和圆括号去掉(只有一个参数的时候，才可以去掉圆括号)
		 
		HeroChecker c4 = h ->h.hp>100 && h.damage<50;
		 
		5. 把c4作为参数传递进去
		 
		filter(heros,c4);
		 
		6. 直接把表达式传递进去
		 
		filter(heros, h -> h.hp > 100 && h.damage < 50);*/
		
		//6 : 匿名方法
		/*与匿名类 概念相比较，
		Lambda 其实就是匿名方法，这是一种把方法作为参数进行传递的编程思想。*/
		
		// 7 : Lambda的弊端
		/*Lambda表达式虽然带来了代码的简洁，但是也有其局限性。
		1. 可读性差，与啰嗦的但是清晰的匿名类代码结构比较起来，Lambda表达式一旦变得比较长，就难以理解
		2. 不便于调试，很难在Lambda表达式中增加调试信息，比如日志
		3. 版本支持，Lambda表达式在JDK8版本中才开始支持，如果系统使用的是以前的版本，考虑系统的稳定性等原因，而不愿意升级，那么就无法使用。
		Lambda比较适合用在简短的业务代码中，并不适合用在复杂的系统中，会加大维护成本。*/
		
		// 8 : 练习-Comparator
		/*把比较器-Comparator 章节中的代码，按照从匿名类演变成Lambda表达式的步骤，改写为Lambda表达式*/
	}
}

package cn.titanium.reflex;





/**
 * 获取类对象
 * @author Administrator
 *2017年10月22日下午2:44:03
 */
public class GetClassObject {
	public static void main(String[] args) {
		//类对象概念： 所有的类，都存在一个类对象，这个类对象用于提供一类层面的信息，比如有几种构造方法， 有多少属性，有哪些普通方法。
		//1 : 什么是类对象
		/*在理解类对象之前，先说我们熟悉的对象之间的区别：
		gareen和teemo都是Hero对象，他们的区别在于，各自有不同的名称，血量，伤害值。

		然后说说类之间的区别
		Hero和Item都是类，他们的区别在于有不同的方法，不同的属性。

		类对象，就是用于描述这种类，都有什么属性，什么方法的*/
		
		// 2 : 获取类对象
		/*获取类对象有3种方式
		1. Class.forName
		2. Hero.class
		3. new Hero().getClass()

		在一个JVM中，一种类，只会有一个类对象存在。所以以上三种方式取出来的类对象，都是一样的。

		注： 准确的讲是一个ClassLoader下，一种类，只会有一个类对象存在。通常一个JVM下，只会有一个ClassLoader。因为还没有引入ClassLoader概念， 所以暂时不展开了。*/
	
		 String className = "cn.titanium.reflex.Hero";
         try {
             Class pClass1=Class.forName(className);
             Class pClass2=Hero.class;
             Class pClass3=new Hero().getClass();
             System.out.println(pClass1==pClass2);
             System.out.println(pClass1==pClass3);
         } catch (ClassNotFoundException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
         
         // 3 : 获取类对象的时候，会导致类属性被初始化
         //为Hero增加一个静态属性,并且在静态初始化块里进行初始化，参考 类属性初始化。 
         
         //4 : 练习-在静态方法上加synchronized，同步对象是什么？
		
	}
}

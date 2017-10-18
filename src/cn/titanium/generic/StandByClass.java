package cn.titanium.generic;


/**
 * 支持泛型的类
 * @author Administrator
 *2017年10月18日上午10:56:48
 */
public class StandByClass {
	public static void main(String[] args) {
		
		//1 : 不支持泛型的Stack
//		以Stack栈为例子，如果不使用泛型
//		当需要一个只能放Hero的栈的时候，就需要设计一个HeroStack
//		当需要一个只能放Item的栈的时候，就需要一个ItemStack
		
		//2 : 支持泛型的Stack
		/*设计一个支持泛型的栈MyStack
		设计这个类的时候，在类的声明上，加上一个<T>，表示该类支持泛型。
		T是type的缩写，也可以使用任何其他的合法的变量，比如A,B,X都可以，但是一般约定成俗使用T，代表类型*/
		
		//3 : 练习-支持泛型的二叉树 
		
		/*把二叉树中的Node类，改造成支持泛型*/
		
	}
}

package cn.titanium.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子访问
 * @author Administrator
 *2017年10月20日下午8:34:25
 */
public class AtomicAccess {
	public static void main(String[] args) {
		
		//1 : 原子性操作概念
		/*所谓的原子性操作即不可中断的操作，比如赋值操作
		 
		int i = 5;
		 

		原子性操作本身是线程安全的 
		但是 i++ 这个行为，事实上是有3个原子性操作组成的。
		步骤 1. 取 i 的值
		步骤 2. i + 1
		步骤 3. 把新的值赋予i
		这三个步骤，每一步都是一个原子操作，但是合在一起，就不是原子操作。就不是线程安全的。 
		换句话说，一个线程在步骤1 取i 的值结束后，还没有来得及进行步骤2，另一个线程也可以取 i的值了。
		这也是分析同步问题产生的原因 中的原理。
		i++ ，i--， i = i+1 这些都是非原子性操作。
		只有int i = 1,这个赋值操作是原子性的。*/
		
		//2 : AtomicInteger
		/*JDK6 以后，新增加了一个包java.util.concurrent.atomic，里面有各种原子类，比如AtomicInteger。
		而AtomicInteger提供了各种自增，自减等方法，这些方法都是原子性的。 换句话说，自增方法 incrementAndGet
		是线程安全的，同一个时间，只有一个线程可以调用这个方法。*/
		
		AtomicInteger ai = new AtomicInteger();
		int i = ai.decrementAndGet();
		int j = ai.incrementAndGet();
		int x = ai.addAndGet(3);
		
		//3 : 同步测试
		/*分别使用基本变量的非原子性的++运算符和 原子性的AtomicInteger对象的 incrementAndGet 来进行多线程测试。
		测试结果如图所示*/
		
		
		//练习-使用AtomicInteger来替换Hero类中的synchronized 
		/*在给Hero的方法加上修饰符synchronized 这个知识点中，通过给hurt和 recover方法加上synchronized来达到线程安全的效果。

		这一次换成使用AtomicInteger来解决这个问题

		提示：int基本类型对应的是AtomicInteger，但是float基本类型没有对应的AtomicFloat。 所以在这个练习中，把hp改为AtomicInteger即可*/
	}
}


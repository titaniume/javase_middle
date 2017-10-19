package cn.titanium.multithreading;

/**
 * 同步
 * @author Administrator
 *2017年10月19日下午12:23:11
 */
public class Synchronization {
	public static void main(String[] args) {
		
		
		/*多线程的同步问题指的是多个线程同时修改一个数据的时候，可能导致的问题 

		多线程的问题，又叫Concurrency 问题*/
		
		// 1 : 演示同步问题
/*		假设盖伦有10000滴血，并且在基地里，同时又被对方多个英雄攻击
		就是有多个线程在减少盖伦的hp
		同时又有多个线程在回复盖伦的hp
		假设线程的数量是一样的，并且每次改变的值都是1，那么所有线程结束后，盖伦应该还是10000滴血。
		但是。。。
		注意： 不是每一次运行都会看到错误的数据产生，多运行几次，或者增加运行的次数*/
		
		//2 : 分析同步问题产生的原因
		/*1. 假设增加线程先进入，得到的hp是10000 
		2. 进行增加运算 
		3. 正在做增加运算的时候，还没有来得及修改hp的值，减少线程来了 
		4. 减少线程得到的hp的值也是10000 
		5. 减少线程进行减少运算 
		6. 增加线程运算结束，得到值10001，并把这个值赋予hp 
		7. 减少线程也运算结束，得到值9999，并把这个值赋予hp 
		hp，最后的值就是9999 
		虽然经历了两个线程各自增减了一次，本来期望还是原值10000，但是却得到了一个9999 
		这个时候的值9999是一个错误的值，在业务上又叫做脏数据*/
		
		//3 : 解决思路
	/*	总体解决思路是： 在增加线程访问hp期间，其他线程不可以访问hp 
		1. 增加线程获取到hp的值，并进行运算 
		2. 在运算期间，减少线程试图来获取hp的值，但是不被允许 
		3. 增加线程运算结束，并成功修改hp的值为10001 
		4. 减少线程，在增加线程做完后，才能访问hp的值，即10001 
		5. 减少线程运算，并得到新的值10000*/
		
		
		//4 : synchronized 同步对象概念
	/*	解决上述问题之前，先理解
		synchronized关键字的意义
		如下代码：
		 
		Object someObject =new Object();
		synchronized (someObject){
		  //此处的代码只有占有了someObject后才可以执行
		}
		 


		synchronized表示当前线程，独占 对象 someObject
		当前线程独占 了对象someObject，如果有其他线程试图占有对象someObject，就会等待，直到当前线程释放对someObject的占用。
		someObject 又叫同步对象，所有的对象，都可以作为同步对象
		为了达到同步的效果，必须使用同一个同步对象

		释放同步对象的方式： synchronized 块自然结束，或者有异常抛出*/
		
		//5 : 使用synchronized 解决同步问题
		/*所有需要修改hp的地方，有要建立在占有someObject的基础上。 
		而对象 someObject在同一时间，只能被一个线程占有。 间接地，导致同一时间，hp只能被一个线程修改。*/
		
		
		//6 : 使用hero对象作为同步对象
/*		既然任意对象都可以用来作为同步对象，而所有的线程访问的都是同一个hero对象，索性就使用gareen来作为同步对象 
		进一步的，对于Hero的hurt方法，加上： 
		synchronized (this) { 
		} 
		表示当期对象为同步对象，即也是gareen为同步对象*/
		
		//7 : 在方法前，加上修饰符synchronized
		/*在recover前，直接加上synchronized ，其所对应的同步对象，就是this
		和hurt方法达到的效果是一样
		外部线程访问gareen的方法，就不需要额外使用synchronized 了*/
		
		//8 : 线程安全的类
		/*如果一个类，其方法都是有synchronized修饰的，那么该类就叫做线程安全的类

		同一时间，只有一个线程能够进入 这种类的一个实例 的去修改数据，进而保证了这个实例中的数据的安全(不会同时被多线程修改而变成脏数据)

		比如StringBuffer和StringBuilder的区别
		StringBuffer的方法都是有synchronized修饰的，StringBuffer就叫做线程安全的类
		而StringBuilder就不是线程安全的类*/
		
		// 9 : 练习-在类前面加修饰符synchronized 
		/*在对象方法前，加上修饰符synchronized ，同步对象是当前实例。
		那么如果在类方法前，加上修饰符 synchronized，同步对象是什么呢？

		提示：要完成本练习，需要反射reflection的知识，如果未学习反射，可以暂时不做*/

		//10 : 练习-线程安全的MyStack 
	}
}

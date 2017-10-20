package cn.titanium.multithreading;

/**
 * Lock对象
 * @author Administrator
 *2017年10月20日下午6:20:14
 */
public class Locks {
	public static void main(String[] args) {
		
		//1 : 回忆 synchronized 同步的方式
		//首先回忆一下 synchronized 同步对象的方式
		//当一个线程占用 synchronized 同步对象，其他线程就不能占用了，直到释放这个同步对象为止
		
		// 2 : 使用Lock对象实现同步效果
		/*Lock是一个接口，为了使用一个Lock对象，需要用到		 
		Lock lock = new ReentrantLock();	 
		与 synchronized (someObject) 类似的，lock()方法，表示当前线程占用lock对象，一旦占用，其他线程就不能占用了。
		与 synchronized 不同的是，一旦synchronized 块结束，就会自动释放对someObject的占用。 lock却必须调用unlock
		方法进行手动释放，为了保证释放的执行，往往会把unlock() 放在finally中进行*/
		
		
		//3 : trylock方法
		/*synchronized 是不占用到手不罢休的，会一直试图占用下去。
		与 synchronized 的钻牛角尖不一样，Lock接口还提供了一个trylock方法。
		trylock会在指定时间范围内试图占用，占成功了，就啪啪啪。 如果时间到了，还占用不成功，扭头就走~

		注意： 因为使用trylock有可能成功，有可能失败，所以后面unlock释放锁的时候，需要判断是否占用成功了，
		如果没占用成功也unlock,就会抛出异常*/
		
		//4 : 线程交互
		/*使用synchronized方式进行线程交互，用到的是同步对象的wait,notify和notifyAll方法

		Lock也提供了类似的解决办法，首先通过lock对象得到一个Condition对象，然后分别调用这个Condition对象的：await, signal,signalAll 方法

		注意： 不是Condition对象的wait,nofity,notifyAll方法,是await,signal,signalAll*/
		
		// 5 : 总结Lock和synchronized的区别
		/*1. Lock是一个接口，而synchronized是Java中的关键字，synchronized是内置的语言实现，Lock是代码层面的实现。
		2. Lock可以选择性的获取锁，如果一段时间获取不到，可以放弃。synchronized不行，会一根筋一直获取下去。 借助Lock的这个特性，
		就能够规避死锁，synchronized必须通过谨慎和良好的设计，才能减少死锁的发生。
		3. synchronized在发生异常和同步块结束的时候，会自动释放锁。而Lock必须手动释放， 所以如果忘记了释放锁，一样会造成死锁。*/
	
		// 6 : 练习-借助Lock，把MyStack修改为线程安全的类
		
		//7 : 练习-借助tryLock 解决死锁问题
		/*当多个线程按照不同顺序占用多个同步对象的时候，就有可能产生死锁现象。
		死锁之所以会发生，就是因为synchronized 如果占用不到同步对象，
		就会苦苦的一直等待下去，借助tryLock的有限等待时间，解决死锁问题*/
		
		
		//10 : 练习-生产者消费者问题 
		/*接下来使用Condition对象的：await, signal,signalAll 方法实现同样的效果*/
	}
}

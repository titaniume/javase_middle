package cn.titanium.multithreading.interactive;

public class TestThread_proandcons {
	 public static void main(String[] args) {
	        MyStack<Character> stack = new MyStack<>();
	        new ProducerThread(stack, "Producer1").start();
	        new ProducerThread(stack, "Producer2").start();
	        new ConsumerThread(stack, "Consumer1").start();
	        new ConsumerThread(stack, "Consumer2").start();
	        new ConsumerThread(stack, "Consumer3").start();
	                           
	    }
}

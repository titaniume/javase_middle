package cn.titanium.multithreading.threadsafeclass;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import cn.titanium.multithreading.synchronization.Hero;

public class MyStack implements Stack {

	//把LinkedList通过 Collections.synchronizedList转换成了一个线程安全的List
	/*
	不需要在push上加synchronized修饰符
	虽然多个线程可以同时进入push方法，但是调用heros.add方法的时候 
	同一时间，只有一个线程可以进入*/
	List<Hero> heros =(List<Hero>)Collections.synchronizedList(new LinkedList<Hero>());
	
	
	@Override
	public void push(Hero h) {
		// TODO Auto-generated method stub
		heros.add(h);
	}

	@Override
	public Hero pull() {
		// TODO Auto-generated method stub
		return heros.remove(heros.size()-1);
	}

	@Override
	public Hero peek() {
		// TODO Auto-generated method stub
		return heros.get(heros.size()-1);
	}

}

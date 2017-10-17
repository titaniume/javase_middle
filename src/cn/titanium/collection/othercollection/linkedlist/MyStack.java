package cn.titanium.collection.othercollection.linkedlist;

import java.util.LinkedList;

import cn.titanium.collection.pojo.Hero;

public class MyStack implements Stack {

	LinkedList<Hero> heros = new LinkedList<>();
	
	@Override
	public void push(Hero h) {
		// TODO Auto-generated method stub
		heros.add(h);
	}

	@Override
	public Hero pull() {
		// TODO Auto-generated method stub
		return heros.removeLast();
	}

	@Override
	public Hero peek() {
		// TODO Auto-generated method stub
		return heros.getLast();
	}
	public static void main(String[] args) {
		MyStack mk = new MyStack();
		for (int i = 0; i < 5; i++) {
			 Hero h = new Hero("hero name " + i);
	         System.out.println("压入 hero:" + h);
	         mk.push(h);
		}
		Hero peek = mk.peek();
		System.out.println("查看最后一个:"+peek);
		for (int i = 0; i < 5; i++) {
            Hero h =mk.pull();
            System.out.println("弹出 hero" + h);
        }
		
		
		
	}

}

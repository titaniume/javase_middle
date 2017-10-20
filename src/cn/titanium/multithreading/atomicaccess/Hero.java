package cn.titanium.multithreading.atomicaccess;

import java.util.concurrent.atomic.AtomicInteger;

public class Hero {
	public String name;
	public AtomicInteger hp = new AtomicInteger();
	
	public int damage;
	
	public void recover(){
		hp.incrementAndGet();
	}
	
	public void hurt(){
		hp.decrementAndGet();
	}
	
	public void attackHero(Hero hero){
		hero.hp.addAndGet(0-damage);
		System.out.format("%s 正在攻击 %s, %s的血变成了 %d.f%n", name,hero.name,hero.name,hero.hp);
		if(hero.isDead()){
			System.out.println(hero.name+"死了");
		}
	}

	private boolean isDead() {
		// TODO Auto-generated method stub
		return 0>=hp.intValue()?true:false;
	}
}

package cn.titanium.generic.standbyclass;

import java.util.LinkedList;

public class HeroStack {
	
	LinkedList<Hero> heros = new LinkedList<Hero>();
	
  public void push(Hero h) {
        heros.addLast(h);
    }
   
    public Hero pull() {
        return heros.removeLast();
    }
   
    public Hero peek() {
        return heros.getLast();
    }
    
    public static void main(String[] args) {
		HeroStack hs = new HeroStack();
		for (int i = 0; i < 5; i++) {
			 Hero h = new Hero("hero name " + i);
            System.out.println("压入 hero:" + h);
            hs.push(h);
		}
	 for (int i = 0; i < 5; i++) {
            Hero h =hs.pull();
            System.out.println("弹出 hero" + h);
        }
		
	}
}

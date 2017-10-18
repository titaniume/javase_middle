package cn.titanium.generic.wildcard;

import java.util.ArrayList;

public class TestGeneric {
	public static void main(String[] args) {
		ArrayList<Hero> hs = new ArrayList<>();
        ArrayList<APHero> aphs = new ArrayList<>();
        ArrayList<ADHero> adhs = new ArrayList<>();
        
      /*  iterate(hs);
        iterateAD(adhs);
        iterateAP(aphs);*/
        
        iterate(hs);
        iterate(adhs);
        iterate(aphs);
	}
	
	/*public static void iterate(ArrayList<Hero> list){
		for (Hero hero : list) {
			System.out.println(hero);
		}
	}
   public static void iterateAP(ArrayList<APHero> list) {
        for (Hero hero : list) {
            System.out.println(hero.name);
        }
    }
 
    public static void iterateAD(ArrayList<ADHero> list) {
        for (Hero hero : list) {
            System.out.println(hero.name);
        }
    }*/
	
	//通过? extens 给代码减肥

    public static void iterate(ArrayList<? extends Hero> list) {
        for (Hero hero : list) {
            System.out.println(hero.name);
        }
    }
    
    
}

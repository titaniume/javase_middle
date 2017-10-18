package cn.titanium.generic.wildcard;



public class Hero2 implements Comparable<Hero2> {
	  public String name;
	    public float hp;
	  
	    public int damage;
	  
	    public Hero2() {
	  
	    }
	  
	    public Hero2(String name) {
	 
	        this.name = name;
	    }
	  
	    public String toString() {
	        return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
	    }
	 
	    public Hero2(String name, int hp, int damage) {
	        this.name = name;
	        this.hp = hp;
	        this.damage = damage;
	    }

		@Override
		public int compareTo(Hero2 o) {
			// TODO Auto-generated method stub
			return 0;
		}
}

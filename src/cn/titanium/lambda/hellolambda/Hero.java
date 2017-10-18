package cn.titanium.lambda.hellolambda;
public class Hero implements Comparable<Hero>{
    public String name; 
    public float hp;
      
    public String getName() {
		return name;
	}

	public float getHp() {
		return hp;
	}

	public int damage;
        
    public Hero(){
           
    }
       
    public Hero(String name) {
        this.name =name;
   
    }
       
    //初始化name,hp,damage的构造方法
    public Hero(String name,float hp, int damage) {
        this.name =name;
        this.hp = hp;
        this.damage = damage;
    }
   
    @Override
    public int compareTo(Hero anotherHero) {
        if(damage<anotherHero.damage)
            return 1;  
        else
            return -1;
    }
    public boolean matched(){
    	   return this.hp>100 && this.damage<50;
    }
   
    @Override
    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
    }
    
    public int compareHero(Hero h){
        return hp>=h.hp?-1:1;
    }
       
}
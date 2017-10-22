package cn.titanium.reflex.accessattribute;

public class Hero {
	public String name;
	public float hp;
	public int damage;
	public int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Hero() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Hero(String naem){
		this.name = name;
	}
	@Override
	public String toString() {
		return "Hero [name=" + name + "]";
	}
	
	public boolean isDead(){
		return false;
	}
	
	public void attackHero(Hero h){
		System.out.println(this.name+"正在攻击"+h.getName());
	}
	
}

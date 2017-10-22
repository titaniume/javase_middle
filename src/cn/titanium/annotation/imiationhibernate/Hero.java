package cn.titanium.annotation.imiationhibernate;

@MyEntity
@MyTable(name = "Hero")
public class Hero {
	
	private int id;
	private String name;
	private int damage;
	private int armor;
	
	@MyId
	@MyGeneratedValue(strategy="identity")
	@MyColumn("id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@MyColumn("name_")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@MyColumn("damage_")
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	@MyColumn("armor_")
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	
}

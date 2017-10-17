package cn.titanium.collection.pojo;

import cn.titanium.collection.arraylist.generic.LOL;

public class Hero implements LOL {
	

	public String name; //姓名
    
	public float hp; //血量
      
	public float armor; //护甲
      
	public int moveSpeed; //移动速度

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getHp() {
		return hp;
	}

	public void setHp(float hp) {
		this.hp = hp;
	}

	public float getArmor() {
		return armor;
	}

	public void setArmor(float armor) {
		this.armor = armor;
	}

	public int getMoveSpeed() {
		return moveSpeed;
	}

	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public Hero(String name) {
		super();
		this.name = name;
	}

	public Hero() {
		super();
	}
	
	//重写toString方法
	public String toString(){
		return name;
	}
	
	
}

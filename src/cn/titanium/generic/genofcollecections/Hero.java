package cn.titanium.generic.genofcollecections;

public  abstract class Hero {

	String name;

	float hp;

	float armor;

	int moveSpeed;
	
	//抽象方法attact
	//hero的子类会被要求实现attact()方法
	public abstract void attact();
}

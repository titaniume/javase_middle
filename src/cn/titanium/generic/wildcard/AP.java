package cn.titanium.generic.wildcard;

public interface AP {
	
	//魔法伤害
	public void magicAttack();
	
	public static final int resistPysic= 100;
	 //resistMagic即便没有显式的声明为 public static final
    //但依然默认为public static final
	int resistMagic = 0;
	void attact(); 
	
}

package cn.titanium.generic.wildcard;

public class ADHero extends Hero implements AD {


	
	public void physicAttack(){
		System.out.println("进行物理攻击");
	}
	
	@Override
	public void attact() {
		physicAttack();
		
	}
}

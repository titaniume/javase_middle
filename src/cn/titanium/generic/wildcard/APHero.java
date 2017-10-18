package cn.titanium.generic.wildcard;

public class APHero  extends Hero implements AP{

	
   public void magicAttack() {
        System.out.println("进行魔法攻击");
    }
   
   @Override
	public void attact() {
		magicAttack();
		
	}


}

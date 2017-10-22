package cn.titanium.annotation.basicbuilannotions;

//AD接口只有一个adAttack方法，那么就可以被注解为@FunctionalInterface
@FunctionalInterface
public interface AD {
	public void adAttack();
}

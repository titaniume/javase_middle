package cn.titanium.annotation.basicbuilannotions;


//而AP接口有两个方法apAttack()和apAttack2(),那么就不能被注解为函数式接口
//@FunctionalInterface
public interface AP {
    public void apAttack();
    public void apAttack2();
}
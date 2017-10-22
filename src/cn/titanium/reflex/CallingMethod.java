package cn.titanium.reflex;

/**
 * 调用方法----->通过反射机制，调用一个对象的方法
 * @author Administrator
 *2017年10月22日下午7:19:51
 */
public class CallingMethod {
	
	public static void main(String[] args) {
		
		// 1 : 调用方法
		/*首先为Hero的name属性，增加setter和getter
		通过反射机制调用Hero的setName*/
		
		
		//2 : 练习-调用方法
		/*继续上一个练习 练习-通过配置文件获取对象，把hero.config改动成为支持如下格式：
		charactor.APHero
		gareen
		charactor.ADHero
		teemo
		首先根据这个配置文件，使用反射实例化出两个英雄出来。
		然后通过反射给这两个英雄设置名称，接着再通过反射，调用第一个英雄的attackHero方法，攻击第二个英雄*/
	}
}

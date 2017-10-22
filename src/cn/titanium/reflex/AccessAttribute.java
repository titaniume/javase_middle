package cn.titanium.reflex;

/**
 * 访问属性
 * @author Administrator
 *2017年10月22日下午7:02:27
 */
public class AccessAttribute {
	public static void main(String[] args) {
		
		//通过反射机制修改对象的属性
		//1 : Hero.java
		/*为了访问属性，把name修改为public。
		对于private修饰的成员，需要使用setAccessible(true)才能访问和修改*/
		
		// 2 : TestRelection
		//通过反射修改属性的值
		
		//3 : getField和getDeclaredField的区别
		/*getField和getDeclaredField的区别
		这两个方法都是用于获取字段
		getField 只能获取public的，包括从父类继承来的字段。
		getDeclaredField 可以获取本类所有的字段，包括private的，但是不能获取继承来的字段。 (注： 这里只能获取到private的字段，但并不能访问该private字段的值,除非加上setAccessible(true))*/
	}
}	

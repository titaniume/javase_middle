package cn.titanium.annotation;

/**
 * 注解分类
 * @author Administrator
 *2017年10月22日下午11:46:13
 */
public class Annotations {
	
	public static void main(String[] args) {
		
		
		// 1 : 按照作用域分
		/*根据注解的作用域@Retention，注解分为
		RetentionPolicy.SOURCE： Java源文件上的注解
		RetentionPolicy.CLASS： Class类文件上的注解
		RetentionPolicy.RUNTIME： 运行时的注解*/
		
		// 2 : 按照来源分
		/*按照注解的来源，也是分为3类
		1. 内置注解 如@Override ，@Deprecated 等等
		2. 第三方注解，如Hibernate, Struts等等
		3. 自定义注解，如fahibernate的自定义注解

		在工作中，大部分都是使用第三方注解， 当然第三方注解本身就是自定义注解。 */
	}
}


package cn.titanium.annotation;

/**
 * 元注解
 * @author Administrator
 *2017年10月22日下午10:07:30
 */
public class MetaAnnotation {
	
	public static void main(String[] args) {
		
		// 1 : 元注解概念
		/*在讲解元注解概念之前，我们先建立元数据的概念。 元数据在英中对应单词 metadata, metadata在wiki中的解释是：
		Metadata is data [information] that provides information about other data
		为其他数据提供信息的数据

		这样元注解就好理解了，元注解 meta annotation用于注解 自定义注解 的注解。
		元注解有这么几种：
		@Target 
		@Retention 
		@Inherited 
		@Documented 
		@Repeatable (java1.8 新增) 
		接下来挨个讲解*/
		
		// 2 : @Target
		/*@Target 表示这个注解能放在什么位置上，是只能放在类上？还是即可以放在方法上，又可以放在属性上。自定义注解@JDBCConfig 这个注解上的@Target是：@Target({METHOD,TYPE})，表示他可以用在方法和类型上（类和接口），但是不能放在属性等其他位置。 可以选择的位置列表如下：
		ElementType.TYPE：能修饰类、接口或枚举类型
		ElementType.FIELD：能修饰成员变量
		ElementType.METHOD：能修饰方法
		ElementType.PARAMETER：能修饰参数
		ElementType.CONSTRUCTOR：能修饰构造器
		ElementType.LOCAL_VARIABLE：能修饰局部变量
		ElementType.ANNOTATION_TYPE：能修饰注解
		ElementType.PACKAGE：能修饰包*/
		
		// 3 : @Retention
		/*@Retention 表示生命周期，自定义注解@JDBCConfig 上的值是 RetentionPolicy.RUNTIME, 表示可以在运行的时候依然可以使用。 @Retention可选的值有3个：

		RetentionPolicy.SOURCE： 注解只在源代码中存在，编译成class之后，就没了。@Override 就是这种注解。
		RetentionPolicy.CLASS： 注解在java文件编程成.class文件后，依然存在，但是运行起来后就没了。@Retention的默认值，即当没有显示指定@Retention的时候，就会是这种类型。
		RetentionPolicy.RUNTIME： 注解在运行起来之后依然存在，程序可以通过反射获取这些信息，自定义注解@JDBCConfig 就是这样。
		大家可以试试把自定义注解@JDBCConfig的@Retention改成其他两种，并且运行起来，看看有什么不同*/
		
		//4 : @Inherited
		//@Inherited 表示该注解具有继承性。如例，做一个DBUtil的子类，其getConnection2方法，可以获取到父类DBUtil上的注解信息。
	
		//5 : @Documented
		//@Documented 如图所示， 在用javadoc命令生成API文档后，DBUtil的文档里会出现该注解说明。
	
		// 6 : @Repeatable (java1.8 新增)
		/*当没有@Repeatable修饰的时候，注解在同一个位置，只能出现一次，如例所示：
		@JDBCConfig(ip = "127.0.0.1", database = "test", encoding = "UTF-8", loginName = "root", password = "admin")
		@JDBCConfig(ip = "127.0.0.1", database = "test", encoding = "UTF-8", loginName = "root", password = "admin")
		重复做两次就会报错了。 
		使用@Repeatable之后，再配合一些其他动作，就可以在同一个地方使用多次了。
		如何使用@Repeatable 单独拿出来讲解：@Repeatable运用举例*/
		
		//7 : @Repeatable 运用举例
		/*比如在练习练习-查找文件内容 中有一个要求，即查找文件后缀名是.java的文件，我们把部分代码修改为注解，并且使用@Repeatable 这个元注解来表示，文件后缀名的范围可以使java, html, css, js 等等。

		为了紧凑起见，把注解作为内部类的形式放在一个文件里。
		1. 注解FileTypes，其value()返回一个FileType数组
		2. 注解FileType，其@Repeatable的值采用FileTypes
		3. 运用注解：在work方法上重复使用多次@FileType注解
		4. 解析注解： 在work方法内，通过反射获取到本方法上的FileType类型的注解数组，然后遍历本数组*/
	}
}

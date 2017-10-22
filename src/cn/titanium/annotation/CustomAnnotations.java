package cn.titanium.annotation;

/**
 * 自定义注解
 * 在本例中，把数据库连接的工具类DBUtil改造成为注解的方式，来举例演示怎么自定义注解以及如何解析这些自定义注解
 * @author Administrator
 *2017年10月22日下午9:39:32
 */
public class CustomAnnotations {
	
	//1 : 非注解方式DBUtil
	
	//2 : 自定义注解@JDBCConfig
	/*接下来，就要把DBUtil这个类改造成为支持自定义注解的方式。 首先创建一个注解JDBCConfig

	1. 创建注解类型的时候即不使用class也不使用interface,而是使用@interface
	 
	public @interface JDBCConfig 
	 

	2. 元注解
	@Target({METHOD,TYPE}) 表示这个注解可以用用在类/接口上，还可以用在方法上
	@Retention(RetentionPolicy.RUNTIME) 表示这是一个运行时注解，即运行起来之后，才获取注解中的相关信息，而不像基本注解如@Override 那种不用运行，在编译时eclipse就可以进行相关工作的编译时注解。
	@Inherited 表示这个注解可以被子类继承
	@Documented 表示当执行javadoc的时候，本注解会生成相关文档
	请在学习完本知识点最后一个步骤解析注解之后，再查看 元注解，做更详尽的学习。

	3. 注解元素，这些注解元素就用于存放注解信息，在解析的时候获取出来*/
	
	// 3 : 注解方式DBUtil
	/*有了自定义注解@JDBCConfig之后，我们就把非注解方式DBUtil改造成为注解方式DBUtil。
	如例所示，数据库相关配置信息本来是以属性的方式存放的，现在改为了以注解的方式，提供这些信息了。*/
	
	
	// 4 : 解析注解
	/*接下来就通过反射，获取这个DBUtils这个类上的注解对象
	 JDBCConfig config = DBUtil.class.getAnnotation(JDBCConfig.class);
	拿到注解对象之后，通过其方法，获取各个注解元素的值：
	String ip = config.ip();
	int port = config.port();
	String database = config.database();
	String encoding = config.encoding();
	String loginName = config.loginName();
	String password = config.password();*/
}

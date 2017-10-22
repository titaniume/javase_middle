package cn.titanium.annotation;

/**
 * 仿Hibernate 注解
 * 本知识点将做一套防hibernate的自定义注解，并解析其信息，来演示hibernate注解方式是如何工作的。
 * @author Administrator
 *2017年10月22日下午10:59:21
 */
public class ImitationHibernate {
	
	//1 : hibernate两种配置方式
	/*hibernate有两种配置方式，分别是*.hbm.xml 配置方式 和注解方式。 虽然方式不一样，但是都是用于解决如下问题：
	1. 当前类是否实体类
	2. 对应的表名称
	3. 主键对应哪个属性， 自增长策略是什么，对应字段名称是什么
	4. 非主键属性对应字段名称是什么

	接下来，我会做一套仿hibernate的注解，并且在一个实体类Hero上运用这些注解，并通过反射解析这些注解信息，来解决上述的问题*/

	//2 : 自定义hibernate注解
	/*参考hibernate的 注解配置方式 ，自定义5个注解，分别对应hibernate中用到的注解：
	hibernate_annotation.MyEntity 对应 javax.persistence.Entity
	hibernate_annotation.MyTable 对应 javax.persistence.Table
	hibernate_annotation.MyId 对应 javax.persistence.Id
	hibernate_annotation.MyGeneratedValue 对应 javax.persistence.GeneratedValue
	hibernate_annotation.MyColumn 对应 javax.persistence.Column*/
	
	//3 : 运用在Hero对象上
	/*像以注解方式配置Product类 那样，在Hero类上运用这些自定义注解：
	当注解的方法是value的时候，给这个注解赋值时，本来应该是：
	 
	@MyColumn(value="name_")
	 

	现在可以简略一点，写为
	 
	@MyColumn("name_")*/
	
	// 4 : 解析注解
	/*创建一个解析类ParseHibernateAnnotation ，获取Hero类上配置的注解信息，其运行结果如图所示。
	思路如下：
	1. 首先获取Hero.class类对象
	2. 判断本类是否进行了MyEntity 注解
	3. 获取注解 MyTable
	4. 遍历所有的方法，如果某个方法有MyId注解，那么就记录为主键方法primaryKeyMethod 
	5. 把主键方法的自增长策略注解MyGeneratedValue和对应的字段注解MyColumn 取出来，并打印
	6. 遍历所有非主键方法，并且有MyColumn注解的方法，打印属性名称和字段名称的对应关系。*/
	
}

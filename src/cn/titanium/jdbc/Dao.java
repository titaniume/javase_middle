package cn.titanium.jdbc;

/**
 * Dao
 * @author Administrator
 *2017年10月21日下午10:25:55
 */
public class Dao {
	
	public static void main(String[] args) {
		
		/*DAO=DataAccess Object 

		数据库访问对象 

		实际上就是运用了练习-ORM中的思路，把数据库相关的操作都封装在这个类里面，其他地方看不到JDBC的代码*/
		
		
		//1 : DAO接口
		//2 : HeroDAO
		/*设计类HeroDAO，实现接口DAO

		这个HeroDAO和答案-ORM很接近，做了几个改进：
		1. 把驱动的初始化放在了构造方法HeroDAO里：
		 
		public HeroDAO() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		 
		因为驱动初始化值需要执行一次，所以放在这里更合适，其他方法里也不需要写了，代码更简洁

		2. 提供了一个getConnection方法返回连接
		所有的数据库操作都需要事先拿到一个数据库连接Connection，以前的做法每个方法里都会写一个，
		如果要改动密码，那么每个地方都需要修改。 通过这种方式，只需要修改这一个地方就可以了。 代码变得更容易维护，而且也更加简洁。*/
		
		//练习-ItemDAO
		//设计一个ItemDAO，实现了DAO接口，提供相应的功能实现Item类的ORM
	}
}

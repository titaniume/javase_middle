package cn.titanium.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;


/**
 * 查询
 * @author Administrator
 *2017年10月21日上午10:58:06
 */
public class Query {
	public static void main(String[] args) {
		
		//1 : 查询语句
		/*executeQuery 执行SQL查询语句

		注意： 在取第二列的数据的时候，用的是rs.get(2) ，而不是get(1). 这个是整个Java自带的api里唯二的地方，使用基1的，即2就代表第二个。

		另一个地方是在PreparedStatement这里*/
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try (
		Connection conn =(Connection)DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=utf-8", "root", "root");
	     Statement st = conn.createStatement();
		)
		{
			String sql = "select *from hero";
			//执行查询结果集返回给ResultSet
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				int id =rs.getInt("id"); //可以使用字段名
				String name = rs.getString(2);
				float hp = rs.getFloat("hp");
				int damage = rs.getInt(4);
				System.out.printf("%d\t%s\t%f\t%d%n", id,name,hp,damage);
			}
			// 不一定要在这里关闭ReultSet，因为Statement关闭的时候，会自动关闭ResultSet
            // rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//2 : SQL语句判断账号密码是否正确
		/*1. 创建一个用户表，有字段name,password
		2. 插入一条数据
		 
		insert into user values(null,'dashen','thisispassword');
		 

		3. SQL语句判断账号密码是否正确

		判断账号密码的正确方式是根据账号和密码到表中去找数据，如果有数据，就表明密码正确了，如果没数据，就表明密码错误。

		不恰当的方式 是把uers表的数据全部查到内存中，挨个进行比较。 如果users表里有100万条数据呢？ 内存都不够用的。*/
		
		
		try (Connection conn = (Connection) DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=UTF-8",
				"root", "root"); Statement st =conn.createStatement();)
		{
			String name ="dashen";
			//正确密码是：thisispassword
			String password = "thisispassword";
			  String sql = "select * from user where name = '" + name +"' and password = '" + password+"'";
		    // 执行查询语句，并把结果集返回给ResultSet
		    ResultSet rs = st.executeQuery(sql);
		    if(rs.next())
		    	System.out.println("账号密码正确！");
		    else
		    	System.out.println("账号密码错误！");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		//统计总数
		try (Connection conn = (Connection) DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=UTF-8",
				"root", "root");Statement st=conn.createStatement();) 
		{
			String sql ="select count(*) from hero";
			ResultSet rs = st.executeQuery(sql);
			int total = 0;
			while(rs.next()){
				total = rs.getInt(1);
			}
			System.out.println("表Hero中共有:"+total +"条数据");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//4 : 练习-分页查询 
	/*	设计一个方法，进行分页查询
		 
		public static void list(int start, int count)
		 

		start 表示开始页数，count表示一页显示的总数
		list(0,5) 表示第一页，一共显示5条数据
		list(10,5) 表示第三页，一共显示5条数据
		进行分页查询用到的SQL语句参考 ： 查询数据*/
		
		//分页
		list(5,5);
	}
	
	/**分页查询
	 * @param start	 	 开始页
	 * @param count    一页显示多少条数据
	 */
	public static void list(int start, int count) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (Connection conn = (Connection) DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=UTF-8",
				"root", "root");Statement st =conn.createStatement();) 
		{
			String sql ="select * from hero limit " + start + ","+count;
			// 执行查询语句，并把结果集返回给ResultSet
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				 int id = rs.getInt("id");// 可以使用字段名
                 String name = rs.getString(2);// 也可以使用字段的顺序
                 float hp = rs.getFloat("hp");
                 int damage = rs.getInt(4);
                 System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

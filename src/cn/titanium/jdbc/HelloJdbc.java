package cn.titanium.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class HelloJdbc {
	public static void main(String[] args) {
		
		
		//1 : 为项目导入mysql-jdbc的jar包
		// 2 : 初始化驱动
		/*通过Class.forName("com.mysql.jdbc.Driver");
		初始化驱动类com.mysql.jdbc.Driver
		就在 mysql-connector-java-5.0.8-bin.jar中
		如果忘记了第一个步骤的导包，就会抛出ClassNotFoundException

		Class.forName是把这个类加载到JVM中，加载的时候，就会执行其中的静态初始化块，完成驱动的初始化的相关工作。*/
		//初始化驱动
		Statement st =null;
		Connection c= null;
		try {
			 //驱动类com.mysql.jdbc.Driver
            //就在 mysql-connector-java-5.0.8-bin.jar中
            //如果忘记了第一个步骤的导包，就会抛出ClassNotFoundException
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 3 : 建立与数据库的连接
	/*	建立与数据库的Connection连接
		这里需要提供：
		数据库所处于的ip:127.0.0.1 (本机)
		数据库的端口号： 3306 （mysql专用端口号）
		数据库名称 titanium
		编码方式 UTF-8
		账号 root
		密码 admin*/
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 建立与数据库的Connection连接
	        // 这里需要提供：
	        // 数据库所处于的ip:127.0.0.1 (本机)
	        // 数据库的端口号： 3306 （mysql专用端口号）
	        // 数据库名称 how2java
	        // 编码方式 UTF-8
	        // 账号 root
	        // 密码 admin
		c=(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=utf-8", "root", "root");
		st= c.createStatement();
		// 准备sql语句
        // 注意： 字符串要用单引号'
		String sql="insert into hero values(null,"+"'test'"+","+123.0f+","+40+")";
		st.execute(sql);
		System.out.println("连接成功:"+c+"\t"+"statement对象："+st);
		System.out.println("执行插入语句成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			// 数据库的连接时有限资源，相关操作结束后，养成关闭数据库的好习惯
            // 先关闭Statement
			if(st!=null	){
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 // 后关闭Connection
			if(c!=null){
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		//4 : 创建Statement Statement是用于执行SQL语句的，比如增加，删除
		// 注意：使用的是 java.sql.Statement
        // 不要不小心使用到： com.mysql.jdbc.Statement;
		
		// 5 : 执行SQL语句
		/*s.execute执行sql语句
		执行成功后，用mysql-front进行查看，明确插入成功*/
		
		
		//6 : 关闭连接
		/*数据库的连接是有限资源，相关操作结束后，养成关闭数据库的好习惯
		先关闭Statement
		后关闭Connection*/
		
		//7 : 使用try-with-resource的方式自动关闭连接
		/*如果觉得上一步的关闭连接的方式很麻烦，可以参考关闭流 的方式，
		使用try-with-resource的方式自动关闭连接，因为Connection和Statement都实现了AutoClosable接口*/
		try(Connection conn =(Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=utf-8", "root", "root");
				 Statement s = conn.createStatement(); )
		{
			for(int i=0;i< 100;i++){
			 String sql = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
	         s.execute(sql);
			}    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 8 : 练习-一次性 插入100条数据 做一个0-100的for循环，生成不同的sql语句，然后执行
		
		
	}
}

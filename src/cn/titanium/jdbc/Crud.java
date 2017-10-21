package cn.titanium.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;


/**
 * 
 * @author Administrator
 *2017年10月21日上午12:27:25
 */
public class Crud {
	public static void main(String[] args) {
		
		/*CRUD是最常见的数据库操作，即增删改查 
		C 增加(Create) 
		R 读取查询(Retrieve) 
		U 更新(Update) 
		D 删除(Delete) 

		在JDBC中增加，删除，修改的操作都很类似，只是传递不同的SQL语句就行了*/
		
		//1 : 增加
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	try (
		Connection  c =(Connection)DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=UTF-8",
				"root","root");
		 Statement st = c.createStatement();)
	{
		//新增
		//String sql="insert into hero values(null,"+ "'德玛西亚'"+","+120.0f+","+20+")";
		
		//删除
		//String sql="delete from hero where id = 1";
		
		//修改
		//String sql = "update hero set name= 'updae' where id =2";
		//st.execute(sql);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//4 : 练习-增 删 改
	/*设计一个方法
	 
	public static void execute(String sql)*/

	execute("delete from hero where id=2");
	
	}
	
	public static void execute(String sql){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try (
			Connection conn =(Connection) DriverManager.getConnection
			("jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=utf-8", "root", "root");
			Statement st=conn.createStatement();)				
		{	
			st.equals(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
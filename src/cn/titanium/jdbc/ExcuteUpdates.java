package cn.titanium.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * excute 和excuteUpdate的区别
 * @author Administrator
 *2017年10月21日下午4:23:17
 */
public class ExcuteUpdates {
	
	public static void main(String[] args) {
		
		// 1 : 相同点
		//execute与executeUpdate的相同点：都可以执行增加，删除，修改
		 try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	 
	        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=UTF-8","root", "root");
	            Statement s =  c.createStatement();) {
	 
	            String sqlInsert = "insert into Hero values (null,'盖伦',616,100)";
	            String sqlDelete = "delete from Hero where id = 100";
	            String sqlUpdate = "update Hero set hp = 300 where id = 100";
	 
	            // 相同点：都可以执行增加，删除，修改
	 
	            s.execute(sqlInsert);
	            s.execute(sqlDelete);
	            s.execute(sqlUpdate);
	            s.executeUpdate(sqlInsert);
	            s.executeUpdate(sqlDelete);
	            s.executeUpdate(sqlUpdate);
	 
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	       //2 : 不同点
	        /*不同1：
	        execute可以执行查询语句
	                        然后通过getResultSet，把结果集取出来
	        executeUpdate不能执行查询语句
	                        不同2:
	        execute返回boolean类型，true表示执行的是查询语句，false表示执行的是insert,delete,update等等
	        executeUpdate返回的是int，表示有多少条数据受到了影响*/
	        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=UTF-8","root", "root");
	                Statement s = (Statement) c.createStatement();) {
	      
	                // 不同1：execute可以执行查询语句
	                // 然后通过getResultSet，把结果集取出来
	                String sqlSelect = "select * from hero";
	      
	                s.execute(sqlSelect);
	                ResultSet rs = s.getResultSet();
	                while (rs.next()) {
	                    System.out.println(rs.getInt("id"));
	                }
	      
	                // executeUpdate不能执行查询语句
	                // s.executeUpdate(sqlSelect);
	      
	                // 不同2:
	                // execute返回boolean类型，true表示执行的是查询语句，false表示执行的是insert,delete,update等等
	                boolean isSelect = s.execute(sqlSelect);
	                System.out.println(isSelect);
	      
	                // executeUpdate返回的是int，表示有多少条数据受到了影响
	                String sqlUpdate = "update Hero set hp = 300 where id < 100";
	                int number = s.executeUpdate(sqlUpdate);
	                System.out.println(number);
	      
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        
	        // 3 : 练习-分页查询 
	        // 使用execute方式，而不是executeQuery方式完成练习 练习-分页查询
	        list(10,5);
	}
	
	
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
			
			//execute :如果是查询语句返回true
			boolean isQuery	 = st.execute(sql);
			if(isQuery){
				// 执行查询语句，并把结果集返回给ResultSet
				ResultSet rs = st.getResultSet();
				while(rs.next()){
					 int id = rs.getInt("id");// 可以使用字段名
	                 String name = rs.getString(2);// 也可以使用字段的顺序
	                 float hp = rs.getFloat("hp");
	                 int damage = rs.getInt(4);
	                 System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

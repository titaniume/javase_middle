package cn.titanium.jdbc.preparedst;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

/**
 * PreparedStatement 和Statement 插入10000条数据速度比较
 * @author Administrator
 *2017年10月21日下午12:25:21
 */
public class TestInsert {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = 100;
		long start = System.currentTimeMillis();
		insertByPreparedStatment(count);
	    long end = System.currentTimeMillis();
	    System.out.printf("使用预编译Statement插入%d条数据，耗时: %d毫秒%n", count, end - start);
	    
	    start = System.currentTimeMillis();
	    insertStatment(count);
	    end = System.currentTimeMillis();
	    System.out.printf("使用Statement插入%d条数据，耗时: %d毫秒%n", count, end - start);
	}
	 private static void insertByPreparedStatment(int count) {
	        String sql = "insert into hero values(null,?,?,?)";
	        try (Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=UTF-8",
	                "root", "root");
	            PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);) {
	            for (int i = 0; i < count; i++) {
	                ps.setString(1, "吕布");
	                ps.setFloat(2, 313.0f);
	                ps.setInt(3, 50);
	                ps.execute();
	            }
	 
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
	 
	    private static void insertStatment(int count) {
	        try (Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=UTF-8",
	                "root", "root"); 
	                Statement s = (Statement) c.createStatement();) {
	            for (int i = 0; i < count; i++) {
	                String sql = "insert into hero values(null," + "'貂蝉'" + "," + i + "," + i + ")";
	                s.execute(sql);             
	            }
	 
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	    }
}
	


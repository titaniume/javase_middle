package cn.titanium.jdbc.affair;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 事务练习
 * @author Administrator
 *2017年10月21日下午5:23:58
 */
public class TestTran {
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql ="";
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=UTF-8",
				"root", "root");
				Statement st1 =conn.createStatement();
				Statement st2 =conn.createStatement();
				Scanner sc = new Scanner(System.in);
				)
		{
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

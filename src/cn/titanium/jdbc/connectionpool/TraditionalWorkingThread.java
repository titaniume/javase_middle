package cn.titanium.jdbc.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 传统方式
 * @author Administrator
 *2017年10月22日上午12:36:03
 */
public class TraditionalWorkingThread  extends Thread{
	

    public void run() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
 
        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=UTF-8",
                "root", "root"); Statement st = c.createStatement()) {
 
            for (int i = 0; i < TestConnecionPools.insertTime; i++) {
 
                String sql = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
                st.execute(sql);
            }
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
}

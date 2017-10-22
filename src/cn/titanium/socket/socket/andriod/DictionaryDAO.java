package cn.titanium.socket.socket.andriod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryDAO {
	
	/**
	 * 初始化加载驱动
	 */
	public DictionaryDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/android?characterEncoding=UTF-8", "root","root");
		
	}
	
	/**
	 * 根据一个字符串查询出对应的字符
	 * @param str
	 * @return
	 */
	public 	List<Dictionary> query(String str){
		List<Dictionary> dList = new ArrayList<Dictionary>();
		String sql ="select * from dictionary where receive = ?";
		try(Connection c = getConnection();PreparedStatement p = c.prepareStatement(sql);){
			p.setString(1, str);
			ResultSet rs = p.executeQuery();
			while(rs.next()){
				Dictionary d = new Dictionary();
				int id = rs.getInt(1);
			    String receive = rs.getString(2);
			    String response = rs.getString("response");
			    d.id = id;
			    d.recive =receive;
			    d.response= response;
			    dList.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dList;
		
	}
	
	
	
	
}

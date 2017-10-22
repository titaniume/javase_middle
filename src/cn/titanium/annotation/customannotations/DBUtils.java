package cn.titanium.annotation.customannotations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@JDBCConfig(ip = "127.0.0.1",database ="titanium",encoding ="UTF-8",loginName ="root",password ="root")
public class DBUtils {
	
	//目前只是以注解的方式提供这些信息，但是还没有解析，接下来进行解析
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		JDBCConfig config =DBUtils.class.getAnnotation(JDBCConfig.class);
		String ip = config.ip();
		int port = config.port();
		String database = config.database();
		String encoding = config.encoding();
		String loginName = config.loginName();
		String password = config.password();
		
		String url =String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip,port,database,encoding);
	    return DriverManager.getConnection(url, loginName, password);
	}
	
	public static void main(String[] args) throws SQLException {
		Connection connection = getConnection();
		System.out.println("数据库连接：" +connection);
	}
}

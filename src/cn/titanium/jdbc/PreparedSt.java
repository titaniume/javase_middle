package cn.titanium.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class PreparedSt {
	public static void main(String[] args) {
		
		
		//1 : 使用PreparedStatement.
		/*和 Statement一样，PreparedStatement也是用来执行sql语句的
		与创建Statement不同的是，需要根据sql语句创建PreparedStatement
		除此之外，还能能够通过设置参数，指定相应的值，而不是Statement那样使用字符串拼接

		注： 这是JAVA里唯二的基1的地方，另一个是查询语句中的ResultSet也是基1的。*/
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql ="insert into hero values(null,?,?,?)";

		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=UTF-8",
				"root", "root");
				  PreparedStatement ps = conn.prepareStatement(sql);) 
		{
			//设置参数
			ps.setString(1, "亚索");
			ps.setFloat(2, 455.0f);
			ps.setInt(3, 20);
			//指向
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//2 : PreparedStatement的优点1-参数设置
		/*Statement 需要进行字符串拼接，可读性和维护性比较差
		 
		String sql = "insert into hero values(null,"+"'提莫'"+","+313.0f+","+50+")";
		 

		PreparedStatement 使用参数设置，可读性好，不易犯错
		 
		String sql = "insert into hero values(null,?,?,?)";
	 	// Statement需要进行字符串拼接，可读性和维修性比较差
        String sql0 = "insert into hero values(null," + "'提莫'" + "," + 313.0f + "," + 50 + ")";
        s.execute(sql0);
        
        // PreparedStatement 使用参数设置，可读性好，不易犯错
        // "insert into hero values(null,?,?,?)";
        ps.setString(1, "提莫");
        ps.setFloat(2, 313.0f);
        ps.setInt(3, 50);
        ps.execute();
		*/
		
		// 3 : PreparedStatement的优点2-性能表现    -->PreparedStatement有预编译机制，性能比Statement更快

        String sql1 = "insert into hero values(null,?,?,?)";
        try (Connection c =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=UTF-8","root", "root"); 
                Statement s = c.createStatement(); 
                PreparedStatement ps = c.prepareStatement(sql1);
            ) {
            // Statement执行10次，需要10次把SQL语句传输到数据库端
            // 数据库要对每一次来的SQL语句进行编译处理
            for (int i = 0; i < 10; i++) {
                String sql0 = "insert into hero values(null," + "'提莫'" + ","
                        + 313.0f + "," + 50 + ")";
                s.execute(sql0);
            }
            s.close();
  
            // PreparedStatement 执行10次，只需要1次把SQL语句传输到数据库端
            // 数据库对带?的SQL进行预编译
  
            // 每次执行，只需要传输参数到数据库端
            // 1. 网络传输量比Statement更小
            // 2. 数据库不需要再进行编译，相应更快
            for (int i = 0; i < 10; i++) {
                ps.setString(1, "提莫");
                ps.setFloat(2, 313.0f);
                ps.setInt(3, 50);
                ps.execute();
            }
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        // 4 : PreparedStatement的优点3-防止SQL注入式攻击
        /*假设name是用户提交来的数据
      
        String name = "'盖伦' OR 1=1";
         
	        使用Statement就需要进行字符串拼接
	        拼接出来的语句是：
	         
	        select * from hero where name = '盖伦' OR 1=1
	         
	        因为有OR 1=1，这是恒成立的
	        那么就会把所有的英雄都查出来，而不只是盖伦
	        如果Hero表里的数据时海量的，比如几百万条，把这个表里的数据全部查出来
	        会让数据库负载变高，CPU100%，内存消耗光，响应变得极其缓慢
	
	        而PreparedStatement使用的是参数设置，就不会有这个问题*/
        
        String sql2 = "select * from hero where name = ?";
        try (Connection c =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=UTF-8","root", "root");
                Statement s = c.createStatement();
            PreparedStatement ps =  c.prepareStatement(sql2);
        ) {
            // 假设name是用户提交来的数据
            String name = "'盖伦' OR 1=1";
            String sql0 = "select * from hero where name = " + name;
            // 拼接出来的SQL语句就是
            // select * from hero where name = '盖伦' OR 1=1
            // 因为有OR 1=1，所以恒成立
            // 那么就会把所有的英雄都查出来，而不只是盖伦
            // 如果Hero表里的数据时海量的，比如几百万条，把这个表里的数据全部查出来
            // 会让数据库负载变高，CPU100%，内存消耗光，响应变得极其缓慢
            System.out.println(sql0);
  
            ResultSet rs0 = s.executeQuery(sql0);
            while (rs0.next()) {
                String heroName = rs0.getString("name");
                System.out.println(heroName);
            }
  
            s.execute(sql0);
  
            // 使用预编译Statement就可以杜绝SQL注入
  
            ps.setString(1, name);
  
            ResultSet rs = ps.executeQuery();
            // 查不出数据出来
            while (rs.next()) {
                String heroName = rs.getString("name");
                System.out.println(heroName);
            }
 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        //5 : 练习-性能比较
        //向数据库中插入10000条数据，分别使用Statement和PreparedStatement，比较各自花的时间差异
        
        
	}
	
	
}

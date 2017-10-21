package cn.titanium.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 特殊操作
 * @author Administrator
 *2017年10月21日下午4:42:48
 */
public class SpecialOperation {
	public static void main(String[] args) {
		
		// 1 : 获取自增长id
		/*在Statement通过execute或者executeUpdate执行完插入语句后，MySQL会为新插入的数据分配一个自增长id,
		 (前提是这个表的id设置为了自增长,在Mysql创建表的时候，AUTO_INCREMENT就表示自增长)
		 
		CREATE TABLE hero (
		  id int(11) AUTO_INCREMENT,
		  ...
		}		 
		但是无论是execute还是executeUpdate都不会返回这个自增长id是多少。需要通过Statement的getGeneratedKeys获取该id
		注： 第20行的代码，后面加了个Statement.RETURN_GENERATED_KEYS参数，以确保会返回自增长ID。 通常情况下不需要加这个，有的时候需要加，所以先加上，保险一些
		 
		PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);*/
		
		  try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	         String sql = "insert into hero values(null,?,?,?)";
	        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=UTF-8","root", "root");
	                PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);           
	                ) {
	  
	            ps.setString(1, "aaa");
	            ps.setFloat(2, 616);
	            ps.setInt(3, 100);
	   
	            // 执行插入语句
	            ps.execute();
	   
	            // 在执行完插入语句后，MySQL会为新插入的数据分配一个自增长id
	            // JDBC通过getGeneratedKeys获取该id
	            ResultSet rs = ps.getGeneratedKeys();
	            if (rs.next()) {
	                int id = rs.getInt(1);
	                System.out.println(id);
	            }
	   
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	        //2 : 获取表的元数据
		   /*元数据概念：
		        和数据库服务器相关的数据，比如数据库版本，有哪些表，表有哪些字段，字段类型是什么等等。*/
	        
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=UTF-8",
				"root", "root");)
		{
			  // 查看数据库层面的元数据
			  // 即数据库服务器版本，驱动版本，都有哪些数据库等等
			
			 DatabaseMetaData dbmp = conn.getMetaData();
			 
			 // 获取数据库服务器产品名称
			 System.out.println("数据库产品名称:\t"+dbmp.getDatabaseProductName());
			 // 获取数据库服务器产品版本号
			 System.out.println("数据库服务器产品版本号:\t"+dbmp.getDatabaseProductVersion());
			 // 获取数据库服务器用作类别和表名之间的分隔符 如test.user
			 System.out.println("数据库和表分隔符:\t"+dbmp.getCatalogSeparator());
		     // 获取驱动版本
			 System.out.println("驱动版本:\t"+dbmp.getDriverVersion());
			 System.out.println("可用的数据库列表：");
			 //获取数据库名称
			 ResultSet rs = dbmp.getCatalogs();
			 while(rs.next()){
				 System.out.println("数据库名称:\t"+rs.getString(1));
			 }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3 : 练习-自增长id
		/*当插入一条数据之后，通过获取自增长id，得到这条数据的id，比如说是55. 

		删除这条数据的前一条，54.

		如果54不存在，则删除53，以此类推直到删除上一条数据。*/
		 String sql1 = "insert into hero values(null,?,?,?)";
	        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=UTF-8","root", "root");
	                PreparedStatement ps = c.prepareStatement(sql1);      
	        		Statement st=c.createStatement();
	                ) {
	  
	            ps.setString(1, "貂蝉");
	            ps.setFloat(2, 62);
	            ps.setInt(3, 14);
	   
	            // 执行插入语句
	            ps.execute();
	   
	            // 在执行完插入语句后，MySQL会为新插入的数据分配一个自增长id
	            // JDBC通过getGeneratedKeys获取该id
	            ResultSet rs = ps.getGeneratedKeys();
	            int id = -1;
	            if (rs.next()) {
	                 id = rs.getInt(1);
	            }
	            System.out.println("刚插入的数据的id是:" + id);
	            for(int i =id -1;i>0;i--){
	            	int targetId = i;
	            	ResultSet rs2 = st.executeQuery("select id from hero where id ="+targetId);
	            	if(rs2.next()){
	            		System.out.println("id="+targetId +"的数据存在，删除该数据");
	            		String deleteSQL ="delete from hero where id ="+targetId;
	            		st.execute(deleteSQL);
	            		break;
	            	}
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	}
}

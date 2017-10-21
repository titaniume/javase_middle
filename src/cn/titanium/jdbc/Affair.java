package cn.titanium.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 事务
 * @author Administrator
 *2017年10月21日下午5:10:48
 */
public class Affair {
	public static void main(String[] args) {
		
		// 1 : 不使用事务的情况
		/*没有事务的前提下
		假设业务操作是：加血，减血各做一次
		结束后，英雄的血量不变
		而减血的SQL
		不小心写错写成了 updata(而非update)
		那么最后结果是血量增加了，而非期望的不变*/
		 try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	 
	        /*try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=UTF-8","root", "root");
	            Statement s = c.createStatement();) {
	  
	            //没有事务的前提下
	            //假设业务操作时，加血，减血各做一次
	            //结束后，英雄的血量不变
	              
	            //加血的SQL
	            String sql1 = "update hero set hp = hp +1 where id = 4842";
	            s.execute(sql1);
	              
	            //减血的SQL
	            //不小心写错写成了 updata(而非update)
	              
	            String sql2 = "updata hero set hp = hp -1 where id = 4842";
	            s.execute(sql2);
	  
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        */
	        //2 : 使用事务
	       /* 在事务中的多个操作，要么都成功，要么都失败
		            通过 c.setAutoCommit(false);关闭自动提交
		    使用 c.commit();进行手动提交
		    在22行-35行之间的数据库操作，就处于同一个事务当中，要么都成功，要么都失败
		           所以，虽然第一条SQL语句是可以执行的，但是第二条SQL语句有错误，其结果就是两条SQL语句都没有被提交。 除非两条SQL语句都是正确的。*/
	        
	        try (Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=UTF-8","root", "root");
	                Statement s = c.createStatement();) {
	      
	                // 有事务的前提下
	                // 在事务中的多个操作，要么都成功，要么都失败
	      
	                c.setAutoCommit(false);
	      
	                // 加血的SQL
	                String sql1 = "update hero set hp = hp +1 where id = 4842";
	                s.execute(sql1);
	      
	                // 减血的SQL
	                // 不小心写错写成了 updata(而非update)
	      
	                String sql2 = "updata hero set hp = hp -1 where id = 4842";
	                s.execute(sql2);
	      
	                // 手动提交
	                c.commit();
	      
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        
	       // 3 : MYSQL 表的类型必须是INNODB才支持事务
	        /*在Mysql中，只有当表的类型是INNODB的时候，才支持事务，所以需要把表的类型设置为INNODB,否则无法观察到事务.

	                      修改表的类型为INNODB的SQL：
	         
	       alter table hero ENGINE  = innodb;
	         
	                      查看表的类型的SQL
	         
	        show table status from how2java; 
	         
	                       不过有个前提，就是当前的MYSQL服务器本身要支持INNODB,如果不支持*/
	        
	        //4 : 练习-事务 
	        
	}
}

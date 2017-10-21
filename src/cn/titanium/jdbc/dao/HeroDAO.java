package cn.titanium.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HeroDAO implements DAO {
	
	/**
	 * 初始化
	 */
	public HeroDAO(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public 	Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/titanium?characterEncoding=UTF-8", "root", "root");
	}
	

	@Override
	public void add(Hero hero) {
	   String sql ="insert into hero values(null,?,?,?)";
	   try(Connection c =getConnection();PreparedStatement ps = c.prepareStatement(sql);){
		   ps.setString(1, hero.name);
		   ps.setFloat(2, hero.hp);
		   ps.setInt(3, hero.damage);
		   ps.execute();
		   ResultSet rs = ps.getGeneratedKeys();
		   if(rs.next()){
			   int id = rs.getInt(1);
			   hero.id =id;
		   }
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

	@Override
	public void update(Hero hero) {
		  String sql = "update hero set name= ?, hp = ? , damage = ? where id = ?";
		try (Connection c = getConnection();
				PreparedStatement ps = c.prepareStatement(sql);) 
		{
			ps.setString(1, hero.name);
			ps.setFloat(2, hero.hp);
			ps.setInt(3, hero.damage);
			ps.setInt(4, hero.id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		
		String sql ="delete from hero where id = ?";
		try(Connection c =getConnection(); PreparedStatement ps =c.prepareStatement(sql);)
		{
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Hero get(int id) {	
		  Hero hero = null;
		  
	        try (Connection c = getConnection(); Statement s = c.createStatement();) {
	  
	            String sql = "select * from hero where id = " + id;
	  
	            ResultSet rs = s.executeQuery(sql);
	  
	            if (rs.next()) {
	                hero = new Hero();
	                String name = rs.getString(2);
	                float hp = rs.getFloat("hp");
	                int damage = rs.getInt(4);
	                hero.name = name;
	                hero.hp = hp;
	                hero.damage = damage;
	                hero.id = id;
	            }
	            System.out.println(hero.name);
	  
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	        return hero;
	}

	@Override
	public List<Hero> list() {
		  return list(0, Short.MAX_VALUE);
	}

	@Override
	public List<Hero> list(int start, int count) {
		List<Hero> heros = new ArrayList<Hero>();
		String sql = "select * from hero order by id desc limit ?,? ";
		 try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			  
	            ps.setInt(1, start);
	            ps.setInt(2, count);
	  
	            ResultSet rs = ps.executeQuery();
	  
	            while (rs.next()) {
	                Hero hero = new Hero();
	                int id = rs.getInt(1);
	                String name = rs.getString(2);
	                float hp = rs.getFloat("hp");
	                int damage = rs.getInt(4);
	                hero.id = id;
	                hero.name = name;
	                hero.hp = hp;
	                hero.damage = damage;
	                heros.add(hero);
	            }
	        } catch (SQLException e) {
	  
	            e.printStackTrace();
	        }
	        return heros;
	}
	
	public int getTotal() {
        int total = 0;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select count(*) from hero";
  
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
  
            System.out.println("total:" + total);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return total;
    }

	public static void main(String[] args) {
		HeroDAO hd =new HeroDAO();
		//hd.delete(4852);
		//hd.get(4851);
		hd.getTotal();
		Hero h = new Hero();
		h.id = 4848;
		h.name ="修改";
		h.hp = 123.0f;
		h.damage =88;
		hd.update(h);
	
	}

}

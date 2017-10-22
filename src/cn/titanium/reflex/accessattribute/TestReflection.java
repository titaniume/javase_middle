package cn.titanium.reflex.accessattribute;

import java.lang.reflect.Field;

public class TestReflection {
	
	public static void main(String[] args) {
		
		  Hero h =new Hero();
          //使用传统方式修改name的值为gareen
          h.name = "gareen";
          h.hp=123;
         try {
        	 //获取类Hero的名字叫做name的字段
			Field f1 = h.getClass().getDeclaredField("name");
			Field f2 = h.getClass().getField("name");
		    //修改这个字段的值
			f1.set(h, "德玛西亚");
			System.out.println(h.name);
			System.out.println(f1.equals(f2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
	}
}

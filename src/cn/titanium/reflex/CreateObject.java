package cn.titanium.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 创建对象
 * @author Administrator
 *2017年10月22日下午4:50:32
 */
public class CreateObject {
	
	public static void main(String[] args) {
		
		//1 : 创建一个对象
		//传统的使用new的方式创建对象
        Hero h1 =new Hero();
        h1.name = "teemo";
        System.out.println(h1);
        
        try {
			//使用反射方式创建对象
			String className = "cn.titanium.reflex.Hero";
			//类对象
			Class pClass =Class.forName(className);
			//构造器
			Constructor c =pClass.getConstructor();
			 //通过构造器实例化
			Hero h2 =(Hero) c.newInstance();
		     h2.name="gareen";
	        System.out.println(h2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
	
		}
        
        //2 : 练习-通过配置文件获取对象 
   /*     首先准备一个文本文件：hero.config。 在这个文件中保存类的全名称，可以是charactor.APHero 或者是charactor.ADHero

                              接着设计一个方法叫做：
         
          public static Hero getHero()
                              在这个方法中，读取hero.config的数据，取出其中的类名，根据类名实例化出对象，然后返回对象。*/
        
        
	}
}

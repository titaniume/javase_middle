package cn.titanium.reflex.callingmethod;

import java.lang.reflect.Method;

public class TestReflection {
	public static void main(String[] args) {
	    Hero h = new Hero();
	    
	    //获取这个类的名字叫做SetName，参数是String的方法
	    try {
			Method m =h.getClass().getMethod("setName",String.class);
			//对h对象，调用这个方法
			m.invoke(h, "德玛西亚");
			//使用传统的方式，调用getName方法	
			System.out.println(h.getName());
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

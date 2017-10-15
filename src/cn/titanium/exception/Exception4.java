package cn.titanium.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Throwable  
 * @author Administrator
 *2017年10月15日下午4:05:40
 */
public class Exception4 {
	public static void main(String[] args)  {
		/*Throwable是类，Exception和Error都继承了该类
		所以在捕捉的时候，也可以使用Throwable进行捕捉*/
		//Throwable
	/*	 File f = new File("d:/LOL.exe");
		 
        try {
            new FileInputStream(f);
            //使用Throwable进行异常捕捉
        } catch (Throwable t) {
            // TODO Auto-generated catch block
            t.printStackTrace();
        }*/
        
        //练习-Throwable 
	   /* 在方法声明上，可以抛出指定的异常，比如FileNotFoundException
	        那么能否抛出Throwable这个类？ 
	
	        这个方法的调用者又该如何处理？*/
		try {
			method();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	/*	可以抛出Throwable，并且在调用的时候必须进行catch处理。
		但是这样的设计方法做不好，因为不知道抛出的类型到底是哪种具体问题，无法针对性的处理。*/
	}
	
	public 	static void method() throws  Throwable{
		 File f = new File("d:/LOL.exe");
		 new FileInputStream(f);
	}
}

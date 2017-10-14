package cn.titanium.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 什么 是异常
 * @author Administrator
 *2017年10月15日上午1:30:35
 */
public class Exception1 {
	public static void main(String[] args)  {
		/*异常定义： 
		导致程序的正常流程被中断的事件，叫做异常*/
		
		//1:文件不存在异常
		/*比如要打开d盘的LOL.exe文件，这个文件是有可能不存在的 
		Java中通过 new FileInputStream(f) 试图打开某文件，就有可能抛出文件不存在异常FileNotFoundException 
		如果不处理该异常，就会有编译错误 
		处理办法参见 异常处理*/
		File f = new File("d:/LOL.exe");
		//试图打开文件LOL.exe，会抛出FileNotFoundException，如果不处理该异常，就会有编译错误
		try {
			new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		//常见的异常
		/*ParseException 解析异常，日期字符串转换为日期对象的时候，有可能抛出的异常
		OutOfIndexException 数组下标越界异常
		OutOfMemoryError 内存不足
		ClassCastException 类型转换异常
		ArithmaticException 除数为零
		NullPointerException 空指针异常*/
		
	}
}

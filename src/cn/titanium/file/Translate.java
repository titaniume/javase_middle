package cn.titanium.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 什么是流
 * @author Administrator
 *2017年10月15日下午9:18:47
 */
public class Translate {
	public static void main(String[] args) {
	/*什么是流(Stream)，流就是一系列的数据*/
	
	//1 : 什么流
	/*当不同的介质之间有数据交互的时候，JAVA就使用流来实现。 
	数据源可以是文件，还可以是数据库，网络甚至是其他的程序 


	比如读取文件的数据到程序中，站在程序的角度来看，就叫做输入流 
	输入流： InputStream 
	输出流：OutputStream*/
	
	
	
	// 2 : 文件输入流
	/*如下代码，就建立了一个文件输入流，这个流可以用来把数据从硬盘的文件，读取到JVM(内存)。*/

	
         // 创建基于文件的输入流
         try {
        	File f = new File("d:/lol.txt");
			FileInputStream fis = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         // 通过这个输入流，就可以把数据从硬盘，读取到Java的虚拟中来，也就是读取到内存中
         
         //练习-流 
         /*参考文件输入流的建立，建立一个文件输出流*/
         
        
         // 创建基于文件的输出流
         try {
        	File f = new File("d:/lol.txt");
			FileOutputStream fos =new FileOutputStream(f);
			// 通过这个输出流，就可以把数据从内存，输出到硬盘的文件上
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

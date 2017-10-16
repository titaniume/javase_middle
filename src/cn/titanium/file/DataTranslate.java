package cn.titanium.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 数据流
 * @author Administrator
 *2017年10月16日下午9:43:55
 */
public class DataTranslate {
	public static void main(String[] args) {
		
		/*DataInputStream 数据输入流 
		DataOutputStream 数据输出流*/
		
		/*使用数据流的writeUTF()和readUTF() 可以进行数据的格式化顺序读写
		如本例，通过DataOutputStream 向文件顺序写出 布尔值，整数和字符串。 然后再通过DataInputStream 顺序读入这些数据。

		注： 要用DataInputStream 读取一个文件，这个文件必须是由DataOutputStream 写出的，否则会出现EOFException，
		因为DataOutputStream 在写出的时候会做一些特殊标记，只有DataInputStream 才能成功的读取。*/
		
		// 1 : 直接进行字符串的读写
		write();
		read();
		
		//2: 练习-向文件中写入两个数字，然后把这两个数字分别读取出来
		/*	要求
		第一种方式： 使用缓存流把两个数字以字符串的形式写到文件里，再用缓存流以字符串的形式读取出来，然后转换为两个数字。 
		注： 两个数字之间要有分隔符用于区分这两个数字。 比如数字是31和15，如果不使用分隔符，那么就是3115，读取出来就无法识别到底是哪两个数字。 使用分隔符31@15能解决这个问题。

		第二种方式： 使用数据流DataOutputStream向文件连续写入两个数字，然后用DataInpuStream连续读取两个数字*/
		
		//见--->DataTranslate_Lx
		
	}
	
	public static void read(){
		File file =new File("d:/lol.txt");
		
		try(
				FileInputStream fis = new FileInputStream(file);
				DataInputStream dis = new DataInputStream(fis);
				
			){
			
			boolean b = dis.readBoolean();
			int i = dis.readInt();
			String str = dis.readUTF();
			
			System.out.println("读取到的Boolean值"+b);
			System.out.println("读取到的整数："+i);
			System.out.println("读取到的字符串:"+str);
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void write(){
		File file = new File("d:/lol.txt");
		try(FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos);){
			dos.writeBoolean(true);
			dos.writeInt(30);
             
			dos.writeUTF("中国12313abcdef");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

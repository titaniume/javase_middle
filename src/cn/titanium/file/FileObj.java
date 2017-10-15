package cn.titanium.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件对象
 * @author Administrator
 *2017年10月15日下午8:06:36
 */
public class FileObj {
	
	public static void main(String[] args) {
		/*文件和文件夹都是用File代表*/
		//1 : 创建一个文件对象
		/*使用绝对路径或者相对路径创建File对象*/
		File f1 = new File("d:/LOL.exe");
	    System.out.println("f1的绝对路径：" + f1.getAbsolutePath());
	    // 相对路径,相对于工作目录，如果在eclipse中，就是项目目录
	    File f2 = new File("LOL.exe");
	    System.out.println("f2的绝对路径：" + f2.getAbsolutePath());
		
	    // 把f1作为父目录创建文件对象
	    File f3 = new File(f1,"LOL.exe");
	    System.out.println("f3的绝对路径：" + f3.getAbsolutePath());
	    
	    //2:文件常用方法1
	    File f4 = new File("d:/LOLFolder/LOL.exe");
	    System.out.println("当前文件是：" + f4);
	    
	    //判断是否存在
	    System.out.println("判断是否存在:" + f4.exists());
	    
	    //是否是文件(非文件夹)
	    System.out.println("判断是否是文件夹:" +f4.isFile());
	    
	    //文件长度
	    System.out.println("获取文件长度是："+f4.length());
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
	    //文件最后修改时间
	    long time = f4.lastModified();
	    Date d = new Date(time);
	    String format = sdf.format(d);
	    System.out.println("获取文件的最后修改时间:"+format);
	    //设置文件修改时间为1970.1.1 08:00:00
	    f4.setLastModified(0);
	    
	    
	    //文件重命名
	    File f5 = new File("d:/LOLFolder/DATA.exe");
	    f4.renameTo(f5);
	    System.out.println("把LOL.exe该名为DATA.exe");
	    System.out.println(f4);
	    System.out.println("注意： 需要在D:\\LOLFolder确实存在一个LOL.exe,\r\n才可以看到对应的文件长度、修改时间等信息");
	}
}

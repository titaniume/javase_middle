package cn.titanium.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * 字节流
 * @author Administrator
 *2017年10月15日下午10:13:16
 */
public class ByteTranslate {
	
	public static void main(String[] args) {
		/*InputStream字节输入流 
		OutputStream字节输出流 
		用于以字节的形式读取和写入数据*/
		
		/*1 : ASCII码 概念*/
		/*所有的数据存放在计算机中都是以数字的形式存放的。 所以字母就需要转换为数字才能够存放。
		比如A就对应的数字65，a对应的数字97. 不同的字母和符号对应不同的数字，就是一张码表。
		ASCII是这样的一种码表。 字包含简单的英文字母，符号，数字等等。 不包含中文，德文，俄语等复杂的。

		示例中列出了可见的ASCII码以及对应的十进制和十六进制数字，不可见的暂未列出*/
		
		
		//2 : 以字节流的形式读取文件内容
		/*InputStream是字节输入流，同时也是抽象类，只提供方法声明，不提供方法的具体实现。
		FileInputStream 是InputStream子类，以FileInputStream 为例进行文件读取*/
	
		try {
			//准备lol.txt其中的内容ASCIIA B 分别是65 66
			File f =new File("d:/lol.txt");
		    //创建基于文件的输入流
			FileInputStream fis = new FileInputStream(f);
			//创建字节数组，其长度就是文件的长度
			byte [] all = new byte[(int)f.length()];
			//以字节流的形式读取文件所有内容
			fis.read(all);
			for (byte b : all) {
				//打印出来是65 66
				System.out.println(b);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//3:以字节流的形式向文件写入数据
		/*OutpuStream是字节输出流，同时也是抽象类，只提供方法声明，不提供方法的具体实现。
		FileOutputStream 是OutputStream子类，以FileOutputStream 为例向文件写出数据

		注: 如果文件d:/lol2.txt不存在，写出操作会自动创建该文件。 
		但是如果是文件 d:/xyz/lol2.txt，而目录xyz又不存在，会抛出异常*/
		
		try {
			// 准备文件lol2.txt其中的内容是空的
			File f =new File("d:/lol2.txt");
			// 准备长度是2的字节数组，用88,89初始化，其对应的字符分别是X,Y
			byte [] bt =new byte[]{65,66,67,68};
			//创建文件输出流
			FileOutputStream fos =new FileOutputStream(f);
			//把数据写入到输入流
			fos.write(bt);
			//关闭输出流
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//练习-写入数据到文件 
		try {
			File f = new File("d:/aaaa/bbb/cc/dd/e/lol3.txt");
			
			File dir = f.getParentFile();
			if(!dir.exists()){
				// dir.mkdir(); //使用mkdir会抛出异常，因为该目录的父目录也不存在
	             dir.mkdirs(); //使用mkdirs则会把不存在的目录都创建好
			}
			byte [] bt =new byte[]{65,66,67,68};
			FileOutputStream fos =new FileOutputStream(f);
			fos.write(bt);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//练习-拆分文件
		int eachSize = 100 *1024; //100k
		File srcFile = new File("D:\\OpenSources\\eclipse\\eclipse.exe");
		splitfile(srcFile,eachSize);
		
		//合并文件：
		murgeFile("C:/","eclipse.exe");
		
	}
	


	/**
	 * 拆分思路：先源文件读取到内存中，然后从内存中挨个分到子文件里面
	 * @param srcFile	按照这个大小拆分 这里是每个100k
	 * @param eachSize  拆分的源文件
	 */
	private static void splitfile(File srcFile, int eachSize) {
		
		if(0 == srcFile.length()){
			throw new RuntimeException("文件长度为0，不看拆分");
		}
		
		byte[] fileContent = new byte[(int)srcFile.length()];
		
		//把文件度到数组里面
		try {
			FileInputStream fis = new FileInputStream(srcFile);
			fis.read();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 计算需要被划分成多少份子文件
		int fileNumber;
		//文件是否别整除得到的子文件就不一样
		//(假设文件是25，每份的大小是5，那么就应该是5个子文件)
		//(假设文件是26，每份的大小是5，那么就应该是6个子文件)
		if(0 == fileContent.length % eachSize){
			fileNumber= (int) (fileContent.length / eachSize);
		}else{
			fileNumber= (int) (fileContent.length / eachSize)+1;
		}
		
		for (int i = 0; i < fileNumber; i++) {
			   String eachFileName = srcFile.getName() + "-" + i;
			   File eachFile = new File(srcFile.getParent(), eachFileName);
			   byte [] eachContent;
			   //从源文件的内容里面，复制部分数据大子文件
			   //除开最后一个文件，其他文件都是100k
			   //最后一个文件是剩余的大小
			   if(i!= fileNumber){// 不是最后一个
				   eachContent =Arrays.copyOfRange(fileContent, eachSize * i, eachSize * (i + 1));
			   }else{// 最后一个
				   eachContent = Arrays.copyOfRange(fileContent, eachSize * i, fileContent.length);
				   
			   }

	            try {
	                // 写出去
	                FileOutputStream fos = new FileOutputStream(eachFile);
	                fos.write(eachContent);
	                // 记得关闭
	                fos.close();
	                System.out.printf("输出子文件%s，其大小是 %d字节%n", eachFile.getAbsoluteFile(), eachFile.length());
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	//合并文件，把拆分出来的文件合并
	private static void murgeFile(String folder, String fileName) {
		
		
		try {
			// 合并的目标文件
			File destFile = new File(folder,fileName);
			FileOutputStream  fos = new FileOutputStream(destFile);
			int index = 0;
			while (true) {
				//子文件
				File eachFile = new File(folder,fileName + "-" + index++);
				//如果子文件不存在了就结束
				if(!eachFile.exists())
					break;
				//读取子文件的内容
				FileInputStream fis = new FileInputStream(eachFile);
				byte [] bt = new byte[(int)eachFile.length()];
				fis.read();
				fis.close();
				
				//把子文件的内容写出去
				fos.write(bt);
                fos.flush();
                System.out.printf("把子文件 %s写出到目标文件中%n",eachFile);
			}
			 fos.close();
	         System.out.printf("最后目标文件的大小：%,d字节" , destFile.length());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

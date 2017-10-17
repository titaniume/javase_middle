package cn.titanium.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * 综合练习
 * @author Administrator
 *2017年10月17日上午11:39:59
 */
public class All {
	public static void main(String[] args) {
		 //1 : 练习-复制文件
		/*复制文件是常见的IO操作，设计如下方法，实现复制源文件srcFile到目标文件destFile*/ 
			
		 copyFile("d:/a.txt", "d:/b.txt");
		 
		 //2:练习-复制文件夹 
		/* 复制文件夹,实现如下方法，把源文件夹下所有的文件 复制到目标文件夹下(包括子文件夹)*/
		 copyFolder("d:/LOLFolder", "d:/LOLFolder2");
		 
		//3:练习-查找文件内容
		/* 假设你的项目目录是 e:/project，遍历这个目录下所有的java文件（包括子文件夹），找出文件内容包括 Magic的那些文件，并打印出来*/
		File folder =new File("d:\\project");
		search(folder, "Magic");
		 
	}
	/**
	 * 
	 * @param srcFile 源文件
	 * @param destFile	目标文件
	 */
	public static void copyFile(String srcPath, String destPath){
		
		File srFile = new File(srcPath);
		File destFile = new File(destPath);
		
		//缓存区，一次性读取1024字节
		byte [] bt = new byte[1024];
		try(
				FileInputStream fis = new FileInputStream(srcPath);
				FileOutputStream fos = new FileOutputStream(destPath);
			){
			while(true){
				 //实际读取的长度是 actuallyReaded,有可能小于1024
				int actuallyReaded = fis.read(bt);
				//-1表示没有容量了
				if(-1 == actuallyReaded){
					break;
				}
				  fos.write(bt, 0, actuallyReaded);
	               fos.flush();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 /**
	  * 
	  * @param srcFolder  源文件夹
	  * @param destFolder  目标文件夹
	  */
	public static void copyFolder(String srcPath, String destPath){
		 File srcFolder = new File(srcPath);
	        File destFolder = new File(destPath);
	        //源文件夹不存在
	        if(!srcFolder.exists())
	            return;
	        //源文件夹不是一个文件夹
	        if(!srcFolder.isDirectory())
	            return;
	        //目标文件夹是一个文件
	        if(destFolder.isFile())
	            return;
	        //目标文件夹不存在
	        if(!destFolder.exists())
	            destFolder.mkdirs();
	 
	        //遍历源文件夹
	        File[] files=  srcFolder.listFiles();
	        for (File srcFile : files) {
	            //如果是文件，就复制
	            if(srcFile.isFile()){
	                File newDestFile = new File(destFolder,srcFile.getName());
	                copyFile(srcFile.getAbsolutePath(), newDestFile.getAbsolutePath());
	            }
	            //如果是文件夹，就递归
	            if(srcFile.isDirectory()){
	                File newDestFolder = new File(destFolder,srcFile.getName());
	                copyFolder(srcFile.getAbsolutePath(),newDestFolder.getAbsolutePath());
	            }
	        }
	}
	
	/**
	 * 
	 * @param file 查找的目录
	 * @param search 查找的字符串
	 */
	public static void search(File file, String search){
		//是否是文件
		if(file.isFile()){
			if(file.getName().toLowerCase().endsWith(".java")){
				//返回数组
				String fileContent = readFileConent(file);
				if(fileContent.contains(search)){
					System.out.printf("找到子目录字符串%s,在文件:%s%n",file,search);
				}
			}
		}
		//是否是目录
		if(file.isDirectory()){
			File [] fs =file.listFiles();
			for (File f : fs) {
				search(f,search);
			}
		}
	}
	private static String readFileConent(File file) {
		try(FileReader fr = new FileReader(file)){
			char [] cr = new char[(int)file.length()];
			fr.read(cr);
			return new String(cr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

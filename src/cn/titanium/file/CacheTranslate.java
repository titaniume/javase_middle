package cn.titanium.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 缓存流
 * @author Administrator
 *2017年10月16日下午9:02:20
 */
public class CacheTranslate {


	/*以介质是硬盘为例，字节流和字符流的弊端： 
	在每一次读写的时候，都会访问硬盘。 如果读写的频率比较高的时候，其性能表现不佳。 
	
	为了解决以上弊端，采用缓存流。 
	缓存流在读取的时候，会一次性读较多的数据到缓存中，以后每一次的读取，都是在缓存中访问，直到缓存中的数据读取完毕，再到硬盘中区读取。 
	
	就好比吃饭，不用缓存就是每吃一口都到锅里去铲。用缓存就是先把饭盛到碗里，碗里的吃完了，再到锅里去铲 
	
	缓存流在写入数据的时候，会先把数据写入到缓存区，直到缓存区达到一定的量，才把这些数据，一起写入到硬盘中去。按照这种操作模式，就不会像字节流，字符流那样每写一个字节都访问硬盘，从而减少了IO操作*/

	public static void main(String[] args) {
		
		//1 : 使用缓存流读取数据
		/*缓存字符输入流 BufferedReader 可以一次读取一行数据*/
		 // 准备文件lol.txt其中的内容是
        File f = new File("d:/lol.txt");
        // 创建文件字符流
        // 缓存流必须建立在一个存在的流的基础上
        
        try (
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr)){
			while (true) {
				//一次读一行
				String line = br.readLine();
				if(null==line){
					break;
				}
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //22 :   使用缓存流写出数据
       /* PrintWriter 缓存字符输出流， 可以一次写出一行数据*/
        // 向文件lol2.txt中写入三行语句
        File f1 = new File("d:/lol2.txt");
        try(
        		// 创建文件字符流
        		FileWriter fw = new FileWriter(f1);
        		 // 缓存流必须建立在一个存在的流的基础上               
        		PrintWriter pw = new PrintWriter(fw);
        	){
        	 pw.println("garen kill teemo");
             pw.println("teemo revive after 1 minutes");
             pw.println("teemo try to garen, but killed again");
             pw.println("success！");
        	
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //3:flush
        /*有的时候，需要立即把数据写入到硬盘，而不是等缓存满了才写出去。 这时候就需要用到flush*/
        //向文件lol2.txt中写入三行语句
        File f3 =new File("d:/lol2.txt");
        //创建文件字符流
        //缓存流必须建立在一个存在的流的基础上
        try(
        		FileWriter fw = new FileWriter(f3);
        		PrintWriter pw = new PrintWriter(fw);
        	){
        	  pw.println("fflush 立即写入数据到硬盘中了");
        	//强制把缓存中的数据写入硬盘，无论缓存是否已满
        	  pw.flush();
              pw.println("teemo revive after 1 minutes");
              pw.flush();
              pw.println("teemo try to garen, but killed again");
              pw.flush();
              pw.println("success flush");
              pw.flush();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //练习-移除注释
    /*  设计一个方法，用于移除Java文件中的注释
        public void removeComments(File javaFile)

                       比如，移出以//开头的注释行
        File f = new File("d:/LOLFolder/LOL.exe");
        System.out.println("当前文件是：" +f);
        //文件是否存在
        System.out.println("判断是否存在："+f.exists());
        //是否是文件夹
        System.out.println("判断是否是文件夹："+f.isDirectory());
                       注： 如果注释在后面，或者是风格的注释，暂不用处理*/
        
        
        File javaFile = new File("d:/Array02.java");
        System.out.println(javaFile.exists());
        System.out.println(javaFile.length());
        removeComments(javaFile);
        
       
	}
	
	 public static void removeComments(File javaFile){
     	StringBuffer sb = new StringBuffer();
     	//读取内容
     	try(FileReader fr = new FileReader(javaFile);BufferedReader br = new BufferedReader(fr);){
     		
     		while (true) {
				String line = br.readLine();
				if(null== line)
					break;
					if(!line.trim().startsWith("//")){
						sb.append(line).append("\r\n");
					}
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	
     	
		try (
			FileWriter fw = new FileWriter(javaFile);
			PrintWriter pw = new PrintWriter(fw);){
			 //写出内容
			pw.write(sb.toString());
			System.err.println(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
     	
     }
}

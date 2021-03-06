package cn.titanium.multithreading.threadpool;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 多线程查找文件
 * @author Administrator
 *2017年10月20日下午5:51:08
 */
public class SearchFileTask implements Runnable {
	
	 private File file;
	    private String search;
	    public SearchFileTask(File file,String search) {
	        this.file = file;
	        this.search= search;
	    }
	     
	    public void run(){
	         
	        String fileContent = readFileConent(file);
	        if(fileContent.contains(search)){
	            System.out.printf( "线程: %s 找到子目标字符串%s,在文件:%s%n",Thread.currentThread().getName(), search,file);
	             
	        }
	    }
	     
	    public String readFileConent(File file){
	        try (FileReader fr = new FileReader(file)) {
	            char[] all = new char[(int) file.length()];
	            fr.read(all);
	            return new String(all);
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
	  
	    }   

}
